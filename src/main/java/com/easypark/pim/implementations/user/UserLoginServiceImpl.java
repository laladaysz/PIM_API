package com.easypark.pim.implementations.user;

import com.easypark.pim.dtos.authentication.TokenJWTDTO;
import com.easypark.pim.dtos.user.UserAuthenticationDTO;
import com.easypark.pim.entities.User;
import com.easypark.pim.implementations.authentication.TokenGenerateServiceImpl;
import com.easypark.pim.repositories.UserRepository;
import com.easypark.pim.services.user.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenGenerateServiceImpl tokenGenerateServiceImpl;

    @Override
    public TokenJWTDTO login(UserAuthenticationDTO data) {
        UserDetails usuario = repository.findByLogin(data.login());

        if (usuario == null) {
            throw new BadCredentialsException("Usuário inexistente ou senha inválida. Tente novamente!");
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.login()
                , data.senha());

        Authentication autenticacao = manager.authenticate(token);

        var tokenJWT = tokenGenerateServiceImpl.gerarToken((User) autenticacao.getPrincipal());

        Instant expiresAt = tokenGenerateServiceImpl.dataExpiracao();

        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(expiresAt, zoneId);

// Formatando a data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedExpiresAt = localDateTime.format(formatter);

        return new TokenJWTDTO(tokenJWT, formattedExpiresAt);
    }
}
