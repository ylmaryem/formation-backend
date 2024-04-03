package net.javaprojet.formation.mapper;

import net.javaprojet.formation.dto.AnimateursDto;
import net.javaprojet.formation.entity.Animateurs;

public class AnimateursMapper {

    public static AnimateursDto mapToAnimateursDto(Animateurs animateurs) {
        return new AnimateursDto(
                animateurs.getNoAnimateur(),
                animateurs.getNom(),
                animateurs.getPrenom(),
                animateurs.getCoursList()
        );
    }

    public static Animateurs mapToAnimateurs(AnimateursDto animateursDto) {
        return new Animateurs(
                animateursDto.getNoAnimateur(),
                animateursDto.getNom(),
                animateursDto.getPrenom(),
                animateursDto.getCoursList()
        );
    }
}