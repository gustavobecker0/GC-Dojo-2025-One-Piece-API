package com.gustavo.dojo_one_piece.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePirateDTO (

    @NotBlank String name,
    @NotNull String race,
    @NotBlank String crew,
    @NotNull String status

) {}
