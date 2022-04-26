package io.github.leeseojune53.finder.domain.room.service;

import io.github.leeseojune53.finder.domain.invite.domain.Invite;
import io.github.leeseojune53.finder.domain.invite.domain.repository.InviteRepository;
import io.github.leeseojune53.finder.domain.room.presentation.dto.response.RoomMateResponse;
import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.domain.repository.UserRepository;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryRoomMateService {

    private final UserFacade userFacade;
    private final InviteRepository inviteRepository;
    private final UserRepository userRepository;

    public RoomMateResponse execute() {
        User currentUser = userFacade.getCurrentUser();
        List<User> userList = inviteRepository.findByInvitedUser(currentUser)
                .stream().map(Invite::getSendUser)
                .collect(Collectors.toList());
        userList.addAll(userRepository.findByGrade(currentUser.getGrade()));

        return new RoomMateResponse(
                userList.stream()
                        .map(user -> RoomMateResponse.RoomMate.builder()
                                .number(user.getNumber())
                                .name(user.getName())
                                .description(user.getDescription())
                                .lifeStyle(user.getLifeStyle())
                                .bedTime(user.getBedTime())
                                .wakeUpTime(user.getWakeUpTime())
                                .build()
                        ).collect(Collectors.toList())
        );

    }

}
