package com.classdesign.service.impl;

import com.classdesign.dao.ContactDao;
import com.classdesign.dao.UserDao;
import com.classdesign.domain.Contacts;
import com.classdesign.service.ContactService;
import com.classdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yang97
 * @Date 2020/6/17 9:55
 */
@Service("ContactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    public List<Contacts> findAllContact(){
        return contactDao.findAllContact();
    }

    @Override
    public void updateTel(String Contacts, String suppliers, String Telphone) {
        contactDao.updateTel(Contacts,suppliers,Telphone);
    }

    @Override
    public void insertCon(String contacts, String suppliers, String telphone) {
        contactDao.insertCon(contacts,suppliers,telphone);
    }
}
