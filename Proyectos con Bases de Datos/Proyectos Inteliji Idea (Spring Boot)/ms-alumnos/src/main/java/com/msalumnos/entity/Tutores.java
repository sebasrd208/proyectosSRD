package com.msalumnos.entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="TUTORES")
public class Tutores implements Serializable{

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aid_auto")
    @SequenceGenerator(name="aid_auto", sequenceName="TUTORES_SEQ", allocationSize=1)
    @Column(name="ID_TUTOR", columnDefinition="NUMBER")
    private int ID_Tutor;
    @Column(name="NOMBRE", columnDefinition="NVARCHAR2(30)")
    private String nombre;
    @Column(name="EMAIL", columnDefinition="NVARCHAR2(40)")
    private String email;
    @Column(name="CLAVE", columnDefinition="NVARCHAR2(1)")
    private String clave;

    public Tutores(){

    }

    public Tutores(int ID_Tutor){
        super();
        this.ID_Tutor=ID_Tutor;
    }

    public int getID_Tutor(){
        return ID_Tutor;
    }

    public void setID_Tutor(int ID_Tutor){
        this.ID_Tutor=ID_Tutor;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getClave(){
        return clave;
    }

    public void setClave(String clave){
        this.clave=clave;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }
}
