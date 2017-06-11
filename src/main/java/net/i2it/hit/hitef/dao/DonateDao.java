package net.i2it.hit.hitef.dao;

import net.i2it.hit.hitef.entity.po.DonatePO;
import net.i2it.hit.hitef.entity.vo.DonatorVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface DonateDao {

    @Insert("insert into t_donate(out_trade_no,openid,body,detail,total_fee,origin,time_end,state) " +
            "values(#{order_info.out_trade_no},#{order_info.openid},#{order_info.body},#{order_info.detail}," +
            "#{total_fee},#{order_info.device_info},#{time_end},0)")
    int save(Map<String, Object> map);

    @Update("update t_donate set state=1,time_end=#{time_end} where out_trade_no=#{out_trade_no}")
    int updateState(@Param("out_trade_no") String out_trade_no, @Param("time_end") String time_end);

    @Update("update t_donate set comment=#{comment},true_name=#{donatorVO.trueName},phone=#{donatorVO.phone}," +
            "entry_year=#{donatorVO.entryYear},major=#{donatorVO.major},mail_addr=#{donatorVO.mailAddr}," +
            "company=#{donatorVO.company},job=#{donatorVO.job} where out_trade_no=#{out_trade_no}")
    int updateDonatorInfo(@Param("out_trade_no") String out_trade_no, @Param("comment") String comment, @Param("donatorVO") DonatorVO donatorVO);

    @Select("SELECT * FROM t_donate WHERE out_trade_no = #{out_trade_no}")
    @Results(value = {
            @Result(property = "out_trade_no", column = "out_trade_no", javaType = String.class),
            @Result(property = "total_fee", column = "total_fee", javaType = double.class),
            @Result(property = "true_name", column = "true_name", javaType = String.class),
            @Result(property = "entry_year", column = "entry_year", javaType = String.class),
            @Result(property = "mail_addr", column = "mail_addr", javaType = String.class),
            @Result(property = "time_end", column = "time_end", javaType = Date.class)
    })
    DonatePO get(@Param("out_trade_no") String out_trade_no);

    //获取全部记录
    @Select("SELECT * FROM t_donate WHERE state='1' ORDER BY out_trade_no DESC;")
    @Results(value = {
            @Result(property = "out_trade_no", column = "out_trade_no", javaType = String.class),
            @Result(property = "total_fee", column = "total_fee", javaType = double.class),
            @Result(property = "true_name", column = "true_name", javaType = String.class),
            @Result(property = "entry_year", column = "entry_year", javaType = String.class),
            @Result(property = "mail_addr", column = "mail_addr", javaType = String.class),
            @Result(property = "time_end", column = "time_end", javaType = Date.class)
    })
    List<DonatePO> getAllRecords();

    //获取全部记录数
    @Select("SELECT COUNT(state) FROM t_donate WHERE state='1';")
    int getRecordCount();

    //获取指定数量的内容，分页内容
    @Select("SELECT * FROM t_donate WHERE state='1' ORDER BY out_trade_no DESC " +
            "LIMIT #{index},#{count};")
    @Results(value = {
            @Result(property = "out_trade_no", column = "out_trade_no", javaType = String.class),
            @Result(property = "total_fee", column = "total_fee", javaType = double.class),
            @Result(property = "true_name", column = "true_name", javaType = String.class),
            @Result(property = "entry_year", column = "entry_year", javaType = String.class),
            @Result(property = "mail_addr", column = "mail_addr", javaType = String.class),
            @Result(property = "time_end", column = "time_end", javaType = Date.class)
    })
    List<DonatePO> listPageDonate(@Param("index") int recordIndex, @Param("count") int pageSize);

}
