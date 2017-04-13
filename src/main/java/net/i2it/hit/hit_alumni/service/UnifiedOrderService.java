package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.UnifiedOrderInfoVO;
import net.i2it.hit.hit_alumni.util.EncryptionUtil;
import net.i2it.hit.hit_alumni.util.HTTPUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责与微信支付的统一下单接口的处理
 *
 * @author liuming
 */
public class UnifiedOrderService {

    public String getUnifiedOrderResult(String unifiedOrderXmlStr) {
        String result = HTTPUtil.doPost(ConfigConsts.URL_UNIFIED_ORDER, unifiedOrderXmlStr);
        return result;
    }

    public String getUnifiedOrderResult(String openid, SimpleOrderInfoVO simpleOrderInfo) {
        String tmp = this.getOrderInfo(openid, simpleOrderInfo);
        String result = HTTPUtil.doPost(ConfigConsts.URL_UNIFIED_ORDER, tmp);
        return result;
    }

    /**
     * UnifiedOrderBO实体类的实例化和参数赋值，用于生成提交到统一下单接口的xml格式内容
     *
     * @param openid
     * @param simpleOrderInfo
     * @return
     */
    public String getOrderInfo(String openid, SimpleOrderInfoVO simpleOrderInfo) {
        UnifiedOrderInfoVO orderInfo = new UnifiedOrderInfoVO();
        orderInfo.setOpenid(openid);
        orderInfo.setNonce_str((int) (Math.random() * 100000000) + "");
        orderInfo.setBody(simpleOrderInfo.getItemName());
        orderInfo.setDetail(simpleOrderInfo.getItemDetail());
        orderInfo.setTotal_fee((int) (simpleOrderInfo.getItemMoney() * 100));
        //借助于日期实现的字段
        Date dateTime = new Date();
        orderInfo.setOut_trade_no(this.getOut_trade_no(dateTime));
        orderInfo.setTime_start(this.getTime(dateTime).toString());
        orderInfo.setTime_expire(this.getTime(new Date(dateTime.getTime() + 10 * 60 * 1000)).toString());//订单失效时间：10分钟
        orderInfo.setDevice_info("qr_code");
        orderInfo.setNotify_url(ConfigConsts.SERVER_DOMAIN + "/donate/result");
        //最后一步才是设置sign
        orderInfo.setSign(this.getSign(orderInfo));
        //转成xml格式
        return XmlUtil.object2XmlStr(orderInfo);
    }

    /**
     * 签名算法 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
     *
     * @param obj
     * @return
     */
    public String getSign(Object obj) {
        //用于存放获得的对象属性名以及对应的属性值
        Map<String, Object> params = new HashMap<String, Object>();
        //获取对象中属性值不为null的属性及属性值
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fieldValue != null) {
                params.put(field.getName(), fieldValue);
            }
        }
        //对属性名进行排序（字典序）
        Object[] keys = params.keySet().toArray();
        Arrays.sort(keys);
        //对属性名和属性值按照字典序拼接，形如：key1=value1&key2=value2
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i] + "=" + params.get(keys[i]) + "&");
        }
        sb.append("key=" + ConfigConsts.API_SECRET);
        return EncryptionUtil.encrypt(sb.toString(), EncryptionUtil.MD5).toUpperCase();
    }

    private String getOut_trade_no(Date dateTime) {
        StringBuffer sb = getTime(dateTime);
        //添加11个随机数，使得订单号为25位字符
        for (int i = 0; i < 11; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    private StringBuffer getTime(Date dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer sb = new StringBuffer();
        sb.append(dateFormat.format(dateTime));
        return sb;
    }

}
