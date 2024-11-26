package com.easypark.pim.dtos.veiculos;

import com.easypark.pim.entities.Veiculo;

public record VeiculoDTO(String placa, String modelo, String cor) {
    public VeiculoDTO(Veiculo veiculo){
        this(veiculo.getPlaca(), veiculo.getModelo(), veiculo.getCor());
    }
}
