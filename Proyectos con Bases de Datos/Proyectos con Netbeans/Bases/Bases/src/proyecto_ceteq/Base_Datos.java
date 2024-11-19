package proyecto_ceteq;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author sebas
 */
public class Base_Datos extends JFrame implements MouseListener, ActionListener{

    private JLabel fondo;
    public static JTable tabla;
    private JScrollPane scroll;
    private JButton actualizar, generar, cerrar;// btn, btn2, btn3;
    private JComboBox combo;
    
    public static DefaultTableModel model=new DefaultTableModel();
    public static int sesion=1;
    
    public static String url="jdbc:oracle:thin:@localhost:1521:xe";
    public static String user="Sebastian";
    public static String password="admin";
    
    public Base_Datos(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bases de Datos -  Tabla de Alumnos");
        ImageIcon imagen=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(imagen.getImage());

        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);

        tabla=new JTable(model);
        tabla.addMouseListener(this);
        scroll=new JScrollPane(tabla);
        scroll.setBounds(10, 10, 850, 180);
        scroll.setFont(estilo);
        scroll.setViewportView(tabla);
        add(scroll);

        try{

            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM ESTUDIANTES ORDER BY ID_ALUMNO");

            ResultSet set=psp.executeQuery();

            model.addColumn("ID del Alumno");
            model.addColumn("Nombre");
            model.addColumn("Fecha de Nacimiento");
            model.addColumn("Género");
            model.addColumn("Grado");
            model.addColumn("Ciudad");
            model.addColumn("Status");

            while(set.next()){
                Object[] pila=new Object[7];
                for (int i=1; i<7; i++){
                    pila[i]=set.getObject(i);
                }
                model.addRow(pila);
            }
            cnn.close();

        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            s.printStackTrace();
        }

        actualizar=new JButton("Actualizar");
        actualizar.setBounds(730, 230, 130, 25);
        actualizar.setBorder(border);
        actualizar.setFont(estilo);
        actualizar.setFocusPainted(false);
        actualizar.addActionListener(this);
        add(actualizar);
        
        ImageIcon image=new ImageIcon("src/imagenes/impresion.png");
        generar=new JButton(image);
        generar.setBounds(10, 200, 70, 70);
        generar.setBorder(border);
        generar.setFont(estilo);
        generar.setFocusPainted(false);
        generar.addActionListener(this);
        add(generar);

        combo=new JComboBox();
        combo.setBounds(730, 200, 130, 25);
        combo.setBorder(border);
        combo.setFont(estilo);
        combo.addActionListener(this);
        combo.addItem("Alumnos");
        combo.addItem("Carreras");
        combo.addItem("Carreras Alumnos");
        combo.addItem("Tutores");
        combo.addItem("Tutores Alumnos");
        add(combo);
        
        cerrar=new JButton("Cerrar");
        cerrar.setBounds(100, 200, 100, 25);
        cerrar.setBorder(border);
        cerrar.setFont(estilo);
        cerrar.setFocusPainted(false);
        cerrar.addActionListener(this);
        add(cerrar);
        
