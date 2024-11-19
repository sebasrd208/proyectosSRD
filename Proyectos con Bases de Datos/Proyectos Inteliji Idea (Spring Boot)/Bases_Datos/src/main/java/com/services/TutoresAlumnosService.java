package com.services;
import com.dao.*;
import com.entity.*;
import javax.ws.rs.*;
import com.general.*;
import java.util.List;
import javax.ws.rs.core.*;

@Path("tutores-alumnos")
public class TutoresAlumnosService{

    TutoresAlumnosDAO dao;

    @GET
    @Path("mostrar")//http:/localhost:8090/Bases_Datos/Bases_Datos/tutores-alumnos/mostrar
    @Produces({MediaType.APPLICATION_JSON})
    public List<TutoresAlumnos> mostrar(){
        dao=new TutoresAlumnosDAO();

        return dao.mostrar();
    }

    @GET
    @Path("buscar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    public TutoresAlumnos buscar(@PathParam("ID") int ID){
        dao=new TutoresAlumnosDAO();

        return (TutoresAlumnos)dao.buscar(ID);
    }

    @PUT
    @Path("registrar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status registrar(TutoresAlumnos tutor){
        Status s=new Status();
        s.setOb(tutor);

        dao=new TutoresAlumnosDAO();
        String respuesta=dao.registrar(tutor);
        if(respuesta.equals("1")){
            s.setMensaje("¡Usuario Tutor Agregado Exitosamente!");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo agregar al usuario tutor!");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @PUT//verbo http utilizado para publicar nuevos recursos
    @Path("editar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status editar(TutoresAlumnos tutor){
        Status s=new Status();
        s.setOb(tutor);

        dao=new TutoresAlumnosDAO();
        String respuesta=dao.editar(tutor);
        if(respuesta.equals("1")){
            s.setMensaje("¡Usuario tutor actualizado exitosamente!");
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
    public Status eliminar(@PathParam("ID") int ID){
        Status s=new Status();

        dao=new TutoresAlumnosDAO();
        String respuesta=dao.eliminar(ID);
        if(respuesta.equals("1")){
            s.setMensaje("Usuario tutor eliminado exitosamente");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo eliminar al usuario tutor!");
            s.setMensaje(respuesta);
        }
        return s;
    }
}
