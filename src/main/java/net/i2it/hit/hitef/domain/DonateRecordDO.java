package net.i2it.hit.hitef.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应着数据中的t_donate数据表
 * Created by liuming on 2017/4/17.
 */
public class DonateRecordDO implements Serializable {

    private String outTradeNo;
    private String openId;
    private int fundItemId;
    private String fundItemName;
    private double totalFee;
    private String origin;
    private Date timeEnd;
    private int state;
    private String comment;
    private String trueName;
    private String phone;
    private String entryYear;
    private String major;
    private String mailAddr;
    private String company;
    private String job;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFundItemName() {
        return fundItemName;
    }

    public void setFundItemName(String fundItemName) {
        this.fundItemName = fundItemName;
    }

    public int getFundItemId() {
        return fundItemId;
    }

    public void setFundItemId(int fundItemId) {
        this.fundItemId = fundItemId;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "DonateRecordDO{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", openId='" + openId + '\'' +
                ", fundItemName='" + fundItemName + '\'' +
                ", fundItemId=" + fundItemId +
                ", totalFee=" + totalFee +
                ", origin='" + origin + '\'' +
                ", timeEnd=" + timeEnd +
                ", state=" + state +
                ", comment='" + comment + '\'' +
                ", trueName='" + trueName + '\'' +
                ", phone='" + phone + '\'' +
                ", entryYear='" + entryYear + '\'' +
                ", major='" + major + '\'' +
                ", mailAddr='" + mailAddr + '\'' +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
