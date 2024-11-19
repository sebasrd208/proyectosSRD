package com.dao;
import com.entity.Tutores;
import com.entity.TutoresAlumnos;
import com.general.*;
import java.sql.*;
import java.util.*;

public class TutoresAlumnosDAO implements Metodos{
    Database db=new Database();
    TutoresAlumnos tutores;
    String resultado;
    @Override
    public String registrar(Object ob){
        tutores=(TutoresAlumnos)ob;
        String query="INSERT INTO TUTORES_ALUMNOS VALUES(?,?,?)";
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            psp.setInt(1, 1);
            psp.setInt(2, tutores.getID_Alumno());
            psp.setInt(3, tutores.getID_Tutor());

            int bandera=psp.executeUpdate();
            if(bandera==1){
                System.out.println("¡¡Usuario tutor agregado exitosamente!!");
                resultado="Usuario tutor agregado exitosamente";
            }else{
                System.out.println("¡¡ERROR!!, ¡¡No se pudo insertar el usuario tutor!!");
                resultado="Error al agregar";
            }
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String editar(Object ob){
        tutores=(TutoresAlumnos)ob;

        String query="UPDATE TUTORES_ALUMNOS SET ID_ALUMNO=?, ID_TUTOR WHERE ID_TABLA=?";
        try {
            Class.forName(db.getDriver());
            Connection cnn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp = cnn.prepareStatement(query);

            psp.setInt(1, tutores.getID_Tutor());
            psp.setInt(2, tutores.getID_Alumno());
            psp.setInt(3, tutores.getID_Tabla());

            int flag=psp.executeUpdate();
            if(flag==1){
                System.out.println("¡¡Usuario tutor actualizado exitosamente!!");
                resultado="Usuario tutor actualizado exitosamente";
            }else{
                System.out.println("¡ERROR!, ¡No se pudo actualizar al usuario tutor!");
                resultado="Error al actualizar";
            }
        }catch(ClassNotFoundException | SQLException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        String query="DELETE FROM TUTORES_ALUMNOS WHERE ID_TABLA="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            int bandera=psp.executeUpdate();
            if(bandera==1){
                System.out.println("¡¡Usuario tutor eliminado exitosamente!!");
                resultado="Usuario tutor eliminado exitosamente";
            }else{
                System.out.println("¡ERROR!, ¡No se pudo eliminar el usuario tutor!");
                resultado="Error al eliminar";
            }
        }catch(SQLException | ClassNotFoundException s){
            resultado=s.getMessage();
            s.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Object buscar(int ID){
        String query="SELECT * FROM TUTORES_ALUMNOS WHERE ID_TABLA="+ID;
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);

            ResultSet set=psp.executeQuery();

            while(set.next()){
                tutores=new TutoresAlumnos(set.getInt(1), set.getInt(2), set.getInt(3));
            }
            System.out.println("Tutor localizado");
        }catch(SQLException | ClassNotFoundException s){
            resultado=s.getMessage();
            s.printStackTrace();
        }
        return tutores;
    }

    @Override
    public List mostrar(){
        String query="SELECT * FROM TUTORES_ALUMNOS ORDER BY ID_TABLA";
        List<TutoresAlumnos> lista=new ArrayList<TutoresAlumnos>();
        try{
            Class.forName(db.getDriver());
            Connection cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            PreparedStatement psp=cnn.prepareStatement(query);
            ResultSet set=psp.executeQuery();

            while(set.next()){
                tutores=new TutoresAlumnos(set.getInt(1), set.getInt(2), set.getInt(3));
                lista.add(tutores);
            }

        }catch(SQLException | ClassNotFoundException s){
            resultado=s.getMessage();
            s.printStackTrace();
        }
        return lista;
    }
}
