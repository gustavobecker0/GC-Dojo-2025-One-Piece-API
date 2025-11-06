package com.gustavo.dojo_one_piece.controllers;

import com.gustavo.dojo_one_piece.models.Pirate;
import com.gustavo.dojo_one_piece.services.PirateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/pirates")
public class PirateController {

    private final PirateService pirateService;

    public PirateController(PirateService pirateService) {
        this.pirateService = pirateService;
    }

    @PostMapping
    public Pirate createPirate(@RequestBody Pirate pirate){
        return pirateService.savePirate(pirate);
    }

    @GetMapping
    public List<Pirate> getPirates(){
        return pirateService.getPirates();
    }

    @GetMapping("/{id}")
    public Pirate getPirateById(@PathVariable UUID id){
        return pirateService.getPirateById(id);
    }

    @PutMapping("/{id}")
    public Pirate updatePirate(@PathVariable UUID id, @RequestBody Pirate pirate){
        return pirateService.updatePirateById(id, pirate);
    }

    @DeleteMapping("/{id}")
    public void deletePirate(@PathVariable UUID id){
        pirateService.deletePirateById(id);
    }

}
