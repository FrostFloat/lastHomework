package com.dao;

import com.bean.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    /*增加*/
    public void insert(Administrator administrator);
    /*查询Id*/
    public String queryIdByAdmin(String adminAccount);
    /*查询密码*/
    public String queryPwdByAdmin(String adminAccount);
    /*查询名字*/
    public String queryNameByAdmin(String adminAccount);
    /*查询所有信息*/
    public Administrator query(String adminAccount);

}
