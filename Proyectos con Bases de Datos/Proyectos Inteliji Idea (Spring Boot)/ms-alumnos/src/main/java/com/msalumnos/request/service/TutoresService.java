package com.msalumnos.request.service;

import com.msalumnos.entity.*;
import com.msalumnos.exception.*;
import com.msalumnos.request.*;

import java.util.List;

public interface TutoresService{
    public Tutores registrar(TutoresRequest request);
    public Tutores editar(TutoresRequest editar) throws NoSePuedeEditarException;
    public Tutores buscar(int ID);
    public String eliminar(int ID);
    public List<Tutores> mostrar();
}
