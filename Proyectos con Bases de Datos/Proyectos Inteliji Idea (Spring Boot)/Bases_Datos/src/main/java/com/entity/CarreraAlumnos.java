package com.entity;

public class CarreraAlumnos{
    private int ID_Lista, ID_Carrera, ID_Alumno;

    public CarreraAlumnos(){

    }

    public CarreraAlumnos(int ID_Lista, int ID_Carrera, int ID_Alumno){
        super();
        this.ID_Lista=ID_Lista;
        this.ID_Carrera=ID_Carrera;
        this.ID_Alumno=ID_Alumno;
    }

    public int getID_Lista(){
        return ID_Lista;
    }

    public void setID_Lista(int ID_Lista){
        this.ID_Lista=ID_Lista;
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

    @Override
    public String toString() {
        return "CarreraAlumnos{"
                +"ID_Lista="+ID_Lista
                +", ID_Carrera="+ID_Carrera
                +", ID_Alumno="+ID_Alumno+"}";
    }
}
