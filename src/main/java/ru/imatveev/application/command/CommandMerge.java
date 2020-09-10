package ru.imatveev.application.command;

import ru.imatveev.application.Context;

import java.util.Arrays;

public class CommandMerge implements ICommand {
    private final String COMMAND = "merge";

    @Override
    public boolean match(String userCommand) {
        return COMMAND.equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        int[] mergedArray = context.getArrayMap()
                .values()
                .stream()
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
        System.out.println("merged array is " + ((mergedArray.length != 0) ? Arrays.toString(mergedArray) : "empty"));
        context.getArrayMap()
                .entrySet()
                .forEach(entry -> entry.setValue(new int[0]));
    }
}
