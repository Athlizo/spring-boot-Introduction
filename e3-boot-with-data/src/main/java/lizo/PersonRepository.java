package lizo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import lizo.Person;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by 李周 on 2016/11/7.
 */

public interface PersonRepository extends JpaRepository<Person,Long>{

    /*
        @Query test
     */
    @Query("select bean from Person bean where bean.name =:name")
    List<Person> myFindByName(@Param("name") String name);

    /*
        REST test
     */
    @RestResource(path = "restFind",rel = "restFind")
    @Query("select bean from Person bean where bean.name =:name")
    List<Person> restFindByName(@Param("name") String name);

}
