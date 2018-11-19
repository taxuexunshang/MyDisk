package com.yhj.disk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/19 16:07
 */
@Controller
public class LoginController {
    @Autowired
    HttpSession session;

    @RequestMapping("/page/{name}")
    public String getDemo(@PathVariable String name){
        System.out.println(name);
        System.out.println(session.getAttribute("userName"));
        Object userName = session.getAttribute("userName");
        if(userName==null){
            return "login.html";
        }else{
            System.out.println(1);
            return name;
        }
    }

}
