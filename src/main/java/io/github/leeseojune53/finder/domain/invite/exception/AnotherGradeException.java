package io.github.leeseojune53.finder.domain.invite.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class AnotherGradeException extends FinderException {

    public static final FinderException EXCEPTION = new AnotherGradeException();

    private AnotherGradeException() {
        super(ErrorCode.ANOTHER_GRADE);
    }

}
