package net.i2it.hit.hitef.domain.api.response;

/**
 * 请求微信接口获取jsapi_ticket得到的json返回值对应的实例对象
 * Created by liuming on 2017/4/15.
 */
public class JsApiTicketVO {

    private int errcode;
    private String errmsg;
    private String ticket;
    private int expires_in;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
