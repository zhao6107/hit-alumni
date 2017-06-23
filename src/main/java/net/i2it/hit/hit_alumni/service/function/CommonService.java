package net.i2it.hit.hit_alumni.service.function;

import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.util.WebUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CommonService {

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

}
