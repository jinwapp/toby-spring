package tobyspring.helloboot;


import org.springframework.boot.SpringApplication;
import tobyspring.config.MySpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@MySpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);
	}
}
/**
 * 1. 서블릿 컨테이너 생성
 * 2. 서블릿 등록
 * 3. 맵핑해서 응답
 */