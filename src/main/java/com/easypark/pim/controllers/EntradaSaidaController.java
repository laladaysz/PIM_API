package com.easypark.pim.controllers;

import com.easypark.pim.dtos.entrada_saida.EntradaSaidaCreateDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaDTO;
import com.easypark.pim.dtos.entrada_saida.EntradaSaidaUpdateDTO;
import com.easypark.pim.services.entrada_saida.EntradaSaidaGetAllService;
import com.easypark.pim.services.entrada_saida.EntradaSaidaSaveService;
import com.easypark.pim.services.entrada_saida.EntradaSaidaUpdateHoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/entradaSaida")
public class EntradaSaidaController {
    @Autowired
    private EntradaSaidaSaveService entradaSaidaSaveService;

    @Autowired
    private EntradaSaidaGetAllService entradaSaidaGetAllService;

    @Autowired
    private EntradaSaidaUpdateHoraService entradaSaidaUpdateHoraService;

    @PostMapping
    @Operation(summary = "Registrar Entrada/Saída",
            description ="Registrar Entrada/Saída",
            tags = {"Registros Entrada/Saída"})
    public ResponseEntity<?> save(@RequestBody @Valid EntradaSaidaCreateDTO data){
        return new ResponseEntity<>(entradaSaidaSaveService.save(data), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Listar Entradas/Saídas",
            description ="Registrar Entrada/Saída",
            tags = {"Registros Entrada/Saída"})
    public ResponseEntity<List<EntradaSaidaDTO>> getAll(){
        return new ResponseEntity<>(entradaSaidaGetAllService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{numero_vaga}")
    @Operation(summary = "Registrar Hora de Saída",
            description ="Registrar Hora de Saída",
            tags = {"Registros Entrada/Saída"})
    @Transactional
    public ResponseEntity<EntradaSaidaDTO> updateHora(@PathVariable int numero_vaga, @RequestBody EntradaSaidaUpdateDTO data){
        System.out.println("data: " + data);
        System.out.println("numero vaga: " + numero_vaga);
        return new ResponseEntity<>(entradaSaidaUpdateHoraService.updateHoraSaida(data, numero_vaga), HttpStatus.OK);
    }
}
