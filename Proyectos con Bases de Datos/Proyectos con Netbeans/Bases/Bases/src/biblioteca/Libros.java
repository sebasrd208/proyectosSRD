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
public class Libros extends JFrame implements ActionListener{
    private JLabel ticket, ticket2, ticket3, 
            ticket4, fondo;
    public static JTextField titulo, id_autor, copias, ID;
    public static JButton registrar, modificar,
            eliminar, buscar, borrar, generar;
    
    public Libros(){
        setLayout(null);
        int sesion=Biblioteca.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        setTitle("BD Libros");
        ImageIcon icono=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(icono.getImage());
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("Título:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(estilo);
        add(ticket);
        
        titulo=new JTextField();
        titulo.setBounds(10, 35, 220, 25);
        titulo.setBorder(border);
        titulo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBoton();
            }
        });
        titulo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        titulo.setFont(estilo);
        add(titulo);
        
        ticket2=new JLabel("ID del Autor:");
        ticket2.setBounds(240, 10, 80, 25);
        ticket2.setFont(estilo);
        add(ticket2);
        
        id_autor=new JTextField();
        id_autor.setBounds(240, 35, 150, 25);
        id_autor.setBorder(border);
        id_autor.addKeyListener(new KeyAdapter(){
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
            
                if(id_autor.getText().length()>=4){
                    s.consume();
                }
            }
        });
        id_autor.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        id_autor.setFont(estilo);
        add(id_autor);
        
        ticket3=new JLabel("Copias:");
        ticket3.setBounds(10, 70, 150, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        copias=new JTextField();
        copias.setBounds(10, 95, 120, 25);
        copias.setBorder(border);
        copias.addKeyListener(new KeyAdapter(){
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
            
                if(copias.getText().length()>=4){
                    s.consume();
                }
            }
        });
        copias.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        copias.setFont(estilo);
        add(copias);
        
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
        eliminar.setBorder(border);
        eliminar.setEnabled(false);
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
        
        generar=new JButton("Generar PDF de Libros");
        generar.setBounds(230, 130, 180, 25);
        generar.setFont(estilo);
        generar.setBorder(border);
        generar.setFocusPainted(false);
        generar.addActionListener(this);
        add(generar);
        
        ticket4=new JLabel("ID del Libro:");
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
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM LIBROS ORDER BY ID_LIBRO");

            ResultSet set=psp.executeQuery();

            Biblioteca.model.addColumn("ID del Libro");
            Biblioteca.model.addColumn("Titulo");
            Biblioteca.model.addColumn("ID del Autor");
            Biblioteca.model.addColumn("Copias");

            while(set.next()){
                Object[] pila=new Object[4];
                for (int i=0; i<4; i++){
                    pila[i]=set.getObject(i+1);
                }
                Biblioteca.model.addRow(pila);
            }
            cnn.close();

        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            s.printStackTrace();
        }
    }
    
    public void habilitarBoton(){
        String title=titulo.getText().trim();
        String autor=id_autor.getText().trim();
        String copy=copias.getText().trim();
        if(title.equals("") | autor.equals("") | copy.equals("")){
            modificar.setEnabled(false);
        }else{
            modificar.setEnabled(true);
        }
        
        if(title.equals("") | autor.equals("") | copy.equals("")){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
        
        if(title.equals("") | autor.equals("") | copy.equals("")){
            eliminar.setEnabled(false);
        }else{
            eliminar.setEnabled(true);
        }
        
        if(title.equals("") | autor.equals("") | copy.equals("")){
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
                PreparedStatement psp=cnn.prepareStatement("INSERT INTO LIBROS VALUES (?,?,?,?)");
                
                psp.setInt(1, 1);
                psp.setString(2, titulo.getText().trim());
                psp.setInt(3, Integer.parseInt(id_autor.getText().trim()));
                psp.setInt(4, Integer.parseInt(copias.getText().trim()));
                
                if(psp.executeUpdate()==1){
                    titulo.setBackground(Color.green);
                    id_autor.setBackground(Color.green);
                    copias.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Libro insertado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el libro", 
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(HeadlessException | NumberFormatException | SQLException e){
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
                    PreparedStatement psp=cnn.prepareStatement("UPDATE LIBROS SET TITULO=?, ID_AUTOR=?, COPIAS=? "
                            + "WHERE ID_LIBRO="+ID.getText().trim());
                    
                    psp.setString(1, titulo.getText().trim());
                    psp.setInt(2, Integer.parseInt(id_autor.getText().trim()));
                    psp.setInt(3, Integer.parseInt(copias.getText().trim()));
                    
                    if(psp.executeUpdate()==1){
                        titulo.setBackground(Color.green);
                        id_autor.setBackground(Color.green);
                        copias.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Libro actualizado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar al libro",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(HeadlessException | NumberFormatException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e);
                }
                int sesion=Biblioteca.sesion;
                if(sesion==1){
                    metodo();
                }else{
                    
                }
            }
        }else if(s.getSource()==eliminar){
            String[] op={"Si", "No"};
            int delete=JOptionPane.showOptionDialog(null, "¿Estás seguro de eliminar este libro?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
            if(delete==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("DELETE FROM LIBROS WHERE ID_LIBRO="+ID.getText().trim());
                    
                    if(psp.executeUpdate()==1){
                        ID.setText("");
                        titulo.setText("");
                        id_autor.setText("");
                        copias.setText("");
                        JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar al libro",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e);
                }
                int sesion=Biblioteca.sesion;
                if(sesion==1){
                    metodo();
                }else{
                    
                }
            }
        }else if(s.getSource()==buscar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM LIBROS WHERE ID_LIBRO="+ID.getText().trim());
                    
                ResultSet set=psp.executeQuery();
                    
                if(set.next()){
                    titulo.setText(set.getString("TITULO")); 
                    id_autor.setText(String.valueOf(set.getInt("ID_AUTOR")));
                    copias.setText(String.valueOf(set.getInt("COPIAS")));
                    modificar.setEnabled(true);
                    registrar.setEnabled(true);
                    borrar.setEnabled(true);
                    eliminar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Tutor no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    titulo.setText(""); 
                    id_autor.setText(""); 
                    copias.setText("");
                    ID.setText("");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar tutor", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
        }else if(s.getSource()==borrar){
            titulo.setText("");
            id_autor.setText("");
            copias.setText("");
            ID.setText("");
            modificar.setEnabled(false);
            registrar.setEnabled(false);
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
                    JFileChooser seleccion=new JFileChooser();
                    int selector=seleccion.showSaveDialog(null);
                    if(selector==seleccion.APPROVE_OPTION){
                        try{
                            String archivo=seleccion.getSelectedFile()+".pdf";
                            FileOutputStream os=new FileOutputStream(archivo);
                            PdfWriter.getInstance(documento, os);
                            
                            PdfPTable tabla=new PdfPTable(4);
                            tabla.addCell("ID del Libro");
                            tabla.addCell("Título");
                            tabla.addCell("ID del Autor");
                            tabla.addCell("Copias");
                            
                            com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            himel.scaleToFit(91, 196);
                            himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("LIBROS REGISTRADOS\n\n");

                            documento.open();
                            documento.add(himel);
                            
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM LIBROS ORDER BY ID_LIBRO");
                                ResultSet set=psp.executeQuery();
                                
                                if(set.next()){
                                    do{ 
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(set.getString(2));
                                        tabla.addCell(String.valueOf(set.getInt(3)));
                                        tabla.addCell(String.valueOf(set.getInt(4)));
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
                                JOptionPane.showMessageDialog(null, "PDF generado exitosamente\nen: "+archivo, 
                                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(DocumentException | HeadlessException | SQLException e){
                                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", 
                                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                System.err.println("Error: "+e.getMessage());
                            }
                        }catch(DocumentException | HeadlessException | IOException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", 
                                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+e.getMessage());
                        }
                    }
                }else if(respuesta.equals("Ruta Definida")){
                    try{
                        String ruta=System.getProperty("user.home");
                        FileOutputStream strem=new FileOutputStream(ruta+"/desktop/Libros.pdf");
                        PdfWriter.getInstance(documento, strem);
                    
                        PdfPTable tabla=new PdfPTable(4);
                        tabla.addCell("ID del Libro");
                        tabla.addCell("Título");
                        tabla.addCell("ID del Autor");
                        tabla.addCell("Copias");
                            
                        com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        himel.scaleToFit(91, 196);
                        himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                        Paragraph parrafo=new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("LIBROS REGISTRADOS\n\n");

                        documento.open();
                        documento.add(himel);
                        
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM LIBROS ORDER BY ID_LIBRO");
                            ResultSet set=psp.executeQuery();
                                
                            if(set.next()){
                                do{ 
                                    tabla.addCell(String.valueOf(set.getInt(1)));
                                    tabla.addCell(set.getString(2));
                                    tabla.addCell(String.valueOf(set.getInt(3)));
                                    tabla.addCell(String.valueOf(set.getInt(4)));
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
                            JOptionPane.showMessageDialog(null, "PDF generado exitosamente\nen el escritorio de esta computadora", 
                                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }catch(DocumentException | HeadlessException | SQLException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", 
                                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+e.getMessage());
                        }
                    }catch(DocumentException | HeadlessException | IOException e){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", 
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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
        Libros books=new Libros();
        books.setBounds(0, 0, 440, 300);
        books.setVisible(true);
        books.setResizable(false);
        books.setLocationRelativeTo(null);
    }
}
