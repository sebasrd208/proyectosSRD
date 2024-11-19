package com.msalumnos.logic;
import com.msalumnos.request.service.AlumnoService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.msalumnos.repository.*;
import com.msalumnos.exception.*;
import com.msalumnos.request.*;
import com.msalumnos.entity.*;
import java.util.*;

@Service
public class AlumnoLogic implements AlumnoService {
	@Autowired
	AlumnoRepository dao;

	@Override
	public Alumno registrar(AlumnoRequest request){
		Alumno estudiante=new Alumno();
		estudiante.setNombre(request.getNombre());
		estudiante.setFechaNac(request.getfechaNac());
		estudiante.setGenero(request.getGenero());
		estudiante.setGrado(request.getGrado());
		estudiante.setCiudad(request.getCiudad());
		estudiante.setStatus(1);
		
		dao.save(estudiante);

		return estudiante;
	}

	@Override
	public Alumno editar(AlumnoRequest request) throws NoSePuedeEditarException{
		Alumno estudiante=dao.findById(request.getID_Alumno()).get();
		if(estudiante.getStatus()==1){
			estudiante.setNombre(request.getNombre());
			estudiante.setFechaNac(request.getfechaNac());
			estudiante.setGenero(request.getGenero());
			estudiante.setGrado(request.getGrado());
			estudiante.setCiudad(request.getCiudad());

			dao.save(estudiante);
		}else{
			throw new NoSePuedeEditarException("No se puede editar a un alumno que está dado de baja");
		}
		
		return estudiante;
	}

	@Override
	public Alumno buscar(int ID){
		return dao.findById(ID).get();
	}

	@Override
	public String eliminar(int ID){
		dao.deleteById(ID);
		return "Alumno eliminado exitosamente";
	}

	@Override
	public List<Alumno> mostrar(){
		
		return dao.findAll();
	}

	public String inactivar(int ID){
		Alumno estudiante=dao.findById(ID).get();

		estudiante.setStatus(0);

		dao.save(estudiante);
		return "Alumno dado de baja exitosamente";
	}

}
