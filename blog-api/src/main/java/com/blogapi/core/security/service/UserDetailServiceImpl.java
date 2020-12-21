package com.blogapi.core.security.service;

import com.blogapi.core.dao.UserDao;
import com.blogapi.core.entity.User;
import com.blogapi.core.security.entity.factory.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private UserDao userDao;

    @Autowired
    public UserDetailServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format("No user found with username '%s'.", userName));
        } else {
            return JwtUserFactory.createJwtUser(user);
        }
    }
}
