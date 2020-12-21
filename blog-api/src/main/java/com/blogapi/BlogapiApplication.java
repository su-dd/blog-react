package com.blogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.blogapi.core.common.config") // 处理 Error creating bean with name 'springSecurityFilterChain' defined in class path resource
@ComponentScan(basePackages = "com.blogapi.core.security.service")
public class BlogapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogapiApplication.class, args);
    }

}
