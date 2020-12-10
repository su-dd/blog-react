package com.blogapi.security.jwt;

import com.alibaba.fastjson.JSONObject;
import com.blogapi.common.config.JwtConfig;
import com.blogapi.core.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取请求头中JWT的Token
        String tokenHeader = request.getHeader(JwtConfig.tokenHeader);
        if (null != tokenHeader && tokenHeader.startsWith(JwtConfig.tokenPrefix)) {
            try {
                // 截取Jwt前缀
                String token = tokenHeader.replace(JwtConfig.tokenPrefix, "");
                // 解析Jwt
                Claims claims = Jwts.parser()
                        .setSigningKey(JwtConfig.secret)
                        .parseClaimsJws(token)
                        .getBody();
                // 获取用户名
                String username = claims.getSubject();
                String userId = claims.getId();
                if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(userId)) {
                    // 获取角色
                    List<GrantedAuthority> authorityList = new ArrayList<>();
                    String authority = claims.get("authorities").toString();
                    if (!StringUtils.isEmpty(authority)) {
                        List<Map<String,String>> authorityMap = JSONObject.parseObject(authority, List.class);
                        for(Map<String, String> role : authorityMap){
                            if (!StringUtils.isEmpty(role)) {
                                authorityList.add(new SimpleGrantedAuthority(role.get("authority")));
                            }
                        }
                    }
                }

                // 组装参数
                Account account = new Account();
                account.setUser(claims.getSubject());
                account.setId(claims.getId());

            } catch (ExpiredJwtException e){
                log.info("Token过期");
            } catch (Exception e) {
                log.info("Token无效");
            }
        }
        super.doFilterInternal(request, response, chain);
    }
}
