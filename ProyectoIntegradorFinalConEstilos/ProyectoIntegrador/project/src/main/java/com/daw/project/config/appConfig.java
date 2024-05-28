package com.daw.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Indica que esta clase es una clase de configuración de Spring
public class appConfig {

    @Bean // Define un bean que estará disponible en el contexto de la aplicación de
          // Spring
    RestTemplate restTemplate() {
        return new RestTemplate(); // Crea una instancia de RestTemplate y la registra como un bean
    }
}
