package com.classdesign.domain;

import java.io.Serializable;

/**
 * @Author yang97
 * @Date 2020/6/21 21:09
 */
public class Contacts implements Serializable {
    private String Contacts;
    private String Suppliers;
    private String Telphone;

    public String getContacts() {
        return Contacts;
    }

    public void setContacts(String contacts) {
        Contacts = contacts;
    }

    public String getSuppliers() {
        return Suppliers;
    }

    public void setSuppliers(String suppliers) {
        Suppliers = suppliers;
    }

    public String getTelphone() {
        return Telphone;
    }

    public void setTelphone(String telphone) {
        Telphone = telphone;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "Contacts='" + Contacts + '\'' +
                ", Suppliers='" + Suppliers + '\'' +
                ", Telphone='" + Telphone + '\'' +
                '}';
    }
}
