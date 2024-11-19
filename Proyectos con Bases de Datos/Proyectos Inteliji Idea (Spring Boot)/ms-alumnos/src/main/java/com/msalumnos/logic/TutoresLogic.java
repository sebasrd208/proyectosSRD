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
public class TutoresLogic implements TutoresService{

    @Autowired
    TutoresRepository dao;

    @Override
    public Tutores registrar(TutoresRequest request){
        Tutores tutores=new Tutores();
        tutores.setNombre(request.getNombre());
        tutores.setEmail(request.getEmail());
        tutores.setClave(request.getClave());

        dao.save(tutores);

        return tutores;
    }

    @Override
    public Tutores editar(TutoresRequest request) throws NoSePuedeEditarException {
        Tutores tutores=dao.findById(request.getID_Tutor()).get();
        tutores.setNombre(request.getNombre());
        tutores.setEmail(request.getEmail());
        tutores.setClave(request.getClave());

        dao.save(tutores);

        return tutores;
    }

    @Override
    public Tutores buscar(int ID){
        return dao.findById(ID).get();
    }

    @Override
    public String eliminar(int ID){
        dao.deleteById(ID);
        return "Tutor eliminado exitosamente";
    }

    @Override
    public List<Tutores> mostrar() {
        return dao.findAll();
    }
}
