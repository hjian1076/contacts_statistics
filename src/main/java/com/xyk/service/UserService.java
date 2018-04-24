package com.xyk.service;

import com.xyk.entity.User;

public interface UserService {
    //用户登录
    User login(String username,String password);
}
