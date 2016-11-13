/**
 * Created by hzlizhou on 2016/11/8.
 */
public interface DemoService {
    void delete(Long id);

    Object findOne(Person person);

    Object save(Person person);
}
