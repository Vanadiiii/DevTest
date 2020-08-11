package ru.imatveev.application.command;

import ru.imatveev.application.Context;
import ru.imatveev.application.CustomException;

import java.util.Arrays;

public class CommandInit extends AbstractCommand {
    String userCommand = "init";

    @Override
    public void execute(String argument, Context context) {
        if (argument == null) {
            throw new CustomException("initial array can not be null");
        }
        context.initialArray = parseArray(argument);
        context.array3 = filterArray(context.initialArray, 3);
        context.array5 = filterArray(context.initialArray, 5);
        context.array7 = filterArray(context.initialArray, 7);
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

    private int[] filterArray(int[] initialArray, int type) {
        return Arrays.stream(initialArray)
                .filter(it -> it % type == 0)
                .sorted()
                .toArray();
    }
}
