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
public class Tutores_Alumnos extends JFrame implements ActionListener, KeyListener{
    private JLabel ticket, ticket2, ticket3, fondo;
    public static JTextField tabla, alumno, tutor;
    public static JButton btn, btn2, btn3, btn4;
    
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user="Sebastian";
    String password="admin";
    
    public Tutores_Alumnos(){
        setLayout(null);
        int sesion=Base_Datos.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        ImageIcon imagen=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(imagen.getImage());
        setTitle("Tutores Alumnos");
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("ID de la Tabla:");
        ticket.setBounds(10, 160, 100, 25);
        ticket.setFont(estilo);
        ticket.setForeground(Color.white);
        add(ticket);
        
        tabla=new JTextField();
        tabla.addKeyListener(this);
        tabla.setBorder(border);
        tabla.setBounds(100, 160, 120, 25);
        tabla.setFont(estilo);
        tabla.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        add(tabla);
        
        ticket2=new JLabel("ID del Alumno:");
        ticket2.setBounds(10, 195, 120, 25);
        ticket2.setFont(estilo);
        ticket2.setForeground(Color.white);
        add(ticket2);
        
        alumno=new JTextField();
        alumno.addKeyListener(this);
        alumno.setBorder(border);
        alumno.setBounds(100, 195, 120, 25);
        alumno.setFont(estilo);  
        alumno.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        add(alumno);
        
        ticket3=new JLabel("ID del Tutor:");
        ticket3.setBounds(10, 230, 100, 25);
        ticket3.setFont(estilo);
        ticket3.setForeground(Color.white);
        add(ticket3);
        
        tutor=new JTextField();
        tutor.addKeyListener(this);
        tutor.setBorder(border);
        tutor.setBounds(100, 230, 120, 25);
        tutor.setFont(estilo);
        tutor.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        add(tutor);
        
        btn=new JButton("Opciones");
        btn.addActionListener(this);
        btn.setBorder(border);
        btn.setBounds(10, 265, 100, 25);
        btn.setEnabled(false);
        btn.setFocusPainted(false);
        btn.setFont(estilo);
        add(btn);
        
        btn2=new JButton("Limpiar todo");
        btn2.addActionListener(this);
        btn2.setBorder(border);
        btn2.setEnabled(false);
        btn2.setBounds(120, 265, 100, 25);
        btn2.setFocusPainted(false);
        btn2.setFont(estilo);
        add(btn2);
        
        btn3=new JButton("Generar PDF");
        btn3.addActionListener(this);
        btn3.setBorder(border);
        btn3.setBounds(10, 300, 100, 25);
        btn3.setFocusPainted(false);
        btn3.setFont(estilo);
        add(btn3);
        
        btn4=new JButton("Buscar");
        btn4.addActionListener(this);
        btn4.setBorder(border);
        btn4.setBounds(120, 300, 100, 25);
        btn4.setEnabled(false);
        btn4.setFocusPainted(false);
        btn4.setFont(estilo);
        add(btn4);
        
        ImageIcon image=new ImageIcon("src/imagenes/miku belicona.jpeg");
        fondo=new JLabel(image);
        fondo.setBounds(0, 0, 250, 377);
        add(fondo);
        
    }
    
