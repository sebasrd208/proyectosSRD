package com.msalumnos.entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="CARRERAS")
public class Carreras implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aid_auto")
    @SequenceGenerator(name="aid_auto", sequenceName="CARRERAS_SEC", allocationSize=1)
    @Column(name="ID_CARRERA", columnDefinition="NUMBER")
    private int ID_Carrera;
    @Column(name="NOMBRE", columnDefinition="NVARCHAR(50)")
    private String nombre;
    @Column(name="DURACION", columnDefinition="NVARCHAR(20)")
    private String duracion;
    @Column(name="AREA", columnDefinition="NVARCHAR(30)")
    private String area;
    @Column(name="P_MENSUAL", columnDefinition="NUMBER(8,2)")
    private String p_mensual;
    public Carreras(){

    }

    public Carreras(int IDCarrera){
        super();
        this.ID_Carrera=IDCarrera;
    }

    public int getID_Carrera() {
        return ID_Carrera;
    }

    public void setID_Carrera(int ID_Carrera) {
        this.ID_Carrera = ID_Carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getP_mensual() {
        return p_mensual;
    }

    public void setP_mensual(String p_mensual) {
        this.p_mensual = p_mensual;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }

}
