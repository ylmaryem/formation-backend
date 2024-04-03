package net.javaprojet.formation.controller;

import lombok.RequiredArgsConstructor;
import net.javaprojet.formation.entity.Cours;
import net.javaprojet.formation.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
@RequiredArgsConstructor
public class CoursController {

    @Autowired
    private final CoursService coursService;

    @GetMapping
    public ResponseEntity<List<Cours>> getCours() {
        return new ResponseEntity<>(coursService.getAllCours(), HttpStatus.FOUND);
    }

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/update/{id}")
    public Cours updateCours(@RequestBody Cours cours, @PathVariable int noCours) {
        return coursService.updateCours(cours, noCours);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCours(@PathVariable int noCours) {
        coursService.deleteCours(noCours);
    }

    @GetMapping("/cours/{id}")
    public Cours getCoursById(@PathVariable int noCours) {
        return coursService.getCoursById(noCours);
    }
}
