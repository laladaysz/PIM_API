package com.easypark.pim.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "Veiculos")
@Entity(name = "Veiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idVeiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @ManyToOne
    @JoinColumn(name = "id_motorista", referencedColumnName = "id_motorista")
    private Motorista motorista;

    private String placa;
    private String modelo;
    private String cor;

    @OneToMany(mappedBy = "veiculo")
    private Set<EntradaSaida> entradasSaidas = new HashSet<>();
}

