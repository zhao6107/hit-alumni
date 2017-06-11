package net.i2it.hit.hitef.service.function;

import net.i2it.hit.hitef.constant.CacheConsts;
import net.i2it.hit.hitef.constant.ConfigConsts;
import net.i2it.hit.hitef.entity.vo.api.response.AppAccessTokenVO;
import net.i2it.hit.hitef.entity.vo.api.response.JsApiTicketVO;

/**
 * 具体的定时任务逻辑和内容：主要用于更新access_token和jsapi_ticket
 */
public class RefreshTimer implements Runnable {

    private WeChatApi apiService = new WeChatApi();

    public void run() {
        while (true) {
            String lastAccessToken = CacheConsts.APP_ACCESS_TOKEN;
            String lastJsApiTicket = CacheConsts.JS_API_TICKET;
            while (true) {
                if (ConfigConsts.getApp_id() != null && ConfigConsts.getApp_secret() != null) {
                    //更新access_token
                    AppAccessTokenVO accessToken = apiService.getAppAccessToken(ConfigConsts.getApp_id(), ConfigConsts.getApp_secret());
                    if (accessToken != null) {
                        CacheConsts.APP_ACCESS_TOKEN = accessToken.getAccess_token();
                        if (CacheConsts.APP_ACCESS_TOKEN != lastAccessToken) {
                            //更新jsapi_ticket
                            JsApiTicketVO jsApiTicket = apiService.getJsApiTIcket(CacheConsts.APP_ACCESS_TOKEN);
                            CacheConsts.JS_API_TICKET = jsApiTicket.getTicket();
                            if (CacheConsts.JS_API_TICKET != lastJsApiTicket) {
                                //更新access_token和jsapi_ticket的更新时间
                                CacheConsts.LAST_REFRESH_TIME = System.currentTimeMillis();
                                System.out.println(">>> " + CacheConsts.APP_ACCESS_TOKEN + "   " + CacheConsts.JS_API_TICKET);
                            }
                        }
                    }
                }

                if (System.currentTimeMillis() - CacheConsts.LAST_REFRESH_TIME > 90 * 60 * 1000) {
                    //如果没有成功刷新，20秒后尝试再次刷新
                    try {
                        Thread.sleep(20 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

            try {
                //每隔100分钟，尝试进行刷新
                Thread.sleep(100 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
