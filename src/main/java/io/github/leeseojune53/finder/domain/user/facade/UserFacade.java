package io.github.leeseojune53.finder.domain.user.facade;

import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.domain.repository.UserRepository;
import io.github.leeseojune53.finder.domain.user.exception.CredentialsNotFoundException;
import io.github.leeseojune53.finder.global.exception.UserNotFoundException;
import io.github.leeseojune53.finder.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principle instanceof AuthDetails)) {
            throw CredentialsNotFoundException.EXCEPTION;
        }
        return userRepository.findById(((AuthDetails)principle).getUser().getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

    }

}
