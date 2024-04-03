package net.javaprojet.formation.repository;

import net.javaprojet.formation.entity.Participants;
import net.javaprojet.formation.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    Optional<Theme> findById(int noTheme);
}
