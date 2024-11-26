package com.easypark.pim.implementations.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.easypark.pim.entities.User;
import com.easypark.pim.services.authentication.TokenGenerateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenGenerateServiceImpl implements TokenGenerateService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    public String gerarToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("easypark_api")
                    .withSubject(user.getUsername())// Identificando o usuario que está fazendo o login
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}