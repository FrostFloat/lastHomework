package com.service.impl;

import com.bean.Index;
import com.bean.TravelPackage;
import com.dao.TravelPackageDao;
import com.service.TravelPackageServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageServiceImpl implements TravelPackageServiceI {
    @Autowired
    TravelPackageDao travelPackageDao;

    @Override
    public void insert(TravelPackage travelPackage) {
        System.out.println("service--insert");
        System.out.println(travelPackage.toString());
        travelPackageDao.insert(travelPackage);
    }

    @Override
    public List<TravelPackage> queryByCom(String comName) {
        System.out.println("service--queryByCom");
        System.out.println("Company name: " + comName);
        return travelPackageDao.queryByCom(comName);
    }

    @Override
    public TravelPackage queryById(String id) {
        System.out.println("service----queryById");
        System.out.println("id: " + id);
        return travelPackageDao.queryById(id);
    }

    @Override
    public void deleteById(String id) {
        System.out.println("service----deleteById");
        System.out.println("id: " + id);
        travelPackageDao.deleteById(id);
    }

    @Override
    public void updateById(TravelPackage travelPackage) {
        System.out.println("service----updateById");
        System.out.println(travelPackage);
        travelPackageDao.updateById(travelPackage);
    }

    @Override
    public List<Index> queryIndex() {
        System.out.println("service----queryIndex");
        return travelPackageDao.queryIndex();
    }

    @Override
    public int queryAmountById(int id) {
        System.out.println("service----queryAmountById");
        System.out.println("id: " + id);
        return travelPackageDao.queryAmountById(id);
    }

    @Override
    public void updateAmountById(int id,int amount) {
        System.out.println("service----updateAmountById");
        System.out.println("id: " + id);
        travelPackageDao.updateAmountById(id,amount);
    }
}
