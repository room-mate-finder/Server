package io.github.leeseojune53.finder.domain.invite.presentation;

import io.github.leeseojune53.finder.domain.invite.presentation.dto.request.SendInviteRequest;
import io.github.leeseojune53.finder.domain.invite.service.SendInviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class InviteController {

    private final SendInviteService sendInviteService;

    @PostMapping("/invite")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendInvite(@RequestBody @Valid SendInviteRequest request) {
        sendInviteService.execute(request.getNumber());
    }

}
