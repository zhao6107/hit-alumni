package net.i2it.hit.hitef.entity.po;

/**
 * 对应着数据库中的t_back_student_info数据表
 * Created by liuming on 2017/5/20.
 */
public class AlumniPO {

    private String openId;
    private String name;//姓名
    private Integer entryYear;//入学年份
    private String classNO;//班级号码
    private String major;//专业名称
    private String academy;//院系名称
    private Integer contactType;//哪种联系方式：1-手机，2-微信，3-QQ
    private String contactInfo;//联系方式的内容
    private String company;//工作单位
    private String job;//职位

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Integer entryYear) {
        this.entryYear = entryYear;
    }

    public String getClassNO() {
        return classNO;
    }

    public void setClassNO(String classNO) {
        this.classNO = classNO;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
        return "AlumniPO{" +
                "openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                ", entryYear=" + entryYear +
                ", classNO='" + classNO + '\'' +
                ", major='" + major + '\'' +
                ", academy='" + academy + '\'' +
                ", contactType=" + contactType +
                ", contactInfo='" + contactInfo + '\'' +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
    
}
