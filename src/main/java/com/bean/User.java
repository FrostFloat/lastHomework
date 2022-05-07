package com.bean;

/**
 * 用户个人信息
 * id
 * 账号————mail 邮箱 或者 phone 电话号码
 * password 密码
 * nickName 昵称 如果昵称为空 则自动分配一个名字
 * realName 姓名
 */
public class User {
    private int id;
    private String phone;
    private String password;
    private String nickName;
    private String realName;

    public User() {
    }
    public User(int id, String phone, String password, String nickName, String realName) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.nickName = nickName;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
