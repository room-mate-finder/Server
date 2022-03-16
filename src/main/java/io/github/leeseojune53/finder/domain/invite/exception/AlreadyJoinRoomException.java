package io.github.leeseojune53.finder.domain.invite.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class AlreadyJoinRoomException extends FinderException {

    public static final AlreadyJoinRoomException EXCEPTION = new AlreadyJoinRoomException();

    private AlreadyJoinRoomException() {
        super(ErrorCode.ALREADY_JOIN_ROOM);
    }

}
