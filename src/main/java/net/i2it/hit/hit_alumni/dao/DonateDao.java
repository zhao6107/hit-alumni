package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.vo.api.request.UnifiedOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.po.DonatePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public interface DonateDao {

    @Insert("insert into t_donate(out_trade_no,openid,body,detail,total_fee,origin,time_end,state) " +
            "values(#{order_info.out_trade_no},#{order_info.openid},#{order_info.body},#{order_info.detail},#{order_info.total_fee},#{order_info.device_info},#{time_end},0)")
    int save(Map<String, Object> map);

    @Update("update t_donate set state=1,time_end=#{time_end} where out_trade_no=#{out_trade_no}")
    int updateState(@Param("out_trade_no") String out_trade_no, @Param("time_end") String time_end);

//    @Update("update t_donate set state=1,time_end=#{time_end} where out_trade_no=#{out_trade_no}")
//    int updateUserInfo(String out_trade_no, Date time_end);


}
