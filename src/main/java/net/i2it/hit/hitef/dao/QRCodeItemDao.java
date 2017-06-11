package net.i2it.hit.hitef.dao;

import net.i2it.hit.hitef.entity.po.QRCodeItemPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QRCodeItemDao {

    @Insert("INSERT INTO t_items_via_qrcode VALUES(DEFAULT,#{item.body},#{item.detail},#{item.money});")
    int save(@Param("item") QRCodeItemPO item);

    @Delete("DELETE FROM t_items_via_qrcode WHERE id=#{id};")
    int del(@Param("id") int id);

    @Update("UPDATE t_items_via_qrcode SET body=#{item.body},detail=#{item.detail},money=#{item.money} WHERE id=#{item.id};")
    int update(@Param("item") QRCodeItemPO item);

    @Select("SELECT * FROM t_items_via_qrcode WHERE id=#{id};")
    QRCodeItemPO getItem(@Param("id") int id);

    @Select("SELECT * FROM t_items_via_qrcode ORDER BY id DESC;")
    List<QRCodeItemPO> listItems();

}
