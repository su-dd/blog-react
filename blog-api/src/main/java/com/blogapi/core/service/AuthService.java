package com.blogapi.core.service;

import com.blogapi.core.entity.User;

import java.util.Map;

public interface AuthService {
    // 注册
    User register(Map<String,String> registerUser);
    // 登陆
    String login(String username, String password);
    // 刷新
    String refresh(String oldToken);
}
