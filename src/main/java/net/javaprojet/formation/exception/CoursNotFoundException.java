package net.javaprojet.formation.exception;

public class CoursNotFoundException extends RuntimeException {
    public CoursNotFoundException(String msg) {
        super(msg);
    }
}