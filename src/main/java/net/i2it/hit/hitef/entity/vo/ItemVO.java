package net.i2it.hit.hitef.entity.vo;

/**
 * 每一个捐款项目的详细：捐款项目名、捐款项目的具体描述、捐款项目的目标筹集资金
 * Created by liuming on 2017/4/27.
 */
public class ItemVO {

    private String body;
    private String detail;
    private int targetFund;

    public ItemVO() {
    }

    public ItemVO(String body, String detail, int targetFund) {
        this.body = body;
        this.detail = detail;
        this.targetFund = targetFund;
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

    public int getTargetFund() {
        return targetFund;
    }

    public void setTargetFund(int targetFund) {
        this.targetFund = targetFund;
    }

}
