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
}
