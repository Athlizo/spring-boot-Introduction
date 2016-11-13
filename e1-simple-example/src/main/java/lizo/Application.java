package lizo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个最简单的boot 例子
 */
@SpringBootApplication
@RestController
public class Application {
    @RequestMapping("/")
    String hello(){
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
