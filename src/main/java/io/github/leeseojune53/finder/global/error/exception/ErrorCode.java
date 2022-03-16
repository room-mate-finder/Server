package io.github.leeseojune53.finder.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_TOKEN(401, "GLOBAL-401-1", "Expired token."),
    INVALID_TOKEN(401, "GLOBAL-401-2", "Invalid token."),
    NOT_FOUND(404, "GLOBAL-404-1", "Not Found."),
    USER_NOT_FOUND(404, "GLOBAL-404-2", "User Not Found."),
    INTERNAL_SERVER_ERROR(500, "GLOBAL-500-1", "Internal Server Error.");

    private final int status;
    private final String code;
    private final String message;

}
