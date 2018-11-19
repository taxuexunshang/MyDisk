package com.yhj.disk.bean;

import java.io.Serializable;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/15 14:52
 */
public class User implements Serializable {
    //用户名
    private String username;
    //密码
    private String password;
    //备注
    private String memo;
    //手机号
    private String tel;
    //电子邮箱
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMemo() {
        return memo;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String username, String password, String memo, String tel, String email) {
        this.username = username;
        this.password = password;
        this.memo = memo;
        this.tel = tel;
        this.email = email;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", memo='" + memo + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
