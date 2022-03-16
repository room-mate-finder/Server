package io.github.leeseojune53.finder.global.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class InvalidEnumValueException extends FinderException {

    public static final FinderException EXCEPTION = new InvalidEnumValueException();

    private InvalidEnumValueException() {
        super(ErrorCode.INVALID_ENUM_VALUE);
    }

}
