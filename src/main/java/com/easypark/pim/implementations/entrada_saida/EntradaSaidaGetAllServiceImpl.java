package com.easypark.pim.implementations.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;
import com.easypark.pim.repositories.EntradaSaidaRepository;
import com.easypark.pim.services.entrada_saida.EntradaSaidaGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaSaidaGetAllServiceImpl implements EntradaSaidaGetAllService {
    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    @Override
    public List<EntradaSaidaDTO> getAll() {
        return entradaSaidaRepository.findAll().stream().map(EntradaSaidaDTO::new).toList();
    }
}
