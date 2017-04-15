/**
 *
 */
package net.i2it.hit.hit_alumni.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;

/**
 * @author liuming
 * @description 用于构造体教育微信接口的数据结构参数值的构造工具类
 */
public class ValueGeneratorUtil {

    /**
     * 用于获取只包含数字且指定长度的随机字符串
     *
     * @param length
     * @return
     */
    public static String randomStr(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    /**
     * 根据微信开发文档提供的签名算法生成签名<br>
     * 签名算法 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
     *
     * @param obj
     * @return
     */
    public static String getSign(Object obj) {
        // 用于存放获得的对象属性名以及对应的属性值
        Map<String, Object> params = new HashMap<String, Object>();
        // 获取对象中属性值不为null的属性及属性值
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
        // 对属性名进行排序（字典序）
        Object[] keys = params.keySet().toArray();
        Arrays.sort(keys);
        // 对属性名和属性值按照字典序拼接，形如：key1=value1&key2=value2
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i] + "=" + params.get(keys[i]) + "&");
        }
        sb.append("key=" + ConfigConsts.API_SECRET);
        return EncryptionUtil.encrypt(sb.toString().replace("packageStr", "package"), EncryptionUtil.MD5).toUpperCase();
    }

    /**
     * 获取当前日期格式化字符串<br>
     * 日期字符串格式为：yyyyMMddHHmmss
     *
     * @param dateTime
     * @return
     */
    public static String getTime(Date dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(dateTime);
    }

}
