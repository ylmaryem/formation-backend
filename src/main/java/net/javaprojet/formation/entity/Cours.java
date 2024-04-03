package net.javaprojet.formation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noCours;
    @Column(name = "nom",nullable = false)
    private String nom;
    @Column(name = "duree",nullable = false)
    private int duree;
    @Column(name = "niveau",nullable = false)
    private String niveau;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "cours_participants", joinColumns = @JoinColumn(name = "no_cours"), inverseJoinColumns = @JoinColumn(name = "no_participant"))
    private List<Participants> participantsList;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "cours_animateurs", joinColumns = @JoinColumn(name = "no_cours"), inverseJoinColumns = @JoinColumn(name = "no_animateur"))
    private List<Animateurs> animateursList;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "cours_themes", joinColumns = @JoinColumn(name = "no_cours"), inverseJoinColumns = @JoinColumn(name = "no_theme"))
    private List<Theme> themesList;

    public  void animer(List<Animateurs> animateurs, double remuneration ){
        this.animateursList.addAll(animateurs);
        System.out.println("Les animateurs ont été ajoutés au cours avec une rémunération de : " + remuneration);
    }
    public void comprendre(List<Theme> themes){
        this.themesList.addAll(themes);
        System.out.println("Les thèmes ont été ajoutés au cours.");
    }
    @Override
    public String toString() {
        return "\n no_cours=" + noCours +
                ", nom='" + nom + '\'' +
                ", duree=" + duree +
                ", niveau='" + niveau + '\'' +
                ", participants=" + participantsList +
                ", liste des animateurs=" + animateursList;
    }
}