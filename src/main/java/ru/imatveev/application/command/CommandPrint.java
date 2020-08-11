package ru.imatveev.application.command;

import ru.imatveev.application.Context;
import ru.imatveev.application.CustomException;

import java.util.Arrays;

public class CommandPrint extends AbstractCommand {
    String userCommand = "print";

    @Override
    public void execute(String argument, Context context) {
        if (argument.equals("x") || argument.equals("s") || argument.equals("m")) {
            switch (argument) {
                case "x" -> print(context.array3, argument);
                case "s" -> print(context.array5, argument);
                case "m" -> print(context.array7, argument);
                default -> throw new IllegalArgumentException("unknown type of array - '" + argument + "'");
            }
        } else if (argument.isEmpty()) {
            print(context.array3, "x");
            print(context.array5, "s");
            print(context.array7, "m");
        } else {
            throw new CustomException("unknown type '" + argument + "'");
        }
    }

    private void print(int[] array, String type) {
        System.out.printf(
                "array%s is %s%n",
                type.toUpperCase(),
                (array.length != 0) ? Arrays.toString(array) : "empty"
        );
    }
}
