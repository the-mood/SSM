package com.classdesign.service;

import com.classdesign.domain.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 18:09
 */
public interface OrderService {
    //插入订单信息
    public void saveOrders(@Param("part1")String part1, @Param("supplier1")String supplier1, @Param("number1")Integer number1,
                           @Param("part2")String part2, @Param("supplier2")String supplier2, @Param("number2")Integer number2,
                           @Param("part3")String part3, @Param("supplier3")String supplier3, @Param("number3")Integer number3,
                           @Param("username")String username,@Param("price")Integer price);

    //更新供应商状态
    public void updateState(String suppliers);

    //通过用户名查询订单记录
    public List<Orders> findAllOrder(String username);
}
