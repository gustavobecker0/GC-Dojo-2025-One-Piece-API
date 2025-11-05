package com.gustavo.dojo_one_piece.repositories;

import com.gustavo.dojo_one_piece.models.Pirate;
import com.gustavo.dojo_one_piece.models.Pirate.PirateRace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PirateRepository extends JpaRepository<Pirate, UUID> {
    List<Pirate> findByRace(PirateRace race);
}
