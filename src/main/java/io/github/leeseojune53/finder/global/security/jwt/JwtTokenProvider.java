package io.github.leeseojune53.finder.global.security.jwt;

import io.github.leeseojune53.finder.domain.refresh_token.domain.RefreshToken;
import io.github.leeseojune53.finder.domain.refresh_token.domain.repository.RefreshTokenRepository;
import io.github.leeseojune53.finder.global.exception.ExpiredTokenException;
import io.github.leeseojune53.finder.global.exception.InvalidTokenException;
import io.github.leeseojune53.finder.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String number) {
        return generateToken(number, JwtProperties.ACCESS_TYPE, jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String number) {
        String token = generateToken(number, JwtProperties.REFRESH_TYPE, jwtProperties.getRefreshExp());
        refreshTokenRepository.save(
                RefreshToken.builder()
                        .number(number)
                        .token(token)
                        .ttl(jwtProperties.getRefreshExp() / 1000)
                        .build()
        );
        return token;
    }

    public Long getAccessExp() {
        return System.currentTimeMillis() + jwtProperties.getAccessExp();
    }

    private String generateToken(String number, String type, Long exp) {
        return Jwts.builder()
                .setSubject(number)
                .setHeaderParam("typ", type)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getHeader());
        if (bearer != null && bearer.startsWith(jwtProperties.getPrefix()) &&
                bearer.length() > jwtProperties.getPrefix().length()) {
            return bearer.substring(jwtProperties.getPrefix().length() + 1);
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        if (isRefreshToken(token))
            throw InvalidTokenException.EXCEPTION;

        UserDetails userDetails = authDetailsService.loadUserByUsername(getJws(token).getBody().getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private boolean isRefreshToken(String token) {
        return JwtProperties.REFRESH_TYPE.equals(getJws(token).getHeader().get("typ"));
    }

    private Jws<Claims> getJws(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

}
