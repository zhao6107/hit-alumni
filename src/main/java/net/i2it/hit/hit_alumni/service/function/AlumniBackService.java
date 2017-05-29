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
import java.util.*;

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

    //获取一个用户的全部返校信息
    public Map<Long, Object> divideActivities(String openId) {
        Map<Long, Object> map = new HashMap<Long, Object>();
        map.put(1L, new ArrayList<BackActivityPO>());//存储已经结束的返校活动信息
        List<BackActivityPO> list = activityInfoDao.getAllPostedActivities(openId);
        Date curDate = new Date();
        for (BackActivityPO backActivityPO : list) {
            if (backActivityPO.getBeginDate().before(curDate) && backActivityPO.getEndDate().after(curDate)) {
                map.put(2L, backActivityPO);//正在进行的返校活动
            } else if (backActivityPO.getBeginDate().after(curDate)) {
                map.put(3L, backActivityPO);//尚未进行的返校活动
            } else {
                ((ArrayList<BackActivityPO>) (map.get(1L))).add(backActivityPO);
            }
        }
        return map;
    }

    //根据id获取对应的返校活动
    public BackActivityPO getActivityInfoById(Integer id) {
        if (id != null) {
            return activityInfoDao.getActivityInfo(id);
        }
        return null;
    }

    //更新返校活动信息
    public boolean updateActivityInfo(BackActivityPO activityInfo) {
        if (activityInfoDao.updateActivityInfo(activityInfo) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
