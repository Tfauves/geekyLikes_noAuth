package com.careerdevs.geekylikes.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.secret}")
    private String secret;

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
        private Claims getAllClaimsFromToken(String token) {
            return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
        }

        public String generateToken(UserDetails userDetails) {
            Map<String, Object> claims = new HashMap<>();
            return doGenerateToken(claims, userDetails, getUsername());
        }

        private Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserNameFromToken(token);
//        return (username.equals(userDetails.getUsername() && !isTokenExpired(token));
            return
        }


}
