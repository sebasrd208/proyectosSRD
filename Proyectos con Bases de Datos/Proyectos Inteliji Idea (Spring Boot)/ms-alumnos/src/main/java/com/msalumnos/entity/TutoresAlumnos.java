package com.msalumnos.entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="TUTORES_ALUMNOS")
public class TutoresAlumnos implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aid_auto")
    @SequenceGenerator(name="aid_auto", sequenceName="TU_ALUMNOS_SEC", allocationSize=1)
    @Column(name="ID_TABLA", columnDefinition="NUMBER")
    private int ID_Tabla;
    @Column(name="ID_ALUMNO", columnDefinition="NUMBER")
    private int ID_Alumno;
    @Column(name="ID_TUTOR", columnDefinition="NUMBER")
    private int ID_Tutor;

    public TutoresAlumnos(){

    }

    public TutoresAlumnos(int ID_Tabla){
        super();
        this.ID_Tabla=ID_Tabla;
    }

    public int getID_Tabla(){
        return ID_Tabla;
    }

    public void setID_Tabla(int ID_Tabla){
        this.ID_Tabla=ID_Tabla;
    }

    public int getID_Alumno(){
        return ID_Alumno;
    }

    public void setID_Alumno(int ID_Alumno){
        this.ID_Alumno=ID_Alumno;
    }

    public int getID_Tutor(){
        return ID_Tutor;
    }

    public void setID_Tutor(int ID_Tutor){
        this.ID_Tutor=ID_Tutor;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }
}
