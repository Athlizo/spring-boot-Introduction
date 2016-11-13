package lizo.provider;

import lizo.DubboService;
import org.springframework.stereotype.Service;

/**
 * Created by hzlizhou on 2016/11/8.
 */
@Service("dubboService")
public class DubboServiceImp implements DubboService {

    public int delete(Long id) {
        return 1;
    }

}
