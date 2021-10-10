package com.classdesign.domain;

import java.io.Serializable;

/**
 * @Author yang97
 * @Date 2020/6/17 15:21
 */
public class Parts implements Serializable {
    private String suppliers;
    private String part;
    private String price;
    private String number;

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "suppliers='" + suppliers + '\'' +
                ", part='" + part + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
