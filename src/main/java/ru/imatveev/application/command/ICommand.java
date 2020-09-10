package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public interface ICommand {
    boolean match(String userCommand);

    void execute(String argument, Context context);
}
