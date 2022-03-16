package io.github.leeseojune53.finder.domain.room.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRoomInformationRequest {

    private String roomNumber;
    private Integer count;

}
