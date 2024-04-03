
package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Theme;
import net.javaprojet.formation.exception.ThemeAlreadyExistsException;
import net.javaprojet.formation.exception.ThemeNotFoundException;
import net.javaprojet.formation.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public Theme addTheme(Theme theme) {
        if (themeAlreadyExists(theme.getNoTheme())) {
            throw new ThemeAlreadyExistsException("Theme already exists!");
        }
        return themeRepository.save(theme);
    }

    @Override
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    @Override
    public Theme getThemeById(int noTheme) {
        return themeRepository.findById(noTheme)
                .orElseThrow(() -> new ThemeNotFoundException("No theme found with ID: " + noTheme));
    }

    @Override
    public Theme updateTheme(Theme theme, int noTheme) {
        return themeRepository.findById(noTheme).map(th -> {
            th.setNom(theme.getNom());
            th.setCoursList(theme.getCoursList());
            th.setCategoriesList(theme.getCategoriesList());
            return themeRepository.save(th);
        }).orElseThrow(() -> new ThemeNotFoundException("Theme not found with ID: " + noTheme));
    }

    @Override
    public void deleteTheme(int noTheme) {
        if (!themeRepository.existsById(noTheme)) {
            throw new ThemeNotFoundException("No theme found with ID: " + noTheme);
        }
        themeRepository.deleteById(noTheme);
    }

    private boolean themeAlreadyExists(int noTheme) {
        return themeRepository.findById(noTheme).isPresent();
    }
}