package ru.imatveev.application.exceptions;

public class IllegalCommandNameException extends ConsoleAppException {
    public IllegalCommandNameException(String message) {
        super(message);
    }
}
