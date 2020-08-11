package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;
import ru.imatveev.application.CustomException;

public class CommandClear extends AbstractCommand {
    String userCommand = "clear";

    @Override
    public void execute(String argument, Context context) {
        if (argument.isBlank()) {
            context.getArrayMap()
                    .entrySet()
                    .forEach(entry -> entry.setValue(new int[0]));
            System.out.println("all arrays were cleared");
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
                    .forEach(entry -> entry.setValue(new int[0]));
            System.out.println("array" + type.name() + " was cleared");
        }
    }
}
