package net.i2it.hit.hit_alumni.entity.vo;

public class SimpleOrderInfoVO {

    private String itemName;
    private String itemDetail;
    private double itemMoney;
    private String origin;

    public SimpleOrderInfoVO() {
    }

    public SimpleOrderInfoVO(String itemName, String itemDetail, double itemMoney, String origin) {

        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemMoney = itemMoney;
        this.origin = origin;
    }

    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
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

}
