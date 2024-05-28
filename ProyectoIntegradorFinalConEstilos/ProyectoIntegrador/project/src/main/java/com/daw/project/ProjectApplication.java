package com.daw.project; // Define el paquete principal del proyecto

import org.springframework.boot.SpringApplication; // Importa la clase SpringApplication de Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación SpringBootApplication de Spring Boot

@SpringBootApplication // Anotación que indica que esta es una clase principal de configuración de
						// Spring Boot
public class ProjectApplication {

	// Método principal que inicia la aplicación
	public static void main(String[] args) {
		// Llama al método run de SpringApplication para lanzar la aplicación
		SpringApplication.run(ProjectApplication.class, args);
	}

}
