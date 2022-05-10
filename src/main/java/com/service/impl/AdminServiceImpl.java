package com.service.impl;

import com.bean.Administrator;
import com.dao.AdminDao;
import com.service.AdminServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminServiceI {
    @Autowired
    AdminDao adminDao;

    @Override
    public void insert(Administrator administrator) {
        System.out.println("service----insert");
        System.out.println(administrator.toString());
        adminDao.insert(administrator);
    }

    @Override
    public String queryIdByAdmin(String adminAccount) {
        System.out.println("service----queryIdByAdmin");
        System.out.println("account: " + adminAccount);
        return adminDao.queryIdByAdmin(adminAccount);
    }

    @Override
    public String queryPwdByAdmin(String adminAccount) {
        System.out.println("service----queryPwdByAdmin");
        System.out.println("account: " + adminAccount);
        return adminDao.queryPwdByAdmin(adminAccount);
    }

    @Override
    public String queryNameByAdmin(String adminAccount) {
        System.out.println("service----queryNameByAdmin");
        System.out.println("account: " + adminAccount);
        return adminDao.queryNameByAdmin(adminAccount);
    }

    @Override
    public Administrator query(String adminAccount){
        System.out.println("service----query");
        System.out.println("account: " + adminAccount);
        return adminDao.query(adminAccount);
    }

    @Override
    public void update(Administrator administrator){
        System.out.println("service----updateById");
        System.out.println("administrator: " + administrator);
        adminDao.update(administrator);
    }
}

