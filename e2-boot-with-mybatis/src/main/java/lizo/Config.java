package lizo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 李周 on 2016/11/13.
 */
@Configuration
public class Config {

    @Bean
    UserInfo userInfo(){
        UserInfo userInfo =  new UserInfo();
        userInfo.setName("lizo");
        return userInfo;
    }
}
