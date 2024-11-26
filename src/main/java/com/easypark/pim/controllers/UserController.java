package com.easypark.pim.controllers;
import com.easypark.pim.dtos.authentication.TokenJWTDTO;
import com.easypark.pim.dtos.user.UserRoleDTO;
import com.easypark.pim.dtos.user.UserAuthenticationDTO;
import com.easypark.pim.dtos.user.UserCreateDTO;
import com.easypark.pim.dtos.user.UserDTO;
import com.easypark.pim.services.authentication.TokenBlacklistService;
import com.easypark.pim.services.user.UserGetAllService;
import com.easypark.pim.services.user.UserLoginService;
import com.easypark.pim.services.user.UserRegisterService;
import com.easypark.pim.services.user.UserSetPrivilegeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name= "bearer-key")
public class UserController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserGetAllService userGetAllService;

    @Autowired
    private UserSetPrivilegeService userSetPrivilegeService;

    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    @PostMapping("/login")
    @Operation(summary = "Logar Usuário",
            description ="Logar Usuário",
            tags = {"Usuários"})
    public ResponseEntity<TokenJWTDTO> efetuarLogin(@RequestBody @Valid UserAuthenticationDTO dados){
        return new ResponseEntity<>(userLoginService.login(dados), HttpStatus.OK);
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar Usuário",
            description ="Registrar Usuário",
            tags = {"Usuários"})
    public ResponseEntity<?> register(@RequestBody @Valid UserCreateDTO dados, UriComponentsBuilder uriBuilder){
        UserDTO usuario = userRegisterService.register(dados);

        URI uri = uriBuilder.path("/auth/{id}").buildAndExpand(usuario.id()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping
    @Operation(summary = "Buscar Usuários",
            description ="Buscar Usuários",
            tags = {"Usuários"})
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(userGetAllService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/privilege/{id}")
    @Transactional
    @Operation(summary = "Setar como admin",
            description ="Setar como admin",
            tags = {"Usuários"})
    public ResponseEntity<UserDTO> putPrivilegeAdmin(@PathVariable Long id, @RequestBody UserRoleDTO data) {
        return new ResponseEntity<>(userSetPrivilegeService.setPrivilege(id, data), HttpStatus.OK);
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout Usuário",
            description ="Logout Usuário",
            tags = {"Usuários"})
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authorizationHeader) {
        // Extrair o token do cabeçalho
        System.out.println(authorizationHeader);
        String token = authorizationHeader.replace("Bearer ", "");
        tokenBlacklistService.blacklistToken(token);

        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

}
