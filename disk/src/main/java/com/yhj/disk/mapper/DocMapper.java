package com.yhj.disk.mapper;

import com.yhj.disk.bean.Doc;

import java.util.List;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/15 15:03
 */
public interface DocMapper {
    /**
     * 插入一条文档记录
     * @param doc 文档实体类
     */
    public void insert(Doc doc);

    /**
     * 通过id(主键)删除文档记录
     * @param id id(主键)
     */
    public void deleteById(int id);

    /**
     * 更新一条文档记录
     * @param doc 文档实体
     */
    public void update(Doc doc);

    /**
     * 查询单个用户名下的全部文件
     * @return 包含所有用户文件的信息列表
     */
    public List<Doc> selectAllByUserName(String userName);

    /**
     * 通过文件名模糊查询文件
     * @param fileName 文件名
     * @return 文档集合
     */
    public List<Doc> selectByFileName(String fileName);

    /**
     * 根据文件名查询文件
     * @param fileName 文件名
     * @return 返回查询结果
     */
    public Doc selectOneFileByFileName(String fileName);
}
