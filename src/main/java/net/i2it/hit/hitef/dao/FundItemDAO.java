package net.i2it.hit.hitef.dao;

import net.i2it.hit.hitef.domain.FundItemDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundItemDAO {

    String INSERT_KEYS = "`name`,`desc`,type,ctime,utime";
    String INSERT_VALUES = "#{item.name},#{item.desc},#{item.type},#{item.ctime},#{item.utime}";
    String UPDATE_FIELDS = "`name`=#{item.name},`desc`=#{item.desc},type=#{item.type},utime=#{item.utime}";
    String TB_NAME = "hitef_fund_item";
    String SELECT_KEYS = "id,`name`,`desc`,type,`status`,ctime,utime";

    /**
     * 往数据库中添加基金项目的记录，同时得到其主键id
     *
     * @param fundItemDO ：与数据库中的表hitef_fund_info对应的数据对象
     * @return int 插入影响的行数
     */
    @Options(useGeneratedKeys = true, keyProperty = "item.id", keyColumn = "id")
    @Insert("INSERT INTO " + TB_NAME + "(" + INSERT_KEYS + ") VALUES(" + INSERT_VALUES + ");")
    int save(@Param("item") FundItemDO fundItemDO);

    /**
     * 终止基金项目（改变该基金项目状态为终止）
     *
     * @param id          ：基金项目的id
     * @param currentTime ：当前时间，秒，（1970年1月1日0时起的秒数），使用 System.currentTimeMillis/1000得到
     * @return int 更新影响的行数
     */
    @Update("UPDATE " + TB_NAME + " SET `status`='0',utime=#{utime} WHERE id=#{id};")
    int update2StopById(@Param("id") int id, @Param("utime") int currentTime);

    /**
     * 更新基金项目的信息
     *
     * @param fundItemDO ：与数据库中的表hitef_fund_info对应的数据对象
     * @return 更新影响的行数
     */
    @Update("UPDATE " + TB_NAME + " SET " + UPDATE_FIELDS + " WHERE id=#{item.id};")
    int update(@Param("item") FundItemDO fundItemDO);

    /**
     * 根据id获取某个基金项目信息
     *
     * @param id ：基金的id
     * @return FundItemDO 与数据库中的表hitef_fund_info对应的数据对象
     */
    @Select("SELECT " + SELECT_KEYS + " FROM " + TB_NAME + " WHERE id=#{id};")
    FundItemDO getById(@Param("id") int id);

    /**
     * 根据基金的类型 获取全部特别基金（校级别基金）或者某个院系基金项目
     * 类型：0-特别基金(学校级别的基金)，1-院系基金
     *
     * @return List<FundItemDO>
     */
    @Select("SELECT " + SELECT_KEYS + " FROM " + TB_NAME + " WHERE type=#{type};")
    List<FundItemDO> listAllFundItemByType(@Param("type") int type);

    /**
     * 根据基金的状态 获取全部正常进行的基金项目或者已经终止的基金项目
     * 状态，是否终止：0-终止，1-正常
     *
     * @return List<FundItemDO>
     */
    @Select("SELECT " + SELECT_KEYS + " FROM " + TB_NAME + " WHERE `status`=#{status};")
    List<FundItemDO> listAllFundItemByStatus(@Param("status") int status);

    /**
     * 根据类型和状态获取对应的全部基金项目
     * 类型：1-特别基金(学校级别的基金)，>1-某院系基金
     * 状态，是否终止：0-终止，1-正常
     *
     * @return List<FundItemDO>
     */
    @Select("SELECT " + SELECT_KEYS + " FROM " + TB_NAME + " WHERE type=#{type} AND `status`=#{status};")
    List<FundItemDO> listAllFundItemByTypeAndStatus(@Param("type") int type, @Param("status") int status);

}