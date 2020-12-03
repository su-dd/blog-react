package com.blogapi.dao.po;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Article {
    @Id
    private String id;
    private String seriesId;
    private List<String> signs;
    private String createDate;
    private String updateDate;
    private Integer visittimes;
    private String title;
    private String author;
    private String body;
    private List<String> comments;

    public String getSeriesid() {
        return seriesId;
    }

    public void setSeriesid(String seriesid) {
        this.seriesId = seriesid;
    }

    public List<String> getSigns() {
        return signs;
    }

    public void setSigns(List<String> signs) {
        this.signs = signs;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getVisittimes() {
        return visittimes;
    }

    public void setVisittimes(Integer visittimes) {
        this.visittimes = visittimes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
