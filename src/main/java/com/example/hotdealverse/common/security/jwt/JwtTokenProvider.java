package com.example.hotdealverse.common.security.jwt;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.UserRepository;
import com.example.hotdealverse.user.domain.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class JwtTokenProvider {

    private final UserRepository userRepository;

    private static String accessTokenSecret;
    private long accessTokenExpiredMsc;
    private long refreshTokenExpiredMsc;

    public JwtTokenProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("${jwt.accessToken.secret}")
    public void setAccessTokenSecret(String value) {
        accessTokenSecret = value;
    }

    @Value("${jwt.accessToken.expiredMsc}")
    public void setAccessTokenExpiredMsc(String value) {
        accessTokenExpiredMsc = Long.parseLong(value);
    }

    @Value("${jwt.refreshToken.expiredMsc}")
    public void setRefreshTokenExpiredMsc(String value) {
        refreshTokenExpiredMsc = Long.parseLong(value);
    }

    @PostConstruct
    protected void init() {
        accessTokenSecret = Base64.getEncoder().encodeToString(accessTokenSecret.getBytes());
    }

    public Token createToken(String principal) {

        String accessToken = generateAccessToken(principal);
        String refreshToken = generateRefreshToken();

        return Token.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String generateAccessToken(String principal) {
        Claims claims = Jwts.claims().setSubject(principal);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessTokenExpiredMsc))
                .signWith(SignatureAlgorithm.HS512, accessTokenSecret)
                .compact();
    }

    public String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }

    //Jwt 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(accessTokenSecret)
                    .parseClaimsJws(token);

            boolean isTokenExpire = claims.getBody().getExpiration().before(new Date()); // 만료되면 true를 반환

            return isTokenExpire;
        } catch (Exception e) {
            return false;
        }
    }

    // Jwt 토큰에서 회원 이메일 또는 관리자 아이디 추출
    public String getPrincipal(String token) {
        System.out.println(token);
        return Jwts.parser()
                .setSigningKey(accessTokenSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


    public UsernamePasswordAuthenticationToken getAuthenticationByProviderKey(String providerKey) {
        Optional<UserJpaEntity> optionalUserJpaEntity = this.userRepository.findByProviderKey(providerKey);
        if (optionalUserJpaEntity.isPresent()) {
            UserJpaEntity userJpaEntity = optionalUserJpaEntity.get();
            UserDetails userDetails = UserPrincipal.create(userJpaEntity);
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
        return null;
    }

    public Date getExpirationDate(String token) {

        String secretKey;
        secretKey = accessTokenSecret;


        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
