package com.blogapi.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Collection;
import java.util.List;

@Data
public class Account {
    @Id
    private String id;

    @Indexed(unique=true, direction= IndexDirection.DESCENDING, dropDups=true)
    private String user;

    private String pwd;

    private List<String> roles;
}
