package com.blogapi.dao.po;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Series {
    @Id
    private String id;
    private String name;
    private List<String> articles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }
}
