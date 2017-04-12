package net.i2it.hit.hit_alumni.constant;

/**
 * 微信开发的一些配置变量
 */
public class ConfigConsts {

    // 正式公众号的配置信息
    public final static String APP_ID = "wx76aab038ac59632b";
    public final static String APP_SECRET = "336903f68e5455a77c94332f066168f6";
    public final static String TOKEN = "liuming";

    // 微信支付的配置信息
    public final static String MCH_ID = "1455797702";

    // 微信调用接口
    public final static String URL_CODE_FROM_WEB = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    public final static String URL_ACCESS_TOKEN_FROM_WEB = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    // 服务器域名
    public final static String SERVER_DOMAIN = "http://hit-alumni.tunnel.qydev.com";

}
