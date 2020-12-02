package com.blogapi.repository.dao;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    private String id;

    private String user;

    private String pwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
