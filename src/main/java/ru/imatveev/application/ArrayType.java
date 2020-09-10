package ru.imatveev.application;

import lombok.Getter;
import ru.imatveev.application.exceptions.IllegalArrayTypeException;

public enum ArrayType {
    X(3),
    S(7),
    M(21);

    @Getter
    int value;

    ArrayType(int value) {
        this.value = value;
    }

    public static ArrayType getByName(String arrayName) {
        try {
            return ArrayType.valueOf(arrayName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArrayTypeException("unknown type of array - '" + arrayName + "'");
        }
    }
}
