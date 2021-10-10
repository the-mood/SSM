package com.classdesign.service;

import com.classdesign.domain.Contacts;
import com.classdesign.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 9:53
 */
public interface UserService {
    //登录界面时，查询用户密码
    public String findPassword(String username);

    //注册用户
    public void saveUser(@Param("username")String username,@Param("password")String password);

    //修改密码
    public void updatePassword(@Param("username")String username,@Param("password")String password);
}
