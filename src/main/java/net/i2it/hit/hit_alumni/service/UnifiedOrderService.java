package net.i2it.hit.hit_alumni.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.UnifiedOrderInfoVO;
import net.i2it.hit.hit_alumni.util.ValueGeneratorUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;

/**
 * 定义微信支付统一下单接口所需要参数的生成过程规则，以及构建本应用中提交的参数xml格式对应的实例对象
 *
 * @author liuming
 */
public class UnifiedOrderService {

    /**
     * UnifiedOrderVO实体类的实例化和参数赋值，用于生成提交到统一下单接口的xml格式内容
     *
     * @param openid
     * @param simpleOrderInfo
     * @return
     */
    public String getOrderInfo(String openid, SimpleOrderInfoVO simpleOrderInfo) {
        UnifiedOrderInfoVO orderInfo = new UnifiedOrderInfoVO();
        orderInfo.setOpenid(openid);
        orderInfo.setNonce_str(ValueGeneratorUtil.randomStr(10));
        try {
            orderInfo.setBody(URLEncoder.encode(simpleOrderInfo.getItemName(), "UTF-8"));
            orderInfo.setDetail(URLEncoder.encode(simpleOrderInfo.getItemDetail(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        orderInfo.setTotal_fee((int) (simpleOrderInfo.getItemMoney() * 100));
        // 借助于日期实现的字段
        Date dateTime = new Date();
        orderInfo.setOut_trade_no(this.getOut_trade_no(dateTime));
        orderInfo.setTime_start(ValueGeneratorUtil.getTime(dateTime));
        orderInfo.setTime_expire(ValueGeneratorUtil.getTime(new Date(dateTime.getTime() + 10 * 60 * 1000)));// 订单失效时间：10分钟
        orderInfo.setDevice_info(simpleOrderInfo.getOrigin());
        orderInfo.setNotify_url(ConfigConsts.SERVER_DOMAIN + "/donate/result");
        // 最后一步才是设置sign
        orderInfo.setSign(ValueGeneratorUtil.getSign(orderInfo));
        // 转成xml格式
        return XmlUtil.object2XmlStr(orderInfo);
    }

    // 自定义订单id的生成规则
    private String getOut_trade_no(Date dateTime) {
        String str = ValueGeneratorUtil.getTime(dateTime);
        // 添加11个随机数，使得订单号为25位字符
        str = str + ValueGeneratorUtil.randomStr(11);
        return str;
    }

}
