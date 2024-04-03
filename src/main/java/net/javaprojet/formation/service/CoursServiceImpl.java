
package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Cours;
import net.javaprojet.formation.exception.CoursAlreadyExistsException;
import net.javaprojet.formation.exception.CoursNotFoundException;
import net.javaprojet.formation.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Cours addCours(Cours cours) {
        if (coursAlreadyExists(cours.getNom())) {
            throw new CoursAlreadyExistsException("Le cours '" + cours.getNom() + "' existe déjà!");
        }
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours getCoursById(int noCours) {
        return coursRepository.findById(noCours)
                .orElseThrow(() -> new CoursNotFoundException("Désolé, aucun cours trouvé avec l'identifiant : " + noCours));
    }

    @Override
    public Cours updateCours(Cours cours, int noCours) {
        return coursRepository.findById(noCours).map(cr -> {
            cr.setNom(cours.getNom());
            cr.setDuree(cours.getDuree());
            cr.setNiveau(cours.getNiveau());
            cr.setParticipantsList(cours.getParticipantsList());
            cr.setAnimateursList(cours.getAnimateursList());
            cr.setThemesList(cours.getThemesList());
            return coursRepository.save(cr);
        }).orElseThrow(() -> new CoursNotFoundException("Désolé, ce cours n'a pas pu être trouvé!"));
    }

    @Override
    public void deleteCours(int noCours) {
        if (!coursRepository.existsById(noCours)) {
            throw new CoursNotFoundException("Désolé, cours non trouvé!");
        }
        coursRepository.deleteById(noCours);
    }

    private boolean coursAlreadyExists(String nom) {
        return coursRepository.findByNom(nom).isPresent();
    }
}