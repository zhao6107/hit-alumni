package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.po.BackActivityPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActivityInfoDao {

    /**
     * 添加一条返校活动记录到数据库中
     *
     * @param activityInfo
     * @return
     */
    // openId,begin_date,end_date,back_stu_num,
    // visit_history_museum_datetime,visit_astronautics_museum_datetime,visit_school_museum_datetime,
    // meet_alumni_association,accepte_inerview,give_lecture,need_volunteer_assist
    @Insert("INSERT INTO t_back_activity_info VALUES(" +
            "DEFAULT,#{obj.openId},#{obj.beginDate},#{obj.endDate},#{obj.alumniNum}," +
            "#{obj.historyMuseumVisitedDate},#{obj.astronauticsMuseumVisitedDate},#{obj.schoolMuseumVisitedDate}," +
            "#{obj.meetAlumniAssociation},#{obj.acceptInterview},#{obj.giveLecture},#{obj.needVolunteer}" +
            ");")
    @Options(useGeneratedKeys = true, keyProperty = "obj.id")
    int save(@Param("obj") BackActivityPO activityInfo);

    /**
     * 查询一个人提交的返校活动信息
     *
     * @param openId
     * @return
     */
    @Select("SELECT * FROM t_back_activity_info WHERE openId=#{openId} ORDER BY begin_date DESC;;")
    @Results(value = {
            @Result(property = "id", column = "id", javaType = int.class),
            @Result(property = "openId", column = "openId", javaType = String.class),
            @Result(property = "beginDate", column = "begin_date", javaType = Date.class),
            @Result(property = "endDate", column = "end_date", javaType = Date.class),
            @Result(property = "alumniNum", column = "back_stu_num", javaType = int.class),
            @Result(property = "historyMuseumVisitedDate", column = "visit_history_museum_datetime", javaType = Date.class),
            @Result(property = "astronauticsMuseumVisitedDate", column = "visit_astronautics_museum_datetime", javaType = Date.class),
            @Result(property = "schoolMuseumVisitedDate", column = "visit_school_museum_datetime", javaType = Date.class),
            @Result(property = "meetAlumniAssociation", column = "meet_alumni_association", javaType = int.class),
            @Result(property = "acceptInterview", column = "accepte_inerview", javaType = int.class),
            @Result(property = "giveLecture", column = "give_lecture", javaType = int.class),
            @Result(property = "needVolunteer", column = "need_volunteer_assist", javaType = int.class)
    })
    List<BackActivityPO> getPostedActivities(@Param("openId") String openId);

    /**
     * 获取已经已经提交的还没结束的返校活动信息
     *
     * @param openId
     * @return
     */
    @Select("SELECT * FROM t_back_activity_info WHERE openId=#{openId} AND end_date>NOW() LIMIT 1;")
    @Results(value = {
            @Result(property = "id", column = "id", javaType = int.class),
            @Result(property = "openId", column = "openId", javaType = String.class),
            @Result(property = "beginDate", column = "begin_date", javaType = Date.class),
            @Result(property = "endDate", column = "end_date", javaType = Date.class),
            @Result(property = "alumniNum", column = "back_stu_num", javaType = int.class),
            @Result(property = "historyMuseumVisitedDate", column = "visit_history_museum_datetime", javaType = Date.class),
            @Result(property = "astronauticsMuseumVisitedDate", column = "visit_astronautics_museum_datetime", javaType = Date.class),
            @Result(property = "schoolMuseumVisitedDate", column = "visit_school_museum_datetime", javaType = Date.class),
            @Result(property = "meetAlumniAssociation", column = "meet_alumni_association", javaType = int.class),
            @Result(property = "acceptInterview", column = "accepte_inerview", javaType = int.class),
            @Result(property = "giveLecture", column = "give_lecture", javaType = int.class),
            @Result(property = "needVolunteer", column = "need_volunteer_assist", javaType = int.class)
    })
    BackActivityPO getCurActivityInfo(@Param("openId") String openId);

}
