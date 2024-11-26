package com.easypark.pim.dtos.vagas;

import com.easypark.pim.entities.enums.StatusVaga;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record VagaUpdateDTO(@NotNull @Valid StatusVaga statusVaga) {
}
