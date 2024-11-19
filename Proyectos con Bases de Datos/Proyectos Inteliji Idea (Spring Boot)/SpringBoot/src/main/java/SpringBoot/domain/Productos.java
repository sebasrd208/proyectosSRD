package SpringBoot.domain;

public class Productos{

    private Integer ID;
    private String nom;
    private Double precio;
    private Integer unidad;

    public Productos(){

    }

    public Productos(Integer ID, String nom, Double precio, Integer unidad) {
        this.ID = ID;
        this.nom = nom;
        this.precio = precio;
        this.unidad = unidad;
    }

    public Integer getID(){
        return ID;
    }

    public void setID(Integer ID){
        this.ID=ID;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public Double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio=precio;
    }

    public Integer getUnidad(){
        return unidad;
    }

    public void setUnidad(Integer unidad){
        this.unidad=unidad;
    }
}
