package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;
import ru.imatveev.application.exceptions.IllegalCommandArgumentException;

import java.util.Arrays;

public class CommandInit implements ICommand {
    private final String COMMAND = "init";

    @Override
    public boolean match(String userCommand) {
        return COMMAND.equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        if (argument == null) {
            throw new IllegalCommandArgumentException("initial array can not be null");
        }
        context.setInitialArray(parseArray(argument));
        context.getArrayMap()
                .entrySet()
                .forEach(entry -> entry.setValue(filterArray(context.getInitialArray(), entry.getKey())));
        System.out.println("all arrays are initialized");
    }

    private int[] parseArray(String argument) {
        /*language=REGEXP*/
        final String DELIMITER = "[,]";

        if (argument.equals("")) {
            return new int[0];
        } else {
            try {
                return Arrays.stream(argument.split(DELIMITER))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            } catch (NumberFormatException e) {
                throw new IllegalCommandArgumentException(
                        "can not parse argument - '" + argument + "'"
                                + "\nplease, use form 'n1,n2,n3,n4..nm'"
                );
            }
        }
    }

    private int[] filterArray(int[] initialArray, ArrayType type) {
        return Arrays.stream(initialArray)
                .filter(it -> it % type.getValue() == 0)
                .sorted()
                .toArray();
    }
}
