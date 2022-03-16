package io.github.leeseojune53.finder.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    NOT_FOUND(404, "GLOBAL-404-1", "Not Found."),
    INTERNAL_SERVER_ERROR(500, "GLOBAL-500-1", "Internal Server Error.");

    private final int status;
    private final String code;
    private final String message;

}
