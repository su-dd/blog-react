package com.blogapi.security.service.factory;

import com.blogapi.core.entity.Account;
import com.blogapi.security.entity.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser createJwtUser(Account account) {
        return new JwtUser(
                account.getId(),
                account.getUser(),
                account.getPwd(),
                "NORMAL",
                mapToGrantedAuthorities(account.getRoles())
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
