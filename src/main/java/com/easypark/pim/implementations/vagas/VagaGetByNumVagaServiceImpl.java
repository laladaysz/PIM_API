package com.easypark.pim.implementations.vagas;

import com.easypark.pim.dtos.vagas.VagaDTO;
import com.easypark.pim.entities.Vaga;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.VagaRespository;
import com.easypark.pim.services.vagas.VagaGetByNumVagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaGetByNumVagaServiceImpl implements VagaGetByNumVagaService {
    @Autowired
    private VagaRespository vagaRespository;

    @Override
    public VagaDTO getByNumVaga(int numVaga) {
        Vaga vaga = vagaRespository.findByNumeroVaga(numVaga);
        if(vaga != null){
            return new VagaDTO(vaga);
        }
        throw new GenericsNotFoundException("Vaga não encontrada!");
    }
}
