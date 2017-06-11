package net.i2it.hit.hitef.service;

import net.i2it.hit.hitef.dao.*;
import net.i2it.hit.hitef.entity.Pager;
import net.i2it.hit.hitef.entity.po.*;
import net.i2it.hit.hitef.entity.vo.ItemVO;
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
    private ItemDao itemDao;
    @Autowired
    private DonateDao donateDao;
    @Autowired
    private ActivityInfoDao activityInfoDao;
    @Autowired
    private AlumniInfoDao alumniInfoDao;
    @Autowired
    private QRCodeItemDao qrCodeItemDao;

    /**************************************************
     * 对公众号内支付的捐款项目进行管理操作
     **************************************************/

    public List<ItemPO> listNotExpiredItems() {
        return itemDao.listNotExpiredItems();
    }

    public List<ItemPO> listExpiredItems() {
        return itemDao.listExpiredItems();
    }

    public boolean saveItem(ItemVO itemVO) {
        if (itemDao.save(itemVO) == 1) {
            return true;
        }
        return false;
    }

    public ItemPO getItem(int id) {
        return itemDao.get(id);
    }

    public boolean updateItem(int id, ItemVO itemVO) {
        if (itemDao.update(id, itemVO) == 1) {
            return true;
        }
        return false;
    }

    public boolean updateItemTimeEnd(int id) {
        if (itemDao.updateTimeEnd(id) == 1) {
            return true;
        }
        return false;
    }

    public boolean recoverItem(int id) {
        if (itemDao.recoverItem(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**************************************************
     * 查看捐款记录
     **************************************************/

    public Pager<DonatePO> getDonatePage(int pageIndex, int pageSize) {
        int recordCount = donateDao.getRecordCount();
        if (recordCount == 0) {
            return new Pager<DonatePO>(pageSize, 0, 0, 0, null);
        } else {
            int tmp = recordCount / pageSize;
            int totalPage = (tmp * pageSize == recordCount) ? tmp : (tmp + 1);
            //当查询的页数存在
            if ((pageIndex * pageSize < recordCount)//取前totalPage-1页中的某一页
                    || ((pageIndex * pageSize >= recordCount) && ((pageIndex - 1) * pageSize < recordCount))//最后一页
                    ) {
                List<DonatePO> donatePOList = donateDao.listPageDonate((pageIndex - 1) * pageSize, pageSize);
                return new Pager<DonatePO>(pageSize, pageIndex, recordCount, totalPage, donatePOList);
            } else {//如果查询的页数不存在，返回最后一页
                List<DonatePO> donatePOList = donateDao.listPageDonate((totalPage - 1) * pageSize, pageSize);
                return new Pager<DonatePO>(pageSize, totalPage, recordCount, totalPage, donatePOList);
            }
        }
    }

    public DonatePO getDonateInfo(String id) {
        return donateDao.get(id);
    }

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

    /**************************************************
     * 对二维码方式筹款的项目进行管理
     **************************************************/

    public List<QRCodeItemPO> getAllQRCodeItems() {
        return qrCodeItemDao.listItems();
    }

    public boolean addQRCodeItem(QRCodeItemPO item) {
        if (qrCodeItemDao.save(item) == 1) {
            return true;
        }
        return false;
    }

    public QRCodeItemPO getQRCodeItem(int id) {
        return qrCodeItemDao.getItem(id);
    }

    public boolean updateQRCodeItem(QRCodeItemPO item) {
        if (qrCodeItemDao.update(item) == 1) {
            return true;
        }
        return false;
    }

    public boolean delQRCodeItem(int id) {
        if (qrCodeItemDao.del(id) == 1) {
            return true;
        }
        return false;
    }

}