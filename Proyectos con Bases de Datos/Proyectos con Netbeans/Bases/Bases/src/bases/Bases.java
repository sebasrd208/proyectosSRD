package bases;

import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;

/**
 *
 * @author sebas
 */

class Conexion{

    public Connection conexion;
    public Statement sentencia;
    public ResultSet set;

    public void ConectarBases(String stella){
        try{
            final String controlador="com.mysql.jdbc.Driver";
            Class.forName(controlador);
            final String bd="jdbc:mysql://localhost/";
            final String bd2="jdbc:mysql://localhost/"+stella;
            if(stella.equals("")){
                conexion=DriverManager.getConnection(bd, "root", "");
            }else{
                conexion=DriverManager.getConnection(bd2, "root", "");
            }
            sentencia=conexion.createStatement();

        }catch(ClassNotFoundException | SQLException s){
            JOptionPane.showMessageDialog(null, "Error al crear base: "+s.getMessage(),
                "Excepcion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Desconectar(){
        try{
            if(conexion!=null){
                if(sentencia!=null){
                    sentencia.close();
                }
                conexion.close();
            }
        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "Error al crear base: " + s.getMessage(),
                    "Excepcion", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection(){
        return conexion;
    }
 }

public class Bases extends JFrame implements ActionListener{

    private JLabel ticket;
    private JTextField txt, nombre, cantidad;
    private JButton btn, mostrar, table, insertar, borrar;
    private JTable tabla;
    private JScrollPane scroll;
    DefaultTableModel modulo=new DefaultTableModel();
    public static String texto="", datos="", n="";
    public static int num=0;
    
    public Bases() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bases de datos");

        ticket=new JLabel("Nombre:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(new Font("Sylfaen", 1, 12));
        add(ticket);

        txt=new JTextField();
        txt.setBounds(80, 10, 150, 25);
        txt.setFont(new Font("Sylfaen", 1, 12));
        txt.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        txt.setBorder(new BevelBorder(0));
        add(txt);

        btn=new JButton("Crear base");
        btn.setBounds(20, 45, 100, 25);
        btn.setFont(new Font("Sylfaen", 1, 12));
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        btn.setBorder(new BevelBorder(0));
        add(btn);

        mostrar=new JButton("Mostrar bases");
        mostrar.setBounds(130, 45, 100, 25);
        mostrar.setFont(new Font("Sylfaen", 1, 12));
        mostrar.addActionListener(this);
        mostrar.setFocusPainted(false);
        mostrar.setBorder(new BevelBorder(0));
        add(mostrar);

        tabla=new JTable(modulo);
        scroll=new JScrollPane(tabla);
        scroll.setBounds(10, 80, 150, 120);
        add(scroll);
        
        borrar=new JButton("Borrar base");
        borrar.setBounds(163, 120, 90, 25);
        borrar.setFont(new Font("Sylfaen", 1, 12));
        borrar.addActionListener(this);
        borrar.setFocusPainted(false);
        borrar.setBorder(new BevelBorder(0));
        add(borrar);
        
        table=new JButton("Crear tabla");
        table.setBounds(10, 290, 100, 25);
        table.setFont(new Font("Sylfaen", 1, 12));
        table.addActionListener(this);
        table.setFocusPainted(false);
        table.setBorder(new BevelBorder(0));
        add(table);
        
        insertar=new JButton("Insertar");
        insertar.setBounds(130, 290, 100, 25);
        insertar.setFont(new Font("Sylfaen", 1, 12));
        insertar.addActionListener(this);
        insertar.setFocusPainted(false);
        insertar.setBorder(new BevelBorder(0));
        add(insertar);
        
        ticket=new JLabel("Tabla:");
        ticket.setBounds(10, 230, 80, 25);
        ticket.setFont(new Font("Sylfaen", 1, 12));
        add(ticket);
        
        nombre=new JTextField();
        nombre.setBounds(10, 255, 100, 25);
        nombre.setFont(new Font("Sylfaen", 1, 12));
        nombre.setBorder(new BevelBorder(0));
        add(nombre);

        ticket=new JLabel("Cantidad:");
        ticket.setBounds(130, 230, 80, 25);
        ticket.setFont(new Font("Sylfaen", 1, 12));
        add(ticket);
        
        cantidad=new JTextField();
        cantidad.setBounds(130, 255, 100, 25);
        cantidad.setFont(new Font("Sylfaen", 1, 12));
        cantidad.setBorder(new BevelBorder(0));
        add(cantidad);
        
        tabla.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent s){
                int seleccionar=tabla.rowAtPoint(s.getPoint());
                String base=String.valueOf(tabla.getValueAt(seleccionar, 0));
                
                Tablas table=new Tablas();
                table.tabla.setText("");
                txt.setText(base);
            }
        });
        
    }

    public void actionPerformed(ActionEvent s){
        Conexion c=new Conexion();
        if(s.getSource()==btn){
            texto=txt.getText().trim();
            if(texto.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa un nombre, cabrón", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    c.ConectarBases("");
                    c.sentencia.execute("create database "+texto);
                    JOptionPane.showMessageDialog(null, "La base de datos "+texto+"\nha sido creada exitosamente",
                             "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txt.setText("");
                    
                    Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
                    PreparedStatement psp=cnn.prepareStatement("show databases");
                
                    ResultSet set=psp.executeQuery();
                
                    scroll.setViewportView(tabla);
                    modulo.setColumnCount(0);
                    modulo.setRowCount(0);
                    modulo.addColumn("Bases");
                    while(set.next()){
                        Object[] fila=new Object[1];
                        for(int i=0;i<1;i++){
                            fila[i]=set.getObject(i+1);
                        }
                    modulo.addRow(fila);
                    }
                    cnn.close();
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al crear base: " + e.getMessage(),
                            "Excepcion", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(s.getSource()==mostrar){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
                PreparedStatement psp=cnn.prepareStatement("show databases");
                
                ResultSet set=psp.executeQuery();
                
                scroll.setViewportView(tabla);
                modulo.setColumnCount(0);
                modulo.setRowCount(0);
                modulo.addColumn("Bases");
                while(set.next()){
                    Object[] fila=new Object[1];
                    for(int i=0;i<1;i++){
                        fila[i]=set.getObject(i+1);
                    }
                    modulo.addRow(fila);
                }
                cnn.close();
                mostrar.setText("Actualizar bases");
            }catch(SQLException d){
                JOptionPane.showMessageDialog(null, "Error al mostrar las bases: "+d.getMessage(),
                        "Excepcion", JOptionPane.ERROR_MESSAGE);
            }
        }else if(s.getSource()==borrar){
            texto=txt.getText().trim();
            if(texto.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa datos cabrón");
            }else{
                try{
                    int silvia=JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar la base de datos: "+texto+"?"
                            ,"Advertencia", JOptionPane.YES_NO_OPTION);
                    if(silvia==JOptionPane.YES_OPTION){
                        c.ConectarBases("");
                        c.sentencia.execute("drop database "+texto);
                        JOptionPane.showMessageDialog(null, "La base de datos "+texto+"\nfue eliminado con exito"
                                , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txt.setText("");
                        Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
                        PreparedStatement psp=cnn.prepareStatement("show databases");
                
                        ResultSet set=psp.executeQuery();
                
                        scroll.setViewportView(tabla);
                        modulo.setColumnCount(0);
                        modulo.setRowCount(0);
                        modulo.addColumn("Bases");
                        while(set.next()){
                            Object[] fila=new Object[1];
                            for(int i=0;i<1;i++){
                                fila[i]=set.getObject(i+1);
                            }
                        modulo.addRow(fila);
                        }
                        cnn.close();
                    }
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al eliminar base: "+e.getMessage()
                            , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else if(s.getSource()==table){
            texto=txt.getText().trim();
            n=nombre.getText().trim();
            datos=cantidad.getText().trim();
            if(texto.equals("") && datos.equals("") && n.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa datos, cabrón"
                        , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Tablas kunugigaoka=new Tablas();
                kunugigaoka.setBounds(0, 0, 800, 200);
                kunugigaoka.setVisible(true);
                kunugigaoka.setResizable(false);
                kunugigaoka.setLocationRelativeTo(null);
            }
        }else if(s.getSource()==insertar){
            texto=txt.getText().trim();
            if(texto.equals("")){
                JOptionPane.showMessageDialog(null, "Ingresa datos, cabrón"
                        , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, " "+e.getMessage(), 
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args){
        Bases bd=new Bases();
        bd.setBounds(0, 0, 270, 400);
        bd.setVisible(true);
        bd.setResizable(false);
        bd.setLocationRelativeTo(null);
    }
}
