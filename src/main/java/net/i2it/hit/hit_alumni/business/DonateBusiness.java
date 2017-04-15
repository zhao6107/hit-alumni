package net.i2it.hit.hit_alumni.business;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.PayRequestVO;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.UnifiedOrderResultVO;
import net.i2it.hit.hit_alumni.service.UnifiedOrderService;
import net.i2it.hit.hit_alumni.service.WeChatApiService;
import net.i2it.hit.hit_alumni.util.ValueGeneratorUtil;

/**
 * 处理前端控制器传来的参数，进行业务分发和处理
 */
public class DonateBusiness {

    public UnifiedOrderResultVO getUnifiedOrderResult(String code, SimpleOrderInfoVO simpleOrderInfo) {
        UnifiedOrderService unifiedOrderService = new UnifiedOrderService();
        WeChatApiService weChatApiService = new WeChatApiService();
        String openid = weChatApiService.getWebAccessToken(code).getOpenid();
        System.out.println(openid);
        String unifiedOrderXmlStr = unifiedOrderService.getOrderInfo(openid, simpleOrderInfo);
        System.out.println(unifiedOrderXmlStr);
        return weChatApiService.getUnifiedOrderResult(unifiedOrderXmlStr);
    }

    public SimpleOrderInfoVO getSimpleOrderInfo(String itemInfo) {
        String[] arr = itemInfo.split("_");
        if (arr.length == 4) {
            return new SimpleOrderInfoVO(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
        }
        return null;
    }

    /**
     * 主要负责用于构建生成网页端js发起支付请求时需要数据的承载结构 PayRequestVO
     *
     * @param prepayIdStr
     * @return
     */
    public PayRequestVO getPayRequestInfo(String prepayIdStr) {
        PayRequestVO payRequestVO = new PayRequestVO();
        payRequestVO.setAppId(ConfigConsts.APP_ID);
        payRequestVO.setTimeStamp(System.currentTimeMillis() / 10 + "");
        payRequestVO.setNonceStr(ValueGeneratorUtil.randomStr(20));
        payRequestVO.setPackageStr(prepayIdStr);
        payRequestVO.setPaySign(ValueGeneratorUtil.getSign(payRequestVO));
        return payRequestVO;
    }

}
