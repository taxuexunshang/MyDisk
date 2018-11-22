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
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/18 12:22
 */

@RestController
public class DocController {
    @Autowired
    DocService docService;

    @RequestMapping("/file/upload")
    public Map<String,String> upload(MultipartFile file, HttpSession session){
        docService.upload(file,session);
        Map<String,String> map = new HashMap();

        map.put("msg","ok");
        map.put("code","0");

        return map;
    }

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

    @RequestMapping("file/delete")
    public boolean delFile(String fileName,int id){
        return  docService.deleteByUserName(fileName,id);
    }

    @RequestMapping("/file/download")
    public void downloadFile(HttpServletRequest request
            ,HttpServletResponse response, @Param("filepath") String filepath
            ,@Param("id")int id) throws UnsupportedEncodingException {
        docService.downloadFile(request,response,filepath,id);
    }

}
