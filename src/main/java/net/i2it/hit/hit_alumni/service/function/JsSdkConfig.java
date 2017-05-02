package net.i2it.hit.hit_alumni.service.function;

import net.i2it.hit.hit_alumni.constant.CacheConsts;
import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.util.EncryptionUtil;
import net.i2it.hit.hit_alumni.util.ValueGeneratorUtil;

/**
 * 整个应用中关于配置设置的一些操作
 * Created by liuming on 2017/4/15.
 */
public class JsSdkConfig {

    /**
     * 获取网页面传输js-sdk配置信息的实例对象
     *
     * @param url
     * @return
     */
    public JsSdkConfigVO getJsSdkConfig(String url) {
        JsSdkConfigVO jsSdkConfigVO = new JsSdkConfigVO();
        jsSdkConfigVO.setNonceStr(ValueGeneratorUtil.randomStr(16));
        jsSdkConfigVO.setAppId(ConfigConsts.getApp_id());
        jsSdkConfigVO.setTimestamp(System.currentTimeMillis());
        jsSdkConfigVO.setSignature(this.getSign(jsSdkConfigVO, url));
        return jsSdkConfigVO;
    }

    // 微信网页js sdk配置中的signatrue的签名算法
    private String getSign(JsSdkConfigVO jsSdkConfigVO, String url) {
        StringBuffer sb = new StringBuffer();
        sb.append("jsapi_ticket=" + CacheConsts.JS_API_TICKET);
        sb.append("&noncestr=" + jsSdkConfigVO.getNonceStr());
        sb.append("&timeStamp=" + jsSdkConfigVO.getTimestamp());
        sb.append("&url=" + url);
        return EncryptionUtil.encrypt(sb.toString(), EncryptionUtil.SHA1);
    }

}
