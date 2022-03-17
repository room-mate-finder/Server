package io.github.leeseojune53.finder.domain.invite.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class AlreadyInvitedException extends FinderException {

    public static final FinderException EXCEPTION = new AlreadyInvitedException();

    private AlreadyInvitedException() {
        super(ErrorCode.ALREADY_INVITED);
    }

}
