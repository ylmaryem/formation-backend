package net.javaprojet.formation.repository;

import net.javaprojet.formation.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Integer> {
    Optional<Cours> findByNom(String nom);

    List<Cours> findByNoCoursIn(List<Integer> noCours);
}