package net.i2it.hit.hitef.dao;

import net.i2it.hit.hitef.domain.DonateRecordDO;
import net.i2it.hit.hitef.domain.DonatorVO;
import net.i2it.hit.hitef.domain.FundItemStatVO;
import net.i2it.hit.hitef.domain.SimpleDonateVO;
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
    String UPDATE_FIELDS_DONATOR_INFO = "comment=#{comment},true_name=#{a.trueName},phone=#{a.phone},entry_year=#{a.entryYear},major=#{a.major},mail_addr=#{a.mailAddr},company=#{a.company},job=#{a.job}";
    String SELECT_KEYS = "out_trade_no AS outTradeNo,open_id AS openId,fund_item_id AS fundItemId,fund_item_name AS fundItemName,total_fee AS totalFee,origin,time_end AS timeEnd,state,`comment`,true_name AS trueName,entry_year AS entryYear,major,phone,company,job,mail_addr AS mailAddr";


    @Insert("INSERT INTO " + TB_NAME + "(" + INSERT_KEYS_DONATE_RECORD + ") VALUES(" + INSERT_VALUES_DONATE_RECORD + ")")
    int save(Map<String, Object> map);

    @Update("UPDATE " + TB_NAME + " SET state=1,time_end=#{time_end} WHERE out_trade_no=#{out_trade_no} And total_fee=#{total_fee}")
    int updateState(@Param("out_trade_no") String out_trade_no, @Param("total_fee")double total_fee,@Param("time_end") String time_end);

    @Update("UPDATE " + TB_NAME + " SET " + UPDATE_FIELDS_DONATOR_INFO + " WHERE out_trade_no=#{out_trade_no}")
    int updateDonatorInfo(@Param("out_trade_no") String out_trade_no, @Param("comment") String comment, @Param("a") DonatorVO donatorVO);

    @Select("SELECT " + SELECT_KEYS + " FROM " + TB_NAME + " WHERE out_trade_no = #{out_trade_no}")
    @Results(value = {
            @Result(property = "timeEnd", column = "timeEnd", javaType = Date.class)
    })
    DonateRecordDO get(@Param("out_trade_no") String out_trade_no);

    /**
     * 捐助的统计方法
     **/

    //分页实现
    @Select("SELECT true_name AS donatorName,fund_item_name AS fundItemName,total_fee AS donateMoney,time_end as donateDate " +
            "FROM hitef_donate_record WHERE state ='1' and time_end<#{maxDate} " +
            "ORDER BY out_trade_no DESC LIMIT #{pageSize};")
    List<SimpleDonateVO> getSucecessList(@Param("maxDate") Date maxDate, @Param("pageSize") int pageSize);

    // 查询总的成功捐助记录数
    @Select("SELECT COUNT(*) FROM hitef_donate_record WHERE state=1;")
    int donateCount();

    //统计每个基金项目的捐款次数以及总捐款额
    @Select("SELECT t2.fundItemId,t1.`name` AS fundItemName,t2.totalCount,t2.totalMoney FROM " +
            "(SELECT fund_item_id AS fundItemId,SUM(total_fee) AS totalMoney,COUNT(*) AS totalCount FROM hitef_donate_record WHERE state=1 GROUP BY fund_item_id) AS t2 " +
            "LEFT JOIN hitef_fund_item AS t1 " +
            "ON t1.id=t2.fundItemId ORDER BY t2.totalCount DESC,t2.totalMoney DESC;")
    List<FundItemStatVO> getAllFundItemStat();

}
