package com.daw.project.controller.libros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.project.model.Libro;
import com.daw.project.service.libro.libroService;

@Controller // Indica que esta clase es un controlador de Spring MVC
@RequestMapping("/libros") // Define la ruta base para todos los métodos en este controlador
public class librosController {

    @Autowired // Inyección de dependencias para el servicio de libros
    private libroService libroService;

    // Método para manejar solicitudes GET a la URL base ("/libros")
    @GetMapping
    public String showBooks(Model model) {
        List<Libro> books = libroService.listLibros(); // Obtiene la lista de libros desde el servicio
        model.addAttribute("books", books); // Añade la lista de libros al modelo
        return "Libros/home"; // Devuelve el nombre de la vista a renderizar
    }

    // Método para mostrar el formulario de agregar libros, manejando solicitudes
    // GET a "/libros/add"
    @GetMapping("/add")
    public String showAddBookForm() {
        return "Libros/add"; // Devuelve el nombre de la vista del formulario de agregar libros
    }

    // Método para manejar solicitudes POST a "/libros/add" para agregar un nuevo
    // libro
    @PostMapping("/add")
    public String addLibro(@RequestParam String title,
            @RequestParam String author,
            @RequestParam int year,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String genre) {
        // Crea un nuevo objeto Libro y establece sus atributos
        Libro libro = new Libro();
        libro.setTitle(title);
        libro.setAuthor(author);
        libro.setAno(year);
        libro.setPublicadora(publisher);
        libro.setGenero(genre);

        // Llama al servicio para agregar el libro a la base de datos
        libroService.addLibro(libro);

        // Redirige a la lista de libros después de agregar el nuevo libro
        return "redirect:/libros";
    }

    // Método para manejar solicitudes GET a "/libros/buscar" para buscar libros por
    // autor
    @GetMapping("/buscar")
    public String buscarLibrosPorAutor(@RequestParam(required = false) String autor, Model model) {
        List<Libro> books;
        if (autor != null && !autor.isEmpty()) {
            books = libroService.buscarPorAutor(autor); // Busca libros por autor si el parámetro está presente y no
                                                        // está vacío
        } else {
            books = libroService.listLibros(); // Si no hay autor, obtiene la lista completa de libros
        }
        model.addAttribute("books", books); // Añade la lista de libros al modelo
        return "Libros/home"; // Devuelve el nombre de la vista a renderizar
    }

    // Método para manejar solicitudes POST a "/libros/delete" para eliminar un
    // libro por título
    @PostMapping("/delete")
    public String deleteLibro(@RequestParam String title) {
        libroService.deleteLibroByTitle(title); // Llama al servicio para eliminar el libro por título
        return "redirect:/libros"; // Redirige a la lista de libros después de eliminar el libro
    }
}
