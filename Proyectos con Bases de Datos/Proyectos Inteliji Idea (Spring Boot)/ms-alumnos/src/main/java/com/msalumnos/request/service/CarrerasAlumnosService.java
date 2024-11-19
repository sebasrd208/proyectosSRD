package com.msalumnos.request.service;

import com.msalumnos.entity.Carreras;
import com.msalumnos.entity.CarrerasAlumnos;
import com.msalumnos.exception.NoSePuedeEditarException;
import com.msalumnos.request.CarrerasAlumnosRequest;

import java.util.List;

public interface CarrerasAlumnosService{
    public CarrerasAlumnos registrar(CarrerasAlumnosRequest request);
    public CarrerasAlumnos editar(CarrerasAlumnosRequest editar) throws NoSePuedeEditarException;
    public CarrerasAlumnos buscar(int ID);
    public String eliminar(int ID);
    public List<CarrerasAlumnos> mostrar();
}
