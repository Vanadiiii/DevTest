package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public class CommandExit implements AbstractCommand {
    @Override
    public boolean match(String userCommand) {
        return "exit".equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        System.out.println("Thank you for using my app");
        System.exit(0);
    }
}
