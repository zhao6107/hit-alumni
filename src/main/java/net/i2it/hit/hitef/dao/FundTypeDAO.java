package net.i2it.hit.hitef.dao;

import net.i2it.hit.hitef.domain.CommonInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundTypeDAO {

    @Options(useGeneratedKeys = true, keyProperty = "type.id", keyColumn = "id")
    @Insert("INSERT INTO hitef_fund_type (`name`) VALUES (#{type.name};")
    int save(@Param("type") CommonInfo typeInfo);

    @Update("UPDATE hitef_fund_type SET `name`=#{type.name} WHERE id=#{type.id};")
    int update(@Param("type") CommonInfo typeInfo);

    @Select("SELECT id,`name` FROM hitef_fund_type;")
    List<CommonInfo> listAllFundType();

}
