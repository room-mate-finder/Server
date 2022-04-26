package io.github.leeseojune53.finder.domain.user.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class AlreadyExistNumberException extends FinderException {

    public static final FinderException EXCEPTION = new AlreadyExistNumberException();

    private AlreadyExistNumberException() {
        super(ErrorCode.ALREADY_EXIST_NUMBER);
    }

}
