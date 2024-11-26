package com.easypark.pim.dtos.motorista;

import com.easypark.pim.entities.Motorista;

public record MotoristaDTO(String nome, String email, String telefone) {
    public MotoristaDTO(Motorista motorista){
        this(motorista.getNome(), motorista.getEmail(), motorista.getTelefone());
    }
}
