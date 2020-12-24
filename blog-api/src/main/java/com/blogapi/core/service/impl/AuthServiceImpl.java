package com.blogapi.core.service.impl;

import com.blogapi.core.dao.UserDao;
import com.blogapi.core.entity.User;
import com.blogapi.core.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Arrays.asList;

@Service
public class AuthServiceImpl implements AuthService {
//    private AuthenticationManager authenticationManager;
//    private UserDetailsService userDetailsService;
//    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    public AuthServiceImpl(AuthenticationManager authenticationManager,
//                           UserDetailsService userDetailsService,
//                           JwtTokenUtil jwtTokenUtil,
//                           AccountDao accountDao) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.accountDao = accountDao;
//    }

    @Override
    public User register(Map<String,String> registerUser) {

        final String username = registerUser.get("userName");
        if (userDao.findUserByUserName(username) != null) {
            return null;
        }

        final String password = registerUser.get("password");
        User user = new User();
        user.setUserName(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRoles(asList("ROLE_Blogger"));
        return userDao.insert(user);
    }

    @Override
    public String login(String username, String password) {
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
//
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        return token;
        return null;
    }

    @Override
    public String refresh(String oldToken) {
//        final String token = oldToken.substring(JwtConfig.tokenHeader.length());
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//        if (jwtTokenUtil.canTokenBeRefreshed(token)){
//            return jwtTokenUtil.refreshToken(token);
//        }
        return null;
    }
}
