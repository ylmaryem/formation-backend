
package net.javaprojet.formation.exception;

public class ParticipantAlreadyExistsException extends RuntimeException{
    public ParticipantAlreadyExistsException(String msg){
        super(msg);
    }
}