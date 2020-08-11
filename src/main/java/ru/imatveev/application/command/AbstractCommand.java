package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public abstract class AbstractCommand {
    public boolean match(String userCommand) {
        try {
            return userCommand.equals(
                    this.getClass()
                            .getDeclaredField("userCommand")
                            .get(this).toString()
            );
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }

    public abstract void execute(String argument, Context context);
}
