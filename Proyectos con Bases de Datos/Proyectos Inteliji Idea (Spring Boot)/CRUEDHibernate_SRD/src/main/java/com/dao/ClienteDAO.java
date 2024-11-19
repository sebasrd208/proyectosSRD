package com.dao;
import javax.persistence.*;
import com.entity.*;
import com.general.*;
import java.util.*;

public class ClienteDAO implements Metodos{
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Tables");
	EntityManager em=emf.createEntityManager();
	
	Clientes costumer;
	
	@Override
	public String registrar(Object ob){
		costumer=(Clientes)ob;
		em.getTransaction().begin();
		String resultado;
		try{
			em.persist(costumer);
			em.getTransaction().commit();
			resultado="1";
			System.out.println("¡Cliente registrado exitosamente!");
		}catch(Exception s){
			em.getTransaction().rollback();
			resultado=s.getMessage();
			System.out.println("ERROR, !No se pudo registrar el cliente¡");
		}
		em.close();
		return resultado;
	}
	
	@Override
	public String editar(Object ob){
		costumer=(Clientes)ob;
		Clientes costumerdb=em.find(Clientes.class, costumer.getID_Cliente());
		String resultado;
		em.getTransaction().begin();
		try{
			costumerdb.setNombre(costumer.getNombre());
			costumerdb.setDireccion(costumer.getDireccion());
			costumerdb.setIne(costumer.getIne());
			costumerdb.setTelefono(costumer.getTelefono());
			em.getTransaction().commit();
			System.out.println("¡Cliente actualizado exitosamente!");
			resultado="1";
		}catch(Exception s){
			em.getTransaction().rollback();
			resultado=s.getMessage();
			System.out.println("ERROR, !No se pudo actualizar el cliente¡");
		}
		em.close();
		return resultado;
	}
	
	@Override
	public String eliminar(int ID){
		String resultado;
		costumer=em.find(Clientes.class, ID);
		em.getTransaction().begin();
		try{
			em.remove(costumer);
			em.getTransaction().commit();
			System.out.println("¡Cliente eliminado exitosamente!");
			resultado="1";
		}catch(Exception s){
			em.getTransaction().rollback();
			resultado=s.getMessage();
			System.out.println("¡ERROR!, ¡No se pudo eliminar el registro!");
		}
		em.close();
		return resultado;
	}
	
	@Override
	public Object buscar(int ID){
		costumer=em.find(Clientes.class, ID);
		return costumer;
	}
	
	@Override
	public List mostrar(){
		List<Clientes> listCostumer=em.createQuery("from Clientes").getResultList();
		return listCostumer;
	}
}
