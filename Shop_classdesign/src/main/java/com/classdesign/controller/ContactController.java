package com.classdesign.controller;

import com.classdesign.service.ContactService;
import com.classdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 10:09
 */
@RestController
@RequestMapping("/contact")
public class ContactController {
    private String[] result;

    @Autowired
    private ContactService contactService;

    //增加联系人
    @RequestMapping(value = "/addContact",method = RequestMethod.GET)
    public String addContact(String contacts,String suppliers,String telphone){
        try {
            contactService.insertCon(contacts,suppliers,telphone);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    //查询联系人
    @RequestMapping(value = "/findAllContact",method = RequestMethod.GET)
    public List findAllContact(){
        List list= null;
        try {
            list = contactService.findAllContact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改联系人电话号码
    @RequestMapping(value = "/updateTel",method = RequestMethod.GET)
    public String updateTel(String contacts,String suppliers,String telphone){
        try {
            contactService.updateTel(contacts,suppliers,telphone);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
