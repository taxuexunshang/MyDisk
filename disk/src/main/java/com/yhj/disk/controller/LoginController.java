package com.yhj.disk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description: 登录行为控制器
 * @Author: YangWuXin
 * @Date: 2018/11/19 16:07
 */
@Controller
public class LoginController {
    @Autowired
    HttpSession session;

    /**
     * 控制用户不可在未登录时直接通过url访问页面
     * @param name url中 *.html的部分
     * @return
     */
    @RequestMapping("/page/{name}")
    public String getDemo(@PathVariable String name){
        System.out.println(name);
        System.out.println(session.getAttribute("userName"));
        Object userName = session.getAttribute("userName");
        if(userName==null){
            return "/gologin";
        }else{
            return name;
        }
    }

}
