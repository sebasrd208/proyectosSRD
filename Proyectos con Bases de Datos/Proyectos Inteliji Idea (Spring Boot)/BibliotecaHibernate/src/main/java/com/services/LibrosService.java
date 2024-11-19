package com.services;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import com.general.*;
import com.entity.*;
import java.util.*;
import com.dao.*;

@Path("libros")
public class LibrosService{
    LibrosDAO hon;

    @Path("mostrar")//http://localhost:8090/BibliotecaHibernate/BibliotecaHibernate/libros/mostrar
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> mostrar(){
        hon=new LibrosDAO();
        return hon.mostrar();
    }

    @Path("buscar/{ID}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Libros buscar(@PathParam("ID") int ID){
        hon=new LibrosDAO();
        return (Libros) hon.buscar(ID);
    }

    @Path("registrar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status registrar(Libros libro){
        Status estado=new Status();
        estado.setOb(libro);

        hon=new LibrosDAO();
        String respuesta=hon.registrar(libro);
        if(respuesta.equals("1")){
            estado.setMensaje("Libro registrado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo registrar el libro");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }

    @Path("editar")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status editar(Libros libro){
        Status estado=new Status();
        estado.setOb(libro);

        hon=new LibrosDAO();
        String respuesta=hon.editar(libro);
        if(respuesta.equals("1")){
            estado.setMensaje("Libro actualizado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo actualizar el libro");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }
        return estado;
    }

    @Path("eliminar/{ID}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status eliminar(@PathParam("ID") int ID){
        Status estado=new Status();
        estado.setOb(ID);

        hon=new LibrosDAO();
        String respuesta=hon.eliminar(ID);
        if(respuesta.equals("1")){
            estado.setMensaje("Libro eliminado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo eliminar el libro");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }
}
