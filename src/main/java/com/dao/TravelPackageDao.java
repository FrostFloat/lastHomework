package com.dao;

import com.bean.TravelPackage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelPackageDao {
    /*插入数据*/
    public void insert(TravelPackage travelPackage);
    /*根据公司名字查找旅游产品*/
    public List<TravelPackage> queryByCom(String comName);
    /*根据id查询详细信息*/
    public TravelPackage queryById(String id);
}
