package com.blogapi.service;

public interface AuthManage {
    // 管理员
    boolean isAdmin(String id);

    // 博主
    boolean isBloger(String id);

    // 读者
    boolean isReader(String id);
}
