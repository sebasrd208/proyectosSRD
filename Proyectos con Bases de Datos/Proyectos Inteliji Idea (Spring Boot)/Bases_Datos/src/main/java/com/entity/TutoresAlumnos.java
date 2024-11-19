package com.entity;

public class TutoresAlumnos{
    private int ID_Tabla, ID_Alumno, ID_Tutor;

    public TutoresAlumnos(){

    }

    public TutoresAlumnos(int ID_Tabla, int ID_Alumno, int ID_Tutor){
        super();
        this.ID_Tabla=ID_Tabla;
        this.ID_Alumno=ID_Alumno;
        this.ID_Tutor=ID_Tutor;
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

    @Override
    public String toString(){
        return "TutoresAlumnos{"
                +"ID_Tabla: "+ID_Tabla
                +", ID_Alumno: "+ID_Alumno
                +", ID_Tutor: "+ID_Tutor
                +"}";
    }
}
