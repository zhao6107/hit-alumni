package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.dao.DonateDao;
import net.i2it.hit.hit_alumni.dao.ItemDao;
import net.i2it.hit.hit_alumni.entity.Pager;
import net.i2it.hit.hit_alumni.entity.po.DonatePO;
import net.i2it.hit.hit_alumni.entity.po.ItemPO;
import net.i2it.hit.hit_alumni.entity.vo.ItemVO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.service.function.JsSdkConfig;
import net.i2it.hit.hit_alumni.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    public Pager<DonatePO> getPage(int pageIndex, int pageSize) {
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

}
