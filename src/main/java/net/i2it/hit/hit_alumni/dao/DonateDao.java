package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.vo.po.DonatePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;

@Repository
public interface DonateDao {

    @Insert("insert into t_donate(out_trade_no,openid,body,detail,total_fee,origin,time_end,state) " +
            "value(#{out_trade_no},#{openid},#{body},#{detail}),#{total_fee}),#{origin}),#{time_end}),#{state})")
    int save(DonatePO donatePO);

    @Update("update t_donate set state=1,time_end=#{time_end} where out_trade_no=#{out_trade_no}")
    int updateState(String out_trade_no, Date time_end);

//    @Update("update t_donate set state=1,time_end=#{time_end} where out_trade_no=#{out_trade_no}")
//    int updateUserInfo(String out_trade_no, Date time_end);


}
