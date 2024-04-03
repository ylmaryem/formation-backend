
package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Cours;
import net.javaprojet.formation.entity.Participants;
import net.javaprojet.formation.exception.ParticipantAlreadyExistsException;
import net.javaprojet.formation.exception.ParticipantNotFoundException;
import net.javaprojet.formation.repository.CoursRepository;
import net.javaprojet.formation.repository.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {
    @Autowired
    private ParticipantsRepository participantsRepository;
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Participants addParticipant(Participants participant) {
        if(participantAlreadyExists(participant.getEmail())) {
            throw new ParticipantAlreadyExistsException(participant.getEmail() + "already exists!");
        }
        return participantsRepository.save(participant);
    }

    @Override
    public List<Participants> getAllParticipants() {
        return participantsRepository.findAll();
    }

    @Override
    public Participants getParticipantById(int noParticipant) {
        return participantsRepository.findById(noParticipant)
                .orElseThrow(()-> new ParticipantNotFoundException("Sorry, no participant found with the Id:" + noParticipant));
    }
    @Override
    public Participants updatePartcipant(Participants participant, int noParticipant) {
        return participantsRepository.findById(noParticipant).map(pr -> {
            pr.setNom(participant.getNom());
            pr.setPrenom(participant.getPrenom());
            pr.setEmail(participant.getEmail());
            pr.setDateInscription(participant.getDateInscription());
            pr.setCoursList(participant.getCoursList());
            return participantsRepository.save(pr);
        }).orElseThrow(()-> new ParticipantNotFoundException("Sorry this participant could not be found!"));
    }

    @Override
    public void deleteParticipant(int noParticipant) {
        if(!participantsRepository.existsById(noParticipant)){
            throw new ParticipantNotFoundException("Sorry, participant not found!");
        }
    }

    @Override
    public ResponseEntity<Object> participer(List<Integer> noCours, int noParticipant) {
        Participants participant=participantsRepository.findByNoParticipant(noParticipant).orElse(null);
        List<Cours> coursList=coursRepository.findByNoCoursIn(noCours);
        System.out.println(coursList);
        participant.setCoursList(coursList);
        participantsRepository.save(participant);
        return new ResponseEntity<>("ok!", HttpStatus.OK) ;
    }

    private boolean participantAlreadyExists(String email){
        return participantsRepository.findByEmail(email).isPresent();
    }
}

