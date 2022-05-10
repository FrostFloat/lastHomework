package com.dao;

import com.bean.Index;
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
    /*根据id删除产品*/
    public void deleteById(String id);
    /*根据id修改产品*/
    public void updateById(TravelPackage travelPackage);
    /*获取产品索引*/
    public List<Index> queryIndex();
    /*根据id获得剩余数量*/
    public int queryAmountById(int id);
    /*根据id修改剩余数量*/
    public void updateAmountById(int id,int amount);
}
