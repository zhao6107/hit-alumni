package net.i2it.hit.hitef.domain;

public class SimpleOrderInfoVO {

    private String tmpItemId;
    private int itemId;
    private String itemBody;
    private String itemDetail;
    private String tmpItemMoney;
    private double itemMoney;
    private String origin;

    public SimpleOrderInfoVO() {
    }

    public SimpleOrderInfoVO(String itemBody, String itemDetail, String tmpItemMoney, String origin) {
        this.itemBody = itemBody;
        this.itemDetail = itemDetail;
        this.tmpItemMoney = tmpItemMoney;
        this.origin = origin;
    }

    public SimpleOrderInfoVO(String itemBody, String itemDetail, String tmpItemMoney, String origin, String tmpItemId) {
        this.tmpItemId = tmpItemId;
        this.itemBody = itemBody;
        this.itemDetail = itemDetail;
        this.tmpItemMoney = tmpItemMoney;
        this.origin = origin;
    }

    public String getTmpItemId() {
        return tmpItemId;
    }

    public void setTmpItemId(String tmpItemId) {
        this.tmpItemId = tmpItemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemBody() {
        return itemBody;
    }

    public void setItemBody(String itemBody) {
        this.itemBody = itemBody;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public String getTmpItemMoney() {
        return tmpItemMoney;
    }

    public void setTmpItemMoney(String tmpItemMoney) {
        this.tmpItemMoney = tmpItemMoney;
    }

    public double getItemMoney() {
        return itemMoney;
    }

    public void setItemMoney(double itemMoney) {
        this.itemMoney = itemMoney;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "SimpleOrderInfoVO{" +
                "tmpItemId='" + tmpItemId + '\'' +
                ", itemId=" + itemId +
                ", itemBody='" + itemBody + '\'' +
                ", itemDetail='" + itemDetail + '\'' +
                ", tmpItemMoney='" + tmpItemMoney + '\'' +
                ", itemMoney=" + itemMoney +
                ", origin='" + origin + '\'' +
                '}';
    }

}
