package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import io.github.leeseojune53.finder.domain.user.presentation.dto.response.UserInformationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryUserInformationService {

    private final UserFacade userFacade;

    public UserInformationResponse execute() {
        User user = userFacade.getCurrentUser();
        return UserInformationResponse.builder()
                .lifeStyle(user.getLifeStyle())
                .bedTime(user.getBedTime())
                .wakeUpTime(user.getWakeUpTime())
                .description(user.getDescription())
                .build();
    }

}
