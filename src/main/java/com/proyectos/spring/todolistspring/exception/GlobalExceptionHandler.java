package com.proyectos.spring.todolistspring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TareaNotFoundException.class)
    public String tareaNoEncontrada(TareaNotFoundException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error"; // Vista personalizada para errores
    }

}
