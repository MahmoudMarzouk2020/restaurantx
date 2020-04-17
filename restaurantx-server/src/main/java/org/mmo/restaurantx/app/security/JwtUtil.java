package org.mmo.restaurantx.app.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    
    @Value("${app.jwtSecret}")
    private String jwtSecret;
    
    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;
    
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }
    
    private LocalDateTime getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    
    private boolean isTokenExpired(String token) {
        LocalDateTime expiration = getExpirationDateFromToken(token);
        return expiration.isBefore(LocalDateTime.now());
    }
    
    public String getUserEmailFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }
    
    public String generateToken(String userEmail) {
        Map<String, Object> claims = new HashMap<>();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userEmail)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    
//    public boolean validateToken(String authToken, String userEmail) {
    public boolean validateToken(String authToken, UserDetails userDetails) {
        boolean result = false;
        String userEmailFromAuthToken = "";
        try {
            userEmailFromAuthToken = getUserEmailFromToken(authToken);
            result = userEmailFromAuthToken.equals(userDetails.getUsername()) && !isTokenExpired(authToken);
        } catch (SignatureException ex) {
//            logger.error("Invalid JWT signature");
            System.out.println(ex.getMessage());
        } catch (MalformedJwtException ex) {
//            logger.error("Invalid JWT token");
            System.out.println(ex.getMessage());
        } catch (ExpiredJwtException ex) {
//            logger.error("Expired JWT token");
            System.out.println(ex.getMessage());
        } catch (UnsupportedJwtException ex) {
//            logger.error("Unsupported JWT token");
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex) {
//            logger.error("JWT claims string is empty.");
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
}
