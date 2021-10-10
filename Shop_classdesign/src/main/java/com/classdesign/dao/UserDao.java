package com.classdesign.dao;

import com.classdesign.domain.Contacts;
import com.classdesign.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 9:43
 */
@Repository
public interface UserDao {
    //登录界面时，查询用户密码
    @Select("select password from user where username = #{username}")
    public String findPassword(String username);

    // 保存帐户信息
    @Insert("insert into user (username,password) values (#{username},#{password})")
    public void saveUser(@Param("username")String username, @Param("password")String password);

    //修改密码
    @Update("update user set password=#{password} where username=#{username}")
    public void updatePassword(@Param("username")String username,@Param("password")String password);
}
