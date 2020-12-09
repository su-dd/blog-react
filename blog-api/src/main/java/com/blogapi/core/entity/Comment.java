package com.blogapi.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Comment {
    @Id
    private String id;

    private String articleId;
    private String commentId;
    private String createDate;
    private String updateDate;
    private String body;
}
