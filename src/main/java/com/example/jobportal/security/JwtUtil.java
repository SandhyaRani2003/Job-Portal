package com.example.jobportal.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

private final Key signingKey;
private final long expirationMs;

public JwtUtil(@Value("${jwt.secret}") String base64Secret,
			   @Value("${jwt.expiration-ms:3600000}") long expirationMs) {
this.signingKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(base64Secret));
this.expirationMs = expirationMs;
}

public String generateToken(String username){
return Jwts.builder()
.setSubject(username)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
.signWith(signingKey, SignatureAlgorithm.HS256)
.compact();
}

public String extractUsername(String token){
return Jwts.parserBuilder().setSigningKey(signingKey).build()
.parseClaimsJws(token).getBody().getSubject();
}
}
