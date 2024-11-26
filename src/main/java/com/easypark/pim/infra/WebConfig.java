package com.easypark.pim.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS em todas as rotas
                .allowedOrigins("http://localhost:5174") // Origem permitida
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Todos os cabeçalhos permitidos
                .allowCredentials(true); // Permite o envio de credenciais (cookies, etc.)
    }
}
