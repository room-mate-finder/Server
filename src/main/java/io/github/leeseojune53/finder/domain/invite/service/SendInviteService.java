package io.github.leeseojune53.finder.domain.invite.service;

import io.github.leeseojune53.finder.domain.invite.domain.Invite;
import io.github.leeseojune53.finder.domain.invite.domain.repository.InviteRepository;
import io.github.leeseojune53.finder.domain.invite.exception.AlreadyJoinRoomException;
import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendInviteService {

    private final UserFacade userFacade;
    private final InviteRepository inviteRepository;

    public void execute(String number) {
        User user = userFacade.getCurrentUser();
        User invitedUser = userFacade.getUserByNumber(number);

        if(user.getRoom() != null) {
            throw AlreadyJoinRoomException.EXCEPTION;
        }

        if(inviteRepository.findByInvitedUserAndSendUser(user, invitedUser).isPresent()) {
            //TODO 초대 수락 로직
        } else {
            inviteRepository.save(
                    Invite.builder()
                            .sendUser(user)
                            .invitedUser(invitedUser)
                            .build()
            );
        }

    }

}
