package com.easypark.pim.controllers;

import com.easypark.pim.dtos.veiculos.VeiculoMotoristaDTO;
import com.easypark.pim.services.informations.InformationsGetByPlacaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
@SecurityRequirement(name= "bearer-key")
public class VeiculoController {
    @Autowired
    private InformationsGetByPlacaService informationsGetByPlacaService;

    @GetMapping
    @Operation(summary = "Listar Informações por Placa",
            description ="Listar Informações por Placa",
            tags = {"Veículos"})
    public ResponseEntity<VeiculoMotoristaDTO> getInformationsByPlaca(@RequestParam String placa){
        return new ResponseEntity<>(informationsGetByPlacaService.getInformationsByPlaca(placa), HttpStatus.OK);

    }

}
