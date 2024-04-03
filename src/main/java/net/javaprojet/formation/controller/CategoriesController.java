package net.javaprojet.formation.controller;

import lombok.RequiredArgsConstructor;
import net.javaprojet.formation.entity.Categories;
import net.javaprojet.formation.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {
    @Autowired
    private final CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<Categories>> getCategories() {
        return new ResponseEntity<>(categoriesService.getAllCategories(), HttpStatus.FOUND);
    }

    @PostMapping
    public Categories addCategories(@RequestBody Categories categories) {
        return categoriesService.addCategories(categories);
    }

    @PutMapping("/update/{id}")
    public Categories updateCategories(@RequestBody Categories categories, @PathVariable int noCategorie) {
        return categoriesService.updateCategories(categories, noCategorie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategories(@PathVariable int noCategorie) {
        categoriesService.deleteCategories(noCategorie);
    }

    @GetMapping("/categories/{id}")
    public Categories getCategoriesById(@PathVariable int noCategorie) {
        return categoriesService.getCategoriesById(noCategorie);
    }
}
