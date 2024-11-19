package bases;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author sebas
 */
public class Consultas extends JFrame implements ActionListener{
    private JLabel ticket, ticket2, ticket3;
    private JTextField nombre, grupo, id;
    private JButton registrar, modificar,
            eliminar, buscar;
            
    public Consultas(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Registros BD");
        
        BevelBorder border=new BevelBorder(0);
        Font estilo=new Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("Nombre:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(estilo);
        add(ticket);
        
        nombre=new JTextField();
        nombre.setBounds(10, 35, 120, 25);
        nombre.setBorder(border);
        nombre.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        nombre.setFont(estilo);
        add(nombre);
        
        ticket2=new JLabel("Grupo:");
        ticket2.setBounds(10, 70, 80, 25);
        ticket2.setFont(estilo);
        add(ticket2);
        
        grupo=new JTextField();
        grupo.setBounds(10, 95, 120, 25);
        grupo.setBorder(border);
        grupo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        grupo.setFont(estilo);
        add(grupo);
        
        registrar=new JButton("Registrar");
        registrar.setBounds(10, 130, 100, 25);
        registrar.setFont(estilo);
        registrar.setBorder(border);
        registrar.setFocusPainted(false);
        registrar.addActionListener(this);
        add(registrar);
        
        modificar=new JButton("Modificar");
        modificar.setBounds(120, 130, 100, 25);
        modificar.setFont(estilo);
        modificar.setBorder(border);
        modificar.setFocusPainted(false);
        modificar.addActionListener(this);
        add(modificar);
        
        eliminar=new JButton("Eliminar");
        eliminar.setBounds(230, 130, 100, 25);
        eliminar.setFont(estilo);
        eliminar.setBorder(border);
        eliminar.setFocusPainted(false);
        eliminar.addActionListener(this);
        add(eliminar);
        
        ticket3=new JLabel("ID del Alumno:");
        ticket3.setBounds(10, 165, 120, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        id=new JTextField();
        id.setBounds(100, 165, 120, 25);
        id.setBorder(border);
        id.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        id.setFont(estilo);
        add(id);
        
        buscar=new JButton("Buscar");
        buscar.setBounds(10, 200, 100, 25);
        buscar.setFont(estilo);
        buscar.setBorder(border);
        buscar.setFocusPainted(false);
        buscar.addActionListener(this);
        add(buscar);
    }
    
    public void actionPerformed(ActionEvent s){
        if(s.getSource()==registrar){
            String sakura=nombre.getText().trim();
            String nagisa=grupo.getText().trim();
            if(nagisa.equals("") & sakura.equals("")){
                JOptionPane.showMessageDialog(null, "No se permiten espacios vacíos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost/consultas", "root", "");
                    PreparedStatement psp=cnn.prepareStatement("insert into alumnos values(?,?,?)");
                
                    psp.setString(1, "0");
                    psp.setString(2, nombre.getText().trim());
                    psp.setString(3, grupo.getText().trim());
            
                    psp.executeUpdate();
                    
                    nombre.setText("");
                    grupo.setText("");
                    JOptionPane.showMessageDialog(null, "¡¡Registro exitoso!!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }
        }else if(s.getSource()==modificar){
            
        }else if(s.getSource()==eliminar){
            
        }else if(s.getSource()==buscar){
            String nezuko=id.getText().trim();
            if(nezuko.equals("")){
                JOptionPane.showMessageDialog(null, "No se permiten espacios vacíos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost/consultas", "root", "");
                    PreparedStatement psp=cnn.prepareStatement("select * from alumnos where ID_Alumnos=?");

                    psp.setString(1, nezuko);
                    ResultSet set=psp.executeQuery();
                    
                    if(set.next()){
                        nombre.setText(set.getString("alumno"));
                        grupo.setText(set.getString("grupo"));
                    }else{
                        JOptionPane.showMessageDialog(null, "Alumno no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        nombre.setText("");
                        grupo.setText("");
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args){
        Consultas query=new Consultas();
        query.setBounds(0, 0, 400, 300);
        query.setVisible(true);
        query.setResizable(false);
        query.setLocationRelativeTo(null);
    }
}
