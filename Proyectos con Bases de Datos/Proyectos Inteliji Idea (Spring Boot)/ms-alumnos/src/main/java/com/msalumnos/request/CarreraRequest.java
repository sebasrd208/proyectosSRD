package com.msalumnos.request;

public class CarreraRequest{
    private int ID_Carrera;
    private String nombre;
    private String duracion;
    private String area;
    private String p_mensual;

    public CarreraRequest(){

    }

    public CarreraRequest(int ID_Carrera, String nombre,
           String duracion, String area, String p_mensual){
        super();
        this.ID_Carrera=ID_Carrera;
        this.nombre=nombre;
        this.duracion=duracion;
        this.area=area;
        this.p_mensual=p_mensual;
    }

    public int getID_Carrera(){
        return ID_Carrera;
    }

    public void setID_Carrera(int ID_Carrera){
        this.ID_Carrera=ID_Carrera;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getDuracion(){
        return duracion;
    }

    public void setDuracion(String duracion){
        this.duracion=duracion;
    }

    public String getArea(){
        return area;
    }

    public void setArea(String area){
        this.area=area;
    }

    public String getP_mensual(){
        return p_mensual;
    }

    public void setP_mensual(String p_mensual){
        this.p_mensual=p_mensual;
    }

    @Override
    public String toString(){
        return "CarreraRequest{"
                +"ID_Carrera: "+ID_Carrera
                +", nombre: "+nombre
                +", duración: "+duracion
                +", area: " + area
                +", p_mensual: "+p_mensual
                +"}";
    }
}
