package net.i2it.hit.hit_alumni.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.UnifiedOrderInfoVO;
import net.i2it.hit.hit_alumni.util.FieldGenaratorUtil;
import net.i2it.hit.hit_alumni.util.HTTPUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;

/**
 * 负责与微信支付的统一下单接口的处理
 *
 * @author liuming
 */
public class UnifiedOrderService {

	public String getUnifiedOrderResult(String unifiedOrderXmlStr) {
		String result = HTTPUtil.doPost(ConfigConsts.URL_UNIFIED_ORDER, unifiedOrderXmlStr);
		return result;
	}

	public String getUnifiedOrderResult(String openid, SimpleOrderInfoVO simpleOrderInfo) {
		String tmp = this.getOrderInfo(openid, simpleOrderInfo);
		String result = HTTPUtil.doPost(ConfigConsts.URL_UNIFIED_ORDER, tmp);
		return result;
	}

	/**
	 * UnifiedOrderBO实体类的实例化和参数赋值，用于生成提交到统一下单接口的xml格式内容
	 *
	 * @param openid
	 * @param simpleOrderInfo
	 * @return
	 */
	public String getOrderInfo(String openid, SimpleOrderInfoVO simpleOrderInfo) {
		UnifiedOrderInfoVO orderInfo = new UnifiedOrderInfoVO();
		orderInfo.setOpenid(openid);
		orderInfo.setNonce_str((int) (Math.random() * 100000000) + "");
		try {
			orderInfo.setBody(URLEncoder.encode(simpleOrderInfo.getItemName(), "UTF-8"));
			orderInfo.setDetail(URLEncoder.encode(simpleOrderInfo.getItemDetail(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		orderInfo.setTotal_fee((int) (simpleOrderInfo.getItemMoney() * 100));
		// 借助于日期实现的字段
		Date dateTime = new Date();
		orderInfo.setOut_trade_no(this.getOut_trade_no(dateTime));
		orderInfo.setTime_start(FieldGenaratorUtil.getTime(dateTime));
		orderInfo.setTime_expire(FieldGenaratorUtil.getTime(new Date(dateTime.getTime() + 10 * 60 * 1000)));// 订单失效时间：10分钟
		orderInfo.setDevice_info("qr_code");
		orderInfo.setNotify_url(ConfigConsts.SERVER_DOMAIN + "/donate/result");
		// 最后一步才是设置sign
		orderInfo.setSign(FieldGenaratorUtil.getSign(orderInfo));
		// 转成xml格式
		return XmlUtil.object2XmlStr(orderInfo);
	}

	private String getOut_trade_no(Date dateTime) {
		String str = FieldGenaratorUtil.getTime(dateTime);
		// 添加11个随机数，使得订单号为25位字符
		str = str + FieldGenaratorUtil.randomStr(11);
		return str;
	}

}
