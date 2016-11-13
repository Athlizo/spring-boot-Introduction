package lizo.consumer;

import lizo.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 李周 on 2016/10/23.
 */
@SpringBootApplication
@RestController
@ImportResource({"classpath:spring/dubbo-consumer.xml"})
public class Application {

    @Autowired
    DubboService dubboService;

    @RequestMapping("/")
     public int delete(){
        return dubboService.delete(123L);
    }


    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new SpringApplicationBuilder()
                .sources(Application.class)
                .run(args);
    }
}
