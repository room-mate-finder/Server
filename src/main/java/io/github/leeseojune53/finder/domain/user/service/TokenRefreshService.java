package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.refresh_token.domain.RefreshToken;
import io.github.leeseojune53.finder.domain.refresh_token.domain.repository.RefreshTokenRepository;
import io.github.leeseojune53.finder.domain.user.exception.RefreshTokenNotFoundException;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserFacade userFacade;

    public TokenResponse execute(String token) {
        RefreshToken refreshTokenEntity = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        return userFacade.getTokenResponse(refreshTokenEntity.getNumber());
    }

}
