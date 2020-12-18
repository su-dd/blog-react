package com.blogapi.core.service;

import com.blogapi.core.entity.User;

import java.util.List;

public interface UserService {
    // 管理员
    boolean isAdmin(String id);

    // 博主
    boolean isBlogger(String id);

    // 读者
    boolean isReader(String id);

    // 查找全部
    List<User> findAll();

    // 查找
    User findOne(String id);

    // 插入
    User insert(User user);
    // 删除
    void delete(String id);
    // 修改
    User update(User user);
}
