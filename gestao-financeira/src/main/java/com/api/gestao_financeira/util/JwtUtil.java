package com.api.gestao_financeira.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
@Component
public class JwtUtil {

    private static final String SECRET_KEY="123456C";
    private static final long EXPIRATION_DATE=86400000;


    private Key getSigninKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generatedToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public String getUserNameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

}
