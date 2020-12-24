package com.blogapi.core.security.jwt;

import com.blogapi.core.security.config.JwtConfig;
import com.blogapi.core.security.handler.TokenIsExpiredException;
import com.blogapi.core.security.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// 鉴权
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String tokenHeader = request.getHeader(JwtConfig.tokenHeader);

        // 如果没有Authorization信息，则认为没有不需要处理
        if (tokenHeader == null || !tokenHeader.startsWith(JwtConfig.tokenPrefix)) {
            chain.doFilter(request, response);
            return;
        }
        try {
            // 如果请求头中有token，则进行解析，并设置认证信息
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        } catch (TokenIsExpiredException e) {

        }
        super.doFilterInternal(request, response, chain);
    }

    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) throws TokenIsExpiredException {
        String token = tokenHeader.replace(JwtConfig.tokenPrefix, "");
        boolean expiration = JwtTokenUtils.isExpiration(token);
        if (expiration) {
            throw new TokenIsExpiredException("token过期了");
        } else {
            String userName = JwtTokenUtils.getUsername(token);

            if (userName != null) {

                String roles = JwtTokenUtils.getUserRoles(token);

                ArrayList<SimpleGrantedAuthority> arrayList = new ArrayList<>();

                String[] roleArray = roles.split(JwtConfig.role_claims_split);
                for (String role : roleArray) {
                    arrayList.add(new SimpleGrantedAuthority(role));
                }
                return new UsernamePasswordAuthenticationToken(userName, null, arrayList);
            }
        }
        return null;
    }
}
