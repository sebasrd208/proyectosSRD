package com.services;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import com.general.*;
import com.entity.*;
import java.util.*;
import com.dao.*;

@Path("clientes")
public class ClienteService{
	Clientes costumer;
	ClienteDAO costumerDAO;
	
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/CRUEDHibernate_SRD/CRUEDHibernate_SRD/clientes/mostrar
	public List<Clientes> mostrar(){
		costumerDAO=new ClienteDAO();
		
		return costumerDAO.mostrar();
	}
	
	@Path("registrar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/CRUEDHibernate_SRD/CRUEDHibernate_SRD/clientes/registrar
	public Status registrar(Clientes costumer2){
		Status s=new Status();
		s.setOb(costumer2);
		
		costumerDAO=new ClienteDAO();
		String resultado=costumerDAO.registrar(costumer2);
		if(resultado.equals("1")){
			s.setMensaje("¡Cliente registrado exitosamente!");
			s.setRespuesta(resultado);
		}else{
			s.setMensaje("¡ERROR!, ¡No se pudo registrar el cliente!");
			s.setRespuesta(resultado);
		}
		return s;
	}
	
	@Path("eliminar/{ID}")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8080/CRUEDHibernate_SRD/CRUEDHibernate_SRD/clientes/eliminar/
	public Status eliminar(@PathParam("ID")int ID){
		Status s=new Status();
		s.setOb(ID);
		
		costumerDAO=new ClienteDAO();
		String resultado=costumerDAO.eliminar(ID);
		if(resultado.equals("1")){
			s.setMensaje("¡Cliente eliminado exitosamente!");
			s.setRespuesta(resultado);
		}else{
			s.setMensaje("¡ERROR!, ¡No se pudo eliminar el cliente!");
			s.setRespuesta(resultado);
		}
		return s;
	}
	
	@Path("editar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/CRUEDHibernate_SRD/CRUEDHibernate_SRD/clientes/editar
	public Status editar(Clientes costumer3){
		Status s=new Status();
		s.setOb(costumer3);
		
		costumerDAO=new ClienteDAO();
		String resultado=costumerDAO.editar(costumer3);
		if(resultado.equals("1")){
			s.setMensaje("¡Cliente actualizado exitosamente!");
			s.setRespuesta(resultado);
		}else{
			s.setMensaje("¡ERROR!, ¡No se pudo actualizar el cliente!");
			s.setRespuesta(resultado);
		}
		return s;
	}
	
	@Path("buscar/{ID}")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8080/CRUEDHibernate_SRD/CRUEDHibernate_SRD/clientes/buscar/
	public Clientes buscar(@PathParam("ID") int ID){
		costumerDAO=new ClienteDAO();
		
		return (Clientes)costumerDAO.buscar(ID);
	}


}
