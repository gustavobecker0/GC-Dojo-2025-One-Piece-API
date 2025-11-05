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
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PirateRace race;

    private String crew;

    @Enumerated(EnumType.STRING)
    private PirateStatus status;

    public enum PirateRace{
        HUMANO,
        CIBORGUE,
        MINK,
        ANAO,
        TRITAO
    }

    public enum PirateStatus{
        ATIVO,
        CAPTURADO
    }
}
