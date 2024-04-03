package net.javaprojet.formation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Animateurs")
public class Animateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noAnimateur;
    @Column(name="nom",nullable = false)
    private String nom;
    @Column(name="prenom",nullable = false)
    private String prenom;
    @ManyToMany(mappedBy = "animateursList")
    private List<Cours> coursList;
    @Override
    public String toString() {
        return "noAnimateur=" + noAnimateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", la liste des cours=" + coursList;
    }

}