package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.bo.SimpleOrderInfoBO;
import net.i2it.hit.hit_alumni.entity.bo.UnifiedOrderBO;
import net.i2it.hit.hit_alumni.util.EncryptionUtil;

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

    public String getOrderInfo(String openid, SimpleOrderInfoBO simpleOrderInfo) {
        UnifiedOrderBO orderInfo = new UnifiedOrderBO();
        orderInfo.setOpenid(openid);
        orderInfo.setNonce_str((int) (Math.random() * 100000000) + "");
        orderInfo.setBody(simpleOrderInfo.getItemName());
        orderInfo.setDetail(simpleOrderInfo.getItemDetail());
        orderInfo.setOut_trade_no("");
        return "";
    }

    /**
     * 签名算法 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
     *
     * @param orderInfo
     * @return
     */
    private String getSign(UnifiedOrderBO orderInfo) {
        //用于存放获得的对象属性名以及对应的属性值
        Map<String, Object> params = new HashMap<String, Object>();
        //获取对象中属性值不为null的属性及属性值
        Field[] fields = orderInfo.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(orderInfo);
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

    private String getOut_trade_no() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateTime = new Date(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        sb.append(formatter.format(dateTime));
        for (int i = 0; i < 16; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

}
