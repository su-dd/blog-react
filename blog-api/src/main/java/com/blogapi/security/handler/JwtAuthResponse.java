package com.blogapi.security.handler;

import java.io.Serializable;

public class JwtAuthResponse implements Serializable {
    private static final long serialVersionUID = -8472563558954256415L;
    private final String token;

    public JwtAuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
