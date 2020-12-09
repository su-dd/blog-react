package com.blogapi.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
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
}
