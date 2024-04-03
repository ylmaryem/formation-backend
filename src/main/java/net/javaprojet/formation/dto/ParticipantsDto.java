package net.javaprojet.formation.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaprojet.formation.entity.Cours;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParticipantsDto {
    private int noParticipant;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateInscription;
    private List<Cours> coursList;
}
