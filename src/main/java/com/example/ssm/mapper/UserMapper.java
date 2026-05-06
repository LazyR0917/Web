package com.example.ssm.mapper;

import com.example.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /** 根据用户名查询用户（用于登录） */
    User findByUsername(@Param("username") String username);

    /** 插入新用户（用于注册） */
    int insert(User user);
}