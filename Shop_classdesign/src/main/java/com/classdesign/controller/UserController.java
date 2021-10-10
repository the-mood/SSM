package com.classdesign.controller;

import com.classdesign.domain.Parts;
import com.classdesign.domain.User;
import com.classdesign.service.PartService;
import com.classdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 10:09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private String[] result;

    @Autowired //自动按照类型注入。只要ioc容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
    private UserService userService;

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String[] login(String username, String password){
        if(password.equals(userService.findPassword(username))){
            result= new String[]{"success", username};
            return result;
        }else {
            result=new String[]{"error"};
            return result;
        }
    }


    //注册
    @RequestMapping(value = "/saveUser",method = RequestMethod.GET)
    public String saveUser(String username,String password){
        try {
            userService.saveUser(username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


    //修改密码
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    public String updatePassword(String username,String password){
        try {
            userService.updatePassword(username,password);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
