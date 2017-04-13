package net.i2it.hit.hit_alumni.service;

import com.alibaba.fastjson.JSON;
import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.WebAccessTokenVO;
import net.i2it.hit.hit_alumni.util.HTTPUtil;

/**
 * 关于获取微信用户信息的业务类
 *
 * @author liuming
 */
public class UserInfoService {

    /**
     * 从微信浏览器中的网页获取用户的openid信息<br>
     * 方式：以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid的
     *
     * @param code
     * @return
     */
    public WebAccessTokenVO getUserInfoFromWeb(String code) {
        String url = ConfigConsts.URL_ACCESS_TOKEN_FROM_WEB.replace("APPID", ConfigConsts.APP_ID)
                .replace("SECRET", ConfigConsts.APP_SECRET).replace("CODE", code);
        String jsonStr = HTTPUtil.doGet(url);
        WebAccessTokenVO webAccessToken = JSON.parseObject(jsonStr, WebAccessTokenVO.class);
        return webAccessToken;
    }

    /**
     * 从微信浏览器中的网页获取用户的openid、昵称、性别、头像等信息<br>
     * 方式：以snsapi_userinfo为scope发起的网页授权，是用来获取用户的基本信息的
     *
     * @param targetUrl
     * @return
     */
    public String getUserInfoFromWeb2(String targetUrl) {
        return null;
    }

}
