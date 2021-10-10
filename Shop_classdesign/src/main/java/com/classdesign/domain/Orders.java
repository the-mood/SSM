package com.classdesign.domain;

import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

/**
 * @Author yang97
 * @Date 2020/6/17 17:41
 */
public class Orders implements Serializable {
    private Integer orderId;
    private String username;
    private String part1;
    private String part2;
    private String part3;
    private String supplier1;
    private String supplier2;
    private String supplier3;
    private Integer number1;
    private Integer number2;
    private Integer number3;
    private Integer price;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getSupplier1() {
        return supplier1;
    }

    public void setSupplier1(String supplier1) {
        this.supplier1 = supplier1;
    }

    public String getSupplier2() {
        return supplier2;
    }

    public void setSupplier2(String supplier2) {
        this.supplier2 = supplier2;
    }

    public String getSupplier3() {
        return supplier3;
    }

    public void setSupplier3(String supplier3) {
        this.supplier3 = supplier3;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getNumber3() {
        return number3;
    }

    public void setNumber3(Integer number3) {
        this.number3 = number3;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", username='" + username + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", supplier1='" + supplier1 + '\'' +
                ", supplier2='" + supplier2 + '\'' +
                ", supplier3='" + supplier3 + '\'' +
                ", number1=" + number1 +
                ", number2=" + number2 +
                ", number3=" + number3 +
                ", price=" + price +
                '}';
    }

}
