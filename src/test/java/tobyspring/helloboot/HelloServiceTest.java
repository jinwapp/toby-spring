package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        String res = simpleHelloService.sayHello("Test");
        Assertions.assertThat(res).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String res = decorator.sayHello("Test");

        Assertions.assertThat(res).isEqualTo("*Test*");
    }
}
