package net.i2it.hit.hit_alumni.dao;

import net.i2it.hit.hit_alumni.entity.po.AlumniPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniInfoDao {

    /**
     * 添加返校校友信息
     *
     * @param alumniInfo
     * @return
     */
    @Insert("INSERT INTO t_back_student_info VALUES(" +
            "#{obj.openId},#{obj.name},#{obj.entryYear},#{obj.classNO},#{obj.major}," +
            "#{obj.academy},#{obj.contactType},#{obj.contactInfo},#{obj.company},#{obj.job}" +
            ");")
    int save(@Param("obj") AlumniPO alumniInfo);

    /**
     * 根据openId获取校友登记的信息
     *
     * @param openId
     * @return
     */
    @Select("SELECT * FROM t_back_student_info WHERE openId=#{id} LIMIT 1;")
    AlumniPO get(@Param("id") String openId);

    /**
     * 更新校友登记的信息
     *
     * @param alumniInfo
     * @return
     */
    @Update("UPDATE t_back_student_info SET " +
            "entry_year=#{obj.entryYear},class_no=#{obj.classNO},major=#{obj.major},academy=#{obj.academy}," +
            "contact_flag=#{obj.contactType},contact_info=#{obj.contactInfo},company=#{obj.company},job=#{obj.job} " +
            "WHERE openId=#{obj.openId};")
    int updateAlumniInfo(@Param("obj") AlumniPO alumniInfo);
    
}
