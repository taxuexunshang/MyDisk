package com.yhj.disk.service;

import com.yhj.disk.bean.Doc;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/15 17:39
 */

public interface DocService {
    /**
     * 上传单个文件方法
     * @param file 文件
     * @return 是否上传成功
     */
    public String upload(MultipartFile file, HttpSession session);

    /**
     * 查询当前用户所有文件信息
     * @return 文件信息列表
     */
    public List<Doc> fileMsg(String userName);

    /**
     * 文件下载
     * @param id 文件id
     */
    public void download(int id);

    /**
     * 根据文件路径删除文件,同时根据id数据库记录
     * @param filepath
     * @param id
     * @return
     */
    public boolean deleteByUserName(String filepath,int id);
}
