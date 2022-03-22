package io.github.leeseojune53.finder.global.infrastructure.feign.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class OtherUnauthorizedException extends FinderException {

    public static final FinderException EXCEPTION = new OtherUnauthorizedException();

    private OtherUnauthorizedException() {
        super(ErrorCode.OTHER_UNAUTHORIZED);
    }

}
