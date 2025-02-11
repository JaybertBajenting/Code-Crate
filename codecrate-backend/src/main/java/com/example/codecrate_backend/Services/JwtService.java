package com.example.codecrate_backend.Services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtService {



    @Value("${spring.security.jwt.jwtSigningKey}")
    private String secretKey;


    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(String userEmail){
        return generateToken(new HashMap<>(),userEmail);
    }


    public boolean isTokenValid(String token, String userEmail){
        final String username = extractUsername(token);
        return (username.equals(userEmail) && !isTokenExpired(token));
    }




    private String generateToken(Map<String,Object> claims, String userEmail){

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        return Jwts.builder().issuedAt(issuedAt)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();

    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }


    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
