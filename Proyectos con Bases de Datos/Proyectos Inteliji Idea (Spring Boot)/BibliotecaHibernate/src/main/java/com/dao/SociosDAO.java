package com.dao;
import javax.persistence.*;
import com.general.*;
import com.entity.*;
import java.util.*;

public class SociosDAO implements Metodos{
    EntityManagerFactory manager=Persistence.createEntityManagerFactory("Tables");
    EntityManager entity=manager.createEntityManager();

    Socios partners;
    String resultado;


    @Override
    public List mostrar(){
        List<Socios> lista=entity.createQuery("from Socios").getResultList();
        return lista;
    }

    @Override
    public Object buscar(int ID){
        partners=entity.find(Socios.class, ID);
        return partners;
    }

    @Override
    public String registrar(Object ob){
        partners=(Socios) ob;
        entity.getTransaction().begin();
        try{
            entity.persist(partners);
            entity.getTransaction().commit();
            resultado="Socio registrado exitosamente";
            System.out.println("¡Socio registrado exitosamente!");
        }catch(Exception s){
            entity.getTransaction().rollback();
            System.err.println("¡ERROR!, No se pudo registrar el socio\nError: "+s.getMessage());
            resultado="¡ERROR!, No se pudo registrar el socio";
        }
        entity.close();
        return resultado;
    }

    @Override
    public String editar(Object ob){
        partners=(Socios) ob;
        Socios socio=entity.find(Socios.class, partners.getId_socio());
        entity.getTransaction().begin();
        try{
            socio.setNombre(partners.getNombre());
            socio.setDireccion(partners.getDireccion());
            socio.setTelefono(partners.getTelefono());
            entity.getTransaction().commit();
            System.out.println("¡Socio actualizado exitosamente!");
            resultado="Socio actualizado exitosamente";
        }catch(Exception s){
            entity.getTransaction().rollback();
            System.err.println("¡ERROR!, No se pudo actualizar el socio\nError: "+s.getMessage());
            resultado="¡ERROR!, No se pudo actualizar el socio";
        }
        entity.close();
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        partners=entity.find(Socios.class, ID);
        entity.getTransaction().begin();
        try{
            entity.remove(partners);
            entity.getTransaction().commit();
            System.out.println("¡Socio eliminado exitosamente!");
            resultado="Socio eliminado exitosamente";
        }catch(Exception s){
            entity.getTransaction().rollback();
            System.err.println("¡ERROR!, No se pudo eliminar el socio\nError: "+s.getMessage());
            resultado="¡ERROR!, No se pudo eliminar el socio";
        }
        entity.close();
        return resultado;
    }
}
