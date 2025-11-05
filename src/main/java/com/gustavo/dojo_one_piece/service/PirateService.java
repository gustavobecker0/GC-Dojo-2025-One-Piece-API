package com.gustavo.dojo_one_piece.service;

import com.gustavo.dojo_one_piece.models.Pirate;

import java.util.List;
import java.util.UUID;

public interface PirateService {

    Pirate save(Pirate pirate);
    List<Pirate> getPirates();
    Pirate getPirateById(UUID id);
    void deleteById(UUID id);

}
