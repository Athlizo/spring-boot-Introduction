import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 李周 on 2016/10/23.
 */
@RestController
public class Controller {

    @Autowired
    DemoService demoService;

    @Autowired
    CacheManager cacheManager;

    @RequestMapping("/delete")
    Object delete(Long id) {
        demoService.delete(id);
        return "success";
    }

    @RequestMapping("/findOne")
    Object findOne(Person person) {
        return demoService.findOne(person);
    }

    @RequestMapping("/save")
    Object save(Person person) {
        return demoService.save(person);
    }

    @RequestMapping("/cache")
    Object cache(String name,Long key){
        Cache cache = cacheManager.getCache(name);
        if(cache!=null){
            Cache.ValueWrapper wrapper = cache.get(key);
            if(wrapper!=null){
                return wrapper.get();
            }
        }
        return "null";
    }
}
