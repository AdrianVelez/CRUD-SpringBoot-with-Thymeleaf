package com.app.web.service;

import com.app.web.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    public List<Estudiante> listarEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerEstudiante(Long id);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Long id);

}
