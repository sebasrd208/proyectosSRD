package com.msalumnos.request;

public class CarrerasAlumnosRequest{
    private int Ca_ID, ID_Carrera, ID_Alumno;

    public CarrerasAlumnosRequest(){

    }

    public CarrerasAlumnosRequest(int ca_ID, int ID_Carrera, int ID_Alumno){
        super();
        this.Ca_ID = ca_ID;
        this.ID_Carrera = ID_Carrera;
        this.ID_Alumno = ID_Alumno;
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

    @Override
    public String toString() {
        return "CarrerasAlumnosRequest{"
            +"Ca_ID: "+Ca_ID
            +", ID_Carrera: "+ID_Carrera
            +", ID_Alumno: "+ID_Alumno
            +"}";
    }
}
