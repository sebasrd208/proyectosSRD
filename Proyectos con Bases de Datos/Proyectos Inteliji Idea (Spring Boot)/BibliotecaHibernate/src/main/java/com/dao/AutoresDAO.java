package com.dao;
import javax.persistence.*;
import com.entity.*;
import com.general.*;
import java.util.*;

public class AutoresDAO implements Metodos{

    EntityManagerFactory manager=Persistence.createEntityManagerFactory("Tables");
    EntityManager entity=manager.createEntityManager();

    Autores au;

    String resultado;

    @Override
    public List mostrar(){
        List<Autores> lista=entity.createQuery("from Autores").getResultList();

        return lista;
    }

    @Override
    public Object buscar(int ID){
        au=entity.find(Autores.class, ID);
        return au;
    }

    @Override
    public String registrar(Object ob){
        au=(Autores) ob;
        entity.getTransaction().begin();
        try{
            entity.persist(au);
            entity.getTransaction().commit();
            System.out.println("Autor registrado exitosamente");
            resultado="Autor registrado exitosamente";
        }catch(Exception s){
            entity.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo registrar el autor";
            System.out.println("¡ERROR!, No se pudo registrar el autor\nError: "+s.getMessage());
        }
        entity.close();
        return resultado;
    }

    @Override
    public String editar(Object ob){
        au=(Autores) ob;
        Autores autores=entity.find(Autores.class, au.getID_Autor());
        entity.getTransaction().begin();
        try{
            autores.setNombre(au.getNombre());
            autores.setNacionalidad(au.getNacionalidad());
            entity.getTransaction().commit();
            resultado="Autor actualizado exitosamente";
            System.out.println("¡Autor actualizado exitosamente!");
        }catch(Exception s){
            entity.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo actualizar el autor";
            System.err.println("¡ERROR!, No se pudo actualizar el autor\nError: "+s.getMessage());
        }
        entity.close();
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        au=entity.find(Autores.class, ID);
        entity.getTransaction().begin();
        try{
            entity.remove(au);
            entity.getTransaction().commit();
            resultado="Autor eliminado exitosamente";
            System.out.println("¡Autor eliminado exitosamente!");
        }catch(Exception s){
            entity.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo eliminar al autor";
            System.err.println("¡ERROR!, No se pudo eliminar al autor\nError: "+s.getMessage());
        }
        entity.close();
        return resultado;
    }
}
