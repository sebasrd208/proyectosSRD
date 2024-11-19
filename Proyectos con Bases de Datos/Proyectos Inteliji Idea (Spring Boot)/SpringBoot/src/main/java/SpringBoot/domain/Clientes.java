package SpringBoot.domain;
//Clase POJO
public class Clientes{
    private int ID;
    private String nombre, usuario, contrasena;

    public Clientes(int ID, String name, String username, String password){
        super();
        this.nombre=name;
        this.usuario=username;
        this.contrasena=password;
        this.ID=ID;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario=usuario;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }

}
