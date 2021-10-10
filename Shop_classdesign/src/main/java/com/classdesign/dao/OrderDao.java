package com.classdesign.dao;

import com.classdesign.domain.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 18:05
 */
@Repository
public interface OrderDao {
    //插入订单信息
    @Insert("insert into orders (username,part1,supplier1,number1,part2,supplier2,number2,part3,supplier3,number3,price)" +
            "values (#{username},#{part1},#{supplier1},#{number1},#{part2},#{supplier2},#{number2}" +
            ",#{part3},#{supplier3},#{number3},#{price})")
    public void saveOrders(@Param("part1")String part1,@Param("supplier1")String supplier1,@Param("number1")Integer number1,
                           @Param("part2")String part2,@Param("supplier2")String supplier2,@Param("number2")Integer number2,
                           @Param("part3")String part3,@Param("supplier3")String supplier3,@Param("number3")Integer number3,
                           @Param("username")String username,@Param("price")Integer price);

    //更新供应商状态
    @Update("update supplierstatus set status=1 where suppliers=#{suppliers}")
    public void updateState(String suppliers);

    //通过用户名查询订单记录
    @Select("select * from Orders where username=#{username}")
    public List<Orders> findAllOrder(String username);
}
