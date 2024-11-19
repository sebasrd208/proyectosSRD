package com.entity;
import java.sql.*;

public class Alumno{
    private int idAlumno;
    private String nombre, genero, grado, ciudad;
    private Date fec_nacimiento;
    private int status;

    public Alumno(){

    }

    public Alumno(int idAlumno, String nombre, Date fec_nacimiento,
                  String genero, String grado, String ciudad, int status){
        super();
        this.idAlumno=idAlumno;
        this.nombre=nombre;
        this.fec_nacimiento=fec_nacimiento;
        this.genero=genero;
        this.grado=grado;
        this.ciudad=ciudad;
    }

    public int getIdAlumno(){
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno){
        this.idAlumno=idAlumno;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public java.sql.Date getFec_nacimiento(){
        return fec_nacimiento;
    }

    public void setFec_nacimiento(Date fec_nacimiento){
        this.fec_nacimiento=fec_nacimiento;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public String getGrado(){
        return grado;
    }

    public void setGrado(String grado){
        this.grado=grado;
    }

    public String getCiudad(){
        return ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }

    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status=status;
    }

    @Override
    public String toString(){
        return "Alumno{"+"idAlumno="+idAlumno+"\n" +
                ", nombre="+nombre+"\n" +
                ", fec_nacimiento="+fec_nacimiento+"\n"+
                ", genero="+genero+"\n"+
                ", grado="+grado+"\n"+
                ", ciudad="+ciudad+"\n"+
                ", status="+status+"\n"+
                "}";
    }
}
