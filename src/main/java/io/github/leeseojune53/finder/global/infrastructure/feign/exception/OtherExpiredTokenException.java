package io.github.leeseojune53.finder.global.infrastructure.feign.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class OtherExpiredTokenException extends FinderException {

    public static final FinderException EXCEPTION = new OtherExpiredTokenException();

    private OtherExpiredTokenException() {
        super(ErrorCode.OTHER_EXPIRED_TOKEN);
    }

}
