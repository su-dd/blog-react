package com.blogapi.common.util;

import com.blogapi.common.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    public static final String TOKEN_HEADER = JwtConfig.tokenHeader;
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";
    private static final String ISS = "echisan";

    // 创建token
    public static String createToken(String username) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, JwtConfig.secret)
                .setIssuer(JwtConfig.issuer)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtConfig.expiration * 1000))
                .compact();
    }

    // 从token中获取用户名
    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    // 是否过期； true已过期，false未过期
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    // 从token的串中解析 结构数据
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(JwtConfig.secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
