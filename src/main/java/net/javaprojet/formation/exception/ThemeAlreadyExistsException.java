package net.javaprojet.formation.exception;

public class ThemeAlreadyExistsException extends RuntimeException {
    public ThemeAlreadyExistsException(String msg) {
        super(msg);
    }
}