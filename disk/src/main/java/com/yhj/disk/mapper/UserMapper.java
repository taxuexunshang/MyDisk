package com.yhj.disk.mapper;

import com.yhj.disk.bean.User;

import java.util.List;

/**
 * @Description: 用户mapper接口
 * @Author: YangWuXin
 * @Date: 2018/11/15 15:03
 */
public interface UserMapper {
    /**
     * 添加用户
     * @param user 用户对象
     */
    public void insert(User user);

    /**
     * 查询所有用户
     * @return 包含所有用户信息的列表
     */
    public List<User> selectAll();

    /**
     * 根据用户名(主键)进行查询
     * @param UserName 用户名
     * @return 用户实体
     */
    public User selectByUserName(String UserName);

    /**
     * 根据用户名(主键)进行更新
     * @param user
     */
    public void update(User user);
    /**
     * 根据用户名(主键)进行删除
     * @param UserName
     */
    public void deleteByUserName(String UserName);
}
