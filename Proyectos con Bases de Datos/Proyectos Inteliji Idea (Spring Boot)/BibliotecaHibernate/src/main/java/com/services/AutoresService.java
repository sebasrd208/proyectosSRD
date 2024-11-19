package com.services;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import com.general.*;
import com.entity.*;
import java.util.*;
import com.dao.*;

@Path("autores")
public class AutoresService{
    AutoresDAO dao;

    @GET
    @Path("mostrar")//http://localhost:8090/BibliotecaHibernate/BibliotecaHibernate/autores/mostrar
    @Produces({MediaType.APPLICATION_JSON})
    public List<Autores> mostrar(){
        dao=new AutoresDAO();

        return dao.mostrar();
    }

    @GET
    @Path("buscar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Autores buscar(@PathParam("ID") int ID){
        dao=new AutoresDAO();

        return (Autores) dao.buscar(ID);
    }

    @POST
    @Path("registrar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status registrar(Autores autor2){
        Status estado=new Status();
        estado.setOb(autor2);

        dao=new AutoresDAO();
        String respuesta=dao.registrar(autor2);
        if(respuesta.equals("1")){
            estado.setMensaje("¡Autor registrado exitosamente!");
            estado.setMensaje(respuesta);
        }else{
            estado.setMensaje("¡ERROR!, No se pudo registrar el autor");
            estado.setMensaje(respuesta);
        }

        return estado;
    }

    @PUT
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status editar(Autores autor2){
        Status estado=new Status();
        estado.setOb(autor2);

        dao=new AutoresDAO();
        String respuesta=dao.editar(autor2);
        if(respuesta.equals("1")){
            estado.setMensaje("¡Autor actualizado exitosamente!");
            estado.setMensaje(respuesta);
        }else{
            estado.setMensaje("¡ERROR!, No se pudo actualizar el autor");
            estado.setMensaje(respuesta);
        }

        return estado;
    }

    @DELETE
    @Path("eliminar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status eliminar(@PathParam("ID") int ID){
        Status estado=new Status();

        dao=new AutoresDAO();
        String respuesta=dao.eliminar(ID);
        if(respuesta.equals("1")){
            estado.setMensaje("¡Autor eliminado exitosamente!");
            estado.setMensaje(respuesta);
        }else{
            estado.setMensaje("¡ERROR!, No se pudo eliminar al autor");
            estado.setMensaje(respuesta);
        }
        return estado;
    }
}
