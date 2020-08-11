package ru.imatveev.application.command;

import ru.imatveev.application.Context;

import java.util.Arrays;

public class CommandMerge extends AbstractCommand {
    String userCommand = "merge";

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
