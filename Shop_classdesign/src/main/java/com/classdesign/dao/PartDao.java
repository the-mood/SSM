package com.classdesign.dao;

import com.classdesign.domain.Parts;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

/**
 * @Author yang97
 * @Date 2020/6/17 15:23
 */
@Repository
public interface PartDao {
    //查询零件的价格和相关信息
    @Select("select * from component")
    public List<Parts> findPartsAll();

    //查询零件价格
    @Select("select price from component where part=#{part} and suppliers=#{suppliers}")
    public Integer findPrice(@Param("part")String part, @Param("suppliers")String suppliers);

    //查询某个零件所有供应商的价格，按照零件名称返回一个数组
    @Select("select price from component where part=#{part}")
    public Set findPartPrice(@Param("part")String part);

    //查询零件库存
    @Select("select number from component where part=#{part} and suppliers=#{suppliers}")
    public Integer findPartNumber(@Param("part")String part, @Param("suppliers")String suppliers);

    //下单后更新零件库存
    @Update("update component set number=number-#{number} where part=#{part} and suppliers=#{suppliers}")
    public void updatePartNumber(@Param("part")String part, @Param("suppliers")String suppliers,@Param("number")Integer number);

    //修改零件价格
    @Update("update component set price=#{price} where part=#{part} and suppliers=#{suppliers}")
    public void updatePrice(@Param("part")String part, @Param("suppliers")String suppliers,@Param("price")Integer price);

    //修改零件库存
    @Update("update component set number=#{number} where part=#{part} and suppliers=#{suppliers}")
    public void changePN(@Param("part")String part, @Param("suppliers")String suppliers,@Param("number")Integer number);
}
