package com.blogapi.core.service;

import com.blogapi.core.entity.Account;

public interface AuthService {
    // 注册
    Account register(Account account);
    // 登陆
    String login(String username, String password);
    // 刷新
    String refresh(String oldToken);
}
