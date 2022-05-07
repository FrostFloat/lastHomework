package com.bean;

import java.util.List;

/**
 * 管理员————旅游公司
 * id
 * name 公司名字
 * introduce 介绍
 * travelPackages 公司拥有的旅游服务
 * phone 电话号码
 *
 */
public class Administrator {
    private int id;
    private String name;
    private String introduce;
    private String phone;
    private String password;
    private List<TravelPackage> travelPackages;

    public Administrator(int id, String name, String introduce, String phone, String password) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.phone = phone;
        this.password = password;

    }

    @Override
    public String toString() {
        return "administrator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", travelPackages=" + travelPackages +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Administrator() {
    }

    public Administrator(int id, String name, String introduce, String phone) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.phone = phone;
    }

    public Administrator(int id, String name, String introduce, String phone, List<TravelPackage> travelPackages) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.phone = phone;
        this.travelPackages = travelPackages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TravelPackage> getTravelPackages() {
        return travelPackages;
    }

    public void setTravelPackages(List<TravelPackage> travelPackages) {
        this.travelPackages = travelPackages;
    }

}
