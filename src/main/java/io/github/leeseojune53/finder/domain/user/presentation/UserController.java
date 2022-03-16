package io.github.leeseojune53.finder.domain.user.presentation;

import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import io.github.leeseojune53.finder.domain.user.service.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final TokenRefreshService tokenRefreshService;

    @PutMapping("/users/auth")
    public TokenResponse tokenRefresh(@RequestHeader("Refresh-Token") String token) {
        return tokenRefreshService.execute(token);
    }

}
