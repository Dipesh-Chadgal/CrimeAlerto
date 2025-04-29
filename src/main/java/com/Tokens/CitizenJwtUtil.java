package com.Tokens;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CitizenJwtUtil {
    private static final String SECRET_KEY="Life is a canvas of endless possibilities, painted with the colors of dreams and determination";
    private static final long EXPIRATION_TIME=1000*60*60*12;

    public String generateToken(String email){
        return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
        .compact();
    }
}
