package com.msalumnos.request.service;

import java.util.*;
import com.msalumnos.entity.Alumno;
import com.msalumnos.exception.NoSePuedeEditarException;
import com.msalumnos.request.AlumnoRequest;

public interface AlumnoService {
	public Alumno registrar(AlumnoRequest request);
	public Alumno editar(AlumnoRequest editar) throws NoSePuedeEditarException;
	public Alumno buscar(int ID);
	public String eliminar(int ID);
	public List<Alumno> mostrar();
}
