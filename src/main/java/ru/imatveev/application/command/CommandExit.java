package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public class CommandExit extends AbstractCommand {
    String userCommand = "exit";

    @Override
    public void execute(String argument, Context context) {
        System.out.println("Thank you for using my app");
        System.exit(0);
    }
}
