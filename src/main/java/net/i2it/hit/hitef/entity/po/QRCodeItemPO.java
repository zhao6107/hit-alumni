package net.i2it.hit.hitef.entity.po;

/**
 * 二维码发起的捐款项目
 * Created by liuming on 2017/6/1.
 */
public class QRCodeItemPO {

    private int id;
    private String body;
    private String detail;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}
