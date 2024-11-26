package com.easypark.pim.implementations.vagas;

import com.easypark.pim.dtos.veiculos.VeiculoDTO;
import com.easypark.pim.dtos.veiculos.VeiculoMotoristaDTO;
import com.easypark.pim.entities.EntradaSaida;
import com.easypark.pim.entities.Veiculo;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.EntradaSaidaRepository;
import com.easypark.pim.services.vagas.VagaGetVeiculoAtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaGetVeiculoAtualServiceImpl implements VagaGetVeiculoAtualService {
    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    @Override
    public VeiculoMotoristaDTO getVeiculoAtual(int numeroVaga) {
        EntradaSaida entradaSaida = entradaSaidaRepository.findFirstByVagaNumeroVagaAndHoraSaidaIsNullOrderByHoraEntradaDesc(numeroVaga);
        if(entradaSaida != null){
            Veiculo veiculo = entradaSaida.getVeiculo();
            return new VeiculoMotoristaDTO(veiculo);
        }
        throw new GenericsNotFoundException("Registro de Entrada/Saída não encontrado!");
    }
}
