package net.i2it.hit.hit_alumni.entity.vo;

import net.i2it.hit.hit_alumni.entity.po.ItemPO;

/**
 * 进一步封装ItemPO，添加每个
 * Created by liuming on 2017/4/27.
 */
public class PageItemVO {

    private ItemPO item;
    private String payUrl;

    public ItemPO getItem() {
        return item;
    }

    public void setItem(ItemPO item) {
        this.item = item;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

}
