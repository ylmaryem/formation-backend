
package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Categories;
import net.javaprojet.formation.exception.CategorieAlreadyExistsException;
import net.javaprojet.formation.exception.CategorieNotFoundException;
import net.javaprojet.formation.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Categories addCategories(Categories categorie) {
        if (categorieAlreadyExists(categorie.getDesignation())) {
            throw new CategorieAlreadyExistsException("Categories already exists!");
        }
        return categoriesRepository.save(categorie);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories getCategoriesById(int noCategorie) {
        return categoriesRepository.findById(noCategorie)
                .orElseThrow(() -> new CategorieNotFoundException("No categories found with ID: " + noCategorie));
    }

    @Override
    public Categories updateCategories(Categories categorie, int noCategorie) {
        return categoriesRepository.findById(noCategorie).map(cat -> {
            cat.setDesignation(categorie.getDesignation());
            cat.setThemesList(categorie.getThemesList());
            return categoriesRepository.save(cat);
        }).orElseThrow(() -> new CategorieNotFoundException("Categories not found with ID: " + noCategorie));
    }

    @Override
    public void deleteCategories(int noCategorie) {
        if (!categoriesRepository.existsById(noCategorie)) {
            throw new CategorieNotFoundException("No categories found with ID: " + noCategorie);
        }
        categoriesRepository.deleteById(noCategorie);
    }

    private boolean categorieAlreadyExists(String designation) {
        return categoriesRepository.findByDesignation(designation).isPresent();
    }
}