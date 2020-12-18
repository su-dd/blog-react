package com.blogapi.security.entity.factory;

import com.blogapi.core.entity.User;
import com.blogapi.security.entity.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser createJwtUser(User user) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                "NORMAL",
                mapToGrantedAuthorities(user.getRoles())
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
