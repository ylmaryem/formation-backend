
package net.javaprojet.formation.dto;

import net.javaprojet.formation.entity.Animateurs;
import net.javaprojet.formation.entity.Cours;
import net.javaprojet.formation.entity.Participants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaprojet.formation.entity.Theme;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CoursDto {
    private int noCours;
    private String nom;
    private int duree;
    private String niveau;
    private List<Participants> participantsList;
    private List<Animateurs> animateursList;
    private List<Theme> themesList;
}

