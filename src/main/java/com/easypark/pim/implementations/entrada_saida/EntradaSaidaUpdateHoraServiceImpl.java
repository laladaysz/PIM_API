package com.easypark.pim.implementations.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaUpdateDTO;
import com.easypark.pim.entities.EntradaSaida;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.EntradaSaidaRepository;
import com.easypark.pim.services.entrada_saida.EntradaSaidaUpdateHoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaSaidaUpdateHoraServiceImpl implements EntradaSaidaUpdateHoraService {
    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    @Override
    public EntradaSaidaDTO updateHoraSaida(EntradaSaidaUpdateDTO data, Long id) {
        EntradaSaida entradaSaida = entradaSaidaRepository.findById(id).orElseThrow(() -> new GenericsNotFoundException("Registro de entrada/saída não encontrado!"));
        entradaSaida.setHoraSaida(data.horaSaida());

        return new EntradaSaidaDTO(entradaSaida);
    }
}
