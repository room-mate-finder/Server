package io.github.leeseojune53.finder.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class SignupRequest {

    @Length(min = 4, max = 4, message = "학번은 4글자여야 합니다.")
    private String number;

    private String password;

    @Length(min = 2, max = 5, message = "이름은 2글자 이상 5글자 이하여야 합니다.")
    private String name;

}
