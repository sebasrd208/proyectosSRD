package com.services;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import com.general.*;
import com.entity.*;
import java.util.*;
import com.dao.*;

@Path("socios")
public class SociosService{
    SociosDAO dao=new SociosDAO();
    Status estado=new Status();
    String respuesta;

    @GET
    @Path("mostrar")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Socios> mostrar(){
        return dao.mostrar();
    }

    @GET
    @Path("buscar/{v}")
    @Produces({MediaType.APPLICATION_JSON})
    public Socios buscar(@PathParam("v") int ID){
        return (Socios) dao.buscar(ID);
    }

    @POST
    @Path("registrar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status registrar(Socios socio){
        estado.setOb(socio);

        respuesta=dao.registrar(socio);
        if(respuesta.equals("1")){
            estado.setMensaje("Socio registrado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo registrar el socio");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }

    @PUT
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status editar(Socios socio){
        estado.setOb(socio);

        respuesta=dao.editar(socio);
        if(respuesta.equals("1")){
            estado.setMensaje("Socio actualizado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo actualizar el socio");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }

        return estado;
    }

    @DELETE
    @Path("eliminar/{v}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Status eliminar(@PathParam("v") int ID){
        respuesta=dao.eliminar(ID);
        if(respuesta.equals("1")){
            estado.setMensaje("Socio eliminado exitosamente");
            estado.setMensaje(respuesta);
            estado.setRespuesta("0");
        }else{
            estado.setMensaje("¡ERROR!, No se pudo eliminar el socio");
            estado.setMensaje(respuesta);
            estado.setRespuesta("1");
        }
        return estado;
    }

}
