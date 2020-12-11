package com.blogapi.controller;


import com.blogapi.common.config.JwtConfig;
import com.blogapi.core.entity.Account;
import com.blogapi.core.service.AuthService;
import com.blogapi.security.handler.JwtAuthRequest;
import com.blogapi.security.handler.JwtAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 登陆
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResponseEntity<?> login(
            @RequestBody JwtAuthRequest jwtAuthRequest) throws AuthenticationException {
        final String token = authService.login(jwtAuthRequest.getUsername(), jwtAuthRequest.getPassword());
        return ResponseEntity.ok(new JwtAuthResponse(token));
    }

    // 注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Account register(@RequestBody Account account) throws AuthenticationException {
        return authService.register(account);
    }

    // 刷新
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refresh(HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(JwtConfig.tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthResponse(refreshedToken));
        }
    }
}
