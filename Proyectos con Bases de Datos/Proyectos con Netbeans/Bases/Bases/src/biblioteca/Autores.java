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
public class Autores extends JFrame implements ActionListener{
    private JLabel ticket, ticket2, ticket3, fondo;
    public static JTextField id_autor, nombre, nacionalidad;
    public static JButton option, limpiar, generar, buscar;
    
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user="Sebastian";
    String password="admin";
    
    public void habilitarBtn(){
        String firme=id_autor.getText().trim();
        String frontera=nombre.getText().trim();
        String exterminador=nacionalidad.getText().trim();
        
        if(firme.equals("") | frontera.equals("") | exterminador.equals("")){
            option.setEnabled(false);
        }else{
            option.setEnabled(true);
        }
        
        if(firme.equals("") | frontera.equals("") | exterminador.equals("")){
            limpiar.setEnabled(false);
        }else{
            limpiar.setEnabled(true);
        }
    }
    
    public Autores(){
        setLayout(null);
        int sesion=Biblioteca.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        setTitle("BD Autores");
        ImageIcon icono=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(icono.getImage());
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("ID del Autor:");
        ticket.setBounds(10, 160, 100, 25);
        ticket.setFont(estilo);
        ticket.setForeground(Color.white);
        add(ticket);
        
        id_autor=new JTextField();
        //id_autor.addKeyListener(this);
        id_autor.setBorder(border);
        id_autor.setBounds(100, 160, 120, 25);
        id_autor.setFont(estilo);
        id_autor.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        add(id_autor);
        
        ticket2=new JLabel("Nombre:");
        ticket2.setBounds(10, 195, 120, 25);
        ticket2.setFont(estilo);
        ticket2.setForeground(Color.white);
        add(ticket2);
        
        nombre=new JTextField();
        //nombre.addKeyListener(this);
        nombre.setBorder(border);
        nombre.setBounds(100, 195, 120, 25);
        nombre.setFont(new java.awt.Font("Sylfaen", 1, 10));  
        nombre.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        add(nombre);
        
        ticket3=new JLabel("Nacionalidad:");
        ticket3.setBounds(10, 230, 100, 25);
        ticket3.setFont(estilo);
        ticket3.setForeground(Color.white);
        add(ticket3);
        
        nacionalidad=new JTextField();
        //nacionalidad.addKeyListener(this);
        nacionalidad.setBorder(border);
        nacionalidad.setBounds(100, 230, 120, 25);
        nacionalidad.setFont(estilo);
        nacionalidad.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        add(nacionalidad);
        
        option=new JButton("Opciones");
        option.addActionListener(this);
        option.setBorder(border);
        option.setBounds(10, 265, 100, 25);
        option.setEnabled(false);
        option.setFocusPainted(false);
        option.setFont(estilo);
        add(option);
        
        limpiar=new JButton("Limpiar todo");
        limpiar.addActionListener(this);
        limpiar.setBorder(border);
        limpiar.setBounds(120, 265, 100, 25);
        limpiar.setEnabled(false);
        limpiar.setFocusPainted(false);
        limpiar.setFont(estilo);
        add(limpiar);
        
        generar=new JButton("Generar PDF");
        generar.addActionListener(this);
        generar.setBorder(border);
        generar.setBounds(10, 300, 100, 25);
        generar.setFocusPainted(false);
        generar.setFont(estilo);
        add(generar);
        
        buscar=new JButton("Buscar");
        buscar.addActionListener(this);
        buscar.setBorder(border);
        buscar.setBounds(120, 300, 100, 25);
        buscar.setEnabled(false);
        buscar.setFocusPainted(false);
        buscar.setFont(estilo);
        add(buscar);
        
        ImageIcon image=new ImageIcon("src/imagenes/miku belicona.jpeg");
        fondo=new JLabel(image);
        fondo.setBounds(0, 0, 250, 377);
        add(fondo);
        
        id_autor.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                String reona=id_autor.getText().trim();
                if(reona.equals("")){
                    buscar.setEnabled(false);
                }else{
                    buscar.setEnabled(true);
                }
                habilitarBtn();
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
        
        nombre.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBtn();
            }
        });
        
        nacionalidad.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent s){
                habilitarBtn();
            }
        });
    }
    
    public void metodo(){
        Biblioteca.model.setRowCount(0);
        Biblioteca.model.setColumnCount(0);        
        try{
            Connection cnn=DriverManager.getConnection(Biblioteca.url, Biblioteca.user, Biblioteca.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM AUTORES ORDER BY ID_AUTOR");

            ResultSet set=psp.executeQuery();

            Biblioteca.model.addColumn("ID del Autor");
            Biblioteca.model.addColumn("Nombre");
            Biblioteca.model.addColumn("Nacionalidad");
                    
            while(set.next()){
                Object[] fila=new Object[3];
                for(int i=0;i<3;i++){
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
    
    public Icon icono(String camino, int a, int o){
        Icon imagen=new ImageIcon(new ImageIcon(getClass().getResource(camino))
        .getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        Icon icono=null;
        if(s.getSource()==option){
            String name=nombre.getText();
            String nacion=nacionalidad.getText();
            
            try{
                String[] opciones={"Registrar", "Modificar", "Eliminar"};
                String op=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", JOptionPane.INFORMATION_MESSAGE,
                        icono , opciones, opciones[0]);
            
                if(op.equals("Registrar")){
                    try{
                        Connection cnn=DriverManager.getConnection(url, user, password);
                        PreparedStatement psp=cnn.prepareStatement("INSERT INTO AUTORES VALUES(?,?,?)");
                        
                        psp.setInt(1, 1);
                        psp.setString(2, name);
                        psp.setString(3, nacion);
                        
                        
                        if(psp.executeUpdate()==1){
                            JOptionPane.showMessageDialog(null, "Nuevo autor insertado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo insertar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    }catch(HeadlessException | SQLException e){
                        JOptionPane.showMessageDialog(null, "Error al insertar datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: "+e.getMessage());
                        
                    }
                }else if(op.equals("Modificar")){
                    String[] opcion={"Si", "No"};
                    int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), opcion, opcion[0]);
                    if(modify==JOptionPane.YES_OPTION){
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("UPDATE AUTORES SET NOMBRE=?, NACIONALIDAD=? WHERE ID_AUTOR="+id_autor.getText());
                        
                            psp.setString(1, name);
                            psp.setString(2, nacion);
                        
                            if(psp.executeUpdate()==1){
                                id_autor.setBackground(Color.green);
                                nombre.setBackground(Color.green);
                                nacionalidad.setBackground(Color.green);
                                
                                JOptionPane.showMessageDialog(null, "Autor actualizado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Error al actualizar datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+e.getMessage());
                        }
                        if(Biblioteca.sesion==1){
                            metodo();
                        }else{
                            
                        }
                    }
                }else if(op.equals("Eliminar")){
                    String[] opcion={"Si", "No"};
                    int delete=JOptionPane.showOptionDialog(null, "¿Estás seguro de eliminar este autor?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, 
                            icono("/imagenes/eliminar.png", 30, 30), opcion, opcion[0]);
                    if(delete==JOptionPane.YES_OPTION){
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("DELETE FROM AUTORES WHERE ID_AUTOR="+id_autor.getText());
                        
                            if(psp.executeUpdate()==1){
                                JOptionPane.showMessageDialog(null, "Autor eliminado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Error al eliminar datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+e.getMessage());
                        }
                    }
                }
            }catch(NullPointerException e){
                
            }
        }else if(s.getSource()==limpiar){
            id_autor.setText("");
            nombre.setText("");
            nacionalidad.setText("");
            id_autor.setEditable(true);
            option.setEnabled(false);
            buscar.setEnabled(false);
            limpiar.setEnabled(false);
        }else if(s.getSource()==generar){
            Document documento=new Document();
            try{
                String[] opciones={"Definir Ruta", "Ruta Predeterminada", "Cancelar"};
                String op=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", JOptionPane.INFORMATION_MESSAGE,
                        icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
                if(op.equals("Definir Ruta")){
                    JFileChooser seleccion=new JFileChooser();
                    int kaijuu=seleccion.showSaveDialog(null);
                    if(kaijuu==seleccion.APPROVE_OPTION){
                        try{
                            String archivo=seleccion.getSelectedFile()+".pdf";
                            FileOutputStream stream=new FileOutputStream(archivo);
                            PdfWriter.getInstance(documento, stream);
                            
                            PdfPTable tabla2=new PdfPTable(3);
                            tabla2.addCell("ID del Autor");
                            tabla2.addCell("Nombre");
                            tabla2.addCell("Nacionalidad");
                            
                            com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            himel.scaleToFit(91, 196);
                            himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                            Paragraph parrafo2=new Paragraph();
                            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo2.add("AUTORES REGISTRADOS\n\n");
                            
                            documento.open();
                            documento.add(himel);
                            
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM AUTORES ORDER BY ID_AUTOR");
                                ResultSet set=psp.executeQuery();
                                
                                if(set.next()){
                                    do{
                                        tabla2.addCell(String.valueOf(set.getInt(1)));
                                        tabla2.addCell(set.getString(2));
                                        tabla2.addCell(set.getString(3));
                                    }while(set.next());
                                    documento.add(parrafo2);
                                    documento.add(tabla2);
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
                }else if(op.equals("Ruta Predeterminada")){
                    String ruta=System.getProperty("user.home");
                    FileOutputStream strem=new FileOutputStream(ruta+"/desktop/Autores.pdf");
                    PdfWriter.getInstance(documento, strem);
                    
                    try{
                        PdfPTable tabla2=new PdfPTable(3);
                        tabla2.addCell("ID del Autor");
                        tabla2.addCell("Nombre");                            
                        tabla2.addCell("Nacionalidad");
                            
                        
                        com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        himel.scaleToFit(91, 196);
                        himel.setAlignment(Chunk.ALIGN_LEFT);
                            
                        Paragraph parrafo2=new Paragraph();
                        parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo2.add("AUTORES REGISTRADOS\n\n");
                            
                        documento.open();
                        documento.add(himel);
                            
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM AUTORES ORDER BY ID_AUTOR");
                            ResultSet set=psp.executeQuery();
                                
                            if(set.next()){
                                do{
                                    tabla2.addCell(String.valueOf(set.getInt(1)));
                                    tabla2.addCell(set.getString(2));
                                    tabla2.addCell(set.getString(3));
                                }while(set.next());
                                documento.add(parrafo2);
                                documento.add(tabla2);
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
                }else if(op.equals("Cancelar")){
                    JOptionPane.showMessageDialog(null, "Operación Cancelada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){
                
            }
        }else if(s.getSource()==buscar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM AUTORES WHERE ID_AUTOR="+id_autor.getText());
                
                ResultSet set=psp.executeQuery();
                
                if(set.next()){
                    id_autor.setText(String.valueOf(set.getInt("ID_AUTOR")));
                    nombre.setText(String.valueOf(set.getString("NOMBRE")));
                    nacionalidad.setText(String.valueOf(set.getString("NACIONALIDAD")));
                    limpiar.setEnabled(true);
                    option.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Autor no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    id_autor.setText("");
                    nombre.setText("");
                    nacionalidad.setText("");
                    
                }
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "Error al localizar datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
        }
    }
    
    public static void main(String[] args){
        Autores query=new Autores();
        query.setBounds(0, 0, 250, 400);
        query.setVisible(true);
        query.setResizable(false);
        query.setLocationRelativeTo(null);
    }
}
