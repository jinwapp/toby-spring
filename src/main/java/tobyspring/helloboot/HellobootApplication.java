package tobyspring.helloboot;


import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {

		// 스프링 컨테이너 생성 applicationContext
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		applicationContext.registerBean(HelloController.class); // 빈 등록
		applicationContext.registerBean(SimpleHelloService.class); // 빈 등록
		applicationContext.refresh(); // 빈 생성




		/**
		 * 서블릿 컨테이너 띄우기
		 */
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webserver = serverFactory.getWebServer(servletContext -> {

			servletContext.addServlet("frontcontroller", new HttpServlet() { // 서블릿 등록
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// 인증, 보안, 다국어, 공통 기능
					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){ //매핑
						String name = req.getParameter("name");

						HelloController helloController = applicationContext.getBean(HelloController.class);
						String ret = helloController.hello(name);

						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret); // 서블릿 응답 : 바디
					}  else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*"); // front controller
		});
		webserver.start();
	}
}
/**
 * 1. 서블릿 컨테이너 생성
 * 2. 서블릿 등록
 * 3. 맵핑해서 응답
 */