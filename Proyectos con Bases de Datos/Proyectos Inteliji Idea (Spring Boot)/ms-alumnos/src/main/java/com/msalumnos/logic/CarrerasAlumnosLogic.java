package com.msalumnos.logic;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.msalumnos.request.service.*;
import com.msalumnos.repository.*;
import com.msalumnos.exception.*;
import com.msalumnos.request.*;
import com.msalumnos.entity.*;
import java.util.*;


@Service
public class CarrerasAlumnosLogic implements CarrerasAlumnosService {

    @Autowired
    CarrerasAlumnosRepository dao;

    @Override
    public CarrerasAlumnos registrar(CarrerasAlumnosRequest request){
        CarrerasAlumnos students=new CarrerasAlumnos();
        students.setID_Alumno(request.getID_Alumno());
        students.setID_Carrera(request.getID_Carrera());

        dao.save(students);

        return students;
    }

    @Override
    public CarrerasAlumnos editar(CarrerasAlumnosRequest editar) throws NoSePuedeEditarException {
        CarrerasAlumnos students=dao.findById(editar.getCa_ID()).get();

        students.setID_Alumno(editar.getID_Alumno());
        students.setID_Carrera(editar.getID_Carrera());

        dao.save(students);

        return students;
    }

    @Override
    public CarrerasAlumnos buscar(int ID){
        return dao.findById(ID).get();
    }

    @Override
    public String eliminar(int ID){
        dao.deleteById(ID);
        return "Usuario de la carrera eliminado exitosamente";
    }

    @Override
    public List<CarrerasAlumnos> mostrar(){
        return dao.findAll();
    }
}
