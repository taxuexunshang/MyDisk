package com.yhj.disk.controller;

import com.yhj.disk.bean.Doc;
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

//    @RequestMapping("/file/download")
//    public void downloadFile(HttpServletRequest request,
//                               HttpServletResponse response, @Param("filepath") String filepath) throws UnsupportedEncodingException {
//          String fileName = filepath;
//        System.out.println(fileName);
//        // 如果文件名不为空，则进行下载
//        if (fileName != null) {
//            //设置文件路径
//            File file = new File(fileName);
//
//            // 如果文件名存在，则进行下载
//            if (file.exists()) {
//
//                // 配置文件下载
//                response.setHeader("content-type", "application/octet-stream");
//                response.setContentType("application/octet-stream");
//                // 下载文件能正常显示中文
//                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//
//                // 实现文件下载
//                byte[] buffer = new byte[1024];
//                FileInputStream fis = null;
//                BufferedInputStream bis = null;
//                try {
//                    fis = new FileInputStream(file);
//                    bis = new BufferedInputStream(fis);
//                    OutputStream os = response.getOutputStream();
//                    int i = bis.read(buffer);
//                    while (i != -1) {
//                        os.write(buffer, 0, i);
//                        i = bis.read(buffer);
//                    }
//                    System.out.println("Download the song successfully!");
//                }
//                catch (Exception e) {
//                    System.out.println("Download the song failed!");
//                }
//                finally {
//                    if (bis != null) {
//                        try {
//                            bis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (fis != null) {
//                        try {
//                            fis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//    }


//    @RequestMapping("/file/download1")
//    public String downLoad(HttpServletResponse response){
//        String filename="192Z43110-4.jpg";
//        String filePath = "D:/disk/src/main/resources/static/upload/" ;
//        File file = new File(filePath + "/" + filename);
//        if(file.exists()){ //判断文件父目录是否存在
//            response.setContentType("application/force-download");
//            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
//
//            byte[] buffer = new byte[1024];
//            FileInputStream fis = null; //文件输入流
//            BufferedInputStream bis = null;
//
//            OutputStream os = null; //输出流
//            try {
//                os = response.getOutputStream();
//                fis = new FileInputStream(file);
//                bis = new BufferedInputStream(fis);
//                int i = bis.read(buffer);
//                while(i != -1){
//                    os.write(buffer);
//                    i = bis.read(buffer);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("----------file download" + filename);
//            try {
//                bis.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }


}
