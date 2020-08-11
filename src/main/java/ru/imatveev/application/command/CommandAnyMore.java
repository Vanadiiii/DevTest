package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;

import java.util.Arrays;
import java.util.EnumSet;

public class CommandAnyMore implements AbstractCommand {
    @Override
    public boolean match(String userCommand) {
        return "anyMore".equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        boolean hasAnyMore = Arrays.stream(context.getInitialArray())
                .anyMatch(it ->
                        EnumSet.allOf(ArrayType.class)
                                .stream()
                                .anyMatch(type -> it % type.getValue() == 0)
                );
        System.out.println(hasAnyMore);
    }
}
