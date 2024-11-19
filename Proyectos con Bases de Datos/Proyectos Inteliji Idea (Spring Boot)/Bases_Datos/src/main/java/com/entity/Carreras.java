package com.entity;

public class Carreras{
    private int ID_Carrera;
    private String nombre, duracion, area;
    private double presupuesto;

    public Carreras(){

    }

    public Carreras(int ID_Carrera, String nombre, String duracion, String area, double presupuesto){
        super();
        this.ID_Carrera=ID_Carrera;
        this.nombre=nombre;
        this.duracion=duracion;
        this.area=area;
        this.presupuesto=presupuesto;
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

    public double getPresupuesto(){
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto){
        this.presupuesto=presupuesto;
    }

    @Override
    public String toString(){
        return "Carreras{ ID_Carrera:"+ID_Carrera+
                ", nombre: "+nombre+
                ", duración: "+duracion+
                ", área:"+area+
                ", presupuesto="+presupuesto+
                "}";
    }
}
