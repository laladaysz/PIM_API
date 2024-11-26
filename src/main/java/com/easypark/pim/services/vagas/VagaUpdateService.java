package com.easypark.pim.services.vagas;

import com.easypark.pim.dtos.vagas.VagaDTO;
import com.easypark.pim.dtos.vagas.VagaUpdateDTO;

public interface VagaUpdateService {
    VagaDTO update(VagaUpdateDTO data, int numVaga);
}
