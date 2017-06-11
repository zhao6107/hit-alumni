package net.i2it.hit.hitef.entity.vo.api.response;

/**
 * 请求微信API获取access_token,得到正确结果的
 * Created by liuming on 2017/4/15.
 */
public class AppAccessTokenVO {

    private String access_token;
    private String expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

}
