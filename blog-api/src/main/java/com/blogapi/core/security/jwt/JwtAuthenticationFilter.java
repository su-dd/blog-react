package com.blogapi.core.security.jwt;

import com.blogapi.core.common.config.JwtConfig;
import com.blogapi.core.common.util.JwtTokenUtil;
import com.blogapi.core.entity.User;
import com.blogapi.core.security.entity.JwtUser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//
// 登陆验证
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    // 尝试验证登陆
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        // 从输入流中获取到登陆的信息
        try{
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), new ArrayList<>())
            );
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        //
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        System.out.println("jwtUser: " + jwtUser.toString());
        String token = JwtTokenUtil.createToken(jwtUser.getUsername());
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的格式应该是 `Bearer token`
        StringBuilder stringBuilder = new StringBuilder(JwtConfig.tokenPrefix);
        response.setHeader("token", stringBuilder.append(" ").append(token).toString());
    }

    // 失败的时候调用的方法
    @Override
    protected void unsuccessfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("登陆失败, reason: " + failed.getMessage());
    }
}
