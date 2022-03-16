package io.github.leeseojune53.finder.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FinderException extends RuntimeException {

    private final ErrorCode errorCode;

}
