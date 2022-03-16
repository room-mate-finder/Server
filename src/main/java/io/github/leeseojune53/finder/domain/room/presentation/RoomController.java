package io.github.leeseojune53.finder.domain.room.presentation;

import io.github.leeseojune53.finder.domain.room.presentation.dto.response.RoomInformationResponse;
import io.github.leeseojune53.finder.domain.room.service.QueryRoomInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/rooms")
@RestController
public class RoomController {

    private final QueryRoomInformationService queryRoomInformationService;

    @GetMapping("/information")
    public RoomInformationResponse queryRoomInformation() {
        return queryRoomInformationService.execute();
    }

}
