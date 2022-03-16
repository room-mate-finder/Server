package io.github.leeseojune53.finder.domain.room.exception;

import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;

public class RoomNotFoundException extends FinderException {

    public static final FinderException EXCEPTION = new RoomNotFoundException();

    private RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }

}
