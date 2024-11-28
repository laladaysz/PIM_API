package com.easypark.pim.implementations.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaUpdateDTO;
import com.easypark.pim.entities.EntradaSaida;
import com.easypark.pim.entities.Vaga;
import com.easypark.pim.entities.enums.StatusVaga;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.EntradaSaidaRepository;
import com.easypark.pim.repositories.VagaRespository;
import com.easypark.pim.services.entrada_saida.EntradaSaidaUpdateHoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaSaidaUpdateHoraServiceImpl implements EntradaSaidaUpdateHoraService {
    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    @Autowired
    private VagaRespository vagaRespository;

    @Override
    public EntradaSaidaDTO updateHoraSaida(EntradaSaidaUpdateDTO data, int numeroVaga) {
        // Buscar o registro mais recente para a vaga com hora de saída nula
        EntradaSaida entradaSaida = entradaSaidaRepository
                .findFirstByVagaNumeroVagaAndHoraSaidaIsNullOrderByHoraEntradaDesc(numeroVaga);

        entradaSaida.setHoraSaida(data.horaSaida());

        Vaga vaga = vagaRespository.findByNumeroVaga(numeroVaga);

        if(vaga != null){
            vaga.setStatusVaga(StatusVaga.STATUS_LIVRE);
            vagaRespository.save(vaga);
        } else {
            throw new GenericsNotFoundException("Vaga não existente!");
        }


        entradaSaidaRepository.save(entradaSaida);

        return new EntradaSaidaDTO(entradaSaida);
    }
}
