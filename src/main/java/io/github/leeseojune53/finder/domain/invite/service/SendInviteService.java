package io.github.leeseojune53.finder.domain.invite.service;

import io.github.leeseojune53.finder.domain.invite.domain.Invite;
import io.github.leeseojune53.finder.domain.invite.domain.repository.InviteRepository;
import io.github.leeseojune53.finder.domain.invite.exception.AlreadyInvitedException;
import io.github.leeseojune53.finder.domain.invite.exception.AlreadyJoinRoomException;
import io.github.leeseojune53.finder.domain.invite.exception.AnotherGradeException;
import io.github.leeseojune53.finder.domain.room.domain.Room;
import io.github.leeseojune53.finder.domain.room.domain.repositroy.RoomRepository;
import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SendInviteService {

    private final UserFacade userFacade;
    private final InviteRepository inviteRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public void execute(String number) {
        User user = userFacade.getCurrentUser();
        User invitedUser = userFacade.getUserByNumber(number);

        if (!user.getGrade().equals(invitedUser.getGrade())) {
            throw AnotherGradeException.EXCEPTION;
        }

        if (inviteRepository.findByInvitedUserAndSendUser(invitedUser, user).isPresent()) {
            throw AlreadyInvitedException.EXCEPTION;
        }

        if (inviteRepository.findByInvitedUserAndSendUser(user, invitedUser).isPresent()) {
            if (user.getRoom() != null) {
                invitedUser.setRoom(user.getRoom());
            } else if(invitedUser.getRoom() != null) {
                user.setRoom(invitedUser.getRoom());
            } else {
                Room room = roomRepository.save(new Room());
                user.setRoom(room);
                invitedUser.setRoom(room);
            }
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
