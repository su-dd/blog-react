package com.blogapi.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Series {
    @Id
    private String id;
    private String name;
    private List<String> articles;
}
