package net.i2it.hit.hit_alumni.service;

import net.i2it.hit.hit_alumni.dao.ItemDao;
import net.i2it.hit.hit_alumni.entity.po.ItemPO;
import net.i2it.hit.hit_alumni.entity.vo.ItemVO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.service.function.JsSdkConfig;
import net.i2it.hit.hit_alumni.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台管理的业务逻辑
 * Created by liuming on 2017/4/24.
 */
@Service
public class AdminService {

    @Autowired
    private ItemDao itemDao;

    public List<ItemPO> listNotExpiredItems() {
        return itemDao.listNotExpiredItems();
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

}
