
package net.javaprojet.formation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaprojet.formation.entity.Cours;
import net.javaprojet.formation.entity.Theme;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDto {
    private int noCategorie;
    private String designation;
    private List<Theme> ThemesList;
}
