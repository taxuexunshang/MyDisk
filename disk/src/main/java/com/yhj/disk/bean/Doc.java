package com.yhj.disk.bean;

import java.io.Serializable;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/15 14:55
 */
public class Doc implements Serializable {
    //自增序号
    private int id;
    //文件名
    private String filename;
    //存储路径
    private String savepath;
    //文件大小
    private long filesize;
    //分类
    private String catalog;
    //文件类型
    private String filetype;
    //备注
    private String memo;
    //是否分享
    private String isshare;
    //用户名(外键)
    private String username;
    //上传日期
    private String uploaddate;
    //下载数量
    private int count;

    public Doc() {
    }

    public Doc(int id, String filename, String savepath, long filesize, String catalog, String filetype, String memo, String isshare, String username, String uploaddate, int count) {
        this.id = id;
        this.filename = filename;
        this.savepath = savepath;
        this.filesize = filesize;
        this.catalog = catalog;
        this.filetype = filetype;
        this.memo = memo;
        this.isshare = isshare;
        this.username = username;
        this.uploaddate = uploaddate;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIsshare() {
        return isshare;
    }

    public void setIsshare(String isshare) {
        this.isshare = isshare;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(String uploaddate) {
        this.uploaddate = uploaddate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", savepath='" + savepath + '\'' +
                ", filesize=" + filesize +
                ", catalog='" + catalog + '\'' +
                ", filetype='" + filetype + '\'' +
                ", memo='" + memo + '\'' +
                ", isshare='" + isshare + '\'' +
                ", username='" + username + '\'' +
                ", uploaddate='" + uploaddate + '\'' +
                ", count=" + count +
                '}';
    }
}
