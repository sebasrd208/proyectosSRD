package com.example.CRUDEstudiantes.request;

import java.time.*;

public class EstudianteRequest{
    private int ID_Alumno;
    private String nombre;
    private LocalDateTime fecNacimiento;
    private String genero;
    private String grado;
    private String ciudad;
    private int status;

    public EstudianteRequest(){

    }

    public EstudianteRequest(int ID_Estudiante){
        super();
        this.ID_Alumno=ID_Estudiante;
    }

    public int getID_Alumno(){
        return ID_Alumno;
    }

    public void setID_Alumno(int ID_Alumno){
        this.ID_Alumno=ID_Alumno;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public LocalDateTime getFecNacimiento(){
        return fecNacimiento;
    }

    public void setFecNacimiento(LocalDateTime fecNacimiento){
        this.fecNacimiento=fecNacimiento;
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

    public void setStatus(int status) {
        this.status=status;
    }

    @Override
    public String toString() {
        return "EstudianteRequest{" +
                "ID_Alumno: "+ID_Alumno+"\n"+
                ", nombre: "+nombre+"\n"+
                ", fecNacimiento: "+fecNacimiento+"\n"+
                ", genero: "+genero+"\n"+
                ", grado: "+grado+"\n"+
                ", ciudad: "+ciudad+"\n"+
                ", status: "+status+"\n"+
                "}";
    }
}
