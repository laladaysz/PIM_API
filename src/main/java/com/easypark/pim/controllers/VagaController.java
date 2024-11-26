package com.easypark.pim.controllers;

import com.easypark.pim.dtos.vagas.VagaDTO;
import com.easypark.pim.dtos.vagas.VagaUpdateDTO;
import com.easypark.pim.services.vagas.VagaGetAllService;
import com.easypark.pim.services.vagas.VagaGetByNumVagaService;
import com.easypark.pim.services.vagas.VagaGetVeiculoAtualService;
import com.easypark.pim.services.vagas.VagaUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@SecurityRequirement(name= "bearer-key")
public class VagaController {

    @Autowired
    private VagaGetAllService vagaGetAllService;

    @Autowired
    private VagaGetByNumVagaService vagaGetByNumVagaService;

    @Autowired
    private VagaUpdateService vagaUpdateService;

    @Autowired
    private VagaGetVeiculoAtualService vagaGetVeiculoAtualService;

    @GetMapping
    @Operation(summary = "Listar Vagas",
            description ="Listar Vagas",
            tags = {"Vagas"})
    public ResponseEntity<List<VagaDTO>> getAll(){
        return new ResponseEntity<>(vagaGetAllService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getVaga")
    @Operation(summary = "Buscar Vaga",
            description ="Buscar Vaga",
            tags = {"Vagas"})
    public ResponseEntity<VagaDTO> getByNumVaga(@RequestParam int numVaga){
        return new ResponseEntity<>(vagaGetByNumVagaService.getByNumVaga(numVaga), HttpStatus.OK);
    }

    @PutMapping
    @Operation(summary = "Atualizar Status da Vaga",
            description ="Atualizar Status da Vaga",
            tags = {"Vagas"})
    @Transactional
    public ResponseEntity<VagaDTO> update(@RequestBody @Valid VagaUpdateDTO data, @RequestParam int numVaga){
        return new ResponseEntity<>(vagaUpdateService.update(data, numVaga), HttpStatus.OK);
    }

    @GetMapping("/{numeroVaga}/veiculo-atual")
    public ResponseEntity<?> getVeiculoAtual(@PathVariable int numeroVaga){
        return new ResponseEntity<>(vagaGetVeiculoAtualService.getVeiculoAtual(numeroVaga), HttpStatus.OK);
    }

}
