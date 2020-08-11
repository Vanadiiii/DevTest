package ru.imatveev.application;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
