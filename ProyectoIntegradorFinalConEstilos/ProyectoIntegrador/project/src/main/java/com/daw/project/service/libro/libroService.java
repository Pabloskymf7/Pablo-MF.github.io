package com.daw.project.service.libro;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.daw.project.model.Libro;

import com.daw.project.repository.libros.Librosrepository;



@Service
public class libroService {
    
    @Autowired
    private Librosrepository librosRepository;

    public List<Libro> listLibros() {
        return librosRepository.findAll();
    }

    public void setLibroModel(Model model, List<Libro> libros) {
        model.addAttribute("libros", libros);
    }
    public void addLibro(Libro libro) {
        librosRepository.save(libro);
    }
    public List<Libro> buscarPorAutor(String autor) {
        return librosRepository.findByAuthorIgnoreCase(autor);
    }
    
 
    public boolean deleteLibroByTitle(String title) {
        List<Libro> libros = librosRepository.findByTitle(title);
        if (!libros.isEmpty()) {
            librosRepository.deleteAll(libros);
            return true;
        } else {
            return false;
        }
    }
    
}
