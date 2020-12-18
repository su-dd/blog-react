package com.blogapi.core.service.impl;

import com.blogapi.core.entity.User;
import com.blogapi.core.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
//    private AuthenticationManager authenticationManager;
//    private UserDetailsService userDetailsService;
//    private JwtTokenUtil jwtTokenUtil;
//    private AccountDao accountDao;
//
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
//        final String username = account.getUser();
//        if (accountDao.findByUser(username) != null) {
//            return null;
//        }
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        final String rawPassword = account.getPwd();
//        account.setPwd(encoder.encode(rawPassword));
//        account.setRoles(asList("ROLE_Blogger"));
//        return accountDao.insert(account);
        return null;
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
