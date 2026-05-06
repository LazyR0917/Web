package com.example.ssm.service;

import com.example.ssm.entity.User;

public interface UserService {
    /** 登录：成功返回 User，失败返回 null */
    User login(String username, String password);

    /** 注册：成功返回 true，用户名已存在返回 false */
    boolean register(String username, String password);
}