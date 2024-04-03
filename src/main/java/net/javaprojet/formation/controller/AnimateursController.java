package net.javaprojet.formation.controller;

import lombok.RequiredArgsConstructor;
import net.javaprojet.formation.entity.Animateurs;
import net.javaprojet.formation.service.AnimateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animateurs")
@RequiredArgsConstructor
public class AnimateursController {
    @Autowired
    private final AnimateursService animateursService;

    @GetMapping
    public ResponseEntity<List<Animateurs>> getAnimateurs() {
        return new ResponseEntity<>(animateursService.getAllAnimateurs(), HttpStatus.FOUND);
    }

    @PostMapping
    public Animateurs addAnimateur(@RequestBody Animateurs animateur) {
        return animateursService.addAnimateur(animateur);
    }

    @PutMapping("/update/{id}")
    public Animateurs updateAnimateur(@RequestBody Animateurs animateur, @PathVariable int noAnimateur) {
        return animateursService.updateAnimateur(animateur, noAnimateur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnimateur(@PathVariable int noAnimateur) {
        animateursService.deleteAnimateur(noAnimateur);
    }

    @GetMapping("/animateur/{id}")
    public Animateurs getAnimateurById(@PathVariable int noAnimateur) {
        return animateursService.getAnimateurById(noAnimateur);
    }
}
