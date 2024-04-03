
package net.javaprojet.formation.mapper;

import net.javaprojet.formation.dto.ParticipantsDto;
import net.javaprojet.formation.entity.Participants;

public class ParticipantsMapper {

    public static ParticipantsDto mapToPartcipantsDto(Participants participants){
        return new ParticipantsDto(
                participants.getNoParticipant(),
                participants.getNom(),
                participants.getPrenom(),
                participants.getEmail(),
                participants.getDateInscription(),
                participants.getCoursList()
        );
    }
    public static Participants mapToParticipants(ParticipantsDto participantsDto){
        return  new Participants(
                participantsDto.getNoParticipant(),
                participantsDto.getNom(),
                participantsDto.getPrenom(),
                participantsDto.getEmail(),
                participantsDto.getDateInscription(),
                participantsDto.getCoursList()
        );
    }
}