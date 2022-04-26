package io.github.leeseojune53.finder.domain.user.presentation;

import io.github.leeseojune53.finder.domain.user.presentation.dto.request.AuthRequest;
import io.github.leeseojune53.finder.domain.user.presentation.dto.request.SignupRequest;
import io.github.leeseojune53.finder.domain.user.presentation.dto.request.UpdateInformationRequest;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.TokenResponse;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.UserInformationResponse;
import io.github.leeseojune53.finder.domain.user.service.AuthService;
import io.github.leeseojune53.finder.domain.user.service.QueryUserInformationService;
import io.github.leeseojune53.finder.domain.user.service.SignupService;
import io.github.leeseojune53.finder.domain.user.service.TokenRefreshService;
import io.github.leeseojune53.finder.domain.user.service.UpdateUserInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final TokenRefreshService tokenRefreshService;
    private final QueryUserInformationService queryUserInformationService;
    private final UpdateUserInformationService updateUserInformationService;
    private final SignupService signupService;
    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse auth(@RequestBody @Valid AuthRequest request) {
        return authService.execute(request);
    }

    @PutMapping("/auth")
    public TokenResponse tokenRefresh(@RequestHeader("Refresh-Token") String token) {
        return tokenRefreshService.execute(token);
    }

    @GetMapping("/information")
    public UserInformationResponse queryInformation() {
        return queryUserInformationService.execute();
    }

    @PatchMapping("/information")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInformation(@RequestBody @Valid UpdateInformationRequest request) {
        updateUserInformationService.execute(request);
    }

}
