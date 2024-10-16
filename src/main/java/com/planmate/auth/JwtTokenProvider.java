package com.planmate.auth;

import com.planmate.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : leeyounggyo
 * @package : com.planmate.auth
 * @since : 2024. 10. 14.
 */
@Slf4j
@Component
public class JwtTokenProvider {

    private final String secretKey = "TTTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYOPSECRETKEYTTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYOPSECRETKEYTTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYTOPSECRETKEYOPSECRETKEY";
    private final long validityInMilliseconds = 3600000; // 1시간

    public String createToken(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getEmail());
        claims.put("role", user.getRole().toString());

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getUserName(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getRole(String token) {
        return (String) Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .get("role")
                ;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractJwtToken(String tokenWithBearer) {
        if (tokenWithBearer != null && tokenWithBearer.startsWith("Bearer ")) {
            return tokenWithBearer.substring(7); // "Bearer "는 7글자
        }

        return tokenWithBearer; // "Bearer "가 없으면 원본 문자열 반환
    }

}
