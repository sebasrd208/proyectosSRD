package basehospital;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Conexion{
    //Conexion local
    public static Connection conectar(){
        try{
            Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            return cnn;
        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "Conectáte a la base de datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: "+s);
        }
        return (null);
    }
}
