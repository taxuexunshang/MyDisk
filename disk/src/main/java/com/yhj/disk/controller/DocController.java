package com.yhj.disk.controller;

import com.yhj.disk.bean.Doc;
import com.yhj.disk.mapper.DocMapper;
import com.yhj.disk.service.DocService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 文件操作控制器
 * @Author: YangWuXin
 * @Date: 2018/11/18 12:22
 */

@RestController
public class DocController {
    @Autowired
    DocService docService;

    /**
     * 文件上传
     * @param file 文件
     * @param session 需要从session中获取用户名
     * @return
     */
    @RequestMapping("/file/upload")
    public Map<String,String> upload(MultipartFile file, HttpSession session){
        docService.upload(file,session);
        Map<String,String> map = new HashMap();

        //layui规定返回的json格式
        map.put("msg","ok");
        map.put("code","0");

        return map;
    }

    /**
     * 通过用户名来查询文件
     * @param userName 用户名
     * @return
     */
    @RequestMapping("/file/selectUsefulFile")
    public List<Doc> getUsefulFiles(String userName){
        return docService.getUseful(userName);
    }

    /**
     * 修改文件的分享情况
     * @param id 唯一标志id
     * @param fileName 文件名
     */
    @RequestMapping("file/changeShareType")
    public void changeShare(@Param("id")int id,@Param("filename")String fileName){
        System.err.println(fileName);
        System.err.println(id);
        docService.changeShareType(id,fileName);
    }

    /**
     * 获取登录用户的所有文件信息
     * @param session 存放用户名的session
     * @return
     */
    @RequestMapping("/file/list")
    public List<Doc> getAllFile(HttpSession session){
        String userName = (String)session.getAttribute("userName");
        return docService.fileMsg(userName);
    }

    /**
     * 根据用户名查询用户分享文件
     * @param userName
     * @return
     */
    @RequestMapping("/file/SearchUserlist")
    public List<Doc> getUserFileList(@Param("userName") String userName){
        System.out.println("username " +userName);
        return docService.fileMsg(userName);
    }

    /**
     * 根据文件名与id实现文件删除
     * @param fileName 文件名
     * @param id 主键
     * @return
     */
    @RequestMapping("file/delete")
    public boolean delFile(String fileName,int id){
        return  docService.deleteByUserName(fileName,id);
    }

    /**
     * 根据文件名打开流放入response实现下载
     * @param request request请求
     * @param response response请求
     * @param filepath 文件名
     * @param id 主键
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/file/download")
    public void downloadFile(HttpServletRequest request
            ,HttpServletResponse response, @Param("filepath") String filepath
            ,@Param("id")int id) throws UnsupportedEncodingException {
        docService.downloadFile(request,response,filepath,id);
    }

}
