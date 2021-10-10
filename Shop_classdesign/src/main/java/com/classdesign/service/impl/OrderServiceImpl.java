package com.classdesign.service.impl;

import com.classdesign.dao.OrderDao;
import com.classdesign.domain.Orders;
import com.classdesign.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 18:10
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void saveOrders(String part1,String supplier1,Integer number1,
                           String part2,String supplier2,Integer number2,
                           String part3,String supplier3,Integer number3,
                           String username,Integer price) {
        orderDao.saveOrders(part1,supplier1,number1,part2,supplier2,number2,
                part3,supplier3,number3,username,price);
    }

    @Override
    public void updateState(String suppliers) {
        orderDao.updateState(suppliers);
    }

    @Override
    public List<Orders> findAllOrder(String username) {
        return orderDao.findAllOrder(username);
    }
}
