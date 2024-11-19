package proyecto_ceteq;
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
public class Alumnos extends JFrame implements ActionListener, KeyListener{
    private JLabel ticket, ticket2, ticket3, 
            ticket4, ticket5, ticket6, ticket7, fondo;
    public static JTextField nombre, grupo, fecha,
            genero, ciudad, status, id;
    public static JButton registrar, modificar,
            eliminar, buscar, borrar, generar;
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user="Sebastian";
    String password="admin";
    public Alumnos(){
        setLayout(null);
        int sesion=Base_Datos.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            
        }
        setTitle("BD Alumnos");
        ImageIcon icono=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(icono.getImage());
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("Nombre:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(estilo);
        add(ticket);
        
        nombre=new JTextField();
        nombre.setBounds(10, 35, 120, 25);
        nombre.setBorder(border);
        nombre.addKeyListener(this);
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
        grupo.addKeyListener(this);
        grupo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        grupo.setFont(estilo);
        add(grupo);
        
        ticket3=new JLabel("Género:");
        ticket3.setBounds(140, 10, 150, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        genero=new JTextField();
        genero.setBounds(140, 35, 120, 25);
        genero.setBorder(border);
        genero.addKeyListener(this);
        genero.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        genero.setFont(estilo);
        add(genero);
        
        ticket4=new JLabel("Fecha de nacimiento:");
        ticket4.setBounds(140, 70, 150, 25);
        ticket4.setFont(estilo);
        add(ticket4);
        
        fecha=new JTextField();
        fecha.setBounds(140, 95, 120, 25);
        fecha.setBorder(border);
        fecha.addKeyListener(this);
        fecha.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        fecha.setFont(estilo);
        add(fecha);
        
        ticket5=new JLabel("Ciudad:");
        ticket5.setBounds(270, 10, 150, 25);
        ticket5.setFont(estilo);
        add(ticket5);
        
        ciudad=new JTextField();
        ciudad.setBounds(270, 35, 120, 25);
        ciudad.setBorder(border);
        ciudad.addKeyListener(this);
        ciudad.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        ciudad.setFont(estilo);
        add(ciudad);
        
        ticket6=new JLabel("Status:");
        ticket6.setBounds(270, 70, 150, 25);
        ticket6.setFont(estilo);
        add(ticket6);
        
        status=new JTextField();
        status.setBounds(270, 95, 120, 25);
        status.setBorder(border);
        status.addKeyListener(this);
        status.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        status.setFont(estilo);
        add(status);
        
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
        
        eliminar=new JButton("Eliminar");
        eliminar.setBounds(230, 130, 100, 25);
        eliminar.setFont(estilo);
        eliminar.setBorder(border);
        eliminar.setEnabled(false);
        eliminar.setFocusPainted(false);
        eliminar.addActionListener(this);
        add(eliminar);
        
        ticket7=new JLabel("ID del Alumno:");
        ticket7.setBounds(10, 165, 120, 25);
        ticket7.setFont(estilo);
        add(ticket7);
        
        id=new JTextField();
        id.setBounds(100, 165, 120, 25);
        id.setBorder(border);
        id.addKeyListener(this);
        id.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        id.setFont(estilo);
        add(id);
        
        buscar=new JButton("Buscar");
        buscar.setBounds(230, 165, 100, 25);
        buscar.setFont(estilo);
        buscar.setBorder(border);
        buscar.setEnabled(false);
        buscar.setFocusPainted(false);
        buscar.addActionListener(this);
        add(buscar);
        
        borrar=new JButton("Limpiar todo");
        borrar.setBounds(200, 200, 100, 25);
        borrar.setFont(estilo);
        borrar.setEnabled(false);
        borrar.setBorder(border);
        borrar.setFocusPainted(false);
        borrar.addActionListener(this);
        add(borrar);
        
        generar=new JButton("Generar PDF de Alumnos");
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
        Base_Datos.model.setRowCount(0);
        Base_Datos.model.setColumnCount(0);        
        try{
            Connection cnn=DriverManager.getConnection(Base_Datos.url, Base_Datos.user, Base_Datos.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM ESTUDIANTES ORDER BY ID_ALUMNO");

            ResultSet set=psp.executeQuery();

            Base_Datos.model.addColumn("ID del Alumno");
            Base_Datos.model.addColumn("Nombre");
            Base_Datos.model.addColumn("Fecha de Nacimiento");
            Base_Datos.model.addColumn("Género");
            Base_Datos.model.addColumn("Grado");
            Base_Datos.model.addColumn("Ciudad");
            Base_Datos.model.addColumn("Status");

            while(set.next()){
                Object[] fila=new Object[7];
                for(int i=0;i<7;i++){
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
        String group=grupo.getText().trim();
        String date=fecha.getText().trim();
        String gender=genero.getText().trim();
        String city=ciudad.getText().trim();
        String estado=status.getText().trim();
        if(name.equals("") | group.equals("") | date.equals("") | 
                gender.equals("") | city.equals("") | estado.equals("")){
            modificar.setEnabled(false);
        }else{
            modificar.setEnabled(true);
        }
        
        if(name.equals("") | group.equals("") | date.equals("") | 
                gender.equals("") | city.equals("") | estado.equals("")){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
        
        if(name.equals("") | group.equals("") | date.equals("") | 
                gender.equals("") | city.equals("") | estado.equals("")){
            borrar.setEnabled(false);
        }else{
            borrar.setEnabled(true);
        }
        
        if(name.equals("") | group.equals("") | date.equals("") | 
                gender.equals("") | city.equals("") | estado.equals("")){
            eliminar.setEnabled(false);
        }else{
            eliminar.setEnabled(true);
        }
    }
    
    public Icon icono(String path, int w, int h){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        String name=nombre.getText().trim();
        String group=grupo.getText().trim();
        String date=fecha.getText().trim();
        String gender=genero.getText().trim();
        String city=ciudad.getText().trim();
        String estado=status.getText().trim();
        String search=id.getText().trim();
        if(s.getSource()==registrar){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("INSERT INTO ESTUDIANTES VALUES (?,?,?,?,?,?,?)");
                
                psp.setInt(1, 1);
                psp.setString(2, name);
                psp.setDate(3, Date.valueOf(date));
                psp.setString(4, gender);
                psp.setString(5, group);
                psp.setString(6, city);
                psp.setInt(7, Integer.parseInt(estado));
                
                int flag=psp.executeUpdate();
                if(flag==1){
                    JOptionPane.showMessageDialog(null, "Alumno insertado exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar alumno",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                
                PreparedStatement psp2=cnn.prepareStatement("SELECT * FROM ESTUDIANTES WHERE NOMBRE='"+name+"'");
                ResultSet set=psp2.executeQuery();
                
                if(set.next()){
                    id.setText(String.valueOf(set.getInt("ID_ALUMNO")));
                    buscar.setEnabled(true);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }else if(s.getSource()==modificar){
            String[] op={"Si", "No"};
            int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), op, op[0]);
            if(modify==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    PreparedStatement psp=cnn.prepareStatement("UPDATE ESTUDIANTES SET NOMBRE=?,"
                        +" FEC_NACIMIENTO=?, GENERO=?, GRADO=?, CIUDAD=?, ESTADO=? WHERE ID_ALUMNO="+search);
                    
                    psp.setString(1, name);
                    psp.setDate(2, Date.valueOf(date));
                    psp.setString(3, gender);
                    psp.setString(4, group);
                    psp.setString(5, city);
                    psp.setInt(6, Integer.parseInt(estado));
                
                    int flag=psp.executeUpdate();
                    if(flag==1){
                        nombre.setBackground(Color.green);
                        fecha.setBackground(Color.green);
                        genero.setBackground(Color.green);
                        grupo.setBackground(Color.green);
                        ciudad.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Alumno actualizado exitosamente",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Hubo un error al insertar alumno",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e);
                }
                if(Base_Datos.sesion==1){
                    metodo();
                }else{
                    
                }
            }
        }else if(s.getSource()==eliminar){
            if(name.equals("") & group.equals("") & date.equals("") & 
                    gender.equals("") & city.equals("") & estado.equals("")){
                JOptionPane.showMessageDialog(null, "No se permiten espacios vacíos",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String[] op={"Si", "No"};
                int v=JOptionPane.showOptionDialog(null, "¿Estas seguro de eliminar a este estudiante?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, 
                    JOptionPane.YES_NO_CANCEL_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
                if(v==JOptionPane.YES_OPTION){
                    try{
                        Class.forName("oracle.jdbc.OracleDriver");
                        Connection cnn=DriverManager.getConnection(url, user, password);
                        PreparedStatement psp=cnn.prepareStatement("DELETE FROM ESTUDIANTES WHERE ID_ALUMNO="+search);
                        
                        //Únicamente mandamos la info del ID a eliminar
                        int flag=psp.executeUpdate();
                        
                        if(flag==1){
                            JOptionPane.showMessageDialog(null, "Alumnos eliminado exitosamente",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            id.setText("");
                            nombre.setText("");
                            fecha.setText("");
                            genero.setText("");
                            grupo.setText("");
                            ciudad.setText("");
                            status.setText("");
                            registrar.setEnabled(false);
                            modificar.setEnabled(false);
                            eliminar.setEnabled(false);
                            borrar.setEnabled(false);
                            buscar.setEnabled(false);
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar alumno",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch(ClassNotFoundException | SQLException e){
                        System.err.println("Error al eliminar: "+s);
                        e.printStackTrace();
                    } 
                }
                
            }
        }else if(s.getSource()==buscar){
            try{
                    
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM ESTUDIANTES WHERE ID_ALUMNO="+search);
                    
                
                ResultSet set=psp.executeQuery();
                
                if(set.next()){                
                    nombre.setText(set.getString("NOMBRE"));                    
                    fecha.setText(String.valueOf(set.getDate("FEC_NACIMIENTO")));                    
                    genero.setText(set.getString("GENERO"));                    
                    grupo.setText(set.getString("GRADO"));
                    ciudad.setText(set.getString("CIUDAD"));
                    status.setText(String.valueOf(set.getInt("ESTADO")));
                    registrar.setEnabled(true);
                    modificar.setEnabled(true);
                    eliminar.setEnabled(true);
                    borrar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Alumno no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    id.setText("");
                    nombre.setText("");
                    fecha.setText("");
                    genero.setText("");
                    grupo.setText("");
                    ciudad.setText("");
                    status.setText("");
                    registrar.setEnabled(false);
                    modificar.setEnabled(false);
                    eliminar.setEnabled(false);
                    borrar.setEnabled(false);
                    buscar.setEnabled(false);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }else if(s.getSource()==borrar){
            buscar.setEnabled(false);
            nombre.setText("");
            grupo.setText("");
            fecha.setText("");
            genero.setText("");
            ciudad.setText("");
            status.setText("");
            id.setText("");
            id.setEditable(true);
            registrar.setEnabled(false);
            modificar.setEnabled(false);
            eliminar.setEnabled(false);
            borrar.setEnabled(false);
            borrar.setText("Limpiar todo");
        }else if(s.getSource()==generar){
            Document documento=new Document();
            try{
                Icon icono=null;
                String opciones[]={"Definir Ruta", "Ruta Definida", "Cancelar"};
                String respuesta=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
                /*int op=JOptionPane.showOptionDialog(null, "Elige una opción", "Mensaje", JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);*/
                if(respuesta.equals("Definir Ruta")){
                    JFileChooser DC=new JFileChooser();
                    int kaijuu=DC.showSaveDialog(null);
                    if(kaijuu==DC.APPROVE_OPTION){
                        try{
                            String archivo=DC.getSelectedFile()+".pdf";
                            PdfWriter.getInstance(documento, new FileOutputStream(archivo));

                            PdfPTable tabla=new PdfPTable(7);
                            tabla.addCell("ID del Alumno");
                            tabla.addCell("Nombre");
                            tabla.addCell("Fecha de nacimiento");
                            tabla.addCell("Género");
                            tabla.addCell("Grado");
                            tabla.addCell("Ciudad");
                            tabla.addCell("Status");

                            com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                            himel.scaleToFit(91, 196);
                            himel.setAlignment(Chunk.ALIGN_LEFT);

                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("ESTUDIANTES REGISTRADOS\n\n");
                        
                            Paragraph texto=new Paragraph();
                            texto.setAlignment(Paragraph.ALIGN_CENTER);
                            texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                            texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");

                            documento.open();
                            documento.add(himel);
                            documento.add(parrafo);
                        
                            try{
                                Connection cnn=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp=cnn.prepareStatement("select * from estudiantes order by id_alumno");
                            
                                ResultSet set=psp.executeQuery();

                                if(set.next()){
                                    do{
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(set.getString(2));
                                        tabla.addCell(set.getString(3));
                                        tabla.addCell(set.getString(4));
                                        tabla.addCell(set.getString(5));
                                        tabla.addCell(set.getString(6));
                                        tabla.addCell(String.valueOf(set.getInt(7)));
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
                        }catch(DocumentException | HeadlessException | IOException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            e.printStackTrace();
                        }
                    }
                }else if(respuesta.equals("Ruta Definida")){
                    try{
                        String ruta=System.getProperty("user.home");
                        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/desktop/Alumnos.pdf"));
                        
                        PdfPTable tabla=new PdfPTable(7);
                        tabla.addCell("ID del Alumno");
                        tabla.addCell("Nombre");
                        tabla.addCell("Fecha de nacimiento");
                        tabla.addCell("Género");
                        tabla.addCell("Grado");
                        tabla.addCell("Ciudad");
                        tabla.addCell("Status");
                    
                        com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        himel.scaleToFit(91, 196);
                        himel.setAlignment(Chunk.ALIGN_LEFT);
                        
                        Paragraph parrafo=new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.add("Formato PDF creado por ©Ceteq Puebla\n\n");
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("ESTUDIANTES REGISTRADOS\n\n");
                        
                        Paragraph texto=new Paragraph();
                        texto.setAlignment(Paragraph.ALIGN_CENTER);
                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                        texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
                        
                        documento.open();
                        documento.add(himel);
                        documento.add(parrafo);
                        
                        try{
                            Connection cnn=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp=cnn.prepareStatement("select * from estudiantes order by id_alumno");
                            
                            ResultSet set=psp.executeQuery();
                            
                            if(set.next()){
                                do{
                                    tabla.addCell(String.valueOf(set.getInt(1)));
                                    tabla.addCell(set.getString(2));
                                    tabla.addCell(set.getString(3));
                                    tabla.addCell(set.getString(4));
                                    tabla.addCell(set.getString(5));
                                    tabla.addCell(set.getString(6));
                                    tabla.addCell(String.valueOf(set.getInt(7)));
                                }while(set.next());
                                documento.add(tabla);
                            }else{
                                Paragraph parrafo2 = new Paragraph();
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
                    }catch(DocumentException | HeadlessException | IOException e){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }  
                }else if(respuesta.equals("Cancelar")){
                
                }
            }catch(NullPointerException e){
                //System.err.println("Error: "+e);
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent s){
        if(s.getSource()==id){
            String busqueda=id.getText().trim();
            if(busqueda.isEmpty()){
                buscar.setEnabled(false);
            }else{
                buscar.setEnabled(true);
            }
        }else if(s.getSource()==nombre){
            habilitarBoton();
        }else if(s.getSource()==grupo){
            habilitarBoton();
        }else if(s.getSource()==fecha){
            habilitarBoton();
        }else if(s.getSource()==genero){
            habilitarBoton();
        }else if(s.getSource()==ciudad){
            habilitarBoton();
        }else if(s.getSource()==status){
            habilitarBoton();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent s){
        if(s.getSource()==id){
            int llave=s.getKeyChar();
            
            if(!(llave>=48 & llave<=57)){
                s.consume();
            }
            
            if(id.getText().length()>=4){
                s.consume();
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent s){
        
    }
    
    public static void main(String[] args){
        Alumnos query=new Alumnos();
        query.setBounds(0, 0, 440, 300);
        query.setVisible(true);
        query.setResizable(false);
        query.setLocationRelativeTo(null);
    }
    
}
