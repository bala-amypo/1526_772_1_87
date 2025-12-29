package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    // For HS256 algorithm, use SecretKey
    private final SecretKey secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    private final long expiration = 86400000; // 24 hours

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)  // New API - claims() instead of setClaims()
                .subject(subject)  // New API - subject() instead of setSubject()
                .issuedAt(new Date())  // New API - issuedAt() instead of setIssuedAt()
                .expiration(new Date(System.currentTimeMillis() + expiration))  // expiration() instead of setExpiration()
                .signWith(secretKey)  // Uses SecretKey directly
                .compact();
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)  // New API - verifyWith() instead of setSigningKey()
                .build()
                .parseSignedClaims(token)  // New API - parseSignedClaims() instead of parseClaimsJws()
                .getPayload();
    }

    public TokenWrapper parseToken(String token) {
        return new TokenWrapper(extractAllClaims(token));
    }

    public boolean isTokenValid(String token, String username) {
        try {
            String tokenUsername = extractUsername(token);
            return tokenUsername.equals(username) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public static class TokenWrapper {
        private final Claims claims;
        
        public TokenWrapper(Claims claims) {
            this.claims = claims;
        }
        
        public Claims getPayload() {
            return claims;
        }
    }
}