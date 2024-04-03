package net.javaprojet.formation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaprojet.formation.entity.Cours;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimateursDto {
    private int noAnimateur;
    private String nom;
    private String prenom;
    private List<Cours> coursList;
}
