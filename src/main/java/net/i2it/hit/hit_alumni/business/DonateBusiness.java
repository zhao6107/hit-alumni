package net.i2it.hit.hit_alumni.business;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.PayRequestVO;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.UnifiedOrderResultVO;
import net.i2it.hit.hit_alumni.service.UnifiedOrderService;
import net.i2it.hit.hit_alumni.service.UserInfoService;
import net.i2it.hit.hit_alumni.util.FieldGenaratorUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;

/**
 * 处理前端控制器传来的参数，进行业务分发和处理
 */
public class DonateBusiness {

	public UnifiedOrderResultVO getUnifiedOrderResult(String itemInfo, String code) {
		UnifiedOrderService unifiedOrderService = new UnifiedOrderService();
		SimpleOrderInfoVO simpleOrderInfo = this.getSimpleOrderInfo(itemInfo);
		String openid = new UserInfoService().getUserInfoFromWeb(code).getOpenid();
		String unifiedOrderResult = unifiedOrderService.getUnifiedOrderResult(openid, simpleOrderInfo);
		return (UnifiedOrderResultVO) XmlUtil.xmlStr2Object(unifiedOrderResult, UnifiedOrderResultVO.class);
	}

	public UnifiedOrderResultVO getUnifiedOrderResult(SimpleOrderInfoVO simpleOrderInfo, String code) {
		UnifiedOrderService unifiedOrderService = new UnifiedOrderService();
		String openid = new UserInfoService().getUserInfoFromWeb(code).getOpenid();
		String unifiedOrderResult = unifiedOrderService.getUnifiedOrderResult(openid, simpleOrderInfo);
		return (UnifiedOrderResultVO) XmlUtil.xmlStr2Object(unifiedOrderResult, UnifiedOrderResultVO.class);
	}

	public SimpleOrderInfoVO getSimpleOrderInfo(String itemInfo) {
		String[] arr = itemInfo.split("_");
		if (arr.length == 3) {
			SimpleOrderInfoVO simpleOrderInfo = new SimpleOrderInfoVO(arr[0], arr[2], Double.parseDouble(arr[1]));
			System.out.println(simpleOrderInfo.getItemName()+" "+simpleOrderInfo.getItemDetail());
			return simpleOrderInfo;
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
		payRequestVO.setNonceStr(FieldGenaratorUtil.randomStr(20));
		payRequestVO.setPackageStr(prepayIdStr);
		payRequestVO.setPaySign(FieldGenaratorUtil.getSign(payRequestVO));
		return payRequestVO;
	}

}
