package net.i2it.hit.hit_alumni.constant;

/**
 * 微信开发的一些配置变量
 */
public class ConfigConsts {

    // 微信调用接口
    public final static String URL_CODE_FROM_WEB = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    public final static String URL_ACCESS_TOKEN_FROM_WEB = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public final static String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

}
