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
    public Pirate updatePirateById(UUID id, Pirate updatedPirate) {
        Pirate existingPirate = pirateRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Pirate not found with id: " + id));

        if(updatedPirate.getName() != null){
            existingPirate.setName(updatedPirate.getName());
        }

        if(updatedPirate.getCrew() != null){
            existingPirate.setCrew(updatedPirate.getCrew());
        }

        if(updatedPirate.getRace() != null){
            existingPirate.setRace(updatedPirate.getRace());
        }

        if(updatedPirate.getStatus()!= null){
            existingPirate.setStatus(updatedPirate.getStatus());
        }

        return pirateRepository.save(existingPirate);

    }

    @Override
    public void deletePirateById(UUID id) {
        if(!pirateRepository.existsById(id)){
            throw new ResourceNotFoundException("Pirate not found with id: " + id);
        }

        pirateRepository.deleteById(id);
    }
}
