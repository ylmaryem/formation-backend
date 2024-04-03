package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Animateurs;
import net.javaprojet.formation.exception.AnimateurAlreadyExistsException;
import net.javaprojet.formation.exception.AnimateurNotFoundException;
import net.javaprojet.formation.repository.AnimateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimateursServiceImpl implements AnimateursService {
    @Autowired
    private AnimateursRepository animateursRepository;

    @Override
    public Animateurs addAnimateur(Animateurs animateur) {
        if (animateurAlreadyExists(animateur.getNoAnimateur())) {
            throw new AnimateurAlreadyExistsException("Animateur already exists!");
        }
        return animateursRepository.save(animateur);
    }

    @Override
    public List<Animateurs> getAllAnimateurs() {
        return animateursRepository.findAll();
    }

    @Override
    public Animateurs getAnimateurById(int noAnimateur) {
        return animateursRepository.findById(noAnimateur)
                .orElseThrow(() -> new AnimateurNotFoundException("No animateur found with ID: " + noAnimateur));
    }

    @Override
    public Animateurs updateAnimateur(Animateurs animateur, int noAnimateur) {
        return animateursRepository.findById(noAnimateur).map(an -> {
            an.setNom(animateur.getNom());
            an.setPrenom(animateur.getPrenom());
            an.setCoursList(animateur.getCoursList());
            return animateursRepository.save(an);
        }).orElseThrow(() -> new AnimateurNotFoundException("Animateur not found with ID: " + noAnimateur));
    }

    @Override
    public void deleteAnimateur(int noAnimateur) {
        if (!animateursRepository.existsById(noAnimateur)) {
            throw new AnimateurNotFoundException("No animateur found with ID: " + noAnimateur);
        }
        animateursRepository.deleteById(noAnimateur);
    }

    private boolean animateurAlreadyExists(int noAnimateur) {
        return animateursRepository.findById(noAnimateur).isPresent();
    }
}