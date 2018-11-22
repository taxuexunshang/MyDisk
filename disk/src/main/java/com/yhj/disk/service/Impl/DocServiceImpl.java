package com.yhj.disk.service.Impl;

import com.yhj.disk.bean.Doc;
import com.yhj.disk.mapper.DocMapper;
import com.yhj.disk.service.DocService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
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

        String filePath = "D:\\disk\\src\\main\\resources\\static\\upload\\";

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
     *
     * @param id 文件id
     */
    @Override
    public void download(int id) {

    }

    /**
     * 文件下载
     * @param id 文件id
     */
    @Override
    public void downloadFile(HttpServletRequest request
            , HttpServletResponse response, @Param("filepath") String filepath
            , @Param("id")int id) throws UnsupportedEncodingException {
        System.out.println("id="+id);
        Doc doc = docMapper.selectOneFileByFileName(filepath);
        doc.setCount(doc.getCount() + 1);
        docMapper.update(doc);

        String locpath="D:/disk/src/main/resources/static/upload/";
        String fileName = locpath+filepath;
        System.out.println(fileName);
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            File file = new File(fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/force-download");
                response.setContentType("application/force-download");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
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

    /**
     * 根据id修改其文件分享状态
     *
     * @param id 主键id
     */
    @Override
    public void changeShareType(int id,String fileName) {
        Doc doc = docMapper.selectOneFileByFileName(fileName);
        if(doc.getIsshare().equals("yes")){
            doc.setIsshare("no");

        }else{
            doc.setIsshare("yes");
        }
        docMapper.update(doc);
    }

    /**
     * @param userName
     */
    @Override
    public List<Doc> getUseful(String userName) {
        return docMapper.selectShareFileByUserName(userName);
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
