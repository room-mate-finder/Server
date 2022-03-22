package io.github.leeseojune53.finder.global.infrastructure.feign.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class OtherBadRequestException extends FinderException {

    public static final FinderException EXCEPTION = new OtherBadRequestException();

    private OtherBadRequestException() {
        super(ErrorCode.OTHER_BAD_REQUEST);
    }

}
