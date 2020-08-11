package ru.imatveev.application.command;

import ru.imatveev.application.Context;

import java.util.Arrays;
import java.util.stream.Stream;

public class CommandMerge extends AbstractCommand {
    String userCommand = "merge";

    @Override
    public void execute(String argument, Context context) {
        int[] mergedArray = Stream.of(context.array3, context.array5, context.array7)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
        System.out.println("merged array is " + Arrays.toString(mergedArray));
        context.array3 = new int[0];
        context.array5 = new int[0];
        context.array7 = new int[0];
    }
}
