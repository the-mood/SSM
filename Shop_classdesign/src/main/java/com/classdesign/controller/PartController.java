package com.classdesign.controller;

import com.classdesign.domain.Orders;
import com.classdesign.domain.Parts;
import com.classdesign.service.OrderService;
import com.classdesign.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 15:40
 */
@RestController
@RequestMapping("/part")
public class PartController {

    @Autowired
    private PartService partService;
    @Autowired
    private OrderService orderService;

    //修改零件库存
    @RequestMapping(value = "/changePN",method = RequestMethod.GET)
    public String changePN(String part,String suppliers,Integer number){
        try {
            partService.changePN(part,suppliers,number);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    //修改零件价格
    @RequestMapping(value = "/updatePrice",method = RequestMethod.GET)
    public String updatePrice(String part,String suppliers,Integer price){
        try {
            partService.updatePrice(part,suppliers,price);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

//    查询零件信息
    @RequestMapping(value = "/findPartsAll",method = RequestMethod.GET)
    public List findPartsAll(){
        List parts= null;
        try {
            parts = partService.findPartsAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parts;
    }


    //查询价格(下单,推荐订单时需要)
    @RequestMapping("/findPrice")
    public Integer findPrice(String part,String supplier){
        Integer price= null;
        try {
            price = partService.findPrice(part,supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    //下单后自动更新零件库存
    @RequestMapping("/updatePartNumber")
    public void updatePartNumber(String part,String supplier,Integer number){
        try {
            partService.updatePartNumber(part,supplier,number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
