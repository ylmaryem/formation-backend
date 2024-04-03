package net.javaprojet.formation.repository;

import net.javaprojet.formation.entity.Categories;
import net.javaprojet.formation.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    Optional<Categories> findByDesignation(String designation);
}