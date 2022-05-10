package com.service;

import com.bean.Administrator;

public interface AdminServiceI {
    /*增加*/
    public void insert(Administrator administrator);
    /*查询Id*/
    public String queryIdByAdmin(String userAccount);
    /*查询密码*/
    public String queryPwdByAdmin(String userAccount);
    /*查询名字*/
    public String queryNameByAdmin(String userAccount);
    /*查询所有信息*/
    public Administrator query(String adminAccount);
    /*根据id修改信息*/
    public void update(Administrator administrator);
}
