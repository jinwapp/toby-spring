package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {

//        SimpleHelloService helloService = new SimpleHelloService(); // HelloController가 SimpleHelloService 객체를 직접 생성해서 사용하는 방식 => DI 방식으로 수행하겠음
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
// 컨트롤 : 요청 검증의 역할