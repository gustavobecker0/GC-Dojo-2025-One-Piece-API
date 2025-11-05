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
    private pirateRace race;

    private String tripulation;

    @Enumerated(EnumType.STRING)
    private pirateStatus status;

    enum pirateRace{
        HUMANO,
        CIBORGUE,
        MINK,
        ANAO,
        TRITAO
    }

    enum pirateStatus{
        ATIVO,
        CAPTURADO
    }

}
