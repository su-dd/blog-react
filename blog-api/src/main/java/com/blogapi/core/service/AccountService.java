package com.blogapi.core.service;

import com.blogapi.core.entity.Account;

public interface AccountService {
    // 管理员
    boolean isAdmin(String id);

    // 博主
    boolean isBlogger(String id);

    // 读者
    boolean isReader(String id);

    // 插入
    Account insert(Account account);
    // 删除
    void delete(String id);
    // 修改
    Account update(Account account);
}
