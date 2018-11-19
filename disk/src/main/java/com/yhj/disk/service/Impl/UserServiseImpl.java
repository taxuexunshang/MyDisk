package com.yhj.disk.service.Impl;

import com.yhj.disk.bean.User;
import com.yhj.disk.mapper.UserMapper;
import com.yhj.disk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Description: 用户业务接口实现类
 * @Author: YangWuXin
 * @Date: 2018/11/15 17:07
 */
@Service
public class UserServiseImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     *
     * @param user
     * @return 返回是否创建成功
     * @Param user 用户实体
     */
    @Override
    public boolean addUser(User user) {
        userMapper.insert(user);
        return true;
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回是否登录成功
     */
    @Override
    public boolean login(String userName, String password,HttpSession session) {

        User user = userMapper.selectByUserName(userName);
        if(user!=null){
            if(user.getPassword().equals(password)){
                session.setAttribute("userName",userName);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    /**
     * 修改密码
     *
     * @param userName    用户名
     * @param newPassword 新密码
     * @return
     */
    @Override
    public boolean changePassword(String userName, String newPassword) {
        User user = userMapper.selectByUserName(userName);
        if(user!=null){
            user.setPassword(newPassword);
            return true;
        } else{
            return false;
        }

    }

    /**
     * 登出
     *
     * @param userName 用户名
     * @param session session
     * @return 返回是否注销成功
     */
    @Override
    public boolean logout(String userName, HttpSession session) {
        session.invalidate();
        return true;
    }

}
