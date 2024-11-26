package com.easypark.pim.services.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;

import java.util.List;

public interface EntradaSaidaGetAllService {
    List<EntradaSaidaDTO> getAll();
}
