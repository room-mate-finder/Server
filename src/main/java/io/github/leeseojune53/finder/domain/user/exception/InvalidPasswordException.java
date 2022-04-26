package io.github.leeseojune53.finder.domain.user.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class InvalidPasswordException extends FinderException {

    public static final FinderException EXCEPTION = new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }

}
