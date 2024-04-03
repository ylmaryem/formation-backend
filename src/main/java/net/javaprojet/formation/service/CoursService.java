package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Cours;

import java.util.List;

public interface CoursService {

    Cours addCours(Cours cours);

    List<Cours> getAllCours();

    Cours getCoursById(int noCours);

    Cours updateCours(Cours cours, int noCours);

    void deleteCours(int noCours);
}
