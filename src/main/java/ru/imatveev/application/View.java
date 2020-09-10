package ru.imatveev.application;

import ru.imatveev.application.command.ICommand;
import ru.imatveev.application.exceptions.ConsoleAppException;
import ru.imatveev.application.exceptions.IllegalCommandNameException;

import java.util.List;
import java.util.Scanner;

/**
 * <p>created by</p>
 * <p>Ivan Matveev</p>
 */
public class View {
    Context context = new Context();

    List<ICommand> iCommandList = new CommandScanner().getCommands();

    static {
        System.out.println("Welcome to the my app");
        System.out.println("Please, chose your command");
        System.out.println("\t(print 'help' to see all commands)");
    }

    @SuppressWarnings("all")
    public void start() {
        String userCommand = new Scanner(System.in).nextLine();
        try {
            filterCommandsAndExecute(userCommand);
        } catch (ConsoleAppException e) {
            handle(e);
        }
        start();
    }

    private void handle(ConsoleAppException e) {
        System.err.println(e.getMessage());
        System.err.println("please write correct command or print 'help'");
    }

    private void filterCommandsAndExecute(String userCommand) {
        String command = parseCommand(userCommand);
        String argument = parseArgument(userCommand);
        iCommandList.stream()
                .filter(abstractCommand -> abstractCommand.match(command))
                .findFirst()
                .orElseThrow(() -> new IllegalCommandNameException("unknown command - '" + userCommand + "'"))
                .execute(argument, context);
    }

    private String parseCommand(String userCommand) {
        return userCommand.replaceAll("(^\\w+)(\\s*)(.*$)", "$1");
    }

    private String parseArgument(String userCommand) {
        return userCommand.replaceAll("(^\\w+)(\\s*)(.*$)", "$3");
    }
}
