package net.javaprojet.formation.exception;

public class ParticipantNotFoundException extends RuntimeException{
    public ParticipantNotFoundException(String msg){
        super(msg);
    }
}