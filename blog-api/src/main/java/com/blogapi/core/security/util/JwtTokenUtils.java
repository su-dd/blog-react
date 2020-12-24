package com.blogapi.core.security.util;

import com.blogapi.core.security.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenUtils {
    // 创建token
    public static String createToken(String username, String role) {

        HashMap<String, Object> map = new HashMap<>();
        map.put(JwtConfig.role_claims, role);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, JwtConfig.secret)
                .setClaims(map)
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
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    // 从token的串中解析 结构数据
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(JwtConfig.secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getUserRoles(String token){
        return (String) getTokenBody(token).get(JwtConfig.role_claims);
    }
}
