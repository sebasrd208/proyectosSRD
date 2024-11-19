package com.services;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import com.general.*;
import com.entity.*;
import java.util.*;
import com.dao.*;


@Path("prestamos")
public class PrestamosService{

    PrestamosDAO dao;
    String respuesta;

    @GET
    @Path("mostrar")//http://localhost:8090/BibliotecaHibernate/BibliotecaHibernate/prestamos/mostrar
    @Produces({MediaType.APPLICATION_JSON})
    public List<Prestamos> mostrar(){
        dao=new PrestamosDAO();

        return dao.mostrar();
    }

    @GET
    @Path("buscar/{v}")
    @Produces({MediaType.APPLICATION_JSON})
    public Prestamos buscar(@PathParam("v") int ID){
        dao=new PrestamosDAO();
        return (Prestamos) dao.buscar(ID);
    }

    @POST
    @Path("registrar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status registrar(Prestamos loans){
        Status estado=new Status();
        estado.setOb(loans);

        dao=new PrestamosDAO();
        respuesta=dao.registrar(loans);
        if(respuesta.equals("1")){
            estado.setMensaje("Préstamo registrado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo registrar el préstamo");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }

    @PUT
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status editar(Prestamos loans){
        Status estado=new Status();
        estado.setOb(loans);

        dao=new PrestamosDAO();
        respuesta=dao.editar(loans);
        if(respuesta.equals("1")){
            estado.setMensaje("Préstamo actualizado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo actualizar el préstamo");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }


    @DELETE
    @Path("eliminar/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status eliminar(@PathParam("id") int ID){
        Status estado=new Status();

        dao=new PrestamosDAO();
        respuesta=dao.eliminar(ID);
        if(respuesta.equals("1")){
            estado.setMensaje("Préstamo eliminado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo eliminar el préstamo");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }
}
