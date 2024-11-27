package com.easypark.pim.services.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaUpdateDTO;

public interface EntradaSaidaUpdateHoraService {
    EntradaSaidaDTO updateHoraSaida(EntradaSaidaUpdateDTO data, int numeroVaga);
}
