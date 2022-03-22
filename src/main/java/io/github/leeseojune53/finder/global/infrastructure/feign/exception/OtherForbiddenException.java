package io.github.leeseojune53.finder.global.infrastructure.feign.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class OtherForbiddenException extends FinderException {

    public static final FinderException EXCEPTION = new OtherForbiddenException();

    private OtherForbiddenException() {
        super(ErrorCode.OTHER_FORBIDDEN);
    }

}
