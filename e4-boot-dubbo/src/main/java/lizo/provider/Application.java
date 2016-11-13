package lizo.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 李周 on 2016/10/23.
 */
@SpringBootApplication
@ImportResource({"classpath:spring/dubbo-provider.xml"})
public class Application {

    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new SpringApplicationBuilder()
                .sources(Application.class)
                .web(false) //把项目设置成非web环境
                .run(args);

        CountDownLatch countDownLatch = ctx.getBean(CountDownLatch.class);
        countDownLatch.await();
    }
}
