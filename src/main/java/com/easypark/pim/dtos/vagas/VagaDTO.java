package com.easypark.pim.dtos.vagas;

import com.easypark.pim.entities.Vaga;
import com.easypark.pim.entities.enums.StatusVaga;

public record VagaDTO(int numeroVaga, StatusVaga statusVaga) {
    public VagaDTO(Vaga vaga){
        this(vaga.getNumeroVaga(), vaga.getStatusVaga());
    }
}
