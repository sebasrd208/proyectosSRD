package com.msalumnos.request;

public class TutoresRequest{

    private int ID_Tutor;
    private String nombre, email, clave;

    public TutoresRequest(){

    }

    public TutoresRequest(int ID_Tutor, String nombre, String email, String clave){
        super();
        this.ID_Tutor=ID_Tutor;
        this.nombre=nombre;
        this.email=email;
        this.clave=clave;
    }

    public int getID_Tutor(){
        return ID_Tutor;
    }

    public void setID_Tutor(int ID_Tutor){
        this.ID_Tutor=ID_Tutor;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getClave(){
        return clave;
    }

    public void setClave(String clave){
        this.clave=clave;
    }

    @Override
    public String toString(){
        return "TutoresRequest{"
                +"ID_Tutor: "+ID_Tutor
                +", nombre: "+nombre
                +", email: "+email
                +", clave: "+clave
                +"}";
    }
}
//host.docker.internal