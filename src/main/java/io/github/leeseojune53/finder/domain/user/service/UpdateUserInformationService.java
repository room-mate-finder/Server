package io.github.leeseojune53.finder.domain.user.service;

import io.github.leeseojune53.finder.domain.user.domain.User;
import io.github.leeseojune53.finder.domain.user.domain.types.LifeStyle;
import io.github.leeseojune53.finder.domain.user.domain.types.Time;
import io.github.leeseojune53.finder.domain.user.facade.UserFacade;
import io.github.leeseojune53.finder.domain.user.presentation.dto.request.UpdateInformationRequest;
import io.github.leeseojune53.finder.global.utils.EnumUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInformationService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateInformationRequest request) {
        User user = userFacade.getCurrentUser();

        user.updateUserInformation(
                request.getDescription(),
                EnumUtils.convertToEnum(request.getLifeStyle(), LifeStyle.class),
                EnumUtils.convertToEnum(request.getBedTime(), Time.class),
                EnumUtils.convertToEnum(request.getWakeUpTime(), Time.class)
        );
    }

}
