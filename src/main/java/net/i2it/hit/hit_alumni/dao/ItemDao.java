package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.po.ItemPO;
import net.i2it.hit.hit_alumni.entity.vo.ItemVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemDao {

    /**
     * 添加捐款项目
     *
     * @param itemVO
     * @return
     */
    @Insert("INSERT INTO t_items(body,detail,target_fund) " +
            "VALUES(#{itemVO.body},#{itemVO.detail},#{itemVO.targetFund});")
    int save(@Param("itemVO") ItemVO itemVO);

    /**
     * 更新捐献项目信息
     *
     * @param id
     * @param itemVO
     * @return
     */
    @Update("UPDATE t_items SET body = #{itemVO.body}, detail = #{itemVO.detail}, " +
            "target_fund = #{itemVO.targetFund} WHERE id = #{id}")
    int update(@Param("id") int id, @Param("itemVO") ItemVO itemVO);

    /**
     * 根据id查询某个捐款项目的信息
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM t_items WHERE id = #{id}")
    @Results(value = {
            @Result(property = "time_begin", column = "time_begin", javaType = Date.class),
            @Result(property = "time_end", column = "time_end", javaType = Date.class)
    })
    ItemPO get(@Param("id") int id);

    /**
     * 获取全部没有过期的捐款项目
     *
     * @return
     */
    @Select("SELECT * FROM t_items WHERE time_end IS NULL ORDER BY id DESC;")
    @Results(value = {
            @Result(property = "time_begin", column = "time_begin", javaType = Date.class),
            @Result(property = "time_end", column = "time_end", javaType = Date.class)
    })
    List<ItemPO> listNotExpiredItems();

}
