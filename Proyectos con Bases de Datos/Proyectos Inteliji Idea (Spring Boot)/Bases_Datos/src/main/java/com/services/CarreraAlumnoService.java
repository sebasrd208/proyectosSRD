package com.services;
import com.dao.*;
import com.entity.*;
import javax.ws.rs.*;
import com.general.*;
import java.util.List;
import javax.ws.rs.core.*;

@Path("carrera-alumnos")
public class CarreraAlumnoService{
    CarrerasAlumnosDAO carreras;
    @GET
    @Path("mostrar")//http://localhost:8090/Bases_Datos/Bases_Datos/carrera-alumnos/mostrar
    @Produces({MediaType.APPLICATION_JSON})
    public List<CarreraAlumnos> mostrar(){
        carreras=new CarrerasAlumnosDAO();

        return carreras.mostrar();
    }

    @GET
    @Path("buscar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    public CarreraAlumnos buscar(@PathParam("ID") int ID){
        carreras=new CarrerasAlumnosDAO();

        return (CarreraAlumnos) carreras.buscar(ID);
    }

    @PUT
    @Path("registrar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status registrar(CarreraAlumnos car){
        Status s=new Status();
        s.setOb(car);

        carreras=new CarrerasAlumnosDAO();
        String respuesta=carreras.registrar(car);
        if(respuesta.equals("1")){
            s.setMensaje("¡Usuario Agregado Exitosamente!");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo agregar la usuario!");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @PUT//verbo http utilizado para publicar nuevos recursos
    @Path("editar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status editar(CarreraAlumnos dao){
        Status s=new Status();
        s.setOb(dao);

        carreras=new CarrerasAlumnosDAO();
        String respuesta=carreras.editar(dao);
        if(respuesta.equals("1")){
            s.setMensaje("¡Usuario actualizado exitosamente!");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo actualizar el usuario!");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @DELETE//verbo http utilizado para publicar nuevos recursos
    @Path("eliminar/{ID}")//http://localhost:8082//
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status eliminar(@PathParam("ID") int dao){
        Status s=new Status();

        carreras=new CarrerasAlumnosDAO();
        String respuesta=carreras.eliminar(dao);

        if(respuesta.equals("1")){
            s.setMensaje("Usuario eliminado exitosamente");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("¡ERROR!, ¡No se pudo eliminar la carrera!");
            s.setMensaje(respuesta);
        }
        return s;
    }
}
