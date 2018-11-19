package com.yhj.disk.service.Impl;

import com.yhj.disk.bean.Doc;
import com.yhj.disk.mapper.DocMapper;
import com.yhj.disk.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/15 17:51
 */
@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private DocMapper docMapper;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 上传单个文件方法
     * @param file 文件
     * @return 是否上传成功
     */
    @Override
    public String upload(MultipartFile file, HttpSession session) {
        Doc doc = new Doc();
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
//      System.out.println("fileName:" + fileName);
        String filePath = "D:\\disk\\src\\main\\resources\\static\\upload\\";
//      String filePath = "./upload/";
        System.out.println("上传到"+filePath + fileName);
        File dest = new File(filePath + fileName);

        doc.setFilesize(file.getSize());
        doc.setFilename(fileName);
        doc.setSavepath(filePath+fileName);
        doc.setFiletype(file.getContentType());
        doc.setCount(0);
        doc.setIsshare("no");
        doc.setMemo(" ");
        doc.setUploaddate(df.format(new Date()));
        doc.setCatalog(" ");
        doc.setUsername((String) session.getAttribute("userName"));

        try {
            file.transferTo(dest);
            if(docMapper.selectOneFileByFileName(fileName)==null){
                docMapper.insert(doc);
            }
            return "上传成功";
        } catch (IOException e) {
        }
        return "上传失败！";
    }

    /**
     * 查询当前用户所有文件信息
     *
     * @param userName
     * @return 文件信息列表
     */
    @Override
    public List<Doc> fileMsg(String userName) {
        return docMapper.selectAllByUserName(userName);
    }

    /**
     * 文件下载
     * @param id 文件id
     */
    @Override
    public void download(int id) {

    }

    /**
     * 根据文件路径删除文件,同时根据id数据库记录
     *
     * @param filepath
     * @param id
     * @return
     */
    @Override
    public boolean deleteByUserName(String filepath, int id) {
        if(delFile(filepath)){
            docMapper.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //删除本地文件的方法
    public boolean delFile(String filename) {
        File file=new File(filename);
        if(file.exists()&&file.isFile()){
            file.delete();
            return true;
        }else{
            return false;
        }

    }


}
