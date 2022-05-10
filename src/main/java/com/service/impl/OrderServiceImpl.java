package com.service.impl;

import com.bean.Order;
import com.dao.OrderDao;
import com.service.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceI{
    @Autowired
    OrderDao orderDao;

    @Override
    public void insert(Order order) {
        System.out.println("service----insert");
        System.out.println("order: " + order.toString());
        orderDao.insert(order);
    }

    @Override
    public List<Order> queryById(String id) {
        System.out.println("service----queryById");
        System.out.println("id: " + id);
        return orderDao.queryById(id);
    }
}
