package com.sl.ly.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String KEY = "20189wangyi02209Hj";

    public static String createJWT(String userUUID) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Map<String, Object> map = new HashMap<>();
        map.put("userUUID", userUUID);
        JwtBuilder builder = Jwts.builder()
                .setId(UUIDUtils.getUUID())
                .setIssuedAt(now)
                .setSubject("王逸")
                .setClaims(map)
                .setExpiration(new Date(nowMillis + (10 * 60 * 1000)))
                .signWith(signatureAlgorithm, KEY);
        System.out.println(builder.compact());
        return builder.compact();
    }

    public static Boolean isVerify(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody();
        return true;
    }

    public static void main(String[] args) {
        createJWT("123");
    }
}
