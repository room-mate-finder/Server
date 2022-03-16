package io.github.leeseojune53.finder.domain.user.presentation.dto.response;

import io.github.leeseojune53.finder.domain.user.domain.types.LifeStyle;
import io.github.leeseojune53.finder.domain.user.domain.types.Time;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInformationResponse {

    private final LifeStyle lifeStyle;
    private final Time bedTime;
    private final Time wakeUpTime;
    private final String description;

}
