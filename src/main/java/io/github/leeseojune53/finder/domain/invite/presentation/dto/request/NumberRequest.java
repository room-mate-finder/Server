package io.github.leeseojune53.finder.domain.invite.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SendInviteRequest {

    @NotBlank(message = "number는 null이거나 비어있으면 안됩니다.")
    @Size(max = 4, message = "number는 4글자 이하여아 합니다.")
    private String number;

}
