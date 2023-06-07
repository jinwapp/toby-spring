package tobyspring.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import tobyspring.config.ConditionalMyOnClass;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebserverFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() { // 팩토리 메서드
        return new TomcatServletWebServerFactory();
    }
}

/**
 * @MyAutoConfiguration
 * @ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
 * public class TomcatWebServerConfig {
 *     @Bean("tomcatWebserverFactory")
 *     public ServletWebServerFactory servletWebServerFactory() { // 팩토리 메서드
 *         return new TomcatServletWebServerFactory();
 *     }
 * }
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target({ElementType.TYPE, ElementType.METHOD})
 * @Conditional(MyOnClassCondition.class)
 * public @interface ConditionalMyOnClass {
 *     String value();
 * }
 *
 * public class MyOnClassCondition implements Condition {
 *     @Override
 *     public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
 *         Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
 *         String value = (String) attrs.get("value");
 *         return ClassUtils.isPresent(value, context.getClassLoader());
 *     }
 * }
 *
 *
 *
 */