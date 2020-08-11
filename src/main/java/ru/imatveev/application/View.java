package ru.imatveev.application;

import ru.imatveev.application.command.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    Context context = new Context();

    List<AbstractCommand> abstractCommandList = new CommandScanner().getCommands();

    static {
        System.out.println("Welcome to the my app");
        System.out.println("Please, chose your command");
        System.out.println("\t(print 'help' to see all commands)");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();
        try {
            filterCommandsAndExecute(userCommand);
        } catch (CustomException e) {
            handle(e);
        }
        start();
    }

    private void handle(CustomException e) {
        System.err.println(e.getMessage());
        System.err.println("please write right command or print 'help'");
    }

    private void filterCommandsAndExecute(String userCommand) {
        String command = parseCommand(userCommand);
        String argument = parseArgument(userCommand);
        abstractCommandList.stream()
                .filter(abstractCommand -> abstractCommand.match(command))
                .findFirst()
                .orElseThrow(() -> new CustomException("unknown command - '" + userCommand + "'"))
                .execute(argument, context);
    }

    private String parseCommand(String userCommand) {
        return userCommand.split(" ")[0];
    }

    private String parseArgument(String userCommand) {
        return userCommand.replaceAll("^\\w+\\s+", "");
    }
}
