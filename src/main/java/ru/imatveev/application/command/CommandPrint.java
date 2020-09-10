package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;

import java.util.Arrays;

public class CommandPrint implements ICommand {
    private final String COMMAND = "print";

    @Override
    public boolean match(String userCommand) {
        return COMMAND.equals(userCommand);
    }

    @Override
    public void execute(String arrayType, Context context) {
        context.getArrayMap()
                .entrySet()
                .stream()
                .filter(entry -> arrayType.isBlank() || ArrayType.getByName(arrayType).equals(entry.getKey()))
                .forEach(entry -> print(entry.getValue(), entry.getKey()));
    }

    private void print(int[] array, ArrayType type) {
        System.out.printf(
                "array%s is %s%n",
                type.name(),
                (array.length != 0) ? Arrays.toString(array) : "empty"
        );
    }
}
