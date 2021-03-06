package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.domain.repository.UserRepository;
import io.github.leeseojune53.finder.domain.user.exception.AlreadyExistNumberException;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import io.github.leeseojune53.finder.domain.user.presentation.dto.request.SignupRequest;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(SignupRequest request) {
        if (userRepository.findByNumber(request.getNumber()).isPresent()) {
            throw AlreadyExistNumberException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .number(request.getNumber())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build()
        );

        return userFacade.getTokenResponse(request.getNumber());
    }

}
