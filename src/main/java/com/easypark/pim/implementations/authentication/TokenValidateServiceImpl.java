package com.easypark.pim.implementations.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.easypark.pim.services.authentication.TokenValidateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TokenValidateServiceImpl implements TokenValidateService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    // Validando token
    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("easypark_api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido ou expirado!");
        }
    }
}
