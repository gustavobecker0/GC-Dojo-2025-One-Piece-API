package com.gustavo.dojo_one_piece.dto;

import java.util.UUID;

public record GetPiratesDTO (

    UUID id,
    String name,
    String race,
    String crew,
    String status

){}
