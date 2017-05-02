package net.i2it.hit.hit_alumni.constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * 微信开发的一些配置变量
 */
public class ConfigConsts {

    // 正式公众号的配置信息
    private static String app_id;
    private static String app_secret;
    private static String token;

    // 微信支付的配置信息
    private static String mch_id;
    private static String api_secret;

    // 微信网页JS-SDK配置
    private static boolean js_sdk_debug;
    private static String js_api_list;

    // 服务器域名
    private static String server_domain_url;

    //支付-统一下单处理对应的url
    private static String pay_url;

    public static String getApp_id() {
        return app_id;
    }

    public static String getApp_secret() {
        return app_secret;
    }

    public static String getToken() {
        return token;
    }

    public static String getMch_id() {
        return mch_id;
    }

    public static String getApi_secret() {
        return api_secret;
    }

    public static boolean isJs_sdk_debug() {
        return js_sdk_debug;
    }

    public static String getJs_api_list() {
        return js_api_list;
    }

    public static String getServer_domain_url() {
        return server_domain_url;
    }

    public static String getPay_url() {
        return pay_url;
    }

    /**
     * 加载配置文件通过反射的方式为每个变量赋值
     *
     * @throws IOException
     * @throws IllegalAccessException
     */
    public static void load() throws IOException, IllegalAccessException {
        //得到的是转码后的路径
        String configFilePath = ConfigConsts.class.getClassLoader().getResource("hit-alumni.properties").getPath();
        //如果路径中含有中文需要解码
        configFilePath = URLDecoder.decode(configFilePath, "utf-8");
        Properties properties = new Properties();
        properties.load(new FileInputStream(configFilePath));
        Field[] fields = ConfigConsts.class.getDeclaredFields();
        ConfigConsts obj = new ConfigConsts();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("js_sdk_debug")) {//变量js_sdk_debug的类型为boolean，单独处理
                field.set(obj, properties.get(field.getName()).equals("true"));
            } else if (field.getName().equals("js_api_list")) {//需要对字符串变量js_api_list的形式重新组织一下
                /*
                该变量字符串配置形式为：js_function0,js_function1,js_function2
                需要转换换成另一种形式：['js_function0','js_function1','js_function2']
                 */
                //将字符串切分，得到单个js功能
                String[] api_functions = ((String) properties.get(field.getName())).split(",");
                // 然后将每个js功能左右加上单引号'
                for (int i = 0; i < api_functions.length; i++) {
                    api_functions[i] = "'" + api_functions[i] + "'";
                }
                // 最后统一拼接新的形式
                StringBuffer newStr = new StringBuffer("[");
                for (int i = 0; i < api_functions.length - 1; i++) {
                    newStr.append(api_functions[i] + ",");
                }
                newStr.append(api_functions[api_functions.length - 1] + "]");
                // 将新结果赋值为这个变量
                field.set(obj, newStr);
            } else {
                field.set(obj, properties.get(field.getName()));
            }
        }
    }

}
