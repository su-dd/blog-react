package com.blogapi.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
public class User {
    @Id
    private String id;

    private String userName;

    private String password;

    private List<String> roles;
}
