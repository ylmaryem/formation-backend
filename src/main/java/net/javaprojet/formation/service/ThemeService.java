package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Theme;

import java.util.List;

public interface ThemeService {
    Theme addTheme(Theme theme);

    List<Theme> getAllThemes();

    Theme getThemeById(int no_theme);

    Theme updateTheme(Theme theme, int no_theme);

    void deleteTheme(int no_theme);
}
