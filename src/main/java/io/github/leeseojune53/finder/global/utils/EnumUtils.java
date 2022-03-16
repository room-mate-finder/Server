package io.github.leeseojune53.finder.global.utils;

import io.github.leeseojune53.finder.global.exception.InvalidEnumValueException;

public class EnumUtils {

    public static <T extends Enum<T>> T convertToEnum(String value, Class<T> enumClass) {
        if(value == null) {
            return null;
        }
        try {
            return Enum.valueOf(enumClass, value);
        } catch (IllegalArgumentException e) {
            throw InvalidEnumValueException.EXCEPTION;
        }
    }

}
