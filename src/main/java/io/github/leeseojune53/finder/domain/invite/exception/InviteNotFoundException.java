package io.github.leeseojune53.finder.domain.invite.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class InviteNotFoundException extends FinderException {

    public static final FinderException EXCEPTION = new InviteNotFoundException();

    private InviteNotFoundException() {
        super(ErrorCode.INVITE_NOT_FOUND);
    }

}
