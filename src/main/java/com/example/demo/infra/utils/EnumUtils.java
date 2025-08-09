package com.example.demo.infra.utils;

import java.util.Arrays;

public class EnumUtils {

    public static <E extends  Enum<E>> boolean contains(Class<E> enumClass, String value) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return Arrays.stream(enumClass.getEnumConstants()).map(E::name).anyMatch(name -> name.equalsIgnoreCase(value));
    }

}
