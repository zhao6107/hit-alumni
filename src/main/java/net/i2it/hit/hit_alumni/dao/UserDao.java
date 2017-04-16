package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into user values(#{id},#{name},#{sex},#{age})")
    public int save(User user);

}
