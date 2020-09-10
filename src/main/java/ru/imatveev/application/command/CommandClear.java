package ru.imatveev.application.command;

import ru.imatveev.application.ArrayType;
import ru.imatveev.application.Context;

public class CommandClear implements ICommand {
    private final String COMMAND = "clear";

    @Override
    public boolean match(String userCommand) {
        return COMMAND.equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        context.getArrayMap()
                .entrySet()
                .stream()
                .filter(entry -> argument.isBlank() || ArrayType.getByName(argument).equals(entry.getKey()))
                .peek(entry -> System.out.println("array" + entry.getKey().name() + " was cleared"))
                .forEach(entry -> entry.setValue(new int[0]));
    }
}
