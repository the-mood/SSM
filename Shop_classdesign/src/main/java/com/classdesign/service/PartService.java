package com.classdesign.service;

import com.classdesign.domain.Parts;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

/**
 * @Author yang97
 * @Date 2020/6/17 15:37
 */
public interface PartService {
    //查询零件的价格和相关信息
    public List<Parts> findPartsAll();

    //通过零件名称和供应商，查询零件价格
    public Integer findPrice(@Param("part")String part, @Param("suppliers")String suppliers);

    //查询某个零件所有供应商的价格，按照零件名称返回一个数组
    public Set findPartPrice(String part);

    //查询零件库存
    public Integer findPartNumber(@Param("part")String part, @Param("suppliers")String suppliers);

    //下单后更新零件库存
    public void updatePartNumber(@Param("part")String part, @Param("suppliers")String suppliers,@Param("number")Integer number);

    //修改零件价格
    public void updatePrice(@Param("part")String part, @Param("suppliers")String suppliers,@Param("price")Integer price);

    //修改零件库存
    public void changePN(@Param("part")String part, @Param("suppliers")String suppliers,@Param("number")Integer number);







}
