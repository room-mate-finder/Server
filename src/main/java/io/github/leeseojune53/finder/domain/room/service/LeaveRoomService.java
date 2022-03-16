package io.github.leeseojune53.finder.domain.room.service;

import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LeaveRoomService {

    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        userFacade.getCurrentUser().setRoomNull();
    }

}
