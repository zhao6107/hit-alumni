package net.i2it.hit.hit_alumni.entity.vo;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;

/**
 * 调用微信的js sdk时进行配置所需的参数
 */
public class WeChatJsSdkVO {

    private boolean debug;
    private String appId;
    private int timestamp;
    private String nonceStr;
    private String signature;
    private String jsApiList;

    public WeChatJsSdkVO() {
    }

    public WeChatJsSdkVO(String appId, int timestamp, String nonceStr, String signature) {
        this.appId = appId;
        this.timestamp = timestamp;
        this.nonceStr = nonceStr;
        this.signature = signature;
        this.debug = ConfigConsts.DEBUG;
        this.jsApiList = ConfigConsts.JS_API_LIST;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getJsApiList() {
        return jsApiList;
    }

    public void setJsApiList(String jsApiList) {
        this.jsApiList = jsApiList;
    }

}
