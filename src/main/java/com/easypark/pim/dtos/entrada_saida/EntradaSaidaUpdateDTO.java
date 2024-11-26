package com.easypark.pim.dtos.entrada_saida;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EntradaSaidaUpdateDTO(@NotNull LocalDateTime horaSaida) {
}
