package com.easypark.pim.dtos.entrada_saida;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EntradaSaidaCreateDTO(@NotBlank String placa,
                                    @Positive int numeroVaga
                                    ) {
}
