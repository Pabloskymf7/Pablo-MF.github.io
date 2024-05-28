package com.daw.project.controller.libros;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Indica que esta clase es un controlador de Spring MVC
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error") // Mapea las solicitudes a la URL "/error" a este método
    public ModelAndView handleError() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error"); // Establece el nombre de la vista de error que se mostrará
        modelAndView.addObject("errorMessage", "An unexpected error occurred."); // Añade un mensaje de error al modelo
        return modelAndView; // Devuelve el objeto ModelAndView que contiene la vista y los datos del modelo
    }
}
