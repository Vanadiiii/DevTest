package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public interface AbstractCommand {
    boolean match(String userCommand);

    void execute(String argument, Context context);
}
