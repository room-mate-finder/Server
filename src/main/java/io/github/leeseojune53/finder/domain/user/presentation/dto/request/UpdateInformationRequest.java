package io.github.leeseojune53.finder.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateInformationRequest {

    private String lifeStyle;
    private String bedTime;
    private String wakeUpTime;

    @Size(max = 200, message = "description은 200자가 넘으면 안됩니다.")
    private String description;

}
