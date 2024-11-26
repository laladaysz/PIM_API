package com.easypark.pim.dtos.veiculos;

import com.easypark.pim.dtos.motorista.MotoristaDTO;
import com.easypark.pim.entities.Veiculo;

public record VeiculoMotoristaDTO(MotoristaDTO motorista, String placa, String modelo, String cor) {
    public VeiculoMotoristaDTO(Veiculo veiculo){
        this(new MotoristaDTO(veiculo.getMotorista()), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getCor());
    }
}
