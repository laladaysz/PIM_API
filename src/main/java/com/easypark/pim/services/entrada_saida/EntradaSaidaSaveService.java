package com.easypark.pim.services.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaCreateDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;

public interface EntradaSaidaSaveService {
    EntradaSaidaDTO save(EntradaSaidaCreateDTO data);
}
