package com.blogapi.dao.po;

import org.springframework.data.annotation.Id;
public class Account {
    @Id
    private String id;

    private String user;

    private String pwd;

    private boolean isAdmin;

    private boolean isBloger;

    private boolean isReader;

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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBloger() {
        return isBloger;
    }

    public void setBloger(boolean bloger) {
        isBloger = bloger;
    }

    public boolean isReader() {
        return isReader;
    }

    public void setReader(boolean reader) {
        isReader = reader;
    }
}
