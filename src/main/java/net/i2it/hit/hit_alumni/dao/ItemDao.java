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
    @Select("SELECT * FROM t_items WHERE time_end IS NULL;")
    @Results(value = {
            @Result(property = "time_begin", column = "time_begin", javaType = Date.class),
            @Result(property = "time_end", column = "time_end", javaType = Date.class)
    })
    List<ItemPO> listNotExpiredItems();

    /**
     * 成功捐款后，更新已捐款的金额数目
     *
     * @param itemId
     * @param out_trade_no
     * @return
     */
    @Update("UPDATE t_items t1,t_donate t2 SET t1.raised_fund = t1.raised_fund+t2.total_fee " +
            "WHERE t1.id = #{itemId} AND t2.out_trade_no = #{out_trade_no} AND t1.body = t2.body")
    int updateRaisedFund(@Param("itemId") String itemId, @Param("out_trade_no") String out_trade_no);

    /**
     * 捐款项目达成目标后，停止并更新项目结束时间
     *
     * @param itemId
     * @return
     */
    @Update("UPDATE t_items SET time_end=NOW() WHERE id=#{itemId};")
    int updateTimeEnd(@Param("itemId") int itemId);

}
