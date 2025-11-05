package com.gustavo.dojo_one_piece.repositories;

import com.gustavo.dojo_one_piece.models.PirateMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PirateMissionRepository extends JpaRepository<PirateMission, UUID> {

}
