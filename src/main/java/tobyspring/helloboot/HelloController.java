package tobyspring.helloboot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/hello")
@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {

//        SimpleHelloService helloService = new SimpleHelloService(); // HelloController가 SimpleHelloService 객체를 직접 생성해서 사용하는 방식 => DI 방식으로 수행하겠음
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
// 컨트롤 : 요청 검증의 역할