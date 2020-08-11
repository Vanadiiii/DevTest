package ru.imatveev.application;

import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class Context {
    int[] initialArray = new int[0];

    Map<ArrayType, int[]> arrayMap;

    {
        arrayMap = EnumSet.allOf(ArrayType.class)
                .stream()
                .collect(Collectors.toMap(
                        type -> type,
                        type -> new int[0]
                ));
    }
}
