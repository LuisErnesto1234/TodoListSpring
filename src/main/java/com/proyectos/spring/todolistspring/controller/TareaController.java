package com.proyectos.spring.todolistspring.controller;

import com.proyectos.spring.todolistspring.model.EstadoTarea;
import com.proyectos.spring.todolistspring.model.Tarea;
import com.proyectos.spring.todolistspring.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping()
    public String getTareas(Model model) {
        model.addAttribute("tareas", service.findAllTarea());
        return "tarea";
    }

    @PostMapping("/add")
    public String agregarTarea(@ModelAttribute Tarea tarea) { // Recibe el Enum
        service.addTarea(tarea);
        return "redirect:/app/tareas";
    }


    @GetMapping("/edit/{id}")
    public String editarTarea(@PathVariable Long id, Model model){
        Tarea tareaEncontrada = service.findById(id);

        if (tareaEncontrada == null) {
            return "redirect:/app/tareas"; // Si no existe, redirige a la lista
        }
        model.addAttribute("tarea", tareaEncontrada);
        return "update";
    }

    @PostMapping("/update")
    public String editar(@ModelAttribute Tarea tarea){
        service.updateTarea(tarea.getIdTarea(), tarea);
        return "redirect:/app/tareas";
    }

    @GetMapping("/delete/{id}")
    public String eliminarTarea(@PathVariable Long id){
        service.deleteTarea(id);
        return "redirect:/app/tareas";
    }
}
