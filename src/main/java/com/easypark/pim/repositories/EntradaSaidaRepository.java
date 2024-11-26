package com.easypark.pim.repositories;

import com.easypark.pim.entities.EntradaSaida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long> {
    EntradaSaida findFirstByVagaNumeroVagaAndHoraSaidaIsNullOrderByHoraEntradaDesc(int numeroVaga);
}
