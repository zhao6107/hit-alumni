package net.i2it.hit.hit_alumni.service.function;

import com.alibaba.fastjson.JSON;
import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.api.response.AppAccessTokenVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.JsApiTicketVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.UnifiedOrderResultVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.WebAccessTokenVO;
import net.i2it.hit.hit_alumni.util.HTTPUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;

/**
 * 微信各服务功能接口的实现
 * Created by liuming on 2017/4/15.
 */
public class WeChatApi {

    // 微信调用接口
    /**
     * 全局access_token请求接口
     */
    public final static String API_APP_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 微信网页开发：在微信网页中获取用于置换access_token（在网页中使用）的code
     */
    public final static String API_WEB_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    /**
     * 微信网页开发：获取在微信网页中使用的access_token
     */
    public final static String API_WEB_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    /**
     * 微信网页开发：使用js-sdk进行配置的时候，需要的签名生成需要使用jsapi_ticket，这为jsapi_ticket的请求接口
     */
    public final static String API_WEB_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    /**
     * 微信支付：统一下单接口，返回结果中最为重要的是prepay_id
     */
    public final static String API_PAY_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";


    /**
     * 获取全局access_token
     *
     * @param appid
     * @param secret
     * @return
     */
    public AppAccessTokenVO getAppAccessToken(String appid, String secret) {
        String url = API_APP_ACCESS_TOKEN.replace("APPID", appid).replace("APPSECRET", secret);
        String result = HTTPUtil.doGet(url);
        if (result != null && result.contains("access_token")) {
            AppAccessTokenVO accessTokenVO = JSON.parseObject(result, AppAccessTokenVO.class);
            return accessTokenVO;
        }
        System.out.println("[request fail]：获取微信全局access_token失败。");
        return null;
    }

    /**
     * 微信网页开发：获取在微信网页中使用的access_token<br>
     * 方式：以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid以及网页access_token的，access_token可被进一步用来获取用户的基本信息<br>
     *
     * @param code
     * @return
     */
    public WebAccessTokenVO getWebAccessToken(String code) {
        String url = API_WEB_ACCESS_TOKEN.replace("APPID", ConfigConsts.APP_ID)
                .replace("SECRET", ConfigConsts.APP_SECRET).replace("CODE", code);
        String result = HTTPUtil.doGet(url);
        System.out.println(result);
        if (result != null && result.contains("access_token")) {
            return JSON.parseObject(result, WebAccessTokenVO.class);
        }
        System.out.println("[request fail]：微信网页授权获取access_token和openid失败。");
        return null;
    }

    /**
     * 微信网页开发：使用js-sdk进行配置的时候，生成需要的签名需要使用jsapi_ticket
     *
     * @param appAccessToken
     * @return
     */
    public JsApiTicketVO getJsApiTIcket(String appAccessToken) {
        String url = API_WEB_JSAPI_TICKET.replace("ACCESS_TOKEN", appAccessToken);
        String result = HTTPUtil.doGet(url);
        if (result != null) {
            return JSON.parseObject(result, JsApiTicketVO.class);
        }
        System.out.println("[request fail]：微信网页授权获取jsapi_ticket失败。");
        return null;
    }

    /**
     * 微信支付：获取微信统一下单的结果
     *
     * @param unifiedOrderXmlStr 包含统一下单接口所需参数的xml格式的字符串
     * @return
     */
    public UnifiedOrderResultVO getUnifiedOrderResult(String unifiedOrderXmlStr) {
        System.out.println(unifiedOrderXmlStr);
        String result = HTTPUtil.doPost(API_PAY_UNIFIED_ORDER, unifiedOrderXmlStr);
        System.out.println(result);
        if (result != null) {
            return (UnifiedOrderResultVO) XmlUtil.xmlStr2Object(result, UnifiedOrderResultVO.class);
        }
        System.out.println("[request fail]：请求统一下单接口失败，未得到返回结果。");
        return null;
    }

}
