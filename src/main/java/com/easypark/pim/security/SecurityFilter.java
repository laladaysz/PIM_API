package com.easypark.pim.security;
import com.easypark.pim.repositories.UserRepository;
import com.easypark.pim.services.authentication.TokenValidateService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
// A classe 'OncePerRequestFilter' tem como objetivo aplicar um filtro por requisição
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenValidateService tokenValidateService;

    @Autowired
    private UserRepository repository;

    // Existe uma cadeia de filtros, quando um filtro é executado, temos que chamar outro dentro dele,
    // se não o programa para de rodar
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        String tokenJWT = recuperarToken(request);

        if (tokenJWT != null){
            String subject = tokenValidateService.getSubject(tokenJWT);
            UserDetails usuario = repository.findByLogin(subject);

            // Forçando a autenticação do usuário
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    public String recuperarToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}