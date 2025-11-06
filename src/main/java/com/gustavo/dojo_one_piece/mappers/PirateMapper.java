package com.gustavo.dojo_one_piece.mappers;

import com.gustavo.dojo_one_piece.dtos.CreatePirateDTO;
import com.gustavo.dojo_one_piece.dtos.GetPiratesDTO;
import com.gustavo.dojo_one_piece.dtos.UpdatePirateDTO;
import com.gustavo.dojo_one_piece.models.Pirate;
import org.springframework.stereotype.Component;

@Component
public class PirateMapper {

    public Pirate toEntity(CreatePirateDTO pirateDto){
        Pirate pirate = new Pirate();
        pirate.setName(pirateDto.name());
        pirate.setCrew(pirateDto.crew());
        pirate.setRace(parseRace(pirateDto.race()));
        pirate.setStatus(parseStatus(pirateDto.status()));

        return pirate;
    }

    public void updateEntityFromDto(Pirate existing, UpdatePirateDTO dto) {
        if (dto.name() != null && !dto.name().isBlank()) {
            existing.setName(dto.name());
        }
        if (dto.crew() != null && !dto.crew().isBlank()) {
            existing.setCrew(dto.crew());
        }
        if (dto.race() != null && !dto.race().isBlank()) {
            existing.setRace(parseRace(dto.race()));
        }
        if (dto.status() != null && !dto.status().isBlank()) {
            existing.setStatus(parseStatus(dto.status()));
        }
    }

    public GetPiratesDTO toDto(Pirate p) {
        return new GetPiratesDTO(
                p.getId(),
                p.getName(),
                p.getRace() != null ? p.getRace().name() : null,
                p.getCrew(),
                p.getStatus() != null ? p.getStatus().name() : null
        );
    }

    private Pirate.PirateRace parseRace(String raceStr) {
        try {
            return Pirate.PirateRace.valueOf(raceStr.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Valor inválido para race: " + raceStr);
        }
    }

    private Pirate.PirateStatus parseStatus(String statusStr) {
        try {
            return Pirate.PirateStatus.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Valor inválido para status: " + statusStr);
        }
    }

}
