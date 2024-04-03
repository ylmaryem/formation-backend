package net.javaprojet.formation.exception;

public class CategorieNotFoundException extends RuntimeException {
    public CategorieNotFoundException(String msg) {
        super(msg);
    }
}