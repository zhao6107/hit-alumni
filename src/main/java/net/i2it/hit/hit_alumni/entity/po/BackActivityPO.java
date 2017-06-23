package net.i2it.hit.hit_alumni.entity.po;

import java.util.Date;

/**
 * 对应着数据库中的t_back_activity_info数据表
 * Created by liuming on 2017/5/22.
 */
public class BackActivityPO {

    private Integer id;
    private String openId;
    private Date beginDate;//返校日期
    private Date endDate;//返校活动结束日期
    private int alumniNum;//返校人数
    private Date historyMuseumVisitedDate;//参观校史馆的日期，不为空表示校友总会需要帮助预约
    private Date astronauticsMuseumVisitedDate;//参观航天馆的日期，不为空表示校友总会需要帮助预约
    private Date schoolMuseumVisitedDate;//参观博物馆的日期，不为空表示校友总会需要帮助预约
    private int meetAlumniAssociation;//和校友总会是否对接，0-否，1-是
    private int acceptInterview;//接受学校采访，0-否，1-是
    private int giveLecture;//给学生开讲座，0-否，1-是
    private int needVolunteer;//需要志愿者给帮助拍照等，0-否，1-是

    public BackActivityPO() {
    }

    public BackActivityPO(Integer id, String openId, Date beginDate, Date endDate, int alumniNum, Date historyMuseumVisitedDate, Date astronauticsMuseumVisitedDate, Date schoolMuseumVisitedDate, int meetAlumniAssociation, int acceptInterview, int giveLecture, int needVolunteer) {
        this.id = id;
        this.openId = openId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.alumniNum = alumniNum;
        this.historyMuseumVisitedDate = historyMuseumVisitedDate;
        this.astronauticsMuseumVisitedDate = astronauticsMuseumVisitedDate;
        this.schoolMuseumVisitedDate = schoolMuseumVisitedDate;
        this.meetAlumniAssociation = meetAlumniAssociation;
        this.acceptInterview = acceptInterview;
        this.giveLecture = giveLecture;
        this.needVolunteer = needVolunteer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAlumniNum() {
        return alumniNum;
    }

    public void setAlumniNum(int alumniNum) {
        this.alumniNum = alumniNum;
    }

    public Date getHistoryMuseumVisitedDate() {
        return historyMuseumVisitedDate;
    }

    public void setHistoryMuseumVisitedDate(Date historyMuseumVisitedDate) {
        this.historyMuseumVisitedDate = historyMuseumVisitedDate;
    }

    public Date getAstronauticsMuseumVisitedDate() {
        return astronauticsMuseumVisitedDate;
    }

    public void setAstronauticsMuseumVisitedDate(Date astronauticsMuseumVisitedDate) {
        this.astronauticsMuseumVisitedDate = astronauticsMuseumVisitedDate;
    }

    public Date getSchoolMuseumVisitedDate() {
        return schoolMuseumVisitedDate;
    }

    public void setSchoolMuseumVisitedDate(Date schoolMuseumVisitedDate) {
        this.schoolMuseumVisitedDate = schoolMuseumVisitedDate;
    }

    public int getMeetAlumniAssociation() {
        return meetAlumniAssociation;
    }

    public void setMeetAlumniAssociation(int meetAlumniAssociation) {
        this.meetAlumniAssociation = meetAlumniAssociation;
    }

    public int getAcceptInterview() {
        return acceptInterview;
    }

    public void setAcceptInterview(int acceptInterview) {
        this.acceptInterview = acceptInterview;
    }

    public int getGiveLecture() {
        return giveLecture;
    }

    public void setGiveLecture(int giveLecture) {
        this.giveLecture = giveLecture;
    }

    public int getNeedVolunteer() {
        return needVolunteer;
    }

    public void setNeedVolunteer(int needVolunteer) {
        this.needVolunteer = needVolunteer;
    }

    @Override
    public String toString() {
        return "BackActivityPO{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", stuNum=" + alumniNum +
                ", historyMuseumVisitedDate=" + historyMuseumVisitedDate +
                ", astronauticsMuseumVisitedDate=" + astronauticsMuseumVisitedDate +
                ", schoolMuseumVisitedDate=" + schoolMuseumVisitedDate +
                ", meetAlumniAssociation=" + meetAlumniAssociation +
                ", acceptInterview=" + acceptInterview +
                ", giveLecture=" + giveLecture +
                ", needVolunteer=" + needVolunteer +
                '}';
    }

}
