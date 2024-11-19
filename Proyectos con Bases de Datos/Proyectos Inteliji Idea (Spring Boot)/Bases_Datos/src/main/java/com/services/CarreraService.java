package com.services;
import com.dao.*;
import com.entity.*;
import javax.ws.rs.*;
import com.general.*;
import java.util.List;
import javax.ws.rs.core.*;

@Path("carreras")
public class CarreraService{

    CarrerasDAO carreras;
    @GET
    @Path("mostrar")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Carreras> mostrar(){
        carreras=new CarrerasDAO();

        return carreras.mostrar();
    }

    @GET
    @Path("buscar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    public Carreras buscar(@PathParam("ID") int ID){
        carreras=new CarrerasDAO();

        return (Carreras) carreras.buscar(ID);
    }

    @PUT
    @Path("registrar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status registrar(Carreras car){
        Status s=new Status();
        s.setOb(car);

        carreras=new CarrerasDAO();
        String respuesta=carreras.registrar(car);
        if(respuesta.equals("1")){
            s.setMensaje("¡Carrera Agregada Exitosamente!");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo agregar la carrera!");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @PUT//verbo http utilizado para publcar nuevos recursos
    @Path("editar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status editar(Carreras dao){
        Status s=new Status();
        s.setOb(dao);

        carreras=new CarrerasDAO();
        String respuesta=carreras.editar(dao);
        if(respuesta.equals("1")){
            s.setMensaje("¡Carrera actualizada exitosamente!");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo actualizar la carrera!");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @DELETE//verbo http utilizado para publcar nuevos recursos
    @Path("eliminar/{ID}")//http://localhost:8082//
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status eliminar(@PathParam("ID") int dao){
        Status s=new Status();

        carreras=new CarrerasDAO();
        String respuesta=carreras.eliminar(dao);

        if(respuesta.equals("1")){
            s.setMensaje("Carrera eliminada exitosamente");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo eliminar la carrera!");
            s.setMensaje(respuesta);
        }
        return s;
    }
}
