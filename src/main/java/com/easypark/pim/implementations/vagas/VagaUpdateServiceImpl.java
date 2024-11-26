package com.easypark.pim.implementations.vagas;

import com.easypark.pim.dtos.vagas.VagaDTO;
import com.easypark.pim.dtos.vagas.VagaUpdateDTO;
import com.easypark.pim.entities.Vaga;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.VagaRespository;
import com.easypark.pim.services.vagas.VagaUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class VagaUpdateServiceImpl implements VagaUpdateService {
    @Autowired
    private VagaRespository vagaRespository;

    @Override
    public VagaDTO update(VagaUpdateDTO data, int numVaga) {
        Vaga vaga = vagaRespository.findByNumeroVaga(numVaga);
        if(vaga != null){
            vaga.setStatusVaga(data.statusVaga());
            return new VagaDTO(vaga);
        }
        throw new GenericsNotFoundException("Vaga não encontrada!");
    }
}
