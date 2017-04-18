package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.entity.vo.PayRequestVO;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.UnifiedOrderResultVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.WebAccessTokenVO;
import net.i2it.hit.hit_alumni.service.function.JsSdkConfig;
import net.i2it.hit.hit_alumni.service.function.UnifiedOrder;
import net.i2it.hit.hit_alumni.service.function.WeChatApi;
import net.i2it.hit.hit_alumni.util.ValueGeneratorUtil;
import net.i2it.hit.hit_alumni.util.WebUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理前端控制器传来的参数，进行业务分发和处理
 */
public class DonateService {

    private UnifiedOrderResultVO getUnifiedOrderResult(String code, SimpleOrderInfoVO simpleOrderInfo) {
        UnifiedOrder unifiedOrder = new UnifiedOrder();
        WeChatApi weChatApi = new WeChatApi();
        WebAccessTokenVO webAccessTokenVO = weChatApi.getWebAccessToken(code);
        if (webAccessTokenVO != null) {
            String unifiedOrderXmlStr = XmlUtil.object2XmlStr(unifiedOrder
                    .getUnifiedOrderInfo(webAccessTokenVO.getOpenid(), simpleOrderInfo));
            System.out.println(unifiedOrderXmlStr);
            return weChatApi.getUnifiedOrderResult(unifiedOrderXmlStr);
        }
        return null;
    }

    public SimpleOrderInfoVO getSimpleOrderInfo(String itemInfo) {
        String[] arr = itemInfo.split("_");
        if (arr.length == 4) {
            return new SimpleOrderInfoVO(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
        }
        System.out.println("[request parameter error]：订单请求参数不合法。");
        return null;
    }

    public JsSdkConfigVO getJsSdkConfig(HttpServletRequest request) {
        String url = WebUtil.getFullUrl(request);
        JsSdkConfig jsSdkConfig = new JsSdkConfig();
        return jsSdkConfig.getJsSdkConfig(url);
    }

    /**
     * 主要负责用于构建生成网页端js发起支付请求时需要数据的承载结构 PayRequestVO
     *
     * @param code
     * @param simpleOrderInfo
     * @return
     */
    public PayRequestVO getPayRequestInfo(String code, SimpleOrderInfoVO simpleOrderInfo) {
        UnifiedOrderResultVO unifiedOrderResult = null;
        if (simpleOrderInfo != null) {
            unifiedOrderResult = this.getUnifiedOrderResult(code, simpleOrderInfo);
        }
        PayRequestVO payRequestVO = new PayRequestVO();
        payRequestVO.setAppId(ConfigConsts.APP_ID);
        payRequestVO.setTimeStamp(System.currentTimeMillis() / 10 + "");
        payRequestVO.setNonceStr(ValueGeneratorUtil.randomStr(20));
        payRequestVO.setPackageStr("prepay_id=" + ((unifiedOrderResult != null) ? unifiedOrderResult.getPrepay_id() : "0123456789"));
        payRequestVO.setPaySign(ValueGeneratorUtil.getSign(payRequestVO));
        return payRequestVO;
    }

}
