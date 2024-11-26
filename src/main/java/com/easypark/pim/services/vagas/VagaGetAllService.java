package com.easypark.pim.services.vagas;

import com.easypark.pim.dtos.vagas.VagaDTO;

import java.util.List;

public interface VagaGetAllService {
    List<VagaDTO> getAll();
}
