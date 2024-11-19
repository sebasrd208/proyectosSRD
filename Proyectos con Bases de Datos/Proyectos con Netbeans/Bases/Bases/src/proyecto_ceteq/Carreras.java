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
 * 
 */
public class Carreras extends JFrame implements ActionListener, KeyListener{
    private JLabel ticket, ticket2, ticket3, 
            ticket4, ticket5, fondo;
    public static JTextField nombre, periodo, carrera,
            pension, ID;
    public static JButton registrar, modificar,
            eliminar, buscar, borrar, generar;
    
    public Carreras(){
        setLayout(null);
        int sesion=Base_Datos.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        setTitle("BD Carreras");
        ImageIcon icono=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(icono.getImage());
        
        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("Nombre:");
        ticket.setBounds(10, 10, 80, 25);
        ticket.setFont(estilo);
        add(ticket);
        
        nombre=new JTextField();
        nombre.setBounds(10, 35, 200, 25);
        nombre.setBorder(border);
        nombre.addKeyListener(this);
        nombre.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        nombre.setFont(estilo);
        add(nombre);
        
        ticket2=new JLabel("Periodo:");
        ticket2.setBounds(10, 70, 80, 25);
        ticket2.setFont(estilo);
        add(ticket2);
        
        periodo=new JTextField();
        periodo.setBounds(10, 95, 120, 25);
        periodo.setBorder(border);
        periodo.addKeyListener(this);
        periodo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        periodo.setFont(estilo);
        add(periodo);
        
        ticket3=new JLabel("Carrera:");
        ticket3.setBounds(230, 10, 150, 25);
        ticket3.setFont(estilo);
        add(ticket3);
        
        carrera=new JTextField();
        carrera.setBounds(230, 35, 150, 25);
        carrera.setBorder(border);
        carrera.addKeyListener(this);
        carrera.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        carrera.setFont(estilo);
        add(carrera);
        
        ticket4=new JLabel("Pensión:");
        ticket4.setBounds(140, 70, 150, 25);
        ticket4.setFont(estilo);
        add(ticket4);
        
        pension=new JTextField();
        pension.setBounds(140, 95, 120, 25);
        pension.setBorder(border);
        pension.addKeyListener(this);
        pension.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        pension.setFont(estilo);
        add(pension);
        
        ticket5=new JLabel("ID del Alumno:");
        ticket5.setBounds(10, 165, 120, 25);
        ticket5.setFont(estilo);
        add(ticket5);
        
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
        borrar.setEnabled(false);
        borrar.setBorder(border);
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
        Base_Datos.model.setRowCount(0);
        Base_Datos.model.setColumnCount(0);        
        try{
            Connection cnn=DriverManager.getConnection(Base_Datos.url, Base_Datos.user, Base_Datos.password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM CARRERAS ORDER BY ID_CARRERA");

            ResultSet set=psp.executeQuery();

            Base_Datos.model.addColumn("ID de la Carrera");
            Base_Datos.model.addColumn("Nombre");
            Base_Datos.model.addColumn("Periodo de la materia");
            Base_Datos.model.addColumn("Carrera");
            Base_Datos.model.addColumn("Pensión Mensual ($)");

            while(set.next()){
                Object[] fila=new Object[5];
                for(int i=0;i<5;i++){
                    fila[i]=set.getObject(1+i);                        
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
        String period=periodo.getText().trim();
        String collage=carrera.getText().trim();
        String pension2=pension.getText().trim();
        if(name.equals("") | period.equals("") | collage.equals("") | 
                pension2.equals("")){
            modificar.setEnabled(false);
        }else{
            modificar.setEnabled(true);
        }
        
        if(name.equals("") | period.equals("") | collage.equals("") | 
                pension2.equals("")){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
        
        if(name.equals("") | period.equals("") | collage.equals("") | 
                pension2.equals("")){
            eliminar.setEnabled(false);
        }else{
            eliminar.setEnabled(true);
        }
        
        if(name.equals("") | period.equals("") | collage.equals("") | 
                pension2.equals("")){
            borrar.setEnabled(false);
        }else{
            borrar.setEnabled(true);
        }
    }
    
    public Icon icono(String path, int w, int h){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        String search=ID.getText().trim();
        String name=nombre.getText().trim();
        String period=periodo.getText().trim();
        String collage=carrera.getText().trim();
        String pension2=pension.getText().trim();
        if(s.getSource()==registrar){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                PreparedStatement psp=cnn.prepareStatement("INSERT INTO CARRERAS VALUES (?,?,?,?,?)");
                
                psp.setInt(1, 1);
                psp.setString(2, name);
                psp.setString(3, period);
                psp.setString(4, collage);
                psp.setDouble(5, Double.parseDouble(pension2.replace("$", "")));
                
                int flag=psp.executeUpdate();
                if(flag==1){
                    nombre.setBackground(Color.green);
                    periodo.setBackground(Color.green);
                    carrera.setBackground(Color.green);
                    pension.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Carrera insertada exitosamente con el ID "+search,
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar carrera",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }else if(s.getSource()==modificar){
            String[] op={"Si", "No"};
            int modify=JOptionPane.showOptionDialog(null, "Los datos serán modificados, ¿Deseas realizar esta acción?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 40, 40), op, op[0]);
            if(modify==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                    PreparedStatement psp=cnn.prepareStatement("UPDATE CARRERAS SET NOMBRE=?, DURACION=?, "
                            +"AREA=?, P_MENSUAL=? WHERE ID_CARRERA="+search);
                
                    psp.setString(1, name);
                    psp.setString(2, period);
                    psp.setString(3, collage);
                    psp.setDouble(4, Double.parseDouble(pension2.replace("$", "")));
                
                    int flag=psp.executeUpdate();
                    if(flag==1){
                        nombre.setBackground(Color.green);
                        periodo.setBackground(Color.green);
                        carrera.setBackground(Color.green);
                        pension.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Carrera actualizada exitosamente",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Hubo un error al insertar carrera",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NumberFormatException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e.getMessage());
                }   
                if(Base_Datos.sesion==1){
                    metodo();
                }else{
                    
                }
            }
        }else if(s.getSource()==eliminar){
            String[] op={"Si", "No"};
            int delete=JOptionPane.showOptionDialog(null, "¿Estás seguro de eliminar esta carrera?", "Advertencia", 
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
            if(delete==JOptionPane.YES_OPTION){
                try{
                    Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                    PreparedStatement psp=cnn.prepareStatement("DELETE FROM CARRERAS WHERE ID_CARRERA="+search);
                        
                    //Únicamente mandamos la info del ID a eliminar
                    int flag=psp.executeUpdate();
                
                    if(flag==1){
                        JOptionPane.showMessageDialog(null, "Carrera eliminada exitosamente",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        ID.setText("");
                        nombre.setText("");
                        periodo.setText("");
                        carrera.setText("");
                        pension.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar alumno",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(SQLException e){
                    System.err.println("Error al eliminar: "+e);
                }
            } 
        }else if(s.getSource()==buscar){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM CARRERAS WHERE ID_CARRERA="+search);
                    
                ResultSet set=psp.executeQuery();
                    
                if(set.next()){
                    nombre.setText(set.getString("NOMBRE")); 
                    periodo.setText(set.getString("DURACION"));
                    carrera.setText(set.getString("AREA"));
                    pension.setText(String.valueOf("$"+set.getDouble("P_mensual")));
                    modificar.setEnabled(true);
                    registrar.setEnabled(true);
                    eliminar.setEnabled(true);
                    borrar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Alumno no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    nombre.setText(""); 
                    periodo.setText(""); 
                    carrera.setText("");
                    pension.setText("");
                    ID.setText("");
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
            nombre.setText(""); 
            periodo.setText(""); 
            carrera.setText("");
            pension.setText("");
            ID.setText("");
            buscar.setEnabled(false);
            registrar.setEnabled(false);
            eliminar.setEnabled(false);
            borrar.setEnabled(false);
            borrar.setText("Limpiar todo");
            modificar.setEnabled(false);
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
                            
                        PdfPTable tabla = new PdfPTable(5);
                        tabla.addCell("ID de la carrera");
                        tabla.addCell("Materia");
                        tabla.addCell("Periodo semestral");
                        tabla.addCell("Carrera");
                        tabla.addCell("Pensión Mensual");

                        com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                        himel.scaleToFit(91, 196);
                        Paragraph parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("CARRERAS REGISTRADAS\n\n");
                        
                        Paragraph texto=new Paragraph();
                        texto.setAlignment(Paragraph.ALIGN_CENTER);
                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                        texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");

                        documento.open();
                        documento.add(himel);
                        documento.add(parrafo);

                        try{
                            Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                            PreparedStatement psp=cnn.prepareStatement("select * from carreras order by id_carrera");
                            
                            ResultSet set=psp.executeQuery();
                            
                            if(set.next()){
                                do{
                                    tabla.addCell(String.valueOf(set.getInt(1)));
                                    tabla.addCell(set.getString(2));
                                    tabla.addCell(set.getString(3));
                                    tabla.addCell(set.getString(4));
                                    tabla.addCell("$"+String.valueOf(set.getDouble(5)));
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
            }else if(op==1){
                try{
                    String ruta=System.getProperty("user.home");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/desktop/Carreras.pdf"));
                    
                    PdfPTable tabla=new PdfPTable(5);
                    tabla.addCell("ID de la carrera");
                    tabla.addCell("Materia");
                    tabla.addCell("Periodo semestral");
                    tabla.addCell("Carrera");
                    tabla.addCell("Pensión Mensual");

                    com.itextpdf.text.Image himel=com.itextpdf.text.Image.getInstance("src/imagenes/ceteq.png");
                    himel.scaleToFit(91, 196);
                    himel.setAlignment(Chunk.ALIGN_LEFT);

                    Paragraph parrafo=new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                    parrafo.add("CARRERAS REGISTRADAS\n\n");
                        
                    Paragraph texto=new Paragraph();
                    texto.setAlignment(Paragraph.ALIGN_CENTER);                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                    texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");

                    documento.open();
                    documento.add(himel);
                    documento.add(parrafo);

                    try{
                        Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                        PreparedStatement psp=cnn.prepareStatement("select * from carreras order by id_carrera");

                        ResultSet set=psp.executeQuery();

                        if(set.next()){
                            do{
                                tabla.addCell(String.valueOf(set.getInt(1)));
                                tabla.addCell(set.getString(2));
                                tabla.addCell(set.getString(3));
                                tabla.addCell(set.getString(4));
                                tabla.addCell("$"+String.valueOf(set.getDouble(5)));
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
                        JOptionPane.showMessageDialog(null, "Reporte creado exitosamente en el\nescritorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Archivo no generado!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                }catch(DocumentException | HeadlessException | IOException e){
                    JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent s){
        if(s.getSource()==ID){
            String busqueda=ID.getText().trim();
            if(busqueda.isEmpty()){
                buscar.setEnabled(false);
            }else{
                buscar.setEnabled(true);
            }
        }else if(s.getSource()==nombre){
            habilitarBoton();
        }else if(s.getSource()==periodo){
            habilitarBoton();
        }else if(s.getSource()==carrera){
            habilitarBoton();
        }else if(s.getSource()==pension){
            habilitarBoton();
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
    
    public static void main(String[] args){
        Carreras query=new Carreras();
        query.setBounds(0, 0, 440, 300);
        query.setVisible(true);
        query.setResizable(false);
        query.setLocationRelativeTo(null);
    }
}