    public void metodo(){
        Base_Datos.model.setRowCount(0);
        Base_Datos.model.setColumnCount(0);      
        try{
            Connection cnn=DriverManager.getConnection(Base_Datos.url, Base_Datos.user, Base_Datos.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM TUTORES_ALUMNOS ORDER BY ID_TABLA");

            ResultSet set=psp.executeQuery();
            
            Base_Datos.model.addColumn("ID de la Tabla");
            Base_Datos.model.addColumn("ID del Alumno");
            Base_Datos.model.addColumn("ID del Tutor");

            while(set.next()){
                Object[] fila=new Object[3];
                for(int i=0;i<3;i++){
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
    
    public void habilitarBtn(){
        String yoasobi=tabla.getText().trim();
        String mwam=alumno.getText().trim();
        String milet=tutor.getText().trim();
        
        if(yoasobi.equals("") | mwam.equals("") | milet.equals("")){
            btn.setEnabled(false);
        }else{
            btn.setEnabled(true);
        }
        
        if(yoasobi.equals("") | mwam.equals("") | milet.equals("")){
            btn2.setEnabled(false);
        }else{
            btn2.setEnabled(true);
        }
    }
    
    public Icon icono(String camino, int a, int o){
        Icon imagen=new ImageIcon(new ImageIcon (getClass().
            getResource(camino)).getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        Icon icono=null;
        if(s.getSource()==btn){
            
            int estudiante=Integer.parseInt(alumno.getText());
            int asesor=Integer.parseInt(tutor.getText());
            
            try{
                String[] opciones={"Registrar", "Modificar", "Eliminar"};
                String op=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", JOptionPane.INFORMATION_MESSAGE,
                        icono , opciones, opciones[0]);
            
                if(op.equals("Registrar")){
                    try{
                        Connection cnn=DriverManager.getConnection(url, user, password);
                        PreparedStatement psp=cnn.prepareStatement("INSERT INTO TUTORES_ALUMNOS VALUES(?,?,?)");
                        
                        psp.setInt(1, 1);
                        psp.setInt(2, estudiante);
                        psp.setInt(3, asesor);
                        
                        if(psp.executeUpdate()==1){
                            JOptionPane.showMessageDialog(null, "Nuevo ID de tutor insertado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo insertar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    }catch(HeadlessException | SQLException e){
                        JOptionPane.showMessageDialog(null, "Error al insertar"+e.getMessage(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }else if(op.equals("Modificar")){
                    String[] op2={"Si", "No"};
                    int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), op2, op2[0]);
                    if(modify==JOptionPane.YES_OPTION){
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("UPDATE TUTORES_ALUMNOS SET ID_ALUMNO=?, ID_TUTOR=? WHERE ID_TABLA="+tabla.getText());
                            
                            psp.setInt(1, estudiante);
                            psp.setInt(2, asesor);
                            
                            if(psp.executeUpdate()==1){
                                tabla.setBackground(Color.green);
                                alumno.setBackground(Color.green);
                                tutor.setBackground(Color.green);
                                JOptionPane.showMessageDialog(null, "ID de tutor actualizado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Error al actualizar ID de tutor: "+e.getMessage(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if(Base_Datos.sesion==1){
                            metodo();
                        }else{
                        
                        }
                    }
                }else if(op.equals("Eliminar")){
                    String[] opcion={"Si", "No"};
                    int delete=JOptionPane.showOptionDialog(null, "¿Estás seguro de eliminar este tutor?", "Advertencia", 
                    JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), opcion, opcion[0]);
                    if(delete==JOptionPane.YES_OPTION){
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("DELETE FROM TUTORES_ALUMNOS WHERE ID_TABLA="+tabla.getText());
                        
                            if(psp.executeUpdate()==1){
                                JOptionPane.showMessageDialog(null, "ID de tutor eliminado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Error al eliminar ID de tutor: "+e.getMessage(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }catch(NullPointerException e){
                
            }
        }else if(s.getSource()==btn2){
            tabla.setText("");
            tutor.setText("");
            alumno.setText("");
            tabla.setEditable(true);
            btn.setEnabled(false);
            btn2.setEnabled(false);
            btn2.setText("Limpiar todo");
            btn4.setEnabled(false);
        }else if(s.getSource()==btn3){
            Document documento=new Document();
            try{
                String[] opciones={"Definir ruta", "Ruta Predeterminada", "Cancelar"};
                String op=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", JOptionPane.INFORMATION_MESSAGE,
                        icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
            
                if(op.equals("Definir ruta")){
                    JFileChooser seleccion=new JFileChooser();
                    int kaijuu=seleccion.showSaveDialog(null);
                    if(kaijuu==seleccion.APPROVE_OPTION){
                        try{
                            String archivo=seleccion.getSelectedFile()+".pdf";
                            FileOutputStream file=new FileOutputStream(archivo);
                            PdfWriter.getInstance(documento, file);
                            
                            PdfPTable tabla=new PdfPTable(3);
                            tabla.addCell("ID");
                            tabla.addCell("ID de La Carreras");
                            tabla.addCell("ID del Alumno");
                            
                            com.itextpdf.text.Image imagen=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            imagen.scaleToFit(91, 196);
                            imagen.setAlignment(Chunk.ALIGN_LEFT);
                            
                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("ID DE TUTORES REGISTRADOS\n\n");
                            
                            Paragraph texto=new Paragraph();
                            texto.setAlignment(Paragraph.ALIGN_CENTER);
                            texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                            texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
                            
                            documento.open();
                            documento.add(imagen);
                            documento.add(parrafo);
                            
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM TUTORES_ALUMNOS ORDER BY ID_TABLA");
                                
                                ResultSet set=psp.executeQuery();
                                
                                if(set.next()){
                                    do{
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(String.valueOf(set.getInt(2)));
                                        tabla.addCell(String.valueOf(set.getInt(3)));
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
                                JOptionPane.showMessageDialog(null, "Reporte generado exitosamente\nen "+archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(SQLException e){
                                JOptionPane.showMessageDialog(null, "No se pudo localizar a los ID's", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                e.printStackTrace();
                            }
                        }catch(DocumentException | IOException e){
                            JOptionPane.showMessageDialog(null, "No pudo generar archivo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            e.printStackTrace();
                        }
                    }
                }else if(op.equals("Ruta Predeterminada")){
                    try{
                        String ruta=System.getProperty("user.home");
                        FileOutputStream file=new FileOutputStream(ruta+"/desktop/Tutores Alumnos.pdf");
                        PdfWriter.getInstance(documento, file);
                    
                        PdfPTable tabla=new PdfPTable(3);
                        tabla.addCell("ID");
                        tabla.addCell("ID de La Carreras");
                        tabla.addCell("ID del Alumno");
                         
                        com.itextpdf.text.Image imagen=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        imagen.scaleToFit(91, 196);
                        imagen.setAlignment(Chunk.ALIGN_LEFT);
                         
                        Paragraph parrafo=new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("ID DE TUTORES REGISTRADOS\n\n");
                            
                        Paragraph texto=new Paragraph();
                        texto.setAlignment(Paragraph.ALIGN_CENTER);
                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                        texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
                           
                        documento.open();
                        documento.add(imagen);
                        documento.add(parrafo);
                            
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM TUTORES_ALUMNOS ORDER BY ID_TABLA");
                                
                            ResultSet set=psp.executeQuery();
                                
                            if(set.next()){
                                    do{
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(String.valueOf(set.getInt(2)));
                                        tabla.addCell(String.valueOf(set.getInt(3)));
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
                                JOptionPane.showMessageDialog(null, "Reporte generado exitosamente en\nel escritorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(SQLException e){
                                JOptionPane.showMessageDialog(null, "No se pudo localizar a los ID's", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                e.printStackTrace();
                            }
                    }catch(DocumentException | HeadlessException | IOException e){
                        JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo generar PDF", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                }else if(op.equals("Cancelar")){
                    
                }
            }catch(NullPointerException e){
                
            }
        }else if(s.getSource()==btn4){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM TUTORES_ALUMNOS WHERE ID_TABLA="+tabla.getText());
                
                ResultSet set=psp.executeQuery();
                
                if(set.next()){
                    tabla.setText(String.valueOf(set.getInt("ID_TABLA")));
                    alumno.setText(String.valueOf(set.getInt("ID_ALUMNO")));
                    tutor.setText(String.valueOf(set.getInt("ID_TUTOR")));
                    btn.setEnabled(true);
                    btn2.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "ID de tutor no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    tabla.setText("");
                    alumno.setText("");
                    tabla.setText("");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                    btn4.setEnabled(false);
                }
            }catch(HeadlessException | SQLException e){
                
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent s){
        if(s.getSource()==tabla){
            String reona=tabla.getText().trim();
            if(reona.equals("")){
                btn4.setEnabled(false);
            }else{
                btn4.setEnabled(true);
            }
            
            habilitarBtn();
        }else if(s.getSource()==tutor){
            habilitarBtn();
        }else if(s.getSource()==alumno){
            habilitarBtn();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent s){
        int llave=s.getKeyChar();
        if(s.getSource()==tabla){
            if(!(llave>=48 & llave<=57)){
                s.consume();
            }
            
            if(tabla.getText().length()>=4){
                s.consume();
            }
        }else if(s.getSource()==alumno){
            if(!(llave>=48 & llave<=57)){
                s.consume();
            }
            
            if(alumno.getText().length()>=4){
                s.consume();
            }
        }else if(s.getSource()==tutor){
            if(!(llave>=48 & llave<=57)){
                s.consume();
            }
            
            if(tutor.getText().length()>=4){
                s.consume();
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent s){
        
    }
    
    public static void main(String[] args){
        Tutores_Alumnos TA=new Tutores_Alumnos();
        TA.setBounds(0, 0, 250, 400);
        TA.setVisible(true);
        TA.setResizable(false);
        TA.setLocationRelativeTo(null);
    }
}
