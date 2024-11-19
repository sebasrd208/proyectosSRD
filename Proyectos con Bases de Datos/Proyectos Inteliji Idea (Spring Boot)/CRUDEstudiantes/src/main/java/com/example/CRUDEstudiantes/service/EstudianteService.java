package com.example.CRUDEstudiantes.service;

import com.example.CRUDEstudiantes.entity.*;
import com.example.CRUDEstudiantes.request.*;

import java.util.List;

public interface EstudianteService{
    public Estudiantes registrar(EstudianteRequest request);
    public Estudiantes editar(EstudianteRequest editar);
    public Estudiantes buscar(int ID);
    public String eliminar(int ID);
    public List<Estudiantes> mostrar();
}