        ImageIcon foto=new ImageIcon("src/imagenes/fondo.jpg");
        fondo=new JLabel(foto);
        fondo.setBounds(0, 0, 900, 320);
        add(fondo);
    }

    public Icon icono(String path, int w, int h){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    @Override
    public void mouseClicked(MouseEvent s){
        if(s.getSource()==tabla){
            String selector=combo.getSelectedItem().toString();
            int fila=tabla.rowAtPoint(s.getPoint());
            int columna=0;
            String query="";
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                if(selector.equals("Alumnos")){
                    query="SELECT * FROM ESTUDIANTES WHERE ID_ALUMNO="+tabla.getValueAt(fila, columna);
                }else if(selector.equals("Carreras")){
                    query="SELECT * FROM CARRERAS WHERE ID_CARRERA="+tabla.getValueAt(fila, columna);
                }else if(selector.equals("Carreras Alumnos")){
                    query="SELECT * FROM CARRERA_ALUMNOS WHERE CA_ID="+tabla.getValueAt(fila, columna);
                }else if(selector.equals("Tutores")){
                    query="SELECT * FROM TUTORES WHERE ID_TUTOR="+tabla.getValueAt(fila, columna);
                }else if(selector.equals("Tutores Alumnos")){
                    query="SELECT * FROM TUTORES_ALUMNOS WHERE ID_TABLA="+tabla.getValueAt(fila, columna);
                }
                
                PreparedStatement psp=cnn.prepareStatement(query);
                ResultSet set=psp.executeQuery();
                
                if(fila>-1){
                    if(selector.equals("Alumnos")){
                        if(set.next()){
                            Alumnos work=new Alumnos();
                            work.setBounds(0, 0, 440, 300);
                            work.setVisible(true);
                            work.setResizable(false);
                            work.setLocationRelativeTo(null);
                            work.nombre.setText(set.getString("NOMBRE"));
                            work.fecha.setText(String.valueOf(set.getDate("FEC_NACIMIENTO")));
                            work.genero.setText(set.getString("GENERO"));
                            work.grupo.setText(set.getString("GRADO"));
                            work.ciudad.setText(set.getString("CIUDAD"));
                            work.status.setText(String.valueOf(set.getInt("ESTADO")));
                            work.id.setText(String.valueOf(set.getInt("ID_ALUMNO")));
                            work.id.setEditable(false);
                            work.registrar.setEnabled(true);
                            work.modificar.setEnabled(true);
                            work.eliminar.setEnabled(true);
                            work.borrar.setEnabled(true);
                            work.borrar.setText("Nuevo registro");
                        }
                    }else if(selector.equals("Carreras")){
                        if(set.next()){
                            Carreras query2=new Carreras();
                            query2.setBounds(0, 0, 440, 300);
                            query2.setVisible(true);
                            query2.setResizable(false);
                            query2.setLocationRelativeTo(null);
                            query2.nombre.setText(set.getString("NOMBRE")); 
                            query2.periodo.setText(set.getString("DURACION"));
                            query2.carrera.setText(set.getString("AREA"));
                            query2.pension.setText(String.valueOf("$"+set.getDouble("P_mensual")));
                            query2.ID.setText(String.valueOf(set.getInt("ID_CARRERA")));
                            query2.ID.setEditable(false);
                            query2.modificar.setEnabled(true);
                            query2.registrar.setEnabled(true);
                            query2.eliminar.setEnabled(true);
                            query2.borrar.setEnabled(true);
                            query2.borrar.setText("Nuevo registro");
                        }
                    }else if(selector.equals("Carreras Alumnos")){
                        if(set.next()){
                            Carreras_Alumnos CA=new Carreras_Alumnos();
                            CA.setBounds(0, 0, 250, 400);
                            CA.setVisible(true);
                            CA.setResizable(false);
                            CA.setLocationRelativeTo(null);
                            CA.carrera_id.setText(String.valueOf(set.getInt("CA_ID")));
                            CA.carrera.setText(String.valueOf(set.getInt("CARRERA_ID")));
                            CA.alumno.setText(String.valueOf(set.getInt("ALUMNO_ID")));
                            CA.carrera_id.setEditable(false);
                            CA.btn.setEnabled(true);
                            CA.btn2.setEnabled(true);
                            CA.btn2.setText("Nuevo registro");
                        }
                    }else if(selector.equals("Tutores")){
                        if(set.next()){
                            Tutores query3=new Tutores();
                            query3.setBounds(0, 0, 440, 300);
                            query3.setVisible(true);
                            query3.setResizable(false);
                            query3.setLocationRelativeTo(null);
                            query3.nombre.setText(set.getString("NOMBRE")); 
                            query3.correo.setText(set.getString("EMAIL"));
                            query3.clave.setText(set.getString("CLAVE"));
                            query3.ID.setText(String.valueOf(set.getInt("ID_TUTOR")));
                            query3.ID.setEditable(false);
                            query3.borrar.setEnabled(true);
                            query3.borrar.setText("Nuevo registro");
                            query3.registrar.setEnabled(true);
                            query3.modificar.setEnabled(true);
                            query3.eliminar.setEnabled(true);
                        }
                    }else if(selector.equals("Tutores Alumnos")){
                        if(set.next()){
                            Tutores_Alumnos TA=new Tutores_Alumnos();
                            TA.setBounds(0, 0, 250, 400);
                            TA.setVisible(true);
                            TA.setResizable(false);
                            TA.setLocationRelativeTo(null);
                            TA.tabla.setText(String.valueOf(set.getInt("ID_TABLA")));
                            TA.alumno.setText(String.valueOf(set.getInt("ID_ALUMNO")));
                            TA.tutor.setText(String.valueOf(set.getInt("ID_TUTOR")));
                            TA.tabla.setEditable(false);
                            TA.btn.setEnabled(true);
                            TA.btn2.setEnabled(true);
                            TA.btn2.setText("Nuevo registro");
                        }
                    }
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent s){
        Document documento=new Document();
        String selector=combo.getSelectedItem().toString();
        if(s.getSource()==actualizar){
            model.setRowCount(0);
            model.setColumnCount(0);
            String query="";
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                
                if(selector.equals("Alumnos")){
                    setTitle("Bases de Datos -  Tabla de Alumnos");
                    query="SELECT * FROM ESTUDIANTES ORDER BY ID_ALUMNO";
                }else if(selector.equals("Carreras")){
                    setTitle("Bases de Datos -  Tabla de Carreras");
                    query="SELECT * FROM CARRERAS ORDER BY ID_CARRERA";
                }else if(selector.equals("Carreras Alumnos")){
                    setTitle("Bases de Datos -  Tabla de los ID's de Carreras en Alumnos");
                    query="SELECT * FROM CARRERA_ALUMNOS ORDER BY CA_ID";
                }else if(selector.equals("Tutores")){
                    setTitle("Bases de Datos -  Tabla de Tutores");
                    query="SELECT * FROM TUTORES ORDER BY ID_TUTOR";
                }else if(selector.equals("Tutores Alumnos")){
                    query="SELECT * FROM TUTORES_ALUMNOS ORDER BY ID_TABLA";
                    setTitle("Bases de Datos -  Tabla de los ID's de Tutores en Alumnos");
                }
                PreparedStatement psp=cnn.prepareStatement(query);
                ResultSet set=psp.executeQuery();
                
                if(selector.equals("Alumnos")){
                    model.addColumn("ID del Alumno");
                    model.addColumn("Nombre");
                    model.addColumn("Fecha de Nacimiento");
                    model.addColumn("Género");
                    model.addColumn("Grado");
                    model.addColumn("Ciudad");
                    model.addColumn("Status");

                    while(set.next()){
                        Object[] fila=new Object[7];
                        for(int i=0;i<7;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Carreras")){
                    model.addColumn("ID de la Carrera");
                    model.addColumn("Nombre");
                    model.addColumn("Periodo de la materia");
                    model.addColumn("Carrera");
                    model.addColumn("Pensión Mensual ($)");

                    while(set.next()){
                        Object[] fila=new Object[5];
                        for(int i=0;i<5;i++){
                            fila[i]=set.getObject(1+i);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Carreras Alumnos")){
                    model.addColumn("ID");
                    model.addColumn("ID de la Carrera");
                    model.addColumn("ID del Alumno");

                    while(set.next()){
                        Object[] fila=new Object[3];
                        for(int i=0;i<3;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Tutores")){
                    model.addColumn("ID del Tutor");
                    model.addColumn("Nombre");
                    model.addColumn("Correo");
                    model.addColumn("Clave");

                    while(set.next()){
                        Object[] fila=new Object[4];
                        for(int i=0;i<4;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Tutores Alumnos")){
                    model.addColumn("ID de la Tabla");
                    model.addColumn("ID del Alumno");
                    model.addColumn("ID del Tutor");

                    while(set.next()){
                        Object[] fila=new Object[3];
                        for(int i=0;i<3;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }
                cnn.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+e.getMessage());
            }
        }else if(s.getSource()==combo){
            model.setRowCount(0);
            model.setColumnCount(0);
            String query="";
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                
                if(selector.equals("Alumnos")){
                    setTitle("Bases de Datos -  Tabla de Alumnos");
                    query="SELECT * FROM ESTUDIANTES ORDER BY ID_ALUMNO";
                }else if(selector.equals("Carreras")){
                    setTitle("Bases de Datos -  Tabla de Carreras");
                    query="SELECT * FROM CARRERAS ORDER BY ID_CARRERA";
                }else if(selector.equals("Carreras Alumnos")){
                    setTitle("Bases de Datos -  Tabla de los ID's de Carreras en Alumnos");
                    query="SELECT * FROM CARRERA_ALUMNOS ORDER BY CA_ID";
                }else if(selector.equals("Tutores")){
                    setTitle("Bases de Datos -  Tabla de Tutores");
                    query="SELECT * FROM TUTORES ORDER BY ID_TUTOR";
                }else if(selector.equals("Tutores Alumnos")){
                    query="SELECT * FROM TUTORES_ALUMNOS ORDER BY ID_TABLA";
                    setTitle("Bases de Datos -  Tabla de los ID's de Tutores en Alumnos");
                }
                PreparedStatement psp=cnn.prepareStatement(query);
                ResultSet set=psp.executeQuery();
                
                if(selector.equals("Alumnos")){
                    model.addColumn("ID del Alumno");
                    model.addColumn("Nombre");
                    model.addColumn("Fecha de Nacimiento");
                    model.addColumn("Género");
                    model.addColumn("Grado");
                    model.addColumn("Ciudad");
                    model.addColumn("Status");

                    while(set.next()){
                        Object[] fila=new Object[7];
                        for(int i=0;i<7;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Carreras")){
                    model.addColumn("ID de la Carrera");
                    model.addColumn("Nombre");
                    model.addColumn("Periodo de la materia");
                    model.addColumn("Carrera");
                    model.addColumn("Pensión Mensual ($)");

                    while(set.next()){
                        Object[] fila=new Object[5];
                        for(int i=0;i<5;i++){
                            fila[i]=set.getObject(1+i);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Carreras Alumnos")){
                    model.addColumn("ID");
                    model.addColumn("ID de la Carrera");
                    model.addColumn("ID del Alumno");

                    while(set.next()){
                        Object[] fila=new Object[3];
                        for(int i=0;i<3;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Tutores")){
                    model.addColumn("ID del Tutor");
                    model.addColumn("Nombre");
                    model.addColumn("Correo");
                    model.addColumn("Clave");

                    while(set.next()){
                        Object[] fila=new Object[4];
                        for(int i=0;i<4;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Tutores Alumnos")){
                    model.addColumn("ID de la Tabla");
                    model.addColumn("ID del Alumno");
                    model.addColumn("ID del Tutor");

                    while(set.next()){
                        Object[] fila=new Object[3];
                        for(int i=0;i<3;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }
                cnn.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(s.getSource()==generar){
            String opciones[]={"Definir Ruta", "Ruta Definida", "Cancelar"};
            int op=JOptionPane.showOptionDialog(null, "Elige una opción", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);

            if(op==0){
                JFileChooser DC=new JFileChooser();
                int kaijuu=DC.showSaveDialog(null);
                if(kaijuu==DC.APPROVE_OPTION){
                    try{
                        String archivo=DC.getSelectedFile()+".pdf";
                        FileOutputStream file=new FileOutputStream(archivo);
                        PdfWriter.getInstance(documento, file);
                        
                        //ALUMNOS
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

                        documento.open();
                        documento.add(himel);

                        //CARRERAS
                        PdfPTable tabla2=new PdfPTable(5);
                        tabla2.addCell("ID de la carrera");
                        tabla2.addCell("Materia");
                        tabla2.addCell("Periodo semestral");
                        tabla2.addCell("Carrera");
                        tabla2.addCell("Pensión Mensual");

                        Paragraph parrafo2=new Paragraph();
                        parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo2.add("CARRERAS REGISTRADAS\n\n");

                        //TUTORES
                        PdfPTable tabla3=new PdfPTable(4);
                        tabla3.addCell("ID del Tutor");
                        tabla3.addCell("Nombre");
                        tabla3.addCell("Correo electrónico");
                        tabla3.addCell("Clave");

                        Paragraph parrafo3=new Paragraph();
                        parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo3.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo3.add("TUTORES REGISTRADAS\n\n");

                        Paragraph texto=new Paragraph();
                        texto.setAlignment(Paragraph.ALIGN_CENTER);
                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                        texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
                        
                        try{
                            //ALUMNOS
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
                                documento.add(parrafo);
                                documento.add(tabla);
                            }else{
                                Paragraph parrafo4=new Paragraph();
                                parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo4.add("No hay registros todavía\n\n");
                                documento.add(parrafo4);
                            }
                            
                            //CARRERAS
                            PreparedStatement psp2=cnn.prepareStatement("select * from carreras order by id_carrera");
                            set=psp2.executeQuery();

                            if(set.next()){
                                do{
                                    tabla2.addCell(String.valueOf(set.getInt(1)));
                                    tabla2.addCell(set.getString(2));
                                    tabla2.addCell(set.getString(3));
                                    tabla2.addCell(set.getString(4));
                                    tabla2.addCell("$"+String.valueOf(set.getDouble(5)));
                                }while(set.next());
                                documento.add(parrafo2);
                                documento.add(tabla2);
                            }else{
                                Paragraph parrafo4=new Paragraph();
                                parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo4.add("No hay registros todavía\n\n");
                                documento.add(parrafo4);
                            }

                            //TUTORES
                            PreparedStatement psp3=cnn.prepareStatement("select * from tutores order by id_tutor");
                            set=psp3.executeQuery();

                            if(set.next()){
                                do{
                                    tabla3.addCell(String.valueOf(set.getInt(1)));
                                    tabla3.addCell(set.getString(2));
                                    tabla3.addCell(set.getString(3));
                                    tabla3.addCell(set.getString(4));
                                }while(set.next());
                                documento.add(parrafo3);
                                documento.add(tabla3);
                            }else{
                                Paragraph parrafo4=new Paragraph();
                                parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo4.add("No hay registros todavía\n\n");
                                documento.add(parrafo4);
                            }

                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            e.printStackTrace();
                        }
                        documento.add(texto);
                        documento.close();

                        JOptionPane.showMessageDialog(null, "Reporte creado exitosamente\nen "+archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } catch (DocumentException | HeadlessException | IOException e) {
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                }
            }else if(op==1){
                try{
                    String ruta=System.getProperty("user.home");
                    FileOutputStream file=new FileOutputStream(ruta+"/desktop/Reporte.pdf");
                    PdfWriter.getInstance(documento, file);
                    
                    //ALUMNOS
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

                        documento.open();
                        documento.add(himel);

                        //CARRERAS
                        PdfPTable tabla2=new PdfPTable(5);
                        tabla2.addCell("ID de la carrera");
                        tabla2.addCell("Materia");
                        tabla2.addCell("Periodo semestral");
                        tabla2.addCell("Carrera");
                        tabla2.addCell("Pensión Mensual");

                        Paragraph parrafo2=new Paragraph();
                        parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo2.add("CARRERAS REGISTRADAS\n\n");

                        //TUTORES
                        PdfPTable tabla3=new PdfPTable(4);
                        tabla3.addCell("ID del Tutor");
                        tabla3.addCell("Nombre");
                        tabla3.addCell("Correo electrónico");
                        tabla3.addCell("Clave");

                        Paragraph parrafo3=new Paragraph();
                        parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo3.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo3.add("TUTORES REGISTRADAS\n\n");

                        Paragraph texto=new Paragraph();
                        texto.setAlignment(Paragraph.ALIGN_CENTER);
                        texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.BLACK));
                        texto.add("\n\nFormato PDF creado por ©Ceteq Puebla");
                        
                        try{
                            //ALUMNOS
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
                                documento.add(parrafo);
                                documento.add(tabla);
                            }else{
                                Paragraph parrafo4=new Paragraph();
                                parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo4.add("No hay registros todavía\n\n");
                                documento.add(parrafo4);
                            }
                            
                            //CARRERAS
                            Connection cnn2=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp2=cnn2.prepareStatement("select * from carreras order by id_carrera");

                            ResultSet set2=psp2.executeQuery();

                            if(set2.next()){
                                do{
                                    tabla2.addCell(String.valueOf(set2.getInt(1)));
                                    tabla2.addCell(set2.getString(2));
                                    tabla2.addCell(set2.getString(3));
                                    tabla2.addCell(set2.getString(4));
                                    tabla2.addCell("$"+String.valueOf(set2.getDouble(5)));
                                }while(set2.next());
                                documento.add(parrafo2);
                                documento.add(tabla2);
                            }else{
                                Paragraph parrafo4=new Paragraph();
                                parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo4.add("No hay registros todavía\n\n");
                                documento.add(parrafo4);
                            }

                            //TUTORES
                            Connection cnn3=DriverManager.getConnection(url, user, password);
                            PreparedStatement psp3=cnn3.prepareStatement("select * from tutores order by id_tutor");

                            ResultSet set3=psp3.executeQuery();

                            if(set3.next()){
                                do{
                                    tabla3.addCell(String.valueOf(set3.getInt(1)));
                                    tabla3.addCell(set3.getString(2));
                                    tabla3.addCell(set3.getString(3));
                                    tabla3.addCell(set3.getString(4));
                                }while(set3.next());
                                documento.add(parrafo3);
                                documento.add(tabla3);
                            }else{
                                Paragraph parrafo4=new Paragraph();
                                parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                                parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                parrafo4.add("No hay registros todavía\n\n");
                                documento.add(parrafo4);
                            }

                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo consultar registros!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            e.printStackTrace();
                        }
                        documento.add(texto);
                        documento.close();

                        JOptionPane.showMessageDialog(null, "Reporte creado exitosamente en el\nescritorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }catch(DocumentException | HeadlessException | IOException e){
                    JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar el archivo!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }
        }else if(s.getSource()==cerrar){
            Icon icono=null;
            String []op={"Si", "No"};
            int close=JOptionPane.showOptionDialog(null, "¿Deseas cerra la base de datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, HEIGHT, icono, op, op[0]);
            if(close==JOptionPane.YES_OPTION){
                System.exit(0);
            }         
        }
    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    public static void main(String[] args){
        Base_Datos read=new Base_Datos();
        read.setBounds(0, 0, 900, 320);
        read.setVisible(true);
        read.setResizable(false);
        read.setLocationRelativeTo(null);
    }
 }

