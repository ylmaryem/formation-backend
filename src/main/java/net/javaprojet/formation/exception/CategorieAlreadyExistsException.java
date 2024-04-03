package net.javaprojet.formation.exception;

public class CategorieAlreadyExistsException extends RuntimeException {
    public CategorieAlreadyExistsException(String msg) {
        super(msg);
    }
}