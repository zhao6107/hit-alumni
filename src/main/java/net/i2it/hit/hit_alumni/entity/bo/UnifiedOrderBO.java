package net.i2it.hit.hit_alumni.entity.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;

@XmlRootElement(name = "xml")
public class UnifiedOrderBO {

	private String appid = ConfigConsts.APP_ID;
	private String mch_id = ConfigConsts.MCH_ID;
	private String openid;
	private String nonce_str;
	private String sign;
	private String sign_type = "MD5";
	private String body;
	private String detail;
	private String out_trade_no;
	private String fee_type = "CNY";
	private String total_fee;
	private String spbill_create_ip;
	private String time_start;
	private String time_expire;
	private String device_info;
	private String trade_type = "JSAPI";
	private String notify_url;

	public String getAppid() {
		return appid;
	}

	@XmlElement
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	@XmlElement
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getOpenid() {
		return openid;
	}

	@XmlElement
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	@XmlElement
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	@XmlElement
	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	@XmlElement
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBody() {
		return body;
	}

	@XmlElement
	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	@XmlElement
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	@XmlElement
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	@XmlElement
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	@XmlElement
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	@XmlElement
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	@XmlElement
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	@XmlElement
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getDevice_info() {
		return device_info;
	}

	@XmlElement
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getTrade_type() {
		return trade_type;
	}

	@XmlElement
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getNotify_url() {
		return notify_url;
	}

	@XmlElement
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

}
