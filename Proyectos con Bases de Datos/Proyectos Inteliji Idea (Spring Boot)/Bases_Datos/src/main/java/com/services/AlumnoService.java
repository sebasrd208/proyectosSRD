package com.services;
import com.dao.*;
import com.dto.*;
import com.entity.*;
import javax.ws.rs.*;
import com.general.*;
import java.util.List;
import javax.ws.rs.core.*;

@Path("alumnos")
public class AlumnoService{
    AlumnoDAO alumno;

    @GET
    @Path("mostrar")//http://localhost:8090/Bases_Datos/Bases_Datos/alumnos/mostrar
    @Produces({MediaType.APPLICATION_JSON})
    public List<Alumno> mostrar(){
        alumno=new AlumnoDAO();

        return alumno.mostrar();
    }

    @GET
    @Path("buscar/{ID}")
    @Produces({MediaType.APPLICATION_JSON})
    public Alumno buscar(@PathParam("ID") int ID){
        alumno=new AlumnoDAO();
        return (Alumno) alumno.buscar(ID);

    }

    @POST//verbo http utilizado para publicar nuevos recursos
    @Path("registrar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status registrar(Alumno dao){
        Status s=new Status();
        s.setOb(dao);

        alumno=new AlumnoDAO();
        String respuesta=alumno.registrar(dao);

        if(respuesta.equals("1")){
            s.setMensaje("Alumno guardado");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("Error");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @PUT//verbo http utilizado para publicar nuevos recursos
    @Path("editar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Status editar(Alumno dao){
        Status s=new Status();
        s.setOb(dao);

        alumno=new AlumnoDAO();
        String respuesta=alumno.editar(dao);
        if(respuesta.equals("1")){
            s.setMensaje("Alumno actualizado");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("Error");
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

        alumno=new AlumnoDAO();
        String respuesta=alumno.eliminar(dao);

        if(respuesta.equals("1")){
            s.setMensaje("Alumno eliminado exitosamente");
            s.setMensaje(respuesta);
        }else{
            s.setMensaje("Error eliminar");
            s.setMensaje(respuesta);
        }
        return s;
    }

    @GET
    @Path("detalles")//http://localhost:8090/Bases_Datos/Bases_Datos/alumnos/detalles
    @Produces({MediaType.APPLICATION_JSON})
    public List<ObjetoDTO> detalles(){
        alumno=new AlumnoDAO();

        return alumno.datelles();
    }
}
