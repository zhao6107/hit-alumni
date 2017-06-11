package net.i2it.hit.hitef.domain;

public class FundItemDO extends CommonInfo {

    private String desc;//描述
    private int typeId;////基金所属的类别id，校级还是某个院系，特别的：特别推荐基金（校级基金）id指定为1
    private int status;//状态，是否终止：0-终止，1-正常
    private int ctime;//创建时间，秒，（1970年1月1日0时起的秒数）
    private int utime;//修改时间

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public int getUtime() {
        return utime;
    }

    public void setUtime(int utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "FundItemDO{" +
                "desc='" + desc + '\'' +
                ", typeId=" + typeId +
                ", status=" + status +
                ", ctime=" + ctime +
                ", utime=" + utime +
                "} " + super.toString();
    }

}
