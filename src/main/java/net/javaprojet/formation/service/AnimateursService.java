package net.javaprojet.formation.service;

import net.javaprojet.formation.entity.Animateurs;

import java.util.List;

public interface AnimateursService {
    Animateurs addAnimateur(Animateurs animateur);

    List<Animateurs> getAllAnimateurs();

    Animateurs getAnimateurById(int no_animateur);

    Animateurs updateAnimateur(Animateurs animateur, int no_animateur);

    void deleteAnimateur(int no_animateur);
}
