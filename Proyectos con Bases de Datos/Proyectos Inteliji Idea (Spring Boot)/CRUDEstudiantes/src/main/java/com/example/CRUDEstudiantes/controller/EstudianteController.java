package com.example.CRUDEstudiantes.controller;

import com.example.CRUDEstudiantes.entity.*;
import com.example.CRUDEstudiantes.logic.EstudianteLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/alumnos")
public class EstudianteController{

    @Autowired
    EstudianteLogic alumno;
    Estudiantes estudiante;

    @GetMapping
    public List<Estudiantes> mostrar(){
        List<Estudiantes> lista=alumno.mostrar();

        return lista;

    }

    @GetMapping("/{nombre}")
    public Estudiantes consultar(@PathVariable String nombre) {
        List<Estudiantes> lista = alumno.mostrar();
        for (Estudiantes e : lista){
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }

        return null;
    }


    @PostMapping
    public Estudiantes registro(@RequestBody Estudiantes students) {
        List<Estudiantes> lista=alumno.mostrar();
        lista.add(students);

        return students;
    }

    @PutMapping
    public Estudiantes modificacion(@RequestBody Estudiantes estudio) {
        List<Estudiantes> lista = alumno.mostrar();
        for(Estudiantes s: lista){
            if (s.getID_Alumno() == estudio.getID_Alumno()) {
                s.setNombre(estudio.getNombre());
                s.setFecNacimiento(estudio.getFecNacimiento());
                s.setGenero(estudio.getGenero());
                s.setGrado(estudio.getGrado());
                s.setCiudad(estudio.getCiudad());
                s.setStatus(estudio.getStatus());

                return s;
            }
        }
        return null;
    }

    @PatchMapping
    public Estudiantes editar(@RequestBody Estudiantes alumnos){
        List<Estudiantes> lista = alumno.mostrar();
        for(Estudiantes s: lista){
            if(s.getID_Alumno()==alumnos.getID_Alumno()){
                if(s.getNombre()!=null){
                    s.setNombre(alumnos.getNombre());
                }
                if(s.getFecNacimiento()!=null){
                    s.setFecNacimiento(alumnos.getFecNacimiento());
                }
                if(s.getGenero()!=null){
                    s.setGenero(alumnos.getGenero());
                }
                if(s.getGrado()!=null){
                    s.setGrado(alumnos.getGrado());
                }
                if(s.getCiudad()!=null){
                    s.setCiudad(alumnos.getCiudad());
                }
                if(s.getStatus()!=0){
                    s.setStatus(alumnos.getStatus());
                }

                return s;
            }
        }

        return null;
    }

    @DeleteMapping("/{ID}")
    public Estudiantes eliminar(@PathVariable int ID){
        List<Estudiantes> lista=alumno.mostrar();
        for(Estudiantes s: lista){
            if(s.getID_Alumno()==ID){
                lista.remove(ID);

                return s;
            }
        }
        return null;
    }
}
