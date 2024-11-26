package com.easypark.pim.entities;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaCreateDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "Entradas_saidas")
@Entity(name = "entradas_saidas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idRegistro")
public class EntradaSaida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_vaga", referencedColumnName = "id_vaga")
    private Vaga vaga;

    @Column(name = "hora_entrada")
    private LocalDateTime horaEntrada;

    @Column(name = "hora_saida")
    private LocalDateTime horaSaida;

    public EntradaSaida(EntradaSaidaCreateDTO data){
        this.horaEntrada = LocalDateTime.now();
        this.horaSaida = null;
    }
}
