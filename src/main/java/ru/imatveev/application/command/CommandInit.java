package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;
import ru.imatveev.application.CustomException;

import java.util.Arrays;

public class CommandInit implements AbstractCommand {
    @Override
    public boolean match(String userCommand) {
        return "init".equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        if (argument == null) {
            throw new CustomException("initial array can not be null");
        }
        context.setInitialArray(parseArray(argument));
        context.getArrayMap()
                .entrySet()
                .forEach(entry -> entry.setValue(filterArray(context.getInitialArray(), entry.getKey())));
        System.out.println("all arrays are initialized");
    }

    private int[] parseArray(String argument) {
        if (argument.equals("")) {
            return new int[0];
        } else {
            try {
                return Arrays.stream(argument.split("[,]"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            } catch (NumberFormatException e) {
                throw new CustomException(
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
