package com.classdesign.controller;

import com.classdesign.domain.Orders;
import com.classdesign.service.OrderService;
import com.classdesign.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.classdesign.utils.Compute.compute;
import static com.classdesign.utils.compute1.computers;

import com.classdesign.utils.compute1;

/**
 * @Author yang97
 * @Date 2020/6/18 20:57
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private PartService partService;

    @Autowired
    private OrderService orderService;

    //通过用户名查询订单记录
    @RequestMapping(value = "/findAllOrder",method = RequestMethod.GET)
    public List<Orders> findAllOrder(String username){
        List list= null;
        try {
            list = orderService.findAllOrder(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //推荐订单,使用穷举算法
    @RequestMapping(value = "/adviceOrder",method = RequestMethod.GET)
    public String[][] adviceOrder(String part1,Integer number1,String part2,Integer number2,String part3,Integer number3){
        String [][]result=new String[4][1];
        result=buildResult(part1,number1,part2,number2,part3,number3);
        return result;
    }

    //推荐订单，使用穷举算法
    @RequestMapping(value = "/adviceOrder1",method = RequestMethod.GET)
    public String[][] adviceOrder1(String part1,Integer number1,String part2,Integer number2,String part3,Integer number3){
        String [][]result=new String[4][1];
        result=buildResult(part1,number1,part2,number2,part3,number3);
        return result;
    }

    //下订单
    @RequestMapping(value = "/saveOrders",method = RequestMethod.GET)
    public String saveOrders(String part1,String suppliers1,Integer number1,
                             String part2,String suppliers2,Integer number2,
                             String part3,String suppliers3,Integer number3,
                             String username,Integer price){
        try {

            Integer price1=partService.findPrice(part1,suppliers1)*number1;
            Integer price2=partService.findPrice(part2,suppliers2)*number2;
            Integer price3=partService.findPrice(part3,suppliers3)*number3;
            //计算总价
            price=price1+price2+price3;
            orderService.saveOrders(part1,suppliers1,number1,part2,suppliers2,number2,
                    part3,suppliers3,number3,username,price);
            //更新供应商状态
            orderService.updateState(suppliers1);
            orderService.updateState(suppliers2);
            orderService.updateState(suppliers3);
            //更新零件库存数量
            partService.updatePartNumber(part1,suppliers1,number1);
            partService.updatePartNumber(part2,suppliers2,number2);
            partService.updatePartNumber(part3,suppliers3,number3);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        System.out.println("下单成功");
        return "success";
    }

    /**
     *建立价格数组
     *             甲       乙       丙
     * part1    a[0][0]
     * part2
     * part3                      a[2][2]
     *
     */
    public  int[][] buildArray(String part1, String part2, String part3){
        int [][]a=new int[3][3];
        String s1="甲";  String s2="乙";  String s3="丙";
        a[0][0]=partService.findPrice(part1,s1);//甲  零件1
        a[0][1]=partService.findPrice(part1,s2);//乙  零件1
        a[0][2]=partService.findPrice(part1,s3);//丙  零件1
        a[1][0]=partService.findPrice(part2,s1);//甲  零件2
        a[1][1]=partService.findPrice(part2,s2);//乙  零件2
        a[1][2]=partService.findPrice(part2,s3);//丙  零件2
        a[2][0]=partService.findPrice(part3,s1);//甲  零件3
        a[2][1]=partService.findPrice(part3,s2);//乙  零件3
        a[2][2]=partService.findPrice(part3,s3);//丙  零件3
        return a;
    }

    /**
     * 获取最优解,并将配置方案存入数组中
     * @param part1
     * @param number1
     * @param part2
     * @param number2
     * @param part3
     * @param number3
     * @return
     */
    public String[][] buildResult(String part1, Integer number1,
                                  String part2, Integer number2,
                                  String part3, Integer number3){
        //根据得到的零件名称来建立相关的价格数组
        int [][]pr=buildArray(part1,part2,part3);
        //获取最佳推荐的方案，穷举
        int [][]result=compute(pr,number1,number2,number3);
        //获取最佳推荐的方案，回溯
//        int [][]result=computers(pr,number1,number2,number3);
        String s1="甲";  String s2="乙";  String s3="丙";
        String[] rs;
        String[][] rs1 = new String[4][1];
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                //如果价格不为0说明该价格被选择
                if(result[i][j]!=0){
                    if(i==0){
                        if(j==0){
                            rs=new String[]{part1, s1, String.valueOf(number1)};
                        }else if(j==1){
                            rs=new String[]{part1, s2, String.valueOf(number1)};
                        }else {
                            rs=new String[]{part1, s3, String.valueOf(number1)};
                        }
                        rs1[0]=rs;
                    }else if(i==1){
                        if(j==0){
                            rs=new String[]{part2, s1, String.valueOf(number2)};
                        }else if(j==1){
                            rs=new String[]{part2, s2, String.valueOf(number2)};
                        }else {
                            rs=new String[]{part2, s3, String.valueOf(number2)};
                        }
                        rs1[1]=rs;
                    }else {
                        if(j==0){
                            rs=new String[]{part3, s1, String.valueOf(number3)};
                        }else if(j==1){
                            rs=new String[]{part3, s2, String.valueOf(number3)};
                        }else {
                            rs=new String[]{part3, s3, String.valueOf(number3)};
                        }
                        rs1[2]=rs;
                    }
                }
            }
        }
        
        rs1[3]=new String[]{"success", "",""};
        return rs1;
    }
}
