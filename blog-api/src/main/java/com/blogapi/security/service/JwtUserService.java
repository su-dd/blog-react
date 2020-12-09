package com.blogapi.security.service;

import com.blogapi.core.dao.AccountDao;
import com.blogapi.core.entity.Account;
import com.blogapi.security.service.factory.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserService implements UserDetailsService {
    private AccountDao accountDao;

    @Autowired
    public JwtUserService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Account account = accountDao.findByUser(user);
        if (account == null) {
            throw new UsernameNotFoundException(
                    String.format("No user found with username '%s'.", user));
        } else {
            return JwtUserFactory.createJwtUser(account);
        }
    }
}
