package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public class CommandClear extends AbstractCommand {
    String userCommand = "clear";

    @Override
    public void execute(String argument, Context context) {
        context.array3 = new int[0];
        context.array5 = new int[0];
        context.array7 = new int[0];
        System.out.println("all arrays are cleared");
    }
}
