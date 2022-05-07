package com.service;


import com.bean.TravelPackage;

import java.util.List;

public interface TravelPackageServiceI {
    /*插入数据*/
    public void insert(TravelPackage travelPackage);
    /*根据公司名字查找旅游产品*/
    public List<TravelPackage> queryByCom(String comName);
    /*根据id查询详细信息*/
    public TravelPackage queryById(String id);
}
