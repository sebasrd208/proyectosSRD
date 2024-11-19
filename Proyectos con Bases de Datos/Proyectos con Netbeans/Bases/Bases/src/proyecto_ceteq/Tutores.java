package proyecto_ceteq;
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
public class Tutores extends JFrame implements ActionListener, KeyListener{
    private JLabel ticket, ticket2, ticket3, 
            ticket4, fondo;
    public static JTextField nombre, correo, clave, ID;
    public static JButton registrar, modificar,
            eliminar, buscar, borrar, generar;
    
    public Tutores(){
        setLayout(null);
        int sesion=Base_Datos.sesion;
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
        nombre.addKeyListener(this);
        nombre.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        nombre.setFont(estilo);
        add(nombre);
        
        ticket2=new JLabel("Correo:");
        ticket2.setBounds(170, 10, 80, 25);
        ticket2.setFont(estilo);
        add(ticket2);
        
        correo=new JTextField();
        correo.setBounds(170, 35, 220, 25);
        correo.setBorder(border);
        correo.addKeyListener(this);
        correo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        correo.setFont(estilo);
        add(correo);
        
        ticket3=new JLabel("Clave:");
        ticket3.setBounds(10, 70, 150, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        clave=new JTextField();
        clave.setBounds(10, 95, 120, 25);
        clave.setBorder(border);
        clave.addKeyListener(this);
        clave.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        clave.setFont(estilo);
        add(clave);
        
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
        
        ticket4=new JLabel("ID del Tutor:");
        ticket4.setBounds(10, 165, 120, 25);
        ticket4.setFont(estilo);
        add(ticket4);
        
        ID=new JTextField();
        ID.setBounds(100, 165, 120, 25);
        ID.setBorder(border);
        ID.addKeyListener(this);
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
    
    public Icon icono(String path, int w, int h){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
    
    public void metodo(){
        Base_Datos.model.setRowCount(0);
        Base_Datos.model.setColumnCount(0);      
        try{
            Connection cnn=DriverManager.getConnection(Base_Datos.url, Base_Datos.user, Base_Datos.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM TUTORES ORDER BY ID_TUTOR");

            ResultSet set=psp.executeQuery();
            
            Base_Datos.model.addColumn("ID del Tutor");
            Base_Datos.model.addColumn("Nombre");
            Base_Datos.model.addColumn("Correo");
            Base_Datos.model.addColumn("Clave");

            while(set.next()){
                Object[] fila=new Object[4];
                for(int i=0;i<4;i++){
                    fila[i]=set.getObject(i+1);
                }
                Base_Datos.model.addRow(fila);
            }
            cnn.close();

        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            s.printStackTrace();
        }
    }
    
    public void habilitarBoton(){
        String name=nombre.getText().trim();
        String email=correo.getText().trim();
        String lada=clave.getText().trim();
        if(name.equals("") | email.equals("") | lada.equals("")){
            modificar.setEnabled(false);
        }else{
            modificar.setEnabled(true);
        }
        
        if(name.equals("") | email.equals("") | lada.equals("")){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
        
        if(name.equals("") | email.equals("") | lada.equals("")){
            borrar.setEnabled(false);
        }else{
            borrar.setEnabled(true);
        }
        
        if(name.equals("") | email.equals("") | lada.equals("")){
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
                PreparedStatement psp=cnn.prepareStatement("INSERT INTO TUTORES VALUES (?,?,?,?)");
                
                psp.setInt(1, 1);
                psp.setString(2, nombre.getText().trim());
                psp.setString(3, correo.getText().trim());
                psp.setString(4, clave.getText().trim());
                
                if(psp.executeUpdate()==1){
                    nombre.setBackground(Color.green);
                    correo.setBackground(Color.green);
                    clave.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Tutor insertado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo registrar al tutor", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al registrar tutor", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e);
            }
        }else if(s.getSource()==modificar){
            String[] op={"Si", "No"};
            int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), op, op[0]);
            if(modify==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("UPDATE TUTORES SET NOMBRE=?, EMAIL=?, CLAVE=? WHERE ID_TUTOR="+ID.getText().trim());
               
                    psp.setString(1, nombre.getText().trim());
                    psp.setString(2, correo.getText().trim());
                    psp.setString(3, clave.getText().trim());
                    
                    //int bandera=psp.executeUpdate();
                    if(psp.executeUpdate()==1){
                        nombre.setBackground(Color.green);
                        correo.setBackground(Color.green);
                        clave.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Tutor actualizado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar al tutor",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e);
                }
                if(Base_Datos.sesion==1){
                    metodo();
                }else{
                    
                }
            }
        }else if(s.getSource()==eliminar){
            if(nombre.getText().equals("") & correo.getText().equals("") 
                    & clave.getText().equals("") & ID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No se permiten espacios vacíos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String[] op={"Si", "No"};
                int delete=JOptionPane.showOptionDialog(null, "¿Estás seguro de eliminar este tutor?", "Advertencia", 
                    JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
                if(delete==JOptionPane.YES_OPTION){
                    try{
                        Connection cnn=DriverManager.getConnection(url, user, password);
                        PreparedStatement psp=cnn.prepareStatement("DELETE FROM TUTORES WHERE ID_TUTOR="+ID.getText());
                        
                        if(psp.executeUpdate()==1){
                            nombre.setText("");
                            correo.setText("");
                            clave.setText("");
                            ID.setText("");
                            registrar.setEnabled(false);
                            modificar.setEnabled(false);
                            eliminar.setEnabled(false);
                            borrar.setEnabled(false);
                            buscar.setEnabled(false);
                            JOptionPane.showMessageDialog(null, "Tutor eliminado exitosamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar al tutor");
                        }
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Error al eliminar tutor", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: "+e);
                    }
                }
            }
        }else if(s.getSource()==buscar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM TUTORES WHERE ID_TUTOR="+ID.getText().trim());
                    
                ResultSet set=psp.executeQuery();
                    
                if(set.next()){
                    nombre.setText(set.getString("NOMBRE")); 
                    correo.setText(set.getString("EMAIL"));
                    clave.setText(set.getString("CLAVE"));
                    borrar.setEnabled(true);
                    registrar.setEnabled(true);
                    modificar.setEnabled(true);
                    eliminar.setEnabled(true);
                    ID.setEditable(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Tutor no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    nombre.setText(""); 
                    correo.setText(""); 
                    clave.setText("");
                    ID.setText("");
                    registrar.setEnabled(false);
                    modificar.setEnabled(false);
                    eliminar.setEnabled(false);
                    borrar.setEnabled(false);
                    buscar.setEnabled(false);
                }
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar tutor", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
        }else if(s.getSource()==borrar){
            ID.setText("");
            nombre.setText("");
            correo.setText("");
            clave.setText("");
            registrar.setEnabled(false);
            modificar.setEnabled(false);
            buscar.setEnabled(false);
            borrar.setEnabled(false);
            borrar.setText("Limpiar todo");
            eliminar.setEnabled(false);
            ID.setEditable(true);
        }else if(s.getSource()==generar){
            Document documento=new Document();
            String opciones[]={"Definir Ruta", "Ruta Definida", "Cancelar"};
            int op=JOptionPane.showOptionDialog(null, "Elige una opción", "Mensaje", JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
            if(op==0){
                JFileChooser DC=new JFileChooser();
                int kaijuu=DC.showSaveDialog(null);
                if(kaijuu==DC.APPROVE_OPTION){
                    try{
                        String archivo=DC.getSelectedFile()+".pdf";
                        PdfWriter.getInstance(documento, new FileOutputStream(archivo));

                        PdfPTable tabla=new PdfPTable(4);
                        tabla.addCell("ID del Tutor");
                        tabla.addCell("Nombre");
                        tabla.addCell("Correo electrónico");
                        tabla.addCell("Clave");

                        com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        himel.scaleToFit(91, 196);
                        himel.setAlignment(Chunk.ALIGN_LEFT);

                        Paragraph parrafo=new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("TUTORES REGISTRADAS\n\n");
                            
                        Paragraph texto=new Paragraph();
                        texto.setAlignment(Paragraph.ALIGN_CENTER);
                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                        texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
    
                        documento.open();
                        documento.add(himel);
                        documento.add(parrafo);

                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("select * from tutores order by id_tutor");

                            ResultSet set=psp.executeQuery();

                            if(set.next()){
                                do{
                                    tabla.addCell(String.valueOf(set.getInt(1)));
                                    tabla.addCell(set.getString(2));
                                    tabla.addCell(set.getString(3));
                                    tabla.addCell(set.getString(4));
                                }while(set.next());
                                documento.add(tabla);
                            }else{
                                Paragraph parrafo2=new Paragraph();
                                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo2.add("No hay registros todavía\n\n");
                                documento.add(parrafo2);
                            }
                            documento.add(texto);
                            documento.close();
                            JOptionPane.showMessageDialog(null, "Reporte creado exitosamente\nen "+archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Archivo no generado!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            e.printStackTrace();
                        }
                    }catch(DocumentException | IOException e){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                }
            }else if(op==1){
                try{
                    String ruta=System.getProperty("user.home");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/desktop/Tutores.pdf"));
                    
                    PdfPTable tabla=new PdfPTable(4);
                    tabla.addCell("ID del Tutor");
                    tabla.addCell("Nombre");
                    tabla.addCell("Correo electrónico");
                    tabla.addCell("Clave");

                    com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                    himel.scaleToFit(91, 196);
                    himel.setAlignment(Chunk.ALIGN_LEFT);

                    Paragraph parrafo=new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                    parrafo.add("TUTORES REGISTRADOS\n\n");
                        
                    Paragraph texto=new Paragraph();
                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                    texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                    texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
                    
                    documento.open();
                    documento.add(himel);
                    documento.add(parrafo);
                    
                    try{
                        Connection cnn=DriverManager.getConnection(url, user, password);
                        PreparedStatement psp=cnn.prepareStatement("select * from tutores order by id_tutor");
                        
                        ResultSet set=psp.executeQuery();
                        
                        if(set.next()){
                            do{
                                tabla.addCell(String.valueOf(set.getInt(1)));
                                tabla.addCell(set.getString(2));
                                tabla.addCell(set.getString(3));
                                tabla.addCell(set.getString(4));
                            }while(set.next());
                            documento.add(tabla);
                        }else{
                            Paragraph parrafo2=new Paragraph();
                            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo2.add("No hay registros todavía\n\n");
                            documento.add(parrafo2);
                        }
                        documento.add(texto);
                        documento.close();
                        JOptionPane.showMessageDialog(null, "Reporte creado exitosamente en\nel escritorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Archivo no generado!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                }catch(DocumentException | IOException e){
                    JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent s){
        if(s.getSource()==ID){
            int llave=s.getKeyChar();
            
            if(!(llave>=48 & llave<=57)){
                s.consume();
            }
            
            if(ID.getText().length()>=4){
                s.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent s){
        
    }

    @Override
    public void keyReleased(KeyEvent s){
        if(s.getSource()==ID){
            String busqueda=ID.getText().trim();
            if(busqueda.equals("")){
                buscar.setEnabled(false);
            }else{
                buscar.setEnabled(true);
            }
        }else if(s.getSource()==nombre){
            habilitarBoton();
            //habilitarBoton2();
        }else if(s.getSource()==correo){
            habilitarBoton();
            //habilitarBoton2();
        }else if(s.getSource()==clave){
            habilitarBoton();
            //habilitarBoton2();
        }
    }
    
    public static void main(String[] args){
        Tutores query=new Tutores();
        query.setBounds(0, 0, 440, 300);
        query.setVisible(true);
        query.setResizable(false);
        query.setLocationRelativeTo(null);
    }
    
}
