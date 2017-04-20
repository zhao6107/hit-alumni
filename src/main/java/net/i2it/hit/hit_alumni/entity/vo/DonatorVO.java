package net.i2it.hit.hit_alumni.entity.vo;

/**
 * 捐款人的信息
 * Created by liuming on 2017/4/19.
 */
public class DonatorVO {

    private String trueName;
    private String phone;
    private String classNO;
    private String entryYear;
    private String major;
    private String mailAddr;
    private String company;
    private String job;

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

    public String getClassNO() {
        return classNO;
    }

    public void setClassNO(String classNO) {
        this.classNO = classNO;
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
        return "DonatorVO{" +
                "trueName='" + trueName + '\'' +
                ", phone='" + phone + '\'' +
                ", classNO='" + classNO + '\'' +
                ", entryYear=" + entryYear +
                ", major='" + major + '\'' +
                ", mailAddr='" + mailAddr + '\'' +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}