package io.github.leeseojune53.finder.domain.room.presentation.dto.response;

import io.github.leeseojune53.finder.domain.user.domain.types.LifeStyle;
import io.github.leeseojune53.finder.domain.user.domain.types.Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RoomMateResponse {

    private List<RoomMate> mates;

    @Getter
    @Builder
    public static class RoomMate {
        private final String number;
        private final String name;
        private final String description;
        private final LifeStyle lifeStyle;
        private final Time bedTime;
        private final Time wakeUpTime;
    }



}
