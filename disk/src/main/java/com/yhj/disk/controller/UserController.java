package com.yhj.disk.controller;

import com.yhj.disk.bean.User;
import com.yhj.disk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/18 14:02
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public boolean login(String username, String password, HttpSession httpSession){
        return userService.login(username,password,httpSession);
    }

    @RequestMapping("/user/register")
    public boolean register(User user){
        return userService.addUser(user);
    }
}
