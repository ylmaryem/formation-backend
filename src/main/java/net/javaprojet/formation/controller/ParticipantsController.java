package net.javaprojet.formation.controller;

import lombok.RequiredArgsConstructor;
import net.javaprojet.formation.entity.Participants;
import net.javaprojet.formation.service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
@RequiredArgsConstructor
public class ParticipantsController {
    @Autowired
    private final ParticipantsService participantsService;
    @PostMapping("/participer")
    public ResponseEntity<Object> participer(@RequestBody List<Integer> noCours,@RequestParam int noParticipant){
        System.out.println(noCours);
        return participantsService.participer(noCours,noParticipant);
    }
    @GetMapping
    public ResponseEntity<List<Participants>> getParticipants(){
        return new ResponseEntity<>(participantsService.getAllParticipants(), HttpStatus.FOUND);
    }
    @PostMapping
    public Participants addParticipant(@RequestBody Participants participant){
        return participantsService.addParticipant(participant);
    }
    @PutMapping("/update/{id}")
    public Participants updateParticipant(@RequestBody Participants participant, @PathVariable int noParticipant){
        return participantsService.updatePartcipant(participant,noParticipant);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteParticipant(@PathVariable int noParticipant){
        participantsService.deleteParticipant(noParticipant);
    }
    @GetMapping("/participant/{id}")
    public Participants getParticipantById(@PathVariable int noParticipant){
        return participantsService.getParticipantById(noParticipant);
    }
}
