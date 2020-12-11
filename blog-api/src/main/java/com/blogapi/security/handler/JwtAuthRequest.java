package com.blogapi.security.handler;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.Serializable;

public class JwtAuthRequest implements Serializable {
    private static final long serialVersionUID = 5334233735408073164L;
    private String username;
    private String password;

    public JwtAuthRequest() {
        super();
    }

    public JwtAuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
