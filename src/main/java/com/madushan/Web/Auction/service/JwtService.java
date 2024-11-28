package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.UserBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey = null;

    public String generateToken(UserBean userBean) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(userBean.getUsername())
                .issuer("MNS")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10*60*1000))
                .and()
                .signWith(generatedKey())
                .compact();
    }

    private SecretKey generatedKey() {
        byte[] decode = Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decode);
    }

    private String getSecretKey() {
        return secretKey = "9mL5XjOvRbAWZ2HkG4Sz3E2HFlMSrjarGvsyItCOHpc=";
    }

    public String extractUsername(String jwt) {
        return null;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (userDetails.getUsername().equalsIgnoreCase(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(generatedKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
