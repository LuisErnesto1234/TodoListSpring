package com.proyectos.spring.todolistspring.service;

import com.proyectos.spring.todolistspring.exception.TareaNotFoundException;
import com.proyectos.spring.todolistspring.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareaService {

    private final List<Tarea> tareaList = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    //TODO: metodo para obtener todas las tareas
    public List<Tarea> findAllTarea(){
        return Collections.unmodifiableList(tareaList);
    }

    public void addTarea(Tarea tarea) {
        tarea.setIdTarea(contador.getAndIncrement());
        tareaList.add(tarea);
    }

    public void deleteTarea(Long id){
        tareaList.removeIf(t -> t.getIdTarea().equals(id));
    }

    public void updateTarea(Long id, Tarea tarea){
        Tarea tareaExistente = tareaList.stream()
                .filter(t -> t.getIdTarea().equals(id))
                .findFirst()
                .orElseThrow(() -> new TareaNotFoundException("Tarea con ID" + id + " no encontrada"));

        tareaExistente.setNombre(tarea.getNombre());
        tareaExistente.setDescripcion(tarea.getDescripcion());
        tareaExistente.setEstadoTarea(tarea.getEstadoTarea());
    }

    public Tarea findById(Long id){
        return tareaList.stream()
                .filter(t -> t.getIdTarea().equals(id))
                .findFirst()
                .orElse(null);
    }
}
