package com.proyectos.spring.todolistspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    private Long idTarea;
    private String nombre;
    private String descripcion;
    private EstadoTarea estadoTarea; // Ahora usa el Enum


    public Tarea(String nombre, String descripcion, EstadoTarea estadoTarea) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoTarea = estadoTarea;
    }
}
