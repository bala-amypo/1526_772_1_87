package com.example.demo.security;

import io.jsonwebtoken.Claims;

public class JwtParsedToken {

    private final Claims payload;

    public JwtParsedToken(Claims payload) {
        this.payload = payload;
    }

    public Claims getPayload() {
        return payload;
    }
}
