package io.github.leeseojune53.finder.domain.invite.presentation;

import io.github.leeseojune53.finder.domain.invite.presentation.dto.request.NumberRequest;
import io.github.leeseojune53.finder.domain.invite.service.RefuseInviteService;
import io.github.leeseojune53.finder.domain.invite.service.SendInviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/invite")
@RestController
public class InviteController {

    private final SendInviteService sendInviteService;
    private final RefuseInviteService refuseInviteService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendInvite(@RequestBody @Valid NumberRequest request) {
        sendInviteService.execute(request.getNumber());
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void refuseInvite(@RequestBody @Valid NumberRequest request) {
        refuseInviteService.execute(request.getNumber());
    }

}
