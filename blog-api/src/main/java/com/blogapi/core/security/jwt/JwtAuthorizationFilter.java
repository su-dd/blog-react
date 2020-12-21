package com.blogapi.core.security.jwt;

import com.blogapi.core.common.config.JwtConfig;
import com.blogapi.core.common.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
        // 如果请求头中有token，则进行解析，并设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }

    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtConfig.tokenPrefix + " ", "");
        String userName = JwtTokenUtil.getUsername(token);
        if (userName != null) {
            return new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
        }
        return null;
    }
}
