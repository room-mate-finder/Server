package io.github.leeseojune53.finder.domain.room.service;

import io.github.leeseojune53.finder.domain.room.domain.Room;
import io.github.leeseojune53.finder.domain.room.exception.RoomNotFoundException;
import io.github.leeseojune53.finder.domain.room.presentation.dto.request.UpdateRoomInformationRequest;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateRoomInformationService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateRoomInformationRequest request) {
        Room room = userFacade.getCurrentUser().getRoom();
        if (room == null) {
            throw RoomNotFoundException.EXCEPTION;
        }
        room.updateRoomInformation(request.getRoomNumber(), request.getCount());
    }

}
