package io.github.leeseojune53.finder.global.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class RefreshTokenNotFoundException extends FinderException {

    public static final FinderException EXCEPTION = new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }

}
