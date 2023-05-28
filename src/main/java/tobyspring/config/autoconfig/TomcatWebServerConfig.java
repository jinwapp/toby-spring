package tobyspring.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

public class TomcatWebServerConfig {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() { // 팩토리 메서드
        return new TomcatServletWebServerFactory();
    }
}