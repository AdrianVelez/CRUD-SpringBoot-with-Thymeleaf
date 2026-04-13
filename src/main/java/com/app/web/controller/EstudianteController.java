package com.app.web.controller;

import com.app.web.entity.Estudiante;
import com.app.web.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "estudiantes"; // nos retorna el html de estudiantes
    }

    @GetMapping("estudiantes/nuevo")
    public String mostrarFormularioDeRegistroEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("estudiantes/editar/{id}")
    public String mostrarFormularioEditarEstudiante(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("estudiante", estudianteService.obtenerEstudiante(id));
        return "editar_estudiante";
    }

    @PostMapping("estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
        Estudiante estudianteExiste = estudianteService.obtenerEstudiante(id);

        estudianteExiste.setNombre(estudiante.getNombre());
        estudianteExiste.setApellido(estudiante.getApellido());
        estudianteExiste.setEmail(estudiante.getEmail());

        estudianteService.actualizarEstudiante(estudianteExiste);
        return "redirect:/estudiantes";
    }

    @GetMapping("estudiantes/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
