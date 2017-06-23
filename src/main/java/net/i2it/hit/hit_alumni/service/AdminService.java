package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.dao.*;
import net.i2it.hit.hit_alumni.entity.Pager;
import net.i2it.hit.hit_alumni.entity.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台管理的业务逻辑
 * Created by liuming on 2017/4/24.
 */
@Service
public class AdminService {

    @Autowired
    private ActivityInfoDao activityInfoDao;
    @Autowired
    private AlumniInfoDao alumniInfoDao;

    /**************************************************
     * 查看返校信息登记
     **************************************************/

    public Pager<BackActivityPO> getActivityPage(int pageIndex, int pageSize) {
        int recordCount = activityInfoDao.getRecordCount();
        if (recordCount == 0) {
            return new Pager<BackActivityPO>(pageSize, 0, 0, 0, null);
        } else {
            int tmp = recordCount / pageSize;
            int totalPage = (tmp * pageSize == recordCount) ? tmp : (tmp + 1);
            //当查询的页数存在
            if ((pageIndex * pageSize < recordCount)//取前totalPage-1页中的某一页
                    || ((pageIndex * pageSize >= recordCount) && ((pageIndex - 1) * pageSize < recordCount))//最后一页
                    ) {
                List<BackActivityPO> activityPOList = activityInfoDao.listPageActivity((pageIndex - 1) * pageSize, pageSize);
                return new Pager<BackActivityPO>(pageSize, pageIndex, recordCount, totalPage, activityPOList);
            } else {//如果查询的页数不存在，返回最后一页
                List<BackActivityPO> activityPOList = activityInfoDao.listPageActivity((totalPage - 1) * pageSize, pageSize);
                return new Pager<BackActivityPO>(pageSize, totalPage, recordCount, totalPage, activityPOList);
            }
        }
    }

    public AlumniPO getAlumniInfo(String openId) {
        return alumniInfoDao.get(openId);
    }

}