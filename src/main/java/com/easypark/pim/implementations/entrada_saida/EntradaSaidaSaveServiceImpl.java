package com.easypark.pim.implementations.entrada_saida;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaCreateDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;
import com.easypark.pim.entities.EntradaSaida;
import com.easypark.pim.entities.Vaga;
import com.easypark.pim.entities.Veiculo;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.EntradaSaidaRepository;
import com.easypark.pim.repositories.VagaRespository;
import com.easypark.pim.repositories.VeiculoRepository;
import com.easypark.pim.services.entrada_saida.EntradaSaidaSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaSaidaSaveServiceImpl implements EntradaSaidaSaveService {
    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaRespository vagaRespository;

    @Override
    public EntradaSaidaDTO save(EntradaSaidaCreateDTO data) {
        EntradaSaida entradaSaida = new EntradaSaida(data);

        Veiculo veiculo = veiculoRepository.findByPlaca(data.placa());

        if(veiculo != null){
            Vaga vaga = vagaRespository.findByNumeroVaga(data.numeroVaga());
            if(vaga != null){
                entradaSaida.setVeiculo(veiculo);
                entradaSaida.setVaga(vaga);

                entradaSaidaRepository.save(entradaSaida);

                return new EntradaSaidaDTO(entradaSaida);
            } else {
                throw new GenericsNotFoundException("Vaga não encontrada!");
            }

        }

        throw new GenericsNotFoundException("Veículo não encontrado!");
    }
}
