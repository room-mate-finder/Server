package io.github.leeseojune53.finder.domain.room.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomInformationResponse {

    private final String roomNumber;
    private final Integer count;

}
