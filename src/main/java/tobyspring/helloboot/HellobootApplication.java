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
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {

		// 스프링 컨테이너 생성 applicationContext
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext(); // 스프링 컨테이너 : applicationContext
		applicationContext.registerBean(HelloController.class); // 빈 등록
		applicationContext.registerBean(SimpleHelloService.class); // 빈 등록
		applicationContext.refresh(); // 빈 생성




		/**
		 * 서블릿 컨테이너 생성 => 서블릿 등록
		 */
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webserver = serverFactory.getWebServer(servletContext -> {

			servletContext.addServlet("dispatcherServlet",
					new DispatcherServlet(applicationContext) // 스프링을 위한 서블릿 : DispactcherServlet
			).addMapping("/*"); // front controller
		});
		webserver.start();
	}
}
/**
 * 1. 서블릿 컨테이너 생성
 * 2. 서블릿 등록
 * 3. 맵핑해서 응답
 */