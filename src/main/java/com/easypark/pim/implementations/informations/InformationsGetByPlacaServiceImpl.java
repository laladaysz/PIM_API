package com.easypark.pim.implementations.informations;

import com.easypark.pim.dtos.veiculos.VeiculoMotoristaDTO;
import com.easypark.pim.entities.Veiculo;
import com.easypark.pim.exceptions.GenericsNotFoundException;
import com.easypark.pim.repositories.MotoristaRepository;
import com.easypark.pim.repositories.VeiculoRepository;
import com.easypark.pim.services.informations.InformationsGetByPlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationsGetByPlacaServiceImpl implements InformationsGetByPlacaService {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public VeiculoMotoristaDTO getInformationsByPlaca(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        if(veiculo != null){
            return new VeiculoMotoristaDTO(veiculo);
        }
        throw new GenericsNotFoundException("Veículo não encontrado");
    }
}
