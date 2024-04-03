package net.javaprojet.formation.controller;

import lombok.RequiredArgsConstructor;
import net.javaprojet.formation.entity.Theme;
import net.javaprojet.formation.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
@RequiredArgsConstructor
public class ThemeController {
    @Autowired
    private final ThemeService themeService;

    @GetMapping
    public ResponseEntity<List<Theme>> getThemes() {
        return new ResponseEntity<>(themeService.getAllThemes(), HttpStatus.FOUND);
    }

    @PostMapping
    public Theme addTheme(@RequestBody Theme theme) {
        return themeService.addTheme(theme);
    }

    @PutMapping("/update/{id}")
    public Theme updateTheme(@RequestBody Theme theme, @PathVariable int noTheme) {
        return themeService.updateTheme(theme, noTheme);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTheme(@PathVariable int noTheme) {
        themeService.deleteTheme(noTheme);
    }

    @GetMapping("/theme/{id}")
    public Theme getThemeById(@PathVariable int noTheme) {
        return themeService.getThemeById(noTheme);
    }
}
