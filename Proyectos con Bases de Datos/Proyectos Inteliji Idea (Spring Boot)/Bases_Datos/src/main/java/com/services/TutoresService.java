package com.services;
import com.dao.*;
import com.entity.*;
import javax.ws.rs.*;
import com.general.*;
import java.util.List;
import javax.ws.rs.core.*;

@Path("tutores")
public class TutoresService{
    TutoresDAO tutores;
    @GET
    @Path("mostrar")//http://localhost:8090/Bases_Datos/Bases_Datos/tutores/mostrar
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tutores> mostrar(){
        tutores=new TutoresDAO();

        return tutores.mostrar();
    }

    @GET
    @Path("buscar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tutores buscar(@PathParam("ID") int ID){
        tutores=new TutoresDAO();

        return (Tutores)tutores.buscar(ID);
    }

    @PUT
    @Path("registrar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status registrar(Tutores tutor){
        Status s=new Status();
        s.setOb(tutor);

        tutores=new TutoresDAO();
        String respuesta=tutores.registrar(tutor);
        if(respuesta.equals("1")){
            s.setMensaje("¡Tutor Agregado Exitosamente!");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo agregar al tutor!");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @PUT//verbo http utilizado para publicar nuevos recursos
    @Path("editar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status editar(Tutores dao){
        Status s=new Status();
        s.setOb(dao);

        tutores=new TutoresDAO();
        String respuesta=tutores.editar(dao);
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

        tutores=new TutoresDAO();
        String respuesta=tutores.eliminar(dao);

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
