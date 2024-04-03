package net.javaprojet.formation.repository;

import net.javaprojet.formation.entity.Animateurs;
import net.javaprojet.formation.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimateursRepository extends JpaRepository<Animateurs, Integer> {
    Optional<Animateurs> findById(int noAnimateur);
}