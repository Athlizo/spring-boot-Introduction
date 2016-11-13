package lizo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 李周 on 2016/10/23.
 */
@RestController
public class Controller {

    @Autowired
    DemoMapper demoMapper;

    @RequestMapping("/fetchByName")
    public Object fetchByName(@RequestParam("name") String name){
        return demoMapper.fetchByName(name);
    }
}
