package lizo.jpa;

import lizo.Person;
import lizo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Created by hzlizhou on 2016/11/8.
 */
@Service
public class DemoServiceImp implements DemoService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Object myFindByName(String name) {
        return personRepository.myFindByName(name);
    }

    @Override
    @CacheEvict(value = "person")
    public void delete(Long id) {
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "person", key = "#person.id")
    public Object findOne(Person person) {
        return personRepository.findOne(Example.of(person));
    }

    @Override
    @CachePut(value = "person", key = "#person.id")
    public Object save(Person person) {
        return personRepository.save(person);
    }
}
