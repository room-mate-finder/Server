package io.github.leeseojune53.finder.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateInformationRequest {

    private String lifeStyle;
    private String bedTime;
    private String wakeUpTime;
    private String description;

}
