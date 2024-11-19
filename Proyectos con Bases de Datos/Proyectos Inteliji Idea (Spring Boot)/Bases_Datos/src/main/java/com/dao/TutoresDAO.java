package com.dao;
import com.entity.*;
import com.general.*;
import java.sql.*;
import java.util.*;

public class TutoresDAO implements Metodos{
    Database db=new Database();
    Tutores tutores;
    String resultado;
    @Override
    public String registrar(Object ob){
        tutores=(Tutores)ob;

        String query="INSERT INTO TUTORES VALUES(?,?,?,?)";
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);
            psp.setInt(1, 1);
            psp.setString(2, tutores.getNombre());
            psp.setString(3, tutores.getEmail());
            psp.setString(4, tutores.getClave());

            int flag=psp.executeUpdate();

            if(flag==1){
                resultado="Tutor agregado exitosamente";
                System.out.println("¡¡Tutor agregado exitosamente!!");
            }else{
                resultado="Error al agregar";
                System.out.println("¡ERROR!, ¡No se pudo agregar al tutor!");
            }
        }catch(ClassNotFoundException | SQLException s){
            s.printStackTrace();
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String editar(Object ob){
        tutores=(Tutores)ob;

        String query="UPDATE TUTORES SET NOMBRE=?,"
                +" EMAIL=?, CLAVE=? WHERE ID_TUTOR=?";
        try{
            Class.forName(db.getDriver());
            Connection cnn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp = cnn.prepareStatement(query);

            psp.setString(1, tutores.getNombre());
            psp.setString(2, tutores.getEmail());
            psp.setString(3, tutores.getClave());
            psp.setInt(4, tutores.getID_Tutor());

            int flag=psp.executeUpdate();
            if(flag==1){
                resultado="Tutor actualizado exitosamente";
                System.out.println("¡¡Tutor actualizado exitosamente!!");
            }else{
                resultado="Error al actualizar";
                System.out.println("¡ERROR!, ¡No se pudo actualizar al tutor!");
            }
        }catch(ClassNotFoundException | SQLException s){
            s.printStackTrace();
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        String query="DELETE FROM TUTORES WHERE ID_TUTOR="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            int bandera=psp.executeUpdate();
            if(bandera==1){
                System.out.println("¡¡Tutor eliminado exitosamente!!");
                resultado="Tutor eliminado exitosamente";
            }else{
                System.out.println("¡ERROR!, ¡No se pudo eliminar al tutor!");
                resultado="Error al eliminar";
            }
        }catch(SQLException | ClassNotFoundException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public Object buscar(int ID){
        String query="SELECT * FROM TUTORES WHERE ID_TUTOR="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            ResultSet set=psp.executeQuery();

            while(set.next()){
                tutores=new Tutores(set.getInt(1), set.getString(2), set.getString(3),
                        set.getString(4));
            }
            System.out.println("Tutor localizado");
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }
        return tutores;
    }

    @Override
    public List mostrar(){
        String query="SELECT * FROM TUTORES ORDER BY ID_TUTOR";
        List<Tutores> lista=new ArrayList<Tutores>();
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);
            ResultSet set=psp.executeQuery();

            while(set.next()){
                tutores=new Tutores(set.getInt(1), set.getString(2), set.getString(3),
                        set.getString(4));
                lista.add(tutores);
            }

        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }

        return lista;
    }
}
