package ru.imatveev.application.exceptions;

public class IllegalCommandArgumentException extends ConsoleAppException {
    public IllegalCommandArgumentException(String message) {
        super(message);
    }
}
