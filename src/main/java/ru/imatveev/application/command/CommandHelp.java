package ru.imatveev.application.command;

import ru.imatveev.application.Context;

public class CommandHelp extends AbstractCommand {
    String userCommand = "help";

    @Override
    public void execute(String argument, Context context) {
        System.out.println("init [your array]      -> initialize X, S and M arrays by your array");
        System.out.println("                              write [your array] like n1,n2,n3...etc");
        System.out.println("print [type(optional)] -> print array by type or all arrays");
        System.out.println("clear [type(optional)] -> clear array by type or all arrays");
        System.out.println("merge                  -> merge all arrays into one and clear all");
        System.out.println("anyMore                -> check values are not included into arrays");
        System.out.println("help                   -> show the command list");
        System.out.println("exit                   -> exit from application");
    }
}
