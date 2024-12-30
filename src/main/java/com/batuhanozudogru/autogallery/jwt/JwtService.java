package com.batuhanozudogru.autogallery.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    public static final String SECRET_KEY = "abc";
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new java.util.Date())
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getKey(){
        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
         return Keys.hmacShaKeyFor(bytes);
    }

    public <T> T exportToken(String token, Function<Claims,T> claimsFunc){
        Claims claims = getClaims(token);
        return claimsFunc.apply(claims);
    }

    public Claims getClaims (String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token){
        return exportToken(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token){
        Date expireDate = exportToken(token, Claims::getExpiration);
        return expireDate.before(new Date());
    }
}
