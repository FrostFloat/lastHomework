package com.dao;
/**
 * 用户操作
 * 4/24 增删改查
 */
import com.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /*增加*/
    public void insert(User user);
    /*查询Id*/
    public String queryIdByUser(String userAccount);
    /*查询密码*/
    public String queryPwdByUser(String userAccount);
    /*查询昵称*/
    public String queryNickByUser(String userAccount);
    /*返回全部的信息*/
    public User query(String userAccount);
    /*根据id修改信息*/
    public void updateById(User user);

}
