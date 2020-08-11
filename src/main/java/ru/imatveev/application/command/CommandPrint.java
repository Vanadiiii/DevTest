package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;
import ru.imatveev.application.CustomException;

import java.util.Arrays;

public class CommandPrint extends AbstractCommand {
    String userCommand = "print";

    @Override
    public void execute(String argument, Context context) {
        if (argument.isBlank()) {
            context.getArrayMap()
                    .forEach((key, value) -> print(value, key));
        } else {
            ArrayType type;
            try {
                type = ArrayType.valueOf(argument.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new CustomException("unknown type of array - '" + argument + "'");
            }
            context.getArrayMap()
                    .entrySet()
                    .stream()
                    .filter(entry -> type.equals(entry.getKey()))
                    .forEach(entry -> print(entry.getValue(), entry.getKey()));
        }
    }

    private void print(int[] array, ArrayType type) {
        System.out.printf(
                "array%s is %s%n",
                type.name(),
                (array.length != 0) ? Arrays.toString(array) : "empty"
        );
    }
}
