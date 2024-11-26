package com.easypark.pim.repositories;

import com.easypark.pim.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Veiculo findByPlaca(String placa);
}
