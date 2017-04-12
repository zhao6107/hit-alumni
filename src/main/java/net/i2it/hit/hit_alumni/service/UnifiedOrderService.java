package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.entity.bo.SimpleOrderInfoBO;
import net.i2it.hit.hit_alumni.entity.bo.UnifiedOrderBO;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * 负责与微信支付的统一下单接口的处理
 *
 * @author liuming
 */
public class UnifiedOrderService {

    public String getOrderInfo(String oepnid, SimpleOrderInfoBO simpleOrderInfo) {
        UnifiedOrderBO orderInfo = new UnifiedOrderBO();
        orderInfo.setOpenid(oepnid);
        orderInfo.setNonce_str((int) (Math.random() * 100000000) + "");
        return "";
    }

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
        String[] keys = (String[]) params.keySet().toArray();
        Arrays.sort(keys);
        //对属性名和属性值按照字典序拼接，形如：key1=value1&key2=value2
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i] + "=" + params.get(keys[i]) + "&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return null;
    }

    public static void main(String[] args) {
        new UnifiedOrderService().getSign(new UnifiedOrderBO());
    }

}
