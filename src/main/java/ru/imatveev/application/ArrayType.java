package ru.imatveev.application;

import lombok.Getter;

public enum ArrayType {
    X(3),
    S(5),
    M(7);

    @Getter
    int value;

    ArrayType(int value) {
        this.value = value;
    }
}
