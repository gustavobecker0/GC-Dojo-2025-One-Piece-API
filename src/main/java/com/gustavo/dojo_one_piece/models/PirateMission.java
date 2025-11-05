package com.gustavo.dojo_one_piece.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PirateMission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PirateDangerLevel dangerLevel;

    @Enumerated(EnumType.STRING)
    private PirateMissionType missionType;

    @Enumerated(EnumType.STRING)
    private PirateMissionStatus status;

    public enum PirateDangerLevel{
        D,
        C,
        B,
        A,
        S
    }

    public enum PirateMissionType{
        EXPLORACAO,
        BATALHA_NAVAL,
        SAQUE
    }

    public enum PirateMissionStatus{
        CONCLUIDA,
        EM_ANDAMENTO
    }

}
