package com.easypark.pim.services.informations;

import com.easypark.pim.dtos.veiculos.VeiculoMotoristaDTO;

public interface InformationsGetByPlacaService {
    VeiculoMotoristaDTO getInformationsByPlaca(String placa);
}
