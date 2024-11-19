package biblioteca;
import com.itextpdf.text.pdf.*;
import javax.swing.border.*;
import com.itextpdf.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author sebas
 */
public class Socios extends JFrame implements ActionListener{
    private JLabel ticket, ticket2, ticket3, 
            ticket4, fondo;
    public static JTextField nombre, direccion, telefono, ID;
    public static JButton registrar, modificar,
            eliminar, buscar, borrar, generar;
    
    public Socios(){
        setLayout(null);
        int sesion=Biblioteca.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        setTitle("BD Tutores");
        ImageIcon icono=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(icono.getImage());
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("Nombre:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(estilo);
        add(ticket);
        
        nombre=new JTextField();
        nombre.setBounds(10, 35, 150, 25);
        nombre.setBorder(border);
        nombre.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBtn();
            }
        });
        nombre.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        nombre.setFont(estilo);
        add(nombre);
        
        ticket2=new JLabel("Dirección:");
        ticket2.setBounds(170, 10, 80, 25);
        ticket2.setFont(estilo);
        add(ticket2);
        
        direccion=new JTextField();
        direccion.setBounds(170, 35, 220, 25);
        direccion.setBorder(border);
        direccion.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBtn();
            }
        });
        direccion.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        direccion.setFont(estilo);
        add(direccion);
        
        ticket3=new JLabel("Teléfono:");
        ticket3.setBounds(10, 70, 150, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        telefono=new JTextField();
        telefono.setBounds(10, 95, 120, 25);
        telefono.setBorder(border);
        telefono.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBtn();
            }
            
            @Override
            public void keyTyped(KeyEvent s){
                int llave=s.getKeyChar();
                String phone=telefono.getText().trim();
                if(!(llave>=48 & llave<=57)){
                    s.consume();
                }
                
                if(phone.length()>=10){
                    s.consume();
                }
            }
        });
        telefono.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        telefono.setFont(estilo);
        add(telefono);
        
        borrar=new JButton("Limpiar todo");
        borrar.setBounds(140, 95, 120, 25);
        borrar.setFont(estilo);
        borrar.setBorder(border);
        borrar.setEnabled(false);
        borrar.setFocusPainted(false);
        borrar.addActionListener(this);
        add(borrar);
        
        eliminar=new JButton("Eliminar");
        eliminar.setBounds(270, 95, 120, 25);
        eliminar.setFont(estilo);
        eliminar.setEnabled(false);
        eliminar.setBorder(border);
        eliminar.setFocusPainted(false);
        eliminar.addActionListener(this);
        add(eliminar);
        
        registrar=new JButton("Registrar");
        registrar.setBounds(10, 130, 100, 25);
        registrar.setFont(estilo);
        registrar.setBorder(border);
        registrar.setEnabled(false);
        registrar.setFocusPainted(false);
        registrar.addActionListener(this);
        add(registrar);
        
        modificar=new JButton("Modificar");
        modificar.setBounds(120, 130, 100, 25);
        modificar.setFont(estilo);
        modificar.setBorder(border);
        modificar.setEnabled(false);
        modificar.setFocusPainted(false);
        modificar.addActionListener(this);
        add(modificar);
        
        generar=new JButton("Generar PDF de Tutores");
        generar.setBounds(230, 130, 180, 25);
        generar.setFont(estilo);
        generar.setBorder(border);
        generar.setFocusPainted(false);
        generar.addActionListener(this);
        add(generar);
        
        ticket4=new JLabel("ID del Socio:");
        ticket4.setBounds(10, 165, 120, 25);
        ticket4.setFont(estilo);
        add(ticket4);
        
        ID=new JTextField();
        ID.setBounds(100, 165, 120, 25);
        ID.setBorder(border);
        ID.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                String busqueda=ID.getText().trim();
                if(busqueda.equals("")){
                    buscar.setEnabled(false);
                }else{
                    buscar.setEnabled(true);
                }
                habilitarBtn();
            }
            
            @Override
            public void keyTyped(KeyEvent s){
                int llave=s.getKeyChar();
                String busqueda=ID.getText().trim();
                if(!(llave>=48 & llave<=57)){
                    s.consume();
                }
                
                if(busqueda.length()>=4){
                    s.consume();
                }
            }
        });
        ID.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        ID.setFont(estilo);
        add(ID);
        
        buscar=new JButton("Buscar");
        buscar.setBounds(230, 165, 100, 25);
        buscar.setFont(estilo);
        buscar.setBorder(border);
        buscar.setEnabled(false);
        buscar.setFocusPainted(false);
        buscar.addActionListener(this);
        add(buscar);
        
        ImageIcon imagen=new ImageIcon("src/imagenes/escuela.jpg");
        fondo=new JLabel(imagen);
        fondo.setBounds(0, 0, 440, 300);
        add(fondo);
    }
    
    public Icon icono(String camino, int a, int o){
        Icon imagen=new ImageIcon(new ImageIcon(getClass().getResource(camino))
        .getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    public void metodo(){
        Biblioteca.model.setRowCount(0);
        Biblioteca.model.setColumnCount(0);        
        try{
            Connection cnn=DriverManager.getConnection(Biblioteca.url, Biblioteca.user, Biblioteca.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM SOCIOS ORDER BY ID_SOCIO");

            ResultSet set=psp.executeQuery();

            Biblioteca.model.addColumn("ID del Socio");
            Biblioteca.model.addColumn("Nombre");
            Biblioteca.model.addColumn("Dirección");
            Biblioteca.model.addColumn("Teléfono");
                    
            while(set.next()){
                Object[] fila=new Object[4];
                for(int i=0;i<4;i++){
                    fila[i]=set.getObject(i+1);
                }
                Biblioteca.model.addRow(fila);
            }
            cnn.close();
        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: "+s.getMessage());
        }
    }
    
    public void habilitarBtn(){
        String name=nombre.getText().trim();
        String direction=direccion.getText().trim();
        String phone=telefono.getText().trim();
        if(name.equals("") | direction.equals("") | phone.equals("")){
            modificar.setEnabled(false);
        }else{
            modificar.setEnabled(true);
        }
        
        if(name.equals("") | direction.equals("") | phone.equals("")){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
        
        if(name.equals("") | direction.equals("") | phone.equals("")){
            borrar.setEnabled(false);
        }else{
            borrar.setEnabled(true);
        }
        
        if(name.equals("") | direction.equals("") | phone.equals("")){
            eliminar.setEnabled(false);
        }else{
            eliminar.setEnabled(true);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="Sebastian";
        String password="admin";
        if(s.getSource()==registrar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("INSERT INTO SOCIOS VALUES(?,?,?,?)");
                
                psp.setInt(1, 1);
                psp.setString(2, nombre.getText().trim());
                psp.setString(3, direccion.getText().trim());
                psp.setString(4, telefono.getText().trim());
                
                if(psp.executeUpdate()==1){
                    nombre.setBackground(Color.green);
                    direccion.setBackground(Color.green);
                    telefono.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Socio insertado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el socio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "Error al registrar socio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e);
            }
        }else if(s.getSource()==modificar){
            String[] op={"Si", "No"};
            int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), op, op[0]);
            if(modify==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("UPDATE SOCIOS SET NOM_SOCIO=?, DIRECCION=?, TELEFONO=? WHERE ID_SOCIO="+ID.getText().trim());
                    
                    psp.setString(1, nombre.getText().trim());
                    psp.setString(2, direccion.getText().trim());
                    psp.setString(3, telefono.getText().trim());
                    
                    if(psp.executeUpdate()==1){
                        nombre.setBackground(Color.green);
                        direccion.setBackground(Color.green);
                        telefono.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Socio actualizado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el socio",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar socio",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
                if(Biblioteca.sesion==1){
                    metodo();
                }else{
                    
                }
            }
        }else if(s.getSource()==eliminar){
            String[] op={"Si", "No"};
            int delete=JOptionPane.showOptionDialog(null, "¿Estas seguro de eliminar este socio?", "Advertencia", 
                    JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
            if(delete==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("DELETE FROM SOCIOS WHERE ID_SOCIO="+ID.getText());
                    
                    if(psp.executeUpdate()==1){
                        nombre.setText("");
                        direccion.setText("");
                        telefono.setText("");
                        ID.setText("");
                        registrar.setEnabled(false);
                        modificar.setEnabled(false);
                        eliminar.setEnabled(false);
                        borrar.setEnabled(false);
                        buscar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Socio eliminado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el socio");
                    }
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al eliminar socio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e);
                }
            }
        }else if(s.getSource()==buscar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM SOCIOS WHERE ID_SOCIO="+ID.getText().trim());
                    
                ResultSet set=psp.executeQuery();
                    
                if(set.next()){
                    nombre.setText(set.getString("NOM_SOCIO")); 
                    direccion.setText(set.getString("DIRECCION"));
                    telefono.setText(set.getString("TELEFONO"));
                    borrar.setEnabled(true);
                    registrar.setEnabled(true);
                    modificar.setEnabled(true);
                    eliminar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Socio no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    nombre.setText(""); 
                    direccion.setText(""); 
                    telefono.setText("");
                    ID.setText("");
                    registrar.setEnabled(false);
                    modificar.setEnabled(false);
                    eliminar.setEnabled(false);
                    borrar.setEnabled(false);
                    buscar.setEnabled(false);;
                }
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar socio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
        }else if(s.getSource()==borrar){
            ID.setText("");
            nombre.setText("");
            direccion.setText("");
            telefono.setText("");
            registrar.setEnabled(false);
            modificar.setEnabled(false);
            buscar.setEnabled(false);
            borrar.setEnabled(false);
            eliminar.setEnabled(false);
            ID.setEditable(true);
        }else if(s.getSource()==generar){
            try{
                Document documento=new Document();
                String opciones[]={"Definir Ruta", "Ruta Definida", "Cancelar"};
                String respuesta=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
                if(respuesta.equals("Definir Ruta")){
                    JFileChooser selector=new JFileChooser();
                    int muestra=selector.showSaveDialog(null);
                    if(muestra==selector.APPROVE_OPTION){
                        try{
                            String archivo=selector.getSelectedFile()+".pdf";
                            FileOutputStream os=new FileOutputStream(archivo);
                            PdfWriter.getInstance(documento, os);
                            
                            PdfPTable tabla=new PdfPTable(4);
                            tabla.addCell("ID del Socio");
                            tabla.addCell("Nombre");
                            tabla.addCell("Dirección");
                            tabla.addCell("Teléfono");
                            
                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("SOCIOS REGISTRADOS\n\n");
                            
                            com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            himel.scaleToFit(91, 196);
                            himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                            documento.open();
                            documento.add(himel);
                            
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM SOCIOS ORDER BY ID_SOCIO");  
                                ResultSet set=psp.executeQuery();
                                
                                if(set.next()){
                                    do{ 
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(set.getString(2));
                                        tabla.addCell(set.getString(3));
                                        tabla.addCell(set.getString(4));
                                    }while(set.next());
                                    documento.add(parrafo);
                                    documento.add(tabla);
                                }else{
                                    Paragraph texto=new Paragraph();
                                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                                    texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                    texto.add("No hay registros todavía\n\n");
                                    documento.add(texto);
                                }
                                documento.close();
                                JOptionPane.showMessageDialog(null, "PDF generado exitosamente\nen: "+archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(DocumentException | HeadlessException | SQLException e){
                                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                System.err.println("Error: "+e.getMessage());
                            }
                        }catch(DocumentException | HeadlessException | IOException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+e.getMessage());
                        }
                    }
                }else if(respuesta.equals("Ruta Definida")){
                    try{
                        String ruta=System.getProperty("user.home");
                        FileOutputStream strem=new FileOutputStream(ruta+"/desktop/Socios.pdf");
                        PdfWriter.getInstance(documento, strem);
                        
                        PdfPTable tabla=new PdfPTable(4);
                            tabla.addCell("ID del Socio");
                            tabla.addCell("Nombre");
                            tabla.addCell("Dirección");
                            tabla.addCell("Teléfono");
                            
                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("SOCIOS REGISTRADOS\n\n");
                            
                            com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            himel.scaleToFit(91, 196);
                            himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                            documento.open();
                            documento.add(himel);
                            
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM SOCIOS ORDER BY ID_SOCIO");  
                                ResultSet set=psp.executeQuery();
                                
                                if(set.next()){
                                    do{ 
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(set.getString(2));
                                        tabla.addCell(set.getString(3));
                                        tabla.addCell(set.getString(4));
                                    }while(set.next());
                                    documento.add(parrafo);
                                    documento.add(tabla);
                                }else{
                                    Paragraph texto=new Paragraph();
                                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                                    texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                    texto.add("No hay registros todavía\n\n");
                                    documento.add(texto);
                                }
                                documento.close();
                                JOptionPane.showMessageDialog(null, "PDF generado exitosamente\nen el escritorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                System.err.println("Error: "+e.getMessage());
                            }
                    }catch(DocumentException | HeadlessException | IOException e){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: "+e.getMessage());
                    }
                }else if(respuesta.equals("Cancelar")){
                    JOptionPane.showMessageDialog(null, "Operación cancelada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){
                
            }
        }
    }
    
    public static void main(String[] args){
        Socios soicos=new Socios();
        soicos.setBounds(0, 0, 440, 300);
        soicos.setVisible(true);
        soicos.setResizable(false);
        soicos.setLocationRelativeTo(null);
    }
}
