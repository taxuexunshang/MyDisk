package com.yhj.disk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/22 20:13
 */
@Controller
public class GoLogin {
    @RequestMapping("/goLogin")public String goLogin(){
        return "goLogin";
    }
}
