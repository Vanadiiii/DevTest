package ru.imatveev.application.command;

import ru.imatveev.application.Context;

import java.util.Arrays;

public class CommandAnyMore extends AbstractCommand {
    String userCommand = "anyMore";

    @Override
    public void execute(String argument, Context context) {
        boolean hasAnyMore = Arrays.stream(context.initialArray)
                .filter(it -> it % 3 != 0)
                .filter(it -> it % 5 != 0)
                .filter(it -> it % 7 != 0)
                .count() > 0;
        System.out.println(hasAnyMore);
    }
}
