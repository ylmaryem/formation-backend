package net.javaprojet.formation.exception;

public class CoursAlreadyExistsException extends RuntimeException {
    public CoursAlreadyExistsException(String msg) {
        super(msg);
    }
}