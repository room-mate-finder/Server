package io.github.leeseojune53.finder.domain.room.presentation;

import io.github.leeseojune53.finder.domain.room.presentation.dto.request.UpdateRoomInformationRequest;
import io.github.leeseojune53.finder.domain.room.presentation.dto.response.RoomInformationResponse;
import io.github.leeseojune53.finder.domain.room.service.QueryRoomInformationService;
import io.github.leeseojune53.finder.domain.room.service.UpdateRoomInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/rooms")
@RestController
public class RoomController {

    private final QueryRoomInformationService queryRoomInformationService;
    private final UpdateRoomInformationService updateRoomInformationService;

    @GetMapping("/information")
    public RoomInformationResponse queryRoomInformation() {
        return queryRoomInformationService.execute();
    }

    @PatchMapping("/information")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoomInformation(@RequestBody UpdateRoomInformationRequest request) {
        updateRoomInformationService.execute(request);
    }

}
