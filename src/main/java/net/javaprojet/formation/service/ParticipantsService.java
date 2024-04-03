package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Participants;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParticipantsService {

    Participants addParticipant(Participants participant);

    List<Participants> getAllParticipants();

    Participants getParticipantById(int noParticipant);

    Participants updatePartcipant(Participants participant, int noParticipant);

    void deleteParticipant(int noParticipant);

    ResponseEntity<Object> participer(List<Integer> noCours, int noParticipant);
}
