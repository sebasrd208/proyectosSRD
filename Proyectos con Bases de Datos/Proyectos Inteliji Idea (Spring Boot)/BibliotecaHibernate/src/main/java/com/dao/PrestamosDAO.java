package com.dao;
import javax.persistence.*;
import com.general.*;
import com.entity.*;
import java.util.*;

public class PrestamosDAO implements Metodos{
    EntityManagerFactory manager=Persistence.createEntityManagerFactory("Tables");
    EntityManager entity=manager.createEntityManager();
    Prestamos loans;
    String resultado;

    @Override
    public List mostrar(){
        List<Prestamos> lista=entity.createQuery("from Prestamos").getResultList();
        return lista;
    }

    @Override
    public Object buscar(int ID){
        loans=entity.find(Prestamos.class, ID);
        return loans;
    }

    @Override
    public String registrar(Object ob){
        loans=(Prestamos) ob;
        entity.getTransaction().begin();
        try{
            entity.persist(loans);
            entity.getTransaction().commit();
            System.out.println("¡Préstamo registrado exitosamente!");
            resultado="Préstamo registrado exitosamente";
        }catch(Exception s){
            entity.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo registrar el préstamo";
            System.out.println("¡ERROR!, No se pudo registrar el préstamo\nError: "+s.getMessage());
        }
        entity.close();
        return resultado;
    }

    @Override
    public String editar(Object ob){
        loans=(Prestamos) ob;
        Prestamos psp=entity.find(Prestamos.class, loans.getId_prestamo());
        entity.getTransaction().begin();
        try{
            psp.setId_libro(loans.getId_libro());
            psp.setId_socio(loans.getId_socio());
            psp.setFec_prestamo(loans.getFec_prestamo());
            psp.setFec_devolucion(loans.getFec_devolucion());
            entity.getTransaction().commit();
            System.out.println("¡Préstamo actualizado exitosamente!");
            resultado="Préstamo actualizado exitosamente";
        }catch(Exception s){
            entity.getTransaction().rollback();
            System.err.println("¡ERROR!, No se pudo actualizar el préstamo\nError: "+s.getMessage());
            resultado="¡ERROR!, No se pudo actualizar el préstamo";
        }
        entity.close();
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        loans=entity.find(Prestamos.class, ID);
        entity.getTransaction().begin();
        try{
            entity.remove(loans);
            entity.getTransaction().commit();
            System.out.println("¡Préstamo eliminado exitosamente!");
            resultado="Préstamo eliminado exitosamente";
        }catch(Exception s){
            entity.getTransaction().rollback();
            System.out.println("¡ERROR!, No se pudo eliminar el préstamo\nError: "+s.getMessage());
            resultado="¡ERROR!, No se pudo eliminar el préstamo";
        }
        entity.close();
        return resultado;
    }

}
