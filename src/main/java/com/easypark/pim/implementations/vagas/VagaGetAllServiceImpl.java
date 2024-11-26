package com.easypark.pim.implementations.vagas;

import com.easypark.pim.dtos.vagas.VagaDTO;
import com.easypark.pim.repositories.VagaRespository;
import com.easypark.pim.services.vagas.VagaGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaGetAllServiceImpl implements VagaGetAllService {
    @Autowired
    private VagaRespository vagaRespository;

    @Override
    public List<VagaDTO> getAll() {
        return vagaRespository.findAll().stream().map(VagaDTO::new).toList();
    }
}
