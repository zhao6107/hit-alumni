package net.i2it.hit.hitef.domain;

import net.i2it.hit.hitef.entity.vo.api.request.PayRequestVO;

public class DonateFormVO {

    private PayRequestVO payRequestVO;
    private String outTradeNo;
    private String serverUrl;

    public PayRequestVO getPayRequestVO() {
        return payRequestVO;
    }

    public void setPayRequestVO(PayRequestVO payRequestVO) {
        this.payRequestVO = payRequestVO;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

}
