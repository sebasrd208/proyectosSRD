package biblioteca;
import com.itextpdf.text.pdf.*;
import javax.swing.border.*;
import com.itextpdf.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.io.*;

/**
 *
 * @author sebas
 */
public class Prestamos extends JFrame implements ActionListener{
    private JLabel ticket, ticket2, ticket3, 
            ticket4, ticket5, fondo;
    public static JTextField id_libro, id_socio, fec_prestamo,
            fec_devolucion, ID;
    public static JButton registrar, modificar,
            eliminar, buscar, borrar, generar;
    
    public Prestamos(){
        setLayout(null);
        int sesion=Biblioteca.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        setTitle("BD Préstamos");
        ImageIcon icono=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(icono.getImage());
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("ID del Libro:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(estilo);
        add(ticket);
        
        id_libro=new JTextField();
        id_libro.setBounds(10, 35, 200, 25);
        id_libro.setBorder(border);
        id_libro.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBoton();
            }
            
            @Override
            public void keyTyped(KeyEvent s){
                int llave=s.getKeyChar();
            
                if(!(llave>=48 & llave<=57)){
                    s.consume();
                }
            
                if(id_libro.getText().length()>=4){
                    s.consume();
                }
            }
        });
        id_libro.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        id_libro.setFont(estilo);
        add(id_libro);
        
        ticket2=new JLabel("ID del Socio:");
        ticket2.setBounds(10, 70, 80, 25);
        ticket2.setFont(estilo);
        add(ticket2);
        
        id_socio=new JTextField();
        id_socio.setBounds(10, 95, 120, 25);
        id_socio.setBorder(border);
        id_socio.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBoton();
            }
            
            @Override
            public void keyTyped(KeyEvent s){
                int llave=s.getKeyChar();
            
                if(!(llave>=48 & llave<=57)){
                    s.consume();
                }
            
                if(id_socio.getText().length()>=4){
                    s.consume();
                }
            }
        });
        id_socio.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        id_socio.setFont(estilo);
        add(id_socio);
        
        ticket3=new JLabel("Fecha del Préstamo:");
        ticket3.setBounds(230, 10, 150, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        fec_prestamo=new JTextField();
        fec_prestamo.setBounds(230, 35, 150, 25);
        fec_prestamo.setBorder(border);
        fec_prestamo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBoton();
            }
        });
        fec_prestamo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        fec_prestamo.setFont(estilo);
        add(fec_prestamo);
        
        ticket4=new JLabel("Fecha de Devolución:");
        ticket4.setBounds(140, 70, 150, 25);
        ticket4.setFont(estilo);
        add(ticket4);
        
        fec_devolucion=new JTextField();
        fec_devolucion.setBounds(140, 95, 120, 25);
        fec_devolucion.setBorder(border);
        fec_devolucion.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBoton();
            }
        });
        fec_devolucion.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        fec_devolucion.setFont(estilo);
        add(fec_devolucion);
        
        ticket5=new JLabel("ID del Préstamo:");
        ticket5.setBounds(10, 165, 120, 25);
        ticket5.setFont(estilo);
        add(ticket5);
        
        ID=new JTextField();
        ID.setBounds(100, 165, 120, 25);
        ID.setBorder(border);
        ID.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                String fuerza=ID.getText().trim();
                if(fuerza.equals("")){
                    buscar.setEnabled(false);
                }else{
                    buscar.setEnabled(true);
                }
                habilitarBoton();
            }
            
            @Override
            public void keyTyped(KeyEvent s){
                int llave=s.getKeyChar();
            
                if(!(llave>=48 & llave<=57)){
                    s.consume();
                }
            
                if(ID.getText().length()>=4){
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
        
        borrar=new JButton("Limpiar todo");
        borrar.setBounds(270, 95, 120, 25);
        borrar.setFont(estilo);
        borrar.setBorder(border);
        borrar.setEnabled(false);
        borrar.setFocusPainted(false);
        borrar.addActionListener(this);
        add(borrar);
        
        eliminar=new JButton("Eliminar");
        eliminar.setBounds(230, 130, 120, 25);
        eliminar.setFont(estilo);
        eliminar.setBorder(border);
        eliminar.setEnabled(false);
        eliminar.setFocusPainted(false);
        eliminar.addActionListener(this);
        add(eliminar);
        
        generar=new JButton("Generar PDF de Carreras");
        generar.setBounds(10, 200, 180, 25);
        generar.setFont(estilo);
        generar.setBorder(border);
        generar.setFocusPainted(false);
        generar.addActionListener(this);
        add(generar);
        
        ImageIcon imagen=new ImageIcon("src/imagenes/escuela.jpg");
        fondo=new JLabel(imagen);
        fondo.setBounds(0, 0, 440, 300);
        add(fondo);
    }
    
    public void metodo(){
        Biblioteca.model.setRowCount(0);
        Biblioteca.model.setColumnCount(0);        
        try{
            Connection cnn=DriverManager.getConnection(Biblioteca.url, Biblioteca.user, Biblioteca.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS");

            ResultSet set=psp.executeQuery();

            Biblioteca.model.addColumn("ID del Préstamo");
            Biblioteca.model.addColumn("ID del Libro");
            Biblioteca.model.addColumn("ID del Socio");
            Biblioteca.model.addColumn("Fecha de Préstamo");
            Biblioteca.model.addColumn("Fecha de Devolución");
                    
            while(set.next()){
                Object[] fila=new Object[5];
                for(int i=0;i<5;i++){
                    fila[i]=set.getObject(i+1);
                }
                Biblioteca.model.addRow(fila);     
            }
            cnn.close();

        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            s.printStackTrace();
        }
    }
    
    public void habilitarBoton(){
        String libro=id_libro.getText().trim();
        String socio=id_socio.getText().trim();
        String prestamo=fec_prestamo.getText().trim();
        String devolucion=fec_devolucion.getText().trim();
        if(libro.equals("") | socio.equals("") | prestamo.equals("") | 
                devolucion.equals("")){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
        
        
        if(libro.equals("") | socio.equals("") | prestamo.equals("") | 
                devolucion.equals("")){
            modificar.setEnabled(false);
        }else{
            modificar.setEnabled(true);
        }
        
        if(libro.equals("") | socio.equals("") | prestamo.equals("") | 
                devolucion.equals("")){
            eliminar.setEnabled(false);
        }else{
            eliminar.setEnabled(true);
        }
        
        if(libro.equals("") | socio.equals("") | prestamo.equals("") | 
                devolucion.equals("")){
            borrar.setEnabled(false);
        }else{
            borrar.setEnabled(true);
        }
    }
    
    public Icon icono(String camino, int a, int o){
        Icon imagen=new ImageIcon(new ImageIcon(getClass().getResource(camino))
                .getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="Sebastian";
        String password="admin";
        if(s.getSource()==registrar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("INSERT INTO PRESTAMOS VALUES (?,?,?,?,?)");
                
                psp.setInt(1, 1);
                psp.setInt(2, Integer.parseInt(id_libro.getText().trim()));
                psp.setInt(3, Integer.parseInt(id_socio.getText().trim()));
                psp.setDate(4, Date.valueOf(fec_prestamo.getText().trim()));
                psp.setDate(5, Date.valueOf(fec_devolucion.getText().trim()));
                
                int flag=psp.executeUpdate();
                if(flag==1){
                    id_libro.setBackground(Color.green);
                    id_socio.setBackground(Color.green);
                    fec_prestamo.setBackground(Color.green);
                    fec_devolucion.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Carrera insertada exitosamente con el ID ",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar carrera",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
        }else if(s.getSource()==modificar){
            String[] op={"Si", "No"};
            int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), op, op[0]);
            if(modify==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("UPDATE PRESTAMOS SET ID_LIBRO=?, ID_SOCIO=?, FEC_PRESTAMO=?, FEC_DEVOLUCION=?"
                            + " WHERE ID_PRESTAMOS="+ID.getText().trim());
                
                    psp.setInt(1, Integer.parseInt(id_libro.getText().trim()));
                    psp.setInt(2, Integer.parseInt(id_socio.getText().trim()));
                    psp.setDate(3, Date.valueOf(fec_prestamo.getText().trim()));
                    psp.setDate(4, Date.valueOf(fec_devolucion.getText().trim()));
                
                    if(psp.executeUpdate()==1){
                        id_libro.setBackground(Color.green);
                        id_socio.setBackground(Color.green);
                        fec_prestamo.setBackground(Color.green);
                        fec_devolucion.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Préstamo actualizado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Hubo un error al insertar préstamo",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(HeadlessException | NumberFormatException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar préstamo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e.getMessage());
                }
                if(Biblioteca.sesion==1){
                    metodo();
                }else{
                            
                }
            }
        }else if(s.getSource()==eliminar){
            String[] op={"Si", "No"};
            int modify=JOptionPane.showOptionDialog(null, "¿Deseas eliminar este préstamo?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
            if(modify==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("DELETE FROM PRESTAMOS WHERE ID_PRESTAMOS="+ID.getText().trim());
                
                    if(psp.executeUpdate()==1){
                        id_libro.setText("");
                        id_socio.setText("");
                        fec_prestamo.setText("");
                        fec_devolucion.setText("");
                        id_libro.setBackground(Color.green);
                        id_socio.setBackground(Color.green);
                        fec_prestamo.setBackground(Color.green);
                        fec_devolucion.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Préstamo actualizado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Hubo un error al insertar préstamo",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(HeadlessException | NumberFormatException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar préstamo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e.getMessage());
                }
            }
        }else if(s.getSource()==buscar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM PRESTAMOS WHERE ID_PRESTAMOS="+ID.getText().trim());
                    
                ResultSet set=psp.executeQuery();
                if(set.next()){
                    id_libro.setText(String.valueOf(set.getInt("ID_LIBRO")));
                    id_socio.setText(String.valueOf(set.getInt("ID_SOCIO")));
                    fec_prestamo.setText(String.valueOf(set.getDate("FEC_PRESTAMO")));
                    fec_devolucion.setText(String.valueOf(set.getDate("FEC_DEVOLUCION")));
                    registrar.setEnabled(true);
                    modificar.setEnabled(true);
                    eliminar.setEnabled(true);
                    borrar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Préstamo no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    id_libro.setText("");
                    id_socio.setText("");
                    fec_prestamo.setText("");
                    fec_devolucion.setText("");
                    ID.setText("");
                    borrar.setEnabled(false);
                    buscar.setEnabled(false);
                    modificar.setEnabled(false);
                    eliminar.setEnabled(false);
                    registrar.setEnabled(false);
                }                
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
            
        }else if(s.getSource()==borrar){
            id_libro.setText("");
            id_socio.setText("");
            fec_prestamo.setText("");
            fec_devolucion.setText("");
            ID.setText("");
            borrar.setEnabled(false);
            buscar.setEnabled(false);
            modificar.setEnabled(false);
            eliminar.setEnabled(false);
            registrar.setEnabled(false);
            ID.setEditable(true);
        }else if(s.getSource()==generar){
            try{
                Document documento=new Document();
                String opciones[]={"Definir Ruta", "Ruta Definida", "Cancelar"};
                String respuesta=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
                
                if(respuesta.equals("Definir Ruta")){
                    JFileChooser seleccion=new JFileChooser();
                    int selector=seleccion.showSaveDialog(null);
                    if(selector==seleccion.APPROVE_OPTION){
                        try{
                            String archivo=seleccion.getSelectedFile()+".pdf";
                            FileOutputStream os=new FileOutputStream(archivo);
                            PdfWriter.getInstance(documento, os);
                            
                            PdfPTable tabla=new PdfPTable(5);
                            tabla.addCell("ID del Préstamo");
                            tabla.addCell("ID del Libro");
                            tabla.addCell("ID del Socio");
                            tabla.addCell("Fecha de Préstamo");
                            tabla.addCell("Fecha de Devolución");
                            
                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("PRESTAMOS REGISTRADOS\n\n");
                            
                            com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            himel.scaleToFit(91, 196);
                            himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                            documento.open();
                            documento.add(himel);
                            
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS");
                                ResultSet set=psp.executeQuery();
                                
                                if(set.next()){
                                    do{ 
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(String.valueOf(set.getInt(2)));
                                        tabla.addCell(String.valueOf(set.getInt(3)));
                                        tabla.addCell(set.getString(4));
                                        tabla.addCell(set.getString(5));
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
                        FileOutputStream strem=new FileOutputStream(ruta+"/desktop/Libros.pdf");
                        PdfWriter.getInstance(documento, strem);
                        
                        PdfPTable tabla=new PdfPTable(5);
                        tabla.addCell("ID del Préstamo");
                        tabla.addCell("ID del Libro");
                        tabla.addCell("ID del Socio");
                        tabla.addCell("Fecha de Préstamo");                            
                        tabla.addCell("Fecha de Devolución");
                            
                        Paragraph parrafo=new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("PRESTAMOS REGISTRADOS\n\n");
                            
                        com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        himel.scaleToFit(91, 196);
                        himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                        documento.open();
                        documento.add(himel);
                            
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS");
                            ResultSet set=psp.executeQuery();
                            
                            if(set.next()){
                                do{ 
                                    tabla.addCell(String.valueOf(set.getInt(1)));
                                    tabla.addCell(String.valueOf(set.getInt(2)));
                                    tabla.addCell(String.valueOf(set.getInt(3)));
                                    tabla.addCell(set.getString(4));
                                    tabla.addCell(set.getString(5));
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
                        }catch(DocumentException | HeadlessException | SQLException e){
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
        Prestamos query=new Prestamos();
        query.setBounds(0, 0, 440, 300);
        query.setVisible(true);
        query.setResizable(false);
        query.setLocationRelativeTo(null);
    }
    
}
