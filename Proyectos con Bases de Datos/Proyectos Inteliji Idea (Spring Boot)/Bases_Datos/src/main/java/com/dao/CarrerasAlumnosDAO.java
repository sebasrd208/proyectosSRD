package com.dao;
import com.entity.CarreraAlumnos;
import com.general.*;
import java.sql.*;
import java.util.*;
public class CarrerasAlumnosDAO implements Metodos{
    Database db=new Database();
    CarreraAlumnos carrera;
    String resultado;
    @Override
    public String registrar(Object ob){
        carrera=(CarreraAlumnos)ob;

        String query="INSERT INTO CARRERA_ALUMNOS VALUES(?,?,?)";
        try {
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            psp.setInt(1, 1);
            psp.setInt(2, carrera.getID_Carrera());
            psp.setInt(3, carrera.getID_Alumno());

            int flag=psp.executeUpdate();

            if(flag==1){
                resultado="Usuario agregado exitosamente";
                System.out.println("¡¡Usuario agregado exitosamente!!");
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
        carrera=(CarreraAlumnos)ob;

        String query="UPDATE CARRERA_ALUMNOS SET CARRERA_ID=?, ALUMNO_ID=? WHERE CA_ID=?";
        try {
            Class.forName(db.getDriver());
            Connection cnn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp = cnn.prepareStatement(query);

            psp.setInt(1, carrera.getID_Carrera());
            psp.setInt(2, carrera.getID_Alumno());
            psp.setInt(3, carrera.getID_Lista());

            int flag=psp.executeUpdate();
            if(flag==1){
                resultado="Usuario actualizado exitosamente";
                System.out.println("¡¡Usuario actualizado exitosamente!!");
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
        String query="DELETE FROM CARRERA_ALUMNOS WHERE CA_ID="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            int bandera=psp.executeUpdate();
            if(bandera==1){
                System.out.println("¡¡Usuario eliminado exitosamente!!");
                resultado="Usuario eliminado exitosamente";
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
        String query="SELECT * FROM CARRERA_ALUMNOS WHERE CA_ID="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            ResultSet set=psp.executeQuery();

            while(set.next()){
                carrera=new CarreraAlumnos(set.getInt(1), set.getInt(2), set.getInt(3));
            }
            System.out.println("Usuario localizado");
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }
        return carrera;
    }

    @Override
    public List mostrar(){
        String query="SELECT * FROM CARRERA_ALUMNOS ORDER BY CA_ID";
        List<CarreraAlumnos> lista=new ArrayList<CarreraAlumnos>();
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);
            ResultSet set=psp.executeQuery();

            while(set.next()){
                carrera=new CarreraAlumnos(set.getInt(1), set.getInt(2), set.getInt(3));
                lista.add(carrera);
            }

        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }

        return lista;
    }
}
