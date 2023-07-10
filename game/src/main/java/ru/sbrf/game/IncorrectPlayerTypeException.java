package ru.sbrf.game;

public class IncorrectPlayerTypeException extends RuntimeException {

    public IncorrectPlayerTypeException(String message) {
        super(message);
    }
}
