package com.dao;
import com.entity.Carreras;
import com.general.*;
import java.sql.*;
import java.util.*;

public class CarrerasDAO implements Metodos{
    Database db=new Database();
    Carreras carrera;
    String resultado;
    @Override
    public String registrar(Object ob){
        carrera=(Carreras)ob;

        String query="INSERT INTO CARRERAS VALUES(?,?,?,?,?)";
        try {
            Class.forName(db.getDriver());
            Connection cnn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp = cnn.prepareStatement(query);

            psp.setInt(1, 1);
            psp.setString(2, carrera.getNombre());
            psp.setString(3, carrera.getDuracion());
            psp.setString(4, carrera.getArea());
            psp.setDouble(5, carrera.getPresupuesto());

            int flag=psp.executeUpdate();
            if(flag==1){
                resultado="Carrera agregada exitosamente";
                System.out.println("¡¡Carrera agregada exitosamente!!");
            }else{
                resultado="Error al agregar";
                System.out.println("¡ERROR!, ¡No se pudo agregar la carrera!");
            }

        }catch(ClassNotFoundException | SQLException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String editar(Object ob){
        carrera=(Carreras)ob;

        String query="UPDATE CARRERAS SET NOMBRE=?,"
                +" DURACION=?, AREA=?, P_MENSUAL=? WHERE ID_CARRERA=?";
        try {
            Class.forName(db.getDriver());
            Connection cnn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp = cnn.prepareStatement(query);

            psp.setString(1, carrera.getNombre());
            psp.setString(2, carrera.getDuracion());
            psp.setString(3, carrera.getArea());
            psp.setDouble(4, carrera.getPresupuesto());
            psp.setInt(5, carrera.getID_Carrera());

            int flag=psp.executeUpdate();
            if(flag==1){
                resultado="Carrera actualizada exitosamente";
                System.out.println("¡¡Carrera actualizada exitosamente!!");
            }else{
                resultado="Error al actualizar";
                System.out.println("¡ERROR!, ¡No se pudo actualizar la carrera!");
            }
        }catch(ClassNotFoundException | SQLException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        String query="DELETE FROM CARRERAS WHERE ID_CARRERA="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            int bandera=psp.executeUpdate();
            if(bandera==1){
                System.out.println("¡¡Carrera eliminada exitosamente!!");
                resultado="Carrera eliminada exitosamente";
            }else{
                System.out.println("¡ERROR!, ¡No se pudo eliminar la carrera!");
                resultado="Error al eliminar";
            }
        }catch(SQLException | ClassNotFoundException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public Object buscar(int ID){
        String query="SELECT * FROM CARRERAS WHERE ID_CARRERAS="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            ResultSet set=psp.executeQuery();

            while(set.next()){
                carrera=new Carreras(set.getInt(1), set.getString(2), set.getString(3),
                        set.getString(4), set.getDouble(5));
            }
            System.out.println("Carrera localizada");
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }
        return carrera;
    }

    @Override
    public List mostrar(){
        String query="SELECT * FROM CARRERAS ORDER BY ID_CARRERA";
        List<Carreras> lista=new ArrayList<Carreras>();
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);
            ResultSet set=psp.executeQuery();

            while(set.next()){
                carrera=new Carreras(set.getInt(1), set.getString(2), set.getString(3),
                        set.getString(4), set.getDouble(5));
                lista.add(carrera);
            }

        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }

        return lista;
    }
}
