package io.github.leeseojune53.finder.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_ENUM_VALUE(400, "GLOBAL-400-1", "Invalid Enum Value."),
    EXPIRED_TOKEN(401, "GLOBAL-401-1", "Expired token."),
    INVALID_TOKEN(401, "GLOBAL-401-2", "Invalid token."),
    NOT_FOUND(404, "GLOBAL-404-1", "Not Found."),
    USER_NOT_FOUND(404, "GLOBAL-404-2", "User Not Found."),
    INTERNAL_SERVER_ERROR(500, "GLOBAL-500-1", "Internal Server Error."),

    INVALID_PASSWORD(400, "USER-400-1", "Invalid Password"),
    REFRESH_TOKEN_NOT_FOUND(404, "USER-404-1", "Refresh Token Not Found."),
    CREDENTIALS_NOT_FOUND(404, "USER-404-2", "Credentials Not Found."),
    ALREADY_EXIST_NUMBER(409, "USER-409-1", "Already Exist Number"),

    ROOM_NOT_FOUND(404, "ROOM-404-1", "Room Not Found."),

    ANOTHER_GRADE(400, "INVITE-400-1", "Another Grade."),
    INVITE_NOT_FOUND(404, "INVITE-404-1", "Invite Not Found."),
    ALREADY_JOIN_ROOM(409, "INVITE-409-1", "Already Join Room."),
    ALREADY_INVITED(409, "INVITE-409-2", "Already Invited."),

    OTHER_BAD_REQUEST(400, "OTHER-400-1", "BadRequest"),
    OTHER_UNAUTHORIZED(401, "OTHER-401-1", "Unauthorized"),
    OTHER_FORBIDDEN(403, "OTHER-403-1", "Forbidden"),
    OTHER_EXPIRED_TOKEN(419, "OTHER-419", "Expired Token");

    private final int status;
    private final String code;
    private final String message;

}
