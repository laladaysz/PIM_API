package com.easypark.pim.entities;

import com.easypark.pim.entities.enums.StatusVaga;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Vagas")
@Entity(name = "Vagas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idVaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Long idVaga;

    @Column(name = "numero_vaga")
    private int numeroVaga;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusVaga statusVaga;

    @OneToMany(mappedBy = "vaga")
    private Set<EntradaSaida> entradasSaidas = new HashSet<>();
}

