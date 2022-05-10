package com.dao;

import com.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    /*插入数据*/
    public void insert(Order order);
    /*根据id获取全部信息*/
    public List<Order> queryById(String id);
}
