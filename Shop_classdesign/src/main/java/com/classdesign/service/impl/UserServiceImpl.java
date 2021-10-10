package com.classdesign.service.impl;

import com.classdesign.dao.UserDao;
import com.classdesign.domain.Contacts;
import com.classdesign.domain.User;
import com.classdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 9:55
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public String findPassword(String username){
        return userDao.findPassword(username);
    }

    public void saveUser(String username,String password){
        userDao.saveUser(username,password);
    }

    @Override
    public void updatePassword(String username, String password) {
         userDao.updatePassword(username,password);
    }
}
