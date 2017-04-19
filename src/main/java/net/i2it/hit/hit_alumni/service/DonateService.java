package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.dao.DonateDao;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.PayRequestVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.PayResultNotifyVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.UnifiedOrderResultVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.WebAccessTokenVO;
import net.i2it.hit.hit_alumni.service.function.JsSdkConfig;
import net.i2it.hit.hit_alumni.service.function.UnifiedOrder;
import net.i2it.hit.hit_alumni.service.function.WeChatApi;
import net.i2it.hit.hit_alumni.util.ValueGeneratorUtil;
import net.i2it.hit.hit_alumni.util.WebUtil;
import net.i2it.hit.hit_alumni.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 处理前端控制器传来的参数，进行业务分发和处理
 */
@Service
public class DonateService {

    @Autowired
    private DonateDao donateDao;

    private UnifiedOrderResultVO getUnifiedOrderResult(String code, SimpleOrderInfoVO simpleOrderInfo) {
        WeChatApi weChatApi = new WeChatApi();
        //获取页面access_token
        WebAccessTokenVO webAccessTokenVO = weChatApi.getWebAccessToken(code);
        if (webAccessTokenVO != null) {
            //获取统一下单的提交参数
            Map<String, Object> map = new UnifiedOrder()
                    .getUnifiedOrderInfo(webAccessTokenVO.getOpenid(), simpleOrderInfo);
            //将统一下单接口接收的参数转为字符串类型的xml
            String unifiedOrderXmlStr = XmlUtil.object2XmlStr(map.get("order_info"));
            System.out.println(unifiedOrderXmlStr);
            //获取统一下单结果
            UnifiedOrderResultVO unifiedOrderResult = weChatApi.getUnifiedOrderResult(unifiedOrderXmlStr);
            if (unifiedOrderResult != null) {
                //统一下单成功后后将订单信息存入数据库
                //todo 数据库操作可能会抛出异常
                donateDao.save(map);
                return unifiedOrderResult;
            }
        }
        return null;
    }

    /**
     * 处理参数字符串，获取包含的订单简单信息
     *
     * @param itemInfo
     * @return
     */
    public SimpleOrderInfoVO getSimpleOrderInfo(String itemInfo) {
        String[] arr = itemInfo.split("_");
        if (arr.length == 4) {
            return new SimpleOrderInfoVO(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);
        }
        System.out.println("[request parameter error]：订单请求参数不合法。");
        return null;
    }

    /**
     * 获取微信js-sdk配置信息的数据
     *
     * @param request
     * @return
     */
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

    public boolean updatePayState(String notifyResult) {
        PayResultNotifyVO payResultNotifyVO = (PayResultNotifyVO) XmlUtil.xmlStr2Object(notifyResult, PayResultNotifyVO.class);
        String out_trade_no = payResultNotifyVO.getOut_trade_no();
        Date date = ValueGeneratorUtil.str2Date(payResultNotifyVO.getTime_end(), ValueGeneratorUtil.DATE_FORMAT_PATTERN);
        String time_end = ValueGeneratorUtil.date2Str(date, ValueGeneratorUtil.DATE_FORMAT_PATTERN2);
        System.out.println(out_trade_no + " " + time_end);
        if (donateDao.updateState(out_trade_no, time_end) == 1) {
            return true;
        }
        return false;
    }

}
