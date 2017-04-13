package net.i2it.hit.hit_alumni.business;

import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.UnifiedOrderResultVO;
import net.i2it.hit.hit_alumni.service.UnifiedOrderService;
import net.i2it.hit.hit_alumni.service.UserInfoService;
import net.i2it.hit.hit_alumni.util.XmlUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    private SimpleOrderInfoVO getSimpleOrderInfo(String itemInfo) {
        try {
            itemInfo = URLEncoder.encode(itemInfo, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] arr = itemInfo.split("_");
        if (arr.length == 3) {
            SimpleOrderInfoVO simpleOrderInfo = new SimpleOrderInfoVO(arr[0], arr[2], Double.parseDouble(arr[1]));
            return simpleOrderInfo;
        }
        return null;
    }

}
