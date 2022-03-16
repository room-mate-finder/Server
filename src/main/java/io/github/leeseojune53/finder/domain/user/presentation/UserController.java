package io.github.leeseojune53.finder.domain.user.presentation;

import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.UserInformationResponse;
import io.github.leeseojune53.finder.domain.user.service.QueryUserInformationService;
import io.github.leeseojune53.finder.domain.user.service.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final TokenRefreshService tokenRefreshService;
    private final QueryUserInformationService queryUserInformationService;

    @PutMapping("/auth")
    public TokenResponse tokenRefresh(@RequestHeader("Refresh-Token") String token) {
        return tokenRefreshService.execute(token);
    }

    @GetMapping("/information")
    public UserInformationResponse queryInformation() {
        return queryUserInformationService.execute();
    }

}
