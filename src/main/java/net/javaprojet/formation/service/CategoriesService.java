package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Categories;

import java.util.List;

public interface CategoriesService {
    Categories addCategories(Categories categories);

    List<Categories> getAllCategories();

    Categories getCategoriesById(int no_categorie);

    Categories updateCategories(Categories categories, int no_categorie);

    void deleteCategories(int no_categorie);
}
