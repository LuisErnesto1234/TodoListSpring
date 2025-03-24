package com.proyectos.spring.todolistspring.exception;

public class TareaNotFoundException extends RuntimeException{

    public TareaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
