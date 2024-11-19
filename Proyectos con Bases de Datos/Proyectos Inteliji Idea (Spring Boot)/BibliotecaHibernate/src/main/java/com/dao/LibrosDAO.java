package com.dao;
import javax.persistence.*;
import com.general.*;
import com.entity.*;
import java.util.*;

public class LibrosDAO implements Metodos{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("Tables");
    EntityManager em=emf.createEntityManager();
    Libros book;
    String resultado;

    @Override
    public List mostrar(){
        List<Libros> lista=em.createQuery("from Libros").getResultList();
        return lista;
    }

    @Override
    public Object buscar(int ID){
        book=em.find(Libros.class, ID);
        return book;
    }

    @Override
    public String registrar(Object ob){
        book=(Libros) ob;
        em.getTransaction().begin();
        try{
            em.persist(book);
            em.getTransaction().commit();
            resultado="Libro registrado exitosamente";
            System.out.println("Libro registrado exitosamente");
        }catch(Exception s){
            em.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo registrar el libro\nError: "+s.getMessage();
            System.out.println("¡ERROR!, No se pudo registrar el libro");
            System.err.println("Error: "+s.getMessage());
        }
        em.close();
        return resultado;
    }

    @Override
    public String editar(Object ob){
        book=(Libros)ob;
        Libros hon=em.find(Libros.class, book.getID_Libro());
        em.getTransaction().begin();
        try{
            hon.setTitulo(book.getTitulo());
            hon.setID_Autor(book.getID_Autor());
            hon.setCopias(book.getCopias());
            em.getTransaction().commit();
            System.out.println("Libro actualizado exitosamente");
            resultado="Libro actualizado exitosamente";
        }catch(Exception s){
            em.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo actualizar el libro\nError: "+s.getMessage();
            System.out.println("¡ERROR!, No se pudo actualizar el libro");
            System.err.println("Error: "+s.getMessage());
        }
        em.close();
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        book=em.find(Libros.class, ID);
        em.getTransaction().begin();
        try{
            em.remove(book);
            em.getTransaction().commit();
            resultado="Libro eliminado exitosamente";
            System.out.println("Libro eliminado exitosamente");
        }catch(Exception s){
            em.getTransaction().rollback();
            resultado="¡ERROR!, No se pudo eliminar el libro\nError: "+s.getMessage();
            System.out.println("¡ERROR!, No se pudo eliminar el libro");
            System.err.println("Error: "+s.getMessage());
        }
        em.close();
        return resultado;
    }
}
