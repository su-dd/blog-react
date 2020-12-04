package com.blogapi.dao.po;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Account {
    @Id
    private String id;

    private String user;

    private String pwd;

    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return getRoles().contains("admin");
    }

    public boolean isBloger() {
        return getRoles().contains("blogger");
    }

    public boolean isReader() {
        return getRoles().contains("reader");
    }
}
