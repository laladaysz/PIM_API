package com.easypark.pim.repositories;

import com.easypark.pim.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRespository extends JpaRepository<Vaga, Long> {
    Vaga findByNumeroVaga(int numVaga);
}
