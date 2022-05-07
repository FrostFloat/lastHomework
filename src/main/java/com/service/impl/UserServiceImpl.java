package com.service.impl;

import com.bean.User;
import com.dao.UserDao;
import com.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    UserDao userDao;

    /*增加用户信息*/
    @Override
    public void insert(User user) {
        System.out.println("service----insert");
        System.out.println(user.toString());
        userDao.insert(user);
    }
    /*查询Id*/
    public String queryIdByUser(String userAccount){
        System.out.println("service----queryIdByUser");
        System.out.println("account: " + userAccount);
        return userDao.queryIdByUser(userAccount);
    }
    /*用户登录获取密码*/
    @Override
    public String queryPwdByUser(String userAccount) {
        System.out.println("service----queryPwdByUser");
        System.out.println("account: " + userAccount);
        return userDao.queryPwdByUser(userAccount);
    }

    /*查询昵称*/
    @Override
    public String queryNickByUser(String userAccount){
        System.out.println("service----queryNickByUser");
        System.out.println("account: " + userAccount);
        return userDao.queryNickByUser(userAccount);
    }

    /*返回全部的信息*/
    @Override
    public User query(String userAccount){
        System.out.println("service----query");
        System.out.println("account: " + userAccount);
        return userDao.query(userAccount);
    }

    /*根据id修改信息*/
    @Override
    public void updateById(User user){
        System.out.println("service----updateById");
        System.out.println("user: " + user.toString());
        userDao.updateById(user);
    }
}
