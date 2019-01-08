package com.caiwl.yungo.util;

import com.caiwl.yungo.bean.Token;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * JSON Web Token 工具类
 * @author caiwl
 * @date 2017-12-08 14:20
 *
 */
@Deprecated
@Slf4j
public class JWT {

    private static String issuer = "yungo";
    private static String key = "1357924680";
    private static String tokenType = "Bearer";

    /**
     * access_token 有效期：2小时
     */
    private static long ttlMillis_at = 1000 * 60 * 60 * 2;
    /**
     * refresh_token 有效期：7天
     */
    private static long ttlMillis_rt = 1000 * 60 * 60 * 24 * 7;

    
    /**
     * 创建Token，包括accessToken（有效期2小时）、refreshToken（有效期7天）和type（固定：Bearer）
     * @param json 用户信息JSON字符串
     * @return
     */
    public static Token create(String json) {
        return create(json, key);
    }

    /**
     * 创建Token，包括accessToken（有效期2小时）、refreshToken（有效期7天）和type（固定：Bearer）
     * @param json 用户信息JSON字符串
     * @param key 密钥
     * @return
     */
    public static Token create(String json, String key) {
        String accessToken = create(json, key, ttlMillis_at);
        String refreshToken = create(json, key, ttlMillis_rt);

        log.info("[JWT]json={},accessToken={},refreshToken={}", json, accessToken, refreshToken);

        return new Token(accessToken, refreshToken, tokenType);
    }

    // Sample method to construct a JWT
    private static String create(String subject, String key, long ttlMillis) {
        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
    
    private static final MyJwtParser jwtParser;
    
    static {
        try {
            jwtParser = new MyJwtParser(DatatypeConverter.parseBase64Binary(key));
        } catch(Exception e) {
            throw e;
        }
    }

    // Sample method to validate and read the JWT
    /**
     * 验证并解读JWT
     * @param jwt
     * @return 用户信息JSON字符串
     * @throws MalformedJwtException 如果jwt不是一个有效的JWS
     * @throws SignatureException 如果jwt签名不匹配
     * @throws ExpiredJwtException 如果jwt已过期
     */
    public static String parse(String jwt) throws MalformedJwtException, SignatureException, ExpiredJwtException {
        // This line will throw an exception if it is not a signed JWS (as expected)
        try {
            Claims claims = jwtParser
                    .parseClaimsJws(jwt)
                    .getBody();
            
            // OK, we can trust this JWT
            return claims.getSubject();
        } catch (UnsupportedJwtException e) {
            // if the claimsJws argument does not represent an Claims JWS
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // if the claimsJws string is null or empty or only whitespace
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static void main(String[] args) {
//        String subject = "caiwl";
//        System.out.println(subject);
//        
//        String jwt = create(subject, 5000);
//        System.out.println(jwt);
//        
//        subject = parse(jwt);
//        System.out.println(subject);
        
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzZTViMmNlMC1jMmM0LTQ1NjUtOWI4OC01OGI0MjFiNTQ0YmIiLCJpYXQiOjE1MTI3MDQ2MzUsInN1YiI6ImNhaXdsIiwiaXNzIjoiYWxvZXN0ZWMiLCJleHAiOjE1MTI3MDQ2NDB9.YzJ9Fmde6ojznBBluv5rjHfDV10asPgX00rU5smkQeQ";
        String subject = parse(jwt);
        System.out.println(subject);
    }
}
