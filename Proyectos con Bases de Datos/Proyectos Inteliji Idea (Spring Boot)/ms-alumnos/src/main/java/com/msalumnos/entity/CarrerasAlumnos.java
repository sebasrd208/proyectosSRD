package com.msalumnos.entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="CARRERA_ALUMNOS")
public class CarrerasAlumnos implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aid_auto")
    @SequenceGenerator(name="aid_auto", sequenceName="CARRERAS_ALUMNO_SEC", allocationSize=1)
    @Column(name="CA_ID", columnDefinition="NUMBER")
    private int Ca_ID;
    @Column(name="CARRERA_ID", columnDefinition="NUMBER")
    private int ID_Carrera;
    @Column(name="ALUMNO_ID", columnDefinition="NUMBER")
    private int ID_Alumno;

    public CarrerasAlumnos(){

    }

    public CarrerasAlumnos(int ca_ID){
        super();
        this.Ca_ID=ca_ID;
    }

    public int getCa_ID(){
        return Ca_ID;
    }

    public void setCa_ID(int ca_ID){
        this.Ca_ID=ca_ID;
    }

    public int getID_Carrera(){
        return ID_Carrera;
    }

    public void setID_Carrera(int ID_Carrera){
        this.ID_Carrera=ID_Carrera;
    }

    public int getID_Alumno(){
        return ID_Alumno;
    }

    public void setID_Alumno(int ID_Alumno){
        this.ID_Alumno=ID_Alumno;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }
}
