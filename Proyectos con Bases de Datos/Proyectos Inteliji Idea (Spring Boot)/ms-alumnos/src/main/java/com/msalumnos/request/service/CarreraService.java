package com.msalumnos.request.service;
import java.util.*;
import com.msalumnos.entity.Alumno;
import com.msalumnos.entity.Carreras;
import com.msalumnos.exception.NoSePuedeEditarException;
import com.msalumnos.request.CarreraRequest;

public interface CarreraService{
    public Carreras registrar(CarreraRequest request);
    public Carreras editar(CarreraRequest editar) throws NoSePuedeEditarException;
    public Carreras buscar(int ID);
    public String eliminar(int ID);
    public List<Carreras> mostrar();
}

