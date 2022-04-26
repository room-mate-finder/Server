package io.github.leeseojune53.finder.domain.room.service;

import io.github.leeseojune53.finder.domain.room.domain.Room;
import io.github.leeseojune53.finder.domain.room.exception.RoomNotFoundException;
import io.github.leeseojune53.finder.domain.room.presentation.dto.response.RoomInformationResponse;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryRoomInformationService {

    private final UserFacade userFacade;

    public RoomInformationResponse execute() {
        Room room = userFacade.getCurrentUser().getRoom();
        if (room == null) {
            throw RoomNotFoundException.EXCEPTION;
        }
        return RoomInformationResponse.builder()
                .roomNumber(room.getRoomNumber())
                .count(room.getCount())
                .build();
    }

}
