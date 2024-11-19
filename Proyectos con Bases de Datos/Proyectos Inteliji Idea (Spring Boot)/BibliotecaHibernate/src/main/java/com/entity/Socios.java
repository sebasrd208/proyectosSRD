package com.entity;
import javax.persistence.*;

@Entity
@Table(name="SOCIOS")
public class Socios{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cid_auto")
    @SequenceGenerator(name="cid_auto", sequenceName="SOCIOS_SEQ")
    @Column(name="ID_SOCIO", columnDefinition="NUMBER")
    private int id_socio;
    @Column(name="NOM_SOCIO", columnDefinition="NVARCHAR2(50)")
    private String nombre;
    @Column(name="DIRECCION", columnDefinition="NVARCHAR2(50)")
    private String direccion;
    @Column(name="TELEFONO", columnDefinition="NVARCHAR2(20)")
    private String telefono;

    public Socios(){

    }

    public Socios(int id_socio, String nombre, String direccion, String telefono){
        super();
        this.id_socio=id_socio;
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    public int getId_socio(){
        return id_socio;
    }

    public void setId_socio(int id_socio){
        this.id_socio=id_socio;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    @Override
    public String toString(){
        return "Socios{"+
                "id_socio="+id_socio+"\n"+
                ", nombre: "+nombre+"\n"+
                ", dirección: "+direccion+"\n"+
                ", teléfono: "+telefono+"\n"+
                "}";
    }
}
