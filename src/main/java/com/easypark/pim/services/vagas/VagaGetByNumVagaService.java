package com.easypark.pim.services.vagas;

import com.easypark.pim.dtos.vagas.VagaDTO;

public interface VagaGetByNumVagaService {
    VagaDTO getByNumVaga(int numberoVaga);
}
