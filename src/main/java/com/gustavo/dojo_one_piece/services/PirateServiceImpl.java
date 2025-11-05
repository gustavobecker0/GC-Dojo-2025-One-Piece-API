package com.gustavo.dojo_one_piece.services;

import com.gustavo.dojo_one_piece.exceptions.ResourceNotFoundException;
import com.gustavo.dojo_one_piece.models.Pirate;
import com.gustavo.dojo_one_piece.repositories.PirateRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PirateServiceImpl implements PirateService {

    private final PirateRepository pirateRepository;

    public PirateServiceImpl(PirateRepository pirateRepository) {
        this.pirateRepository = pirateRepository;
    }

    @Override
    public Pirate savePirate(Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> getPirates() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate getPirateById(UUID id) {
        return pirateRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Pirate not found with id: " + id));
    }

    @Override
    @Transactional
    public Pirate updatePirateById(UUID id, Pirate oldPirate) {
        Pirate newPirate = pirateRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Pirate not found with id: " + id));

        if(oldPirate.getName() != null){
            oldPirate.setName(newPirate.getName());
        }

        if(newPirate.getCrew() != null){
            newPirate.setCrew(oldPirate.getCrew());
        }

        if(newPirate.getRace() != null){
            newPirate.setRace(oldPirate.getRace());
        }

        if(newPirate.getStatus()!= null){
            newPirate.setStatus(oldPirate.getStatus());
        }

        return pirateRepository.save(newPirate);

    }

    @Override
    public void deletePirateById(UUID id) {
        if(!pirateRepository.existsById(id)){
            throw new ResourceNotFoundException("Pirate not found with id: " + id);
        }

        pirateRepository.deleteById(id);
    }
}
