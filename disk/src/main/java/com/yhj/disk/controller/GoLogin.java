package com.yhj.disk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 页面跳转
 * @Author: YangWuXin
 * @Date: 2018/11/22 20:13
 */
@Controller
public class GoLogin {
    /**
     * 从受保护的templates文件夹跳转到不收保护的static文件夹
     * @return
     */
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "goLogin";
    }
}
