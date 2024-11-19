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
public class TutoresAlumnosLogic implements TutoresAlumnosService{
    @Autowired
    TutoresAlumnosRepository dao;

    @Override
    public TutoresAlumnos registrar(TutoresAlumnosRequest request){
        TutoresAlumnos tutores=new TutoresAlumnos();
        tutores.setID_Alumno(request.getID_Alumno());
        tutores.setID_Tutor(request.getID_Tutor());

        dao.save(tutores);

        return tutores;
    }

    @Override
    public TutoresAlumnos editar(TutoresAlumnosRequest request) throws NoSePuedeEditarException{
        TutoresAlumnos tutores=dao.findById(request.getID_Tabla()).get();
        tutores.setID_Alumno(request.getID_Alumno());
        tutores.setID_Tutor(request.getID_Tutor());

        dao.save(tutores);

        return tutores;
    }

    @Override
    public TutoresAlumnos buscar(int ID){
        return dao.findById(ID).get();
    }

    @Override
    public String eliminar(int ID){
        dao.deleteById(ID);
        return "Usuario de tutor eliminado exitosamente";
    }

    @Override
    public List<TutoresAlumnos> mostrar(){
        return dao.findAll();
    }
}
