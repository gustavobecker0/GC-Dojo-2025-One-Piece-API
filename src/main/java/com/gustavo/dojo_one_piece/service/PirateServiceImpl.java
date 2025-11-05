package com.gustavo.dojo_one_piece.service;

import com.gustavo.dojo_one_piece.models.Pirate;
import com.gustavo.dojo_one_piece.repositories.PirateRepository;
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
    public Pirate save(Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> getPirates() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate getPirateById(UUID id) {
        return pirateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        pirateRepository.deleteById(id);
    }
}
