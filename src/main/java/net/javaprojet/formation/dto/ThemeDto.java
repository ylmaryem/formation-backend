
package net.javaprojet.formation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaprojet.formation.entity.Categories;
import net.javaprojet.formation.entity.Cours;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {
    private int noTheme;
    private String nom;
    private List<Cours> coursList;
    private List<Categories> categoriesList;
}
