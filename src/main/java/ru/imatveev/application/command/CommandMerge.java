package ru.imatveev.application.command;

import ru.imatveev.application.Context;

import java.util.Arrays;

public class CommandMerge implements AbstractCommand {
    @Override
    public boolean match(String userCommand) {
        return "merge".equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        int[] mergedArray = context.getArrayMap()
                .values()
                .stream()
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
        System.out.println("merged array is " + Arrays.toString(mergedArray));
        context.getArrayMap()
                .entrySet()
                .forEach(entry -> entry.setValue(new int[0]));
    }
}
