package net.i2it.hit.hit_alumni.entity.vo;

public class SimpleOrderInfoVO {

    private String itemBody;
    private String itemDetail;
    private double itemMoney;
    private String origin;

    public SimpleOrderInfoVO() {
    }

    public SimpleOrderInfoVO(String itemBody, String itemDetail, double itemMoney, String origin) {

        this.itemBody = itemBody;
        this.itemDetail = itemDetail;
        this.itemMoney = itemMoney;
        this.origin = origin;
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
