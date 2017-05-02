package net.i2it.hit.hit_alumni.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应着数据中的t_donate数据表
 * Created by liuming on 2017/4/17.
 */
public class DonatePO implements Serializable {

    private String out_trade_no;
    private String openid;
    private String body;
    private String detail;
    private double total_fee;
    private String origin;
    private Date time_end;
    private int state;
    private String comment;
    private String true_name;
    private String phone;
    private String entry_year;
    private String major;
    private String mail_addr;
    private String company;
    private String job;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getTime_end() {
        return time_end;
    }

    public void setTime_end(Date time_end) {
        this.time_end = time_end;
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

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEntry_year() {
        return entry_year;
    }

    public void setEntry_year(String entry_year) {
        this.entry_year = entry_year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMail_addr() {
        return mail_addr;
    }

    public void setMail_addr(String mail_addr) {
        this.mail_addr = mail_addr;
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
        return "DonatePO{" +
                "out_trade_no='" + out_trade_no + '\'' +
                ", openid='" + openid + '\'' +
                ", body='" + body + '\'' +
                ", detail='" + detail + '\'' +
                ", total_fee=" + total_fee +
                ", origin='" + origin + '\'' +
                ", time_end=" + time_end +
                ", state=" + state +
                ", comment='" + comment + '\'' +
                ", true_name='" + true_name + '\'' +
                ", phone='" + phone + '\'' +
                ", entry_year='" + entry_year + '\'' +
                ", major='" + major + '\'' +
                ", mail_addr='" + mail_addr + '\'' +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
