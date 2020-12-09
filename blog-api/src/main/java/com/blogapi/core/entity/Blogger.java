package com.blogapi.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Blogger {
    @Id
    private String id;
    private String accountId;

    @Indexed(unique=true, direction= IndexDirection.DESCENDING, dropDups=true)
    private String user;
    private String mail;
    private String hobby;
    private String word;
}
