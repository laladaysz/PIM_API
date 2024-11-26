package com.easypark.pim.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "Motoristas")
@Entity(name = "Motorista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idMotorista")
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_motorista")
    private Long idMotorista;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Veiculo> veiculoSet = new HashSet<>();
}

