package com.service;

import com.bean.Order;

import java.util.List;

public interface OrderServiceI {
    /*插入数据*/
    public void insert(Order order);
    /*根据id获取全部信息*/
    public List<Order> queryById(String id);
}
