package com.util;

import com.entity.User;

public interface InterfaceLogin {

    /**
     * 登录
     * @param user 用户实体
     * @return 登录结果
     */
    public boolean login(User user,String password);

    /**
     * 重置密码
     * @param user 用户实体
     * @return
     */
    public boolean reset(User user);

    /**
     * 查询用户
     * @param account 用户名
     * @return 用户实体
     */
    public User selectUser(String account);

    public boolean upDateLastOnline(User user);


}

