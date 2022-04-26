package io.github.leeseojune53.finder.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class AuthRequest {

    @Length(min = 4, max = 4, message = "학번은 4글자여야 합니다.")
    private String number;

    @NotBlank(message = "비밀번호는 공백이 포함되어있으면 안됩니다.")
    private String password;

}
