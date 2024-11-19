package proyecto_ceteq;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author sebas
 */
public class Grafica extends JFrame{
    private JLabel fondo;
    int alumno, carreras, carreras_alumnos, tutores, tutores_alumnos;
    String[] nombre=new String[5];
    int[] cantidad=new int[5];
    
    //Conexión a la base de datos
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user="Sebastian";
    String password="admin";
    
    public Grafica(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon image=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(image.getImage());
        setTitle("Grafica de Alumnos");
        
        try{
            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("SELECT NOMBRE, COUNT(NOMBRE) AS STUDENT FROM ESTUDIANTES GROUP BY NOMBRE");
            
            ResultSet set=psp.executeQuery();
            
            if(set.next()){
                int pos=0;
                do{
                    nombre[pos]=set.getString(1);
                    cantidad[pos]=set.getInt(2);
                    
                    if(nombre[pos].equalsIgnoreCase("Alumnos")){
                        alumno=cantidad[pos];
                    }else if(nombre[pos].equalsIgnoreCase("Carreras")){
                        carreras=cantidad[pos];
                    }else if(nombre[pos].equalsIgnoreCase("Carreras Alumnos")){
                        carreras_alumnos=cantidad[pos];
                    }else if(nombre[pos].equalsIgnoreCase("Tutores")){
                        tutores=cantidad[pos];
                    }else if(nombre[pos].equalsIgnoreCase("Tutores Alumnos")){
                        tutores_alumnos=cantidad[pos];
                    }
                    
                    pos++;
                }while(set.next());
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no localizados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: "+e.getMessage());
        }
        
        ImageIcon imagen=new ImageIcon("src/imagenes/fondo2.jpg");
        fondo=new JLabel(imagen);
        fondo.setBounds(0, 0, 400, 400);
        add(fondo);
        
    }
    
    public static void main(String[] args){
        Grafica grafos=new Grafica();
        grafos.setBounds(0, 0, 400, 400);
        grafos.setVisible(true);
        grafos.setResizable(false);
        grafos.setLocationRelativeTo(null);
    }
}
