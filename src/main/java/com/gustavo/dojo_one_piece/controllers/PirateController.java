package com.gustavo.dojo_one_piece.controllers;

import com.gustavo.dojo_one_piece.dtos.CreatePirateDTO;
import com.gustavo.dojo_one_piece.dtos.GetPiratesDTO;
import com.gustavo.dojo_one_piece.dtos.UpdatePirateDTO;
import com.gustavo.dojo_one_piece.mappers.PirateMapper;
import com.gustavo.dojo_one_piece.models.Pirate;
import com.gustavo.dojo_one_piece.services.PirateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pirates")
public class PirateController {

    private final PirateService pirateService;
    private final PirateMapper pirateMapper;

    // injetar ambos via construtor
    public PirateController(PirateService pirateService, PirateMapper pirateMapper) {
        this.pirateService = pirateService;
        this.pirateMapper = pirateMapper;
    }

    @PostMapping
    public GetPiratesDTO createPirate(@Valid @RequestBody CreatePirateDTO pirateDto){
        Pirate pirate = pirateMapper.toEntity(pirateDto);
        Pirate saved = pirateService.savePirate(pirate);
        return pirateMapper.toDto(saved);
    }

    @GetMapping
    public List<GetPiratesDTO> getPirates() {
        return pirateService.getPirates().stream()
                .map(pirateMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GetPiratesDTO getPirateById(@PathVariable UUID id){
        Pirate pirate = pirateService.getPirateById(id);
        return pirateMapper.toDto(pirate);
    }

    @PutMapping("/{id}")
    public GetPiratesDTO updatePirate(@PathVariable UUID id, @Valid @RequestBody UpdatePirateDTO pirateDto) {
        Pirate updated = pirateService.updatePirateByIdUsingDto(id, pirateDto);
        return pirateMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    public void deletePirate(@PathVariable UUID id){
        pirateService.deletePirateById(id);
    }
}
