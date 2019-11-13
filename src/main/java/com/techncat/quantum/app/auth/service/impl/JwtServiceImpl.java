package com.techncat.quantum.app.auth.service.impl;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.auth.entity.LoginCodePair;
import com.techncat.quantum.app.auth.entity.TokenEntity;
import com.techncat.quantum.app.auth.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.expiration}")
    private Long expirationTime;
    @Value("${jwt.refresh_expiration}")
    private Long refreshExpirationTime;
    /**
     * 生成足够的安全随机密钥，以适合符合规范的签名
     */
    private byte[] apiKeySecretBytes; // = DatatypeConverter.parseBase64Binary(jwtSecretKey);
    private SecretKey secretKey; //= Keys.hmacShaKeyFor(apiKeySecretBytes);

    public JwtServiceImpl(@Value("${jwt.secret_key}") String jwtSecretKey) {
        this.apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey);
        this.secretKey = Keys.hmacShaKeyFor(apiKeySecretBytes);
    }

    /*  生成登录 TOKEN  */

    @Override
    public TokenEntity encode(String sid, List<String> roles) {
        long expiration = expirationTime == null ? 864000 : expirationTime; // 10 days default
        long refreshExpiration = refreshExpirationTime == null ? 2400000 : refreshExpirationTime; // 30 days default

        TokenEntity entity = new TokenEntity();
        entity.setType("JWT");
        entity.setIssue_provider("ForkTea");
        entity.setIssue_date(new Date());
        entity.setAccess_token_expiration_date(new Date(System.currentTimeMillis() + expiration * 1000));
        entity.setRefresh_token_expiration_date(new Date(System.currentTimeMillis() + refreshExpiration * 1000));
        String token = Jwts.builder()
                .setHeaderParam("type", entity.getType())
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .claim("roles", String.join(",", roles))
                .setIssuer(entity.getIssue_provider())
                .setIssuedAt(entity.getIssue_date())
                .setSubject(sid)
                .setExpiration(entity.getAccess_token_expiration_date())
                .compact();
        String refreshToken = Jwts.builder()
                .setHeaderParam("type", entity.getType())
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .claim("roles", String.join(",", roles))
                .setIssuer(entity.getIssue_provider())
                .setIssuedAt(entity.getIssue_date())
                .setSubject(sid)
                .setExpiration(entity.getRefresh_token_expiration_date())
                .compact();
        entity.setAccess_token(token);
        entity.setRefresh_token(refreshToken);
        return entity;
    }

    @Override
    public TokenEntity encode(Aser aser) {
        if (aser == null) return null;
        return encode(aser.getSid(), aser.getRoles());
    }

    @Override
    public Aser decode(String token) {
        if (token == null) return null;
        if (token.startsWith("Bearer ")) token = token.substring(7);
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        List<String> roles = Arrays.stream(((String) claims.get("roles")).split(",")).collect(Collectors.toList());
        String sid = claims.getSubject();
        Date expiredDate = claims.getExpiration();
        return new Aser(sid, roles, expiredDate.before(new Date()));
    }

    /*  生成验证码登录 pair  */

    @Override
    public LoginCodePair randomCreateCodePair(String subject) {
        String code = String.valueOf(100000 + (int) (Math.random() * 899999));
        String ticket = Jwts.builder()
                .setHeaderParam("type", "JWT")
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .setIssuer("FORKTEA")
                .setIssuedAt(new Date())
                .setSubject(subject)
                .claim("code", code)
                .setExpiration(new Date(System.currentTimeMillis() + 600 * 1000)) // 10 分钟
                .compact();
        return new LoginCodePair(ticket, subject, code, "10");
    }

    @Override
    public boolean verifyCodePair(LoginCodePair pair) {
        if (pair == null) return false;
        return verifyCodePair(pair.getTicket(), pair.getSubject(), pair.getCode());
    }

    @Override
    public boolean verifyCodePair(String ticket, String subject, String code) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(ticket).getBody();
        String realSubject = claims.getSubject();
        String realCode = (String) claims.get("code");
        return realCode != null && realCode.equals(code) && realSubject != null && realSubject.equals(subject);
    }

}
