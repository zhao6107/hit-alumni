package net.i2it.hit.hitef.dao;

import net.i2it.hit.hitef.domain.DonateRecordDO;
import net.i2it.hit.hitef.entity.vo.DonatorVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface DonateDao {

    String TB_NAME = "hitef_donate_record";
    String INSERT_KEYS_DONATE_RECORD = "out_trade_no,open_id,fund_item_id,fund_item_name,total_fee,origin,time_end,state";
    String INSERT_VALUES_DONATE_RECORD = "#{order_info.out_trade_no},#{order_info.openid},#{order_info.detail},#{order_info.body},#{total_fee},#{order_info.device_info},#{time_end},0";
    String UPDATE_FIELDS_DONATOR_INFO="comment=#{comment},true_name=#{a.trueName},phone=#{a.phone},entry_year=#{a.entryYear},major=#{a.major},mail_addr=#{a.mailAddr},company=#{a.company},job=#{a.job}";
    String SELECT_KEYS="out_trade_no AS outTradeNo,open_id AS openId,fund_item_id AS fundItemId,fund_item_name AS fundItemName,total_fee AS totalFee,origin,time_end AS timeEnd,state,`comment`,true_name AS trueName,entry_year AS entryYear,major,phone,company,job,mail_addr AS mailAddr";


    @Insert("INSERT INTO " + TB_NAME + "(" + INSERT_KEYS_DONATE_RECORD + ") VALUES(" + INSERT_VALUES_DONATE_RECORD + ")")
    int save(Map<String, Object> map);

    @Update("UPDATE "+TB_NAME+" SET state=1,time_end=#{time_end} WHERE out_trade_no=#{out_trade_no}")
    int updateState(@Param("out_trade_no") String out_trade_no, @Param("time_end") String time_end);

    @Update("UPDATE "+TB_NAME+" SET "+UPDATE_FIELDS_DONATOR_INFO+" WHERE out_trade_no=#{out_trade_no}")
    int updateDonatorInfo(@Param("out_trade_no") String out_trade_no, @Param("comment") String comment, @Param("a") DonatorVO donatorVO);

    @Select("SELECT "+SELECT_KEYS+" FROM "+TB_NAME+" WHERE out_trade_no = #{out_trade_no}")
    @Results(value = {
            @Result(property = "timeEnd", column = "timeEnd", javaType = Date.class)
    })
    DonateRecordDO get(@Param("out_trade_no") String out_trade_no);

    //获取全部记录
    @Select("SELECT "+SELECT_KEYS+" FROM t_donate WHERE state='1' ORDER BY out_trade_no DESC;")
    @Results(value = {
            @Result(property = "timeEnd", column = "timeEnd", javaType = Date.class)
    })
    List<DonateRecordDO> getAllRecords();

    //获取全部记录数
    @Select("SELECT COUNT(state) FROM t_donate WHERE state='1';")
    int getRecordCount();

    //获取指定数量的内容，分页内容
    @Select("SELECT "+SELECT_KEYS+" FROM t_donate WHERE state='1' ORDER BY out_trade_no DESC " +
            "LIMIT #{index},#{count};")
    @Results(value = {
            @Result(property = "timeEnd", column = "timeEnd", javaType = Date.class)
    })
    List<DonateRecordDO> listPageDonate(@Param("index") int recordIndex, @Param("count") int pageSize);

}
