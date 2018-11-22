package com.yhj.disk.service;

import com.yhj.disk.bean.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Description: 用户业务接口
 * @Author: YangWuXin
 * @Date: 2018/11/15 17:01
 */
public interface UserService {
    /**
     * 注册用户
     * @Param user 用户实体
     * @return 返回是否创建成功
     */
    public boolean addUser(User user);

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回是否登录成功
     */
    public boolean login(String userName,String password,HttpSession httpSession);

    /**
     * 修改密码
     * @param userName 用户名
     * @param newPassword 新密码
     * @return
     */
    public boolean changePassword(String userName,String newPassword);

    /**
     * 登出
     * @param session session
     * @return
     */
    public boolean logout(HttpSession session);
}
