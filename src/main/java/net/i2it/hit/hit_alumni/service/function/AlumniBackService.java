package net.i2it.hit.hit_alumni.service.function;

import net.i2it.hit.hit_alumni.dao.ActivityInfoDao;
import net.i2it.hit.hit_alumni.dao.AlumniInfoDao;
import net.i2it.hit.hit_alumni.entity.po.AlumniPO;
import net.i2it.hit.hit_alumni.entity.po.BackActivityPO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 对应着校友返校服务
 * Created by liuming on 2017/5/22.
 */
@Service
public class AlumniBackService {

    @Autowired
    private AlumniInfoDao alumniInfoDao;
    @Autowired
    private ActivityInfoDao activityInfoDao;

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
     * 获取校友信息
     *
     * @param openId
     * @return
     */
    public AlumniPO getAlumniInfo(String openId) {
        return alumniInfoDao.get(openId);
    }

    //将返校校友的注册信息持久化到数据表中
    public boolean saveAlumniInfo(AlumniPO alumniInfo) {
        if (alumniInfoDao.save(alumniInfo) == 1) {
            return true;
        }
        return false;
    }

    //更新返校校友的注册信息到数据表中
    public boolean updateAlumniInfo(AlumniPO alumniInfo) {
        if (alumniInfoDao.updateAlumniInfo(alumniInfo) == 1) {
            return true;
        }
        return false;
    }

    //将返校校友填写的返校活动信息持久化到数据库中
    public boolean saveActivityInfo(BackActivityPO activityInfo) {
        if (activityInfoDao.save(activityInfo) == 1) {
            return true;
        }
        return false;
    }

    //获取用户当前是否存在已经提交但没有结束的返校活动信息
    public BackActivityPO getCurActivity(String openId) {
        return activityInfoDao.getCurActivityInfo(openId);
    }

}
