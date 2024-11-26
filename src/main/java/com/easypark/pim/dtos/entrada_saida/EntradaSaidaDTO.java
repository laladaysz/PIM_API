package com.easypark.pim.dtos.entrada_saida;

import com.easypark.pim.dtos.vagas.VagaDTO;
import com.easypark.pim.dtos.veiculos.VeiculoDTO;
import com.easypark.pim.entities.EntradaSaida;

import java.time.LocalDateTime;

public record EntradaSaidaDTO(VeiculoDTO veiculoDTO, VagaDTO vagaDTO, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
    public EntradaSaidaDTO(EntradaSaida entradaSaida){
        this(new VeiculoDTO(entradaSaida.getVeiculo()), new VagaDTO(entradaSaida.getVaga()), entradaSaida.getHoraEntrada(), entradaSaida.getHoraSaida());
    }
}
