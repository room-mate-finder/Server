package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.refresh_token.domain.RefreshToken;
import io.github.leeseojune53.finder.domain.refresh_token.domain.repository.RefreshTokenRepository;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import io.github.leeseojune53.finder.domain.user.exception.RefreshTokenNotFoundException;
import io.github.leeseojune53.finder.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(String token) {
        RefreshToken refreshTokenEntity = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String accessToken = jwtTokenProvider.generateAccessToken(refreshTokenEntity.getNumber());
        String refreshToken = jwtTokenProvider.generateRefreshToken(refreshTokenEntity.getNumber());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .exp(jwtTokenProvider.getAccessExp())
                .build();

    }

}
