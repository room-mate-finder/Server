package io.github.leeseojune53.finder.domain.invite.service;

import io.github.leeseojune53.finder.domain.invite.domain.repository.InviteRepository;
import io.github.leeseojune53.finder.domain.invite.exception.InviteNotFoundException;
import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefuseInviteService {

    private final UserFacade userFacade;
    private final InviteRepository inviteRepository;

    public void execute(String number) {
        User user = userFacade.getCurrentUser();
        User sendUser = userFacade.getUserByNumber(number);
        inviteRepository.delete(
                inviteRepository.findByInvitedUserAndSendUser(user, sendUser)
                        .orElseThrow(() -> InviteNotFoundException.EXCEPTION)
        );
    }

}
