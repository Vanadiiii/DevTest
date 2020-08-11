package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public class CommandClear extends AbstractCommand {
    String userCommand = "clear";

    @Override
    public void execute(String argument, Context context) {
        context.getArrayMap()
                .entrySet()
                .forEach(entry -> entry.setValue(new int[0]));
        System.out.println("all arrays are cleared");
    }
}
