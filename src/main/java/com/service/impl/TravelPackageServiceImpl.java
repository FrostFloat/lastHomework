package com.service.impl;

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
}
