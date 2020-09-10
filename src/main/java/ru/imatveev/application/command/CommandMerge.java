package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;

import java.util.Arrays;
import java.util.EnumSet;

public class CommandMerge implements ICommand {
    private final String COMMAND = "merge";

    @Override
    public boolean match(String userCommand) {
        return COMMAND.equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        int[] mergedArray = Arrays.stream(context.getInitialArray())
                .filter(value ->
                        EnumSet.allOf(ArrayType.class)
                                .stream()
                                .map(ArrayType::getValue)
                                .anyMatch(enumValue -> value % enumValue == 0)
                )
                .sorted()
                .toArray();
        System.out.println("merged array is " + ((mergedArray.length != 0) ? Arrays.toString(mergedArray) : "empty"));
        context.getArrayMap()
                .entrySet()
                .forEach(entry -> entry.setValue(new int[0]));
    }
}
