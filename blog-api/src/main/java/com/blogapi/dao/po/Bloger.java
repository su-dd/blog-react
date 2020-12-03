package com.blogapi.dao.po;

import org.springframework.data.annotation.Id;

public class Bloger {
    @Id
    private String id;
    private String accoutId;
    private String user;
    private String mail;
    private String hobby;
    private String word;

    public String getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(String accoutId) {
        this.accoutId = accoutId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
