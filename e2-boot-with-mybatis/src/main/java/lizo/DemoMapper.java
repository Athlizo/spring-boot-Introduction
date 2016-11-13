package lizo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 李周 on 2016/11/6.
 */
@Mapper
public interface DemoMapper {
    @Select("select * from userinfo where name=#{name}")
     UserInfo fetchByName(String name);
}