package net.i2it.hit.hitef.domain;

import java.util.Date;

/**
 * Created by liuming on 2017/6/19.
 */
public class SimpleDonateVO {

    private String donatorName;
    private String fundItemName;
    private Double donateMoney;
    private Date donateDate;

    public String getDonatorName() {
        return donatorName;
    }

    public void setDonatorName(String donatorName) {
        this.donatorName = donatorName;
    }

    public String getFundItemName() {
        return fundItemName;
    }

    public void setFundItemName(String fundItemName) {
        this.fundItemName = fundItemName;
    }

    public Double getDonateMoney() {
        return donateMoney;
    }

    public void setDonateMoney(Double donateMoney) {
        this.donateMoney = donateMoney;
    }

    public Date getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(Date donateDate) {
        this.donateDate = donateDate;
    }

    @Override
    public String toString() {
        return "SimpleDonateVO{" +
                "donatorName='" + donatorName + '\'' +
                ", fundItemName='" + fundItemName + '\'' +
                ", donateMoney=" + donateMoney +
                ", donateDate=" + donateDate +
                '}';
    }

}