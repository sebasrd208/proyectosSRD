package com.dao;
import com.dto.*;
import com.entity.*;
import com.general.*;
import java.sql.*;
import java.util.*;

public class AlumnoDAO implements Metodos{
    Connection cnn;
    PreparedStatement psp;
    ResultSet set;
    Database db=new Database();
    Alumno a;

    String resultado;

    @Override
    public String registrar(Object ob){
        a=(Alumno)ob;

        String query="INSERT INTO ESTUDIANTES VALUES(?,?,?,?,?,?,?)";
        try{
            Class.forName(db.getDriver());
            cnn= DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            psp=cnn.prepareStatement(query);

            psp.setInt(1, 1);
            psp.setString(2, a.getNombre());
            psp.setDate(3, a.getFec_nacimiento());
            psp.setString(4, a.getGenero());
            psp.setString(5, a.getGrado());
            psp.setString(6, a.getCiudad());
            psp.setInt(7, 1);

            int flag=psp.executeUpdate();
            if(flag==1){
                resultado="Alumno agregado exitosamente";
                System.out.println("¡¡Alumno agregado exitosamente!!");
            }else{
                resultado="Error al agregar";
                System.out.println("Hubo un error");
            }
        }catch(ClassNotFoundException | SQLException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String editar(Object ob){
        a=(Alumno)ob;

        String query="UPDATE ESTUDIANTES SET NOMBRE=?,"
                +" FEC_NACIMIENTO=?, GENERO=?, GRADO=?, CIUDAD=?"
                +" WHERE ID_ALUMNO=?";
        try{
            Class.forName(db.getDriver());
            cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            psp=cnn.prepareStatement(query);

            psp.setString(1, a.getNombre());
            psp.setDate(2, a.getFec_nacimiento());
            psp.setString(3, a.getGenero());
            psp.setString(4, a.getGrado());
            psp.setString(5, a.getCiudad());
            psp.setInt(6, a.getIdAlumno());

            int flag=psp.executeUpdate();
            if(flag==1){
                resultado="Alumno actualizado exitosamente";
                System.out.println("¡¡Alumno actualizado exitosamente!!");
            }else{

                resultado="Error al actualizar";
                System.out.println("Hubo un error");
            }
        }catch(ClassNotFoundException | SQLException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public String eliminar(int ID){
        String query="DELETE FROM ESTUDIANTES WHERE ID_ALUMNO="+ID;
        try{
            Class.forName(db.getDriver());
            cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            psp=cnn.prepareStatement(query);

            int flag=psp.executeUpdate();

            if(flag==1){
                resultado="Alumno eliminado exitosamente";
                System.out.println("¡¡Alumno eliminado exitosamente!!");
            }else{
                resultado="Error al eliminar";
                System.out.println("Hubo un error");
            }
        }catch(ClassNotFoundException | SQLException s){
            resultado=s.getMessage();
        }
        return resultado;
    }

    @Override
    public Object buscar(int ID){
        String query="SELECT * FROM ESTUDIANTES WHERE ID_ALUMNO="+ID;

        try{
            Class.forName(db.getDriver());
            cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            psp=cnn.prepareStatement(query);

            set=psp.executeQuery();

            while(set.next()){
                a=new Alumno(set.getInt(1), set.getString(2), set.getDate(3),set.getString(4), set.getString(5), set.getString(6), set.getInt(7));
            }
        }catch(ClassNotFoundException | SQLException s){
            s.printStackTrace();
        }
        return a;
    }

    @Override
    public List mostrar(){
        String query="SELECT * FROM ESTUDIANTES ORDER BY ID_ALUMNO";
        List<Alumno> alumnos=new ArrayList<Alumno>();

        try{
            Class.forName(db.getDriver());
            cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            psp=cnn.prepareStatement(query);

            set=psp.executeQuery();

            while(set.next()){
                a=new Alumno(set.getInt(1), set.getString(2), set.getDate(3),set.getString(4),
                        set.getString(5), set.getString(6), set.getInt(7));
                alumnos.add(a);
            }
        }catch(ClassNotFoundException | SQLException s){
            s.printStackTrace();
        }
        return alumnos;
    }

    public List datelles(){
        String query="SELECT MS.ID_CARRERA AS MATRICULA_CARRERA, MM.NOMBRE, MM.GRADO, "+
                "MS.NOMBRE AS MATERIA, MS.AREA AS CARRERA FROM ESTUDIANTES MM "+
                "INNER JOIN CARRERA_ALUMNOS MA "+
                "ON MM.ID_ALUMNO=MA.ALUMNO_ID "+
                "INNER JOIN CARRERAS MS "+
                "ON MS.ID_CARRERA=MA.CARRERA_ID";

        List<ObjetoDTO> detalles=new ArrayList<ObjetoDTO>();
        ObjetoDTO fila;
        try{
            Class.forName(db.getDriver());
            cnn=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
            psp=cnn.prepareStatement(query);

            set=psp.executeQuery();

            while(set.next()){
                fila=new ObjetoDTO(set.getInt("MATRICULA_CARRERA"), set.getString("NOMBRE"),
                        set.getString("GRADO"), set.getString("MATERIA"), set.getString("CARRERA"));
                detalles.add(fila);
            }
        }catch(ClassNotFoundException | SQLException s){
            //s.printStackTrace();
        }

        return detalles;
    }
}
