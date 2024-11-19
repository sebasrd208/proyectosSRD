package com.entity;
import javax.persistence.*;

@Entity
@Table(name="AUTORES")
public class Autores{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cid_auto")
    @SequenceGenerator(name="cid_auto", sequenceName="AUTORES_SEQ")
    @Column(name="ID_AUTOR", columnDefinition="NUMBER")
    private int ID_Autor;
    @Column(name="NOMBRE", columnDefinition="NVARCHAR2(100)")
    private String nombre;
    @Column(name="NACIONALIDAD", columnDefinition="NVARCHAR2(50)")
    private String nacionalidad;

    public Autores(){

    }

    public Autores(int ID_Autor){
        super();
        this.ID_Autor=ID_Autor;
    }

    public int getID_Autor(){
        return ID_Autor;
    }

    public void setID_Autor(int ID_Autor){
        this.ID_Autor=ID_Autor;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }

    @Override
    public String toString(){
        return "Autores{"+
                "ID_Autor: "+ID_Autor+"\n"+
                ", nombre: "+nombre +"\n"+
                ", nacionalidad: "+nacionalidad+"\n"+
                "}";
    }
}
