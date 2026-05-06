package com.example.ssm.service.impl;

import com.example.ssm.entity.User;
import com.example.ssm.mapper.UserMapper;
import com.example.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean register(String username, String password) {
        // 用户名已存在 → 注册失败
        if (userMapper.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username, password);
        userMapper.insert(user);
        return true;
    }
}