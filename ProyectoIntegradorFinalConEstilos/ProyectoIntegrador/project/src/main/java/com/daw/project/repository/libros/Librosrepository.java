package com.daw.project.repository.libros; // Define el paquete donde se encuentra esta interfaz

import java.util.List; // Importa la clase List de la biblioteca estándar de Java
import org.springframework.data.mongodb.repository.MongoRepository; // Importa la interfaz MongoRepository de Spring Data MongoDB
import com.daw.project.model.Libro; // Importa la clase Libro del paquete model

// Define un repositorio para la entidad Libro usando MongoDB
public interface Librosrepository extends MongoRepository<Libro, String> {

    // Método de consulta para encontrar libros por autor
    public interface LibrosRepository extends MongoRepository<Libro, String> {
        List<Libro> findByAuthor(String author); // Encuentra libros por autor
    }

    // Método de consulta para encontrar libros por autor, ignorando
    // mayúsculas/minúsculas
    List<Libro> findByAuthorIgnoreCase(String author);

    // Método de consulta para encontrar libros por título
    List<Libro> findByTitle(String title);
}
