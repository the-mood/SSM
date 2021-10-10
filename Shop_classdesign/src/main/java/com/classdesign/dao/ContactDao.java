package com.classdesign.dao;

import com.classdesign.domain.Contacts;
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
public interface ContactDao {

    //查询联系人
    @Select("select * from contacts")
    public List<Contacts> findAllContact();

    //修改联系人电话号码
    @Update("update contacts set Telphone=#{Telphone} where Contacts=#{Contacts} and suppliers=#{suppliers}")
    public void updateTel(@Param("Contacts") String Contacts, @Param("suppliers") String suppliers, @Param("Telphone") String Telphone);

    //增加一个联系人
    @Insert("insert into contacts (Contacts,Suppliers,Telphone) values (#{Contacts},#{Suppliers},#{Telphone})")
    public void insertCon(@Param("Contacts")String contacts,@Param("Suppliers")String suppliers, @Param("Telphone")String telphone);
}
