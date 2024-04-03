package net.javaprojet.formation.mapper;

import net.javaprojet.formation.dto.CoursDto;
import net.javaprojet.formation.entity.Cours;

public class CoursMapper {

    public static CoursDto mapToCoursDto(Cours cours) {
        return new CoursDto(
                cours.getNoCours(),
                cours.getNom(),
                cours.getDuree(),
                cours.getNiveau(),
                cours.getParticipantsList(),
                cours.getAnimateursList(),
                cours.getThemesList()
        );
    }

    public static Cours mapToCours(CoursDto coursDto) {
        return new Cours(
                coursDto.getNoCours(),
                coursDto.getNom(),
                coursDto.getDuree(),
                coursDto.getNiveau(),
                coursDto.getParticipantsList(),
                coursDto.getAnimateursList(),
                coursDto.getThemesList()
        );
    }
}