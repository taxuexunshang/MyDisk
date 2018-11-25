package com.yhj.disk.controller;

import com.yhj.disk.bean.User;
import com.yhj.disk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description: 用户控住器
 * @Author: YangWuXin
 * @Date: 2018/11/18 14:02
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param httpSession session
     * @return
     */
    @RequestMapping("/user/login")
    public boolean login(String username, String password, HttpSession httpSession){
        return userService.login(username,password,httpSession);
    }

    /**
     * 注册用户
     * @param user 用户实体类
     * @return
     */
    @RequestMapping("/user/register")
    public boolean register(User user){
        return userService.addUser(user);
    }

    /**
     * 注销登录
     * @param session session
     */
    @RequestMapping("/user/logout")
    public void logout(HttpSession session){
        userService.logout(session);
    }
}
