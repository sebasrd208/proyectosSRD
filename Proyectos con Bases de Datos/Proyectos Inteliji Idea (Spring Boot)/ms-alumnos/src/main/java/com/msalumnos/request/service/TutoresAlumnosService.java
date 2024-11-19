package com.msalumnos.request.service;
import com.msalumnos.entity.*;
import com.msalumnos.exception.*;
import com.msalumnos.request.*;

import java.util.List;

public interface TutoresAlumnosService{
    public TutoresAlumnos registrar(TutoresAlumnosRequest request);
    public TutoresAlumnos editar(TutoresAlumnosRequest editar) throws NoSePuedeEditarException;
    public TutoresAlumnos buscar(int ID);
    public String eliminar(int ID);
    public List<TutoresAlumnos> mostrar();
}
