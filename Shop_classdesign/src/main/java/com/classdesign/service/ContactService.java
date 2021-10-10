package com.classdesign.service;

import com.classdesign.domain.Contacts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 9:53
 */
public interface ContactService {

    //查询所有联系人
    public List<Contacts> findAllContact();

    //修改联系人电话
    public void updateTel(@Param("Contacts") String Contacts, @Param("suppliers") String suppliers, @Param("Telphone") String Telphone);

    //增加联系人
    public void insertCon(String contacts,String suppliers,String telphone);
}
