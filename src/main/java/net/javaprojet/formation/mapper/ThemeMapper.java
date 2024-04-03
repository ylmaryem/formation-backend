
package net.javaprojet.formation.mapper;

import net.javaprojet.formation.dto.ThemeDto;
import net.javaprojet.formation.entity.Theme;

public class ThemeMapper {

    public static ThemeDto mapToThemeDto(Theme theme) {
        return new ThemeDto(
                theme.getNoTheme(),
                theme.getNom(),
                theme.getCoursList(),
                theme.getCategoriesList()
        );
    }

    public static Theme mapToTheme(ThemeDto themeDto) {
        return new Theme(
                themeDto.getNoTheme(),
                themeDto.getNom(),
                themeDto.getCoursList(),
                themeDto.getCategoriesList()
        );
    }
}
