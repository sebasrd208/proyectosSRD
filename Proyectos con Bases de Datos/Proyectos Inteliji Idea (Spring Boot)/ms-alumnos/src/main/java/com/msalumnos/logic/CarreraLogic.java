package com.msalumnos.logic;
import com.msalumnos.request.service.CarreraService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.msalumnos.repository.*;
import com.msalumnos.exception.*;
import com.msalumnos.request.*;
import com.msalumnos.entity.*;
import java.util.*;

@Service
public class CarreraLogic implements CarreraService {
    @Autowired
    CarreraRepository dao;

    @Override
    public Carreras registrar(CarreraRequest request){
        Carreras carreras=new Carreras();
        carreras.setNombre(request.getNombre());
        carreras.setDuracion(request.getDuracion());
        carreras.setArea(request.getArea());
        carreras.setP_mensual(request.getP_mensual());

        dao.save(carreras);

        return carreras;
    }

    @Override
    public Carreras editar(CarreraRequest request) throws NoSePuedeEditarException{
        Carreras carreras=dao.findById(request.getID_Carrera()).get();
        carreras.setNombre(request.getNombre());
        carreras.setDuracion(request.getDuracion());
        carreras.setArea(request.getArea());
        carreras.setP_mensual(request.getP_mensual());
        dao.save(carreras);

        return carreras;
    }

    @Override
    public Carreras buscar(int ID) throws NoSePuedeEditarException{
        return dao.findById(ID).get();
    }

    @Override
    public String eliminar(int ID){
        dao.deleteById(ID);
        return "Carrera eliminada exitosamente";
    }

    @Override
    public List<Carreras> mostrar(){

        return dao.findAll();
    }

}

