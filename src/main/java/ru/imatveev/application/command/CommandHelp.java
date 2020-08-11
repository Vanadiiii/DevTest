package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public class CommandHelp implements AbstractCommand {
    @Override
    public boolean match(String userCommand) {
        return "help".equals(userCommand);
    }

    @Override
    public void execute(String argument, Context context) {
        System.out.println("""
                init [your array]      -> initialize X, S and M arrays by your array
                                          print [your array] like n1,n2,n3...etc
                print [type(optional)] -> print array by type or all arrays
                clear                  -> clear all arrays
                merge                  -> merge all arrays into one and clear all
                anyMore                -> check values are not included into arrays
                help                   -> show the command list
                exit                   -> exit from application
                """);
    }
}
