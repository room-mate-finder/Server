package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.domain.repository.UserRepository;
import io.github.leeseojune53.finder.domain.user.exception.AlreadyExistNumberException;
import io.github.leeseojune53.finder.domain.user.presentation.dto.request.SignupRequest;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import io.github.leeseojune53.finder.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(SignupRequest request) {
        if(userRepository.findByNumber(request.getNumber()).isPresent()) {
            throw AlreadyExistNumberException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .number(request.getNumber())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build()
        );

        String accessToken = jwtTokenProvider.generateAccessToken(request.getNumber());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getNumber());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .exp(jwtTokenProvider.getAccessExp())
                .build();
    }

}
