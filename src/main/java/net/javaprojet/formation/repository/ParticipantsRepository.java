package net.javaprojet.formation.repository;

import net.javaprojet.formation.entity.Participants;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants, Integer>{
    Optional<Participants> findByEmail(String email);

    Optional<Participants> findByNoParticipant(int noParticipant);
}