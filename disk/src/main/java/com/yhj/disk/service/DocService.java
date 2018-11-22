package com.yhj.disk.service;

import com.yhj.disk.bean.Doc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/15 17:39
 */

public interface DocService {

    public String upload(MultipartFile file, HttpSession session);
    /**
     *
     * @param request http请求
     * @param response http相应
     * @param filepath 文件名
     * @param id 主键
     * @throws UnsupportedEncodingException 异常
     */
    public void downloadFile(HttpServletRequest request
            , HttpServletResponse response, @Param("filepath") String filepath
            , @Param("id")int id) throws UnsupportedEncodingException;

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

    /**
     * 根据id修改其文件分享状态
     * @param id 主键id
     */
    public void changeShareType(int id,String fileName);

    /**
     *
     * @param userName
     */
    public List<Doc> getUseful(String userName);
}
