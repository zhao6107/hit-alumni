package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into user values(#{id},#{name},#{sex},#{age})")
    int save(User user);

    @Select("select * from user where id=#{id}")
    User getUser(@Param("id") String id);



}
