
package net.javaprojet.formation.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Participants")
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noParticipant;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "dateInscri", nullable = false)
    private LocalDate dateInscription;
    @ManyToMany(mappedBy = "participantsList",fetch = FetchType.EAGER)
    private List<Cours> coursList = new ArrayList<>();

    public void participer(List<Cours> coursL, LocalDate dateInscription) {
        if(coursList == null) coursList = new ArrayList<>();
        if (!coursList.containsAll(coursL)) {
            // Ajouter les cours auxquels l'étudiant participe
             coursList.addAll(coursL);
            // Mettre à jour la date d'inscription si nécessaire
            this.dateInscription = dateInscription;
        }
    }
    @Override
    public String toString() {
        return "noParticipant=" + noParticipant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dateInscription=" + dateInscription +
                ", liste des cours=" + coursList;
    }
}