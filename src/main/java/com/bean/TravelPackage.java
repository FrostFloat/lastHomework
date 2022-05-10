package com.bean;

import lombok.Data;

import java.util.List;

/**
 * 旅游套餐
 * id
 * name 套餐的名字
 * price 价格
 * amount 报名数量
 * summary 概述
 * beginDate 出发时间
 * returnDate 返回时间
 * arrangement 具体安排————————分割所得
 * company 所属公司
 * imgLocation 照片位置
 * visitors 报名的游客id————————查询visitor表格所得
 *
 *
 */
public class TravelPackage {
    /*
     * 属性信息
     */
    private int id;
    private String name;
    private double price;
    private int amount;
    private String summary;
    private String beginDate;
    private String returnDate;
    private String arrangement;
    private String company;
    private String imgLocation;


    public TravelPackage() {
    }

    public TravelPackage(int id, String name, double price, int amount, String summary, String beginDate, String returnDate, String arrangement, String company, String imgLocation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.summary = summary;
        this.beginDate = beginDate;
        this.returnDate = returnDate;
        this.arrangement = arrangement;
        this.company = company;
        this.imgLocation = imgLocation;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }


    @Override
    public String toString() {
        return "TravelPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", summary='" + summary + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", arrangement='" + arrangement + '\'' +
                ", company='" + company + '\'' +
                ", imgLocation='" + imgLocation + '\'' +
                '}';
    }
}
