package net.i2it.hit.hit_alumni.entity.po;

import java.util.Date;

/**
 * 对应数据库表中的t_items数据表
 * Created by liuming on 2017/4/24.
 */
public class ItemPO {

    private int id;
    private String body;
    private String detail;
    private int raisedFund;
    private int targetFund;
    private Date time_begin;
    private Date time_end;

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

    public int getRaisedFund() {
        return raisedFund;
    }

    public void setRaisedFund(int raisedFund) {
        this.raisedFund = raisedFund;
    }

    public int getTargetFund() {
        return targetFund;
    }

    public void setTargetFund(int targetFund) {
        this.targetFund = targetFund;
    }

    public Date getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(Date time_begin) {
        this.time_begin = time_begin;
    }

    public Date getTime_end() {
        return time_end;
    }

    public void setTime_end(Date time_end) {
        this.time_end = time_end;
    }

    @Override
    public String toString() {
        return "ItemPO{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", detail='" + detail + '\'' +
                ", raisedFund=" + raisedFund +
                ", targetFund=" + targetFund +
                ", time_begin=" + time_begin +
                ", time_end=" + time_end +
                '}';
    }

}
