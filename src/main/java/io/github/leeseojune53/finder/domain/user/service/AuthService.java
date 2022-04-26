package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.exception.InvalidPasswordException;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import io.github.leeseojune53.finder.domain.user.presentation.dto.request.AuthRequest;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(AuthRequest request) {
        User user = userFacade.getUserByNumber(request.getNumber());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return userFacade.getTokenResponse(request.getNumber());
    }

}
