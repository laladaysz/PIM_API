package com.easypark.pim.services.vagas;

import com.easypark.pim.dtos.veiculos.VeiculoDTO;
import com.easypark.pim.dtos.veiculos.VeiculoMotoristaDTO;

public interface VagaGetVeiculoAtualService {
    VeiculoMotoristaDTO getVeiculoAtual(int numeroVaga);
}
