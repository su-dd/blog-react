package com.blogapi.core.common.config;

import org.springframework.stereotype.Component;

/**
 * JWT配置类
 */
@Component
public class JwtConfig {
    /**
     * 密钥KEY
     */
    public static String secret = "JWTSecret";
    /**
     * TokenKey
     */
    public static String tokenHeader = "Authorization";
    /**
     * Token前缀字符
     */
    public static String tokenPrefix = "Bearer ";
    /**
     * 过期时间 单位:秒; 1天后过期=86400 7天后过期=604800
     */
    public static Integer expiration = 86400;
    /**
     * 不需要认证的接口
     */
    public static String antMatchers = "/index/**,/login/**,/favicon.ico";

    /**
     * 签发人
     * */
    public static String issuer = "daidai";

    // 角色的key
    public static final String ROLE_CLAIMS = "rol";
}