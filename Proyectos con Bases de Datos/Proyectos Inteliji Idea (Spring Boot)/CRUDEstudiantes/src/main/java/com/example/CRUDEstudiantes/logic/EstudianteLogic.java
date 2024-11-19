package com.example.CRUDEstudiantes.logic;

import com.example.CRUDEstudiantes.entity.*;
import com.example.CRUDEstudiantes.repository.*;
import com.example.CRUDEstudiantes.request.*;
import com.example.CRUDEstudiantes.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class EstudianteLogic implements EstudianteService{

    @Autowired
    EstudianteRepository dao;

    @Override
    public Estudiantes registrar(EstudianteRequest request) {
        Estudiantes students=new Estudiantes();
        students.setNombre(request.getNombre());
        students.setFecNacimiento(request.getFecNacimiento());
        students.setGenero(request.getGenero());
        students.setGrado(request.getGrado());
        students.setCiudad(request.getCiudad());
        students.setStatus(1);

        dao.save(students);

        return students;
    }

    @Override
    public Estudiantes editar(EstudianteRequest editar){
        Estudiantes students=dao.findById(editar.getID_Alumno()).get();
        students.setNombre(editar.getNombre());
        students.setFecNacimiento(editar.getFecNacimiento());
        students.setGenero(editar.getGenero());
        students.setGrado(editar.getGrado());
        students.setCiudad(editar.getCiudad());
        students.setStatus(editar.getStatus());

        dao.save(students);

        return students;
    }

    @Override
    public Estudiantes buscar(int ID){

        return dao.findById(ID).get();

    }

    @Override
    public String eliminar(int ID){
        dao.deleteById(ID);

        return "Estudiante eliminado exitosamente";
    }

    @Override
    public List<Estudiantes> mostrar(){
        return dao.findAll();
    }
}
