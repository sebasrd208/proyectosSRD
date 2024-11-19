package biblioteca;
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
public class Biblioteca extends JFrame implements ActionListener{
    private JLabel fondo;
    public static JTable tabla;
    private JScrollPane scroll;
    private JButton actualizar, generar, cerrar;
    private JComboBox combo;
    public static DefaultTableModel model=new DefaultTableModel();
    public static int sesion=1;
    
    public static String url="jdbc:oracle:thin:@localhost:1521:xe";
    public static String user="Sebastian";
    public static String password="admin";
    
    @SuppressWarnings("unchecked")
    public Biblioteca(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bases de Datos - Biblioteca");
        
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/database.png")).getImage());
        /*ImageIcon imagen=new ImageIcon("src/imagenes/database.png");
        this.setIconImage(imagen.getImage());*/

        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);

        tabla=new JTable(model);
        //tabla.addMouseListener(this);
        scroll=new JScrollPane(tabla);
        scroll.setBounds(10, 10, 850, 180);
        scroll.setFont(estilo);
        scroll.setViewportView(tabla);
        add(scroll);

        try{
            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM LIBROS ORDER BY ID_LIBRO");

            ResultSet set=psp.executeQuery();

            model.addColumn("ID del Libro");
            model.addColumn("Titulo");
            model.addColumn("ID del Autor");
            model.addColumn("Copias");

            while(set.next()){
                Object[] pila=new Object[4];
                for (int i=0; i<4; i++){
                    pila[i]=set.getObject(i+1);
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

        ImageIcon imagen=new ImageIcon("src/imagenes/impresion.png");
        generar=new JButton(imagen);
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
        combo.addItem("Libros");
        combo.addItem("Autores");
        combo.addItem("Socios");
        combo.addItem("Prestamos");
        add(combo);
        
        cerrar=new JButton("Cerrar");
        cerrar.setBounds(100, 200, 100, 25);
        cerrar.setBorder(border);
        cerrar.setFont(estilo);
        cerrar.setFocusPainted(false);
        cerrar.addActionListener(this);
        add(cerrar);
        
        ImageIcon image=new ImageIcon("src/imagenes/fondo.jpg");
        fondo=new JLabel(image);
        fondo.setBounds(0, 0, 900, 320);
        add(fondo);
        
        tabla.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent s){
                String selector=combo.getSelectedItem().toString();
                int fila=tabla.rowAtPoint(s.getPoint());
                int columna=0;
                String consulta=null;
                try{
                    Connection cnn=DriverManager.getConnection(url, user, password);
                    if(selector.equals("Libros")){
                        consulta="SELECT * FROM LIBROS WHERE ID_LIBRO="+tabla.getValueAt(fila, columna);
                    }else if(selector.equals("Autores")){
                        consulta="SELECT * FROM AUTORES WHERE ID_AUTOR="+tabla.getValueAt(fila, columna);
                    }else if(selector.equals("Socios")){
                        consulta="SELECT * FROM SOCIOS WHERE ID_SOCIO="+tabla.getValueAt(fila, columna);
                    }else if(selector.equals("Prestamos")){
                        consulta="SELECT * FROM PRESTAMOS WHERE ID_PRESTAMOS="+tabla.getValueAt(fila, columna);
                    }
                    
                    PreparedStatement psp=cnn.prepareStatement(consulta);
                    ResultSet set=psp.executeQuery();
                    
                    if(fila>-1){
                        if(set.next()){
                            if(selector.equals("Libros")){
                                Libros books=new Libros();
                                books.setBounds(0, 0, 440, 300);
                                books.setVisible(true);
                                books.setResizable(false);
                                books.setLocationRelativeTo(null);
                                books.ID.setText(String.valueOf(set.getInt("ID_LIBRO")));
                                books.titulo.setText(set.getString("TITULO")); 
                                books.id_autor.setText(String.valueOf(set.getInt("ID_AUTOR")));
                                books.copias.setText(String.valueOf(set.getInt("COPIAS")));
                                books.modificar.setEnabled(true);
                                books.registrar.setEnabled(true);
                                books.borrar.setEnabled(true);
                                books.eliminar.setEnabled(true);
                                books.ID.setEditable(false);
                                /*JOptionPane.showMessageDialog(null, "ID del Libro: "+String.valueOf(set.getInt("ID_LIBRO"))+"\n"
                                                +"Titulo: "+set.getString("TITULO")+"\n"
                                                +"ID del Autor: "+set.getString("ID_AUTOR")+"\n"
                                                +"Copias: "+set.getString("COPIAS"), "Mensaje", JOptionPane.INFORMATION_MESSAGE);*/
                            }else if(selector.equals("Autores")){
                                Autores query=new Autores();
                                query.setBounds(0, 0, 250, 400);
                                query.setVisible(true);
                                query.setResizable(false);
                                query.setLocationRelativeTo(null);
                                query.id_autor.setText(String.valueOf(set.getInt("ID_AUTOR")));
                                query.nombre.setText(String.valueOf(set.getString("NOMBRE")));
                                query.nacionalidad.setText(String.valueOf(set.getString("NACIONALIDAD")));
                                query.id_autor.setEditable(false);
                                query.option.setEnabled(true);
                                query.limpiar.setEnabled(true);
                                /*JOptionPane.showMessageDialog(null, "ID del Autor: "+String.valueOf(set.getInt("ID_AUTOR"))+"\n"
                                            +"Nombre: "+set.getString("NOMBRE")+"\n"
                                            +"Nacionalidad: "+set.getString("NACIONALIDAD"), "Mensaje", JOptionPane.INFORMATION_MESSAGE);*/
                            }else if(selector.equals("Socios")){
                                Socios soicos=new Socios();
                                soicos.setBounds(0, 0, 440, 300);
                                soicos.setVisible(true);
                                soicos.setResizable(false);
                                soicos.setLocationRelativeTo(null);
                                soicos.ID.setText(String.valueOf(set.getInt("ID_SOCIO")));
                                soicos.nombre.setText(set.getString("NOM_SOCIO")); 
                                soicos.direccion.setText(set.getString("DIRECCION"));
                                soicos.telefono.setText(set.getString("TELEFONO"));
                                soicos.borrar.setEnabled(true);
                                soicos.registrar.setEnabled(true);
                                soicos.modificar.setEnabled(true);
                                soicos.eliminar.setEnabled(true);
                                soicos.ID.setEditable(false);
                                /*JOptionPane.showMessageDialog(null, "ID del Socio: "+String.valueOf(set.getInt("ID_SOCIO"))+"\n"
                                            +"Nombre: "+set.getString("NOM_SOCIO")+"\n"
                                            +"Dirección: "+set.getString("DIRECCION")+"\n"
                                            +"Teléfono: "+set.getString("TELEFONO"), "Mensaje", JOptionPane.INFORMATION_MESSAGE);*/
                            }else if(selector.equals("Prestamos")){
                                Prestamos query=new Prestamos();
                                query.setBounds(0, 0, 440, 300);
                                query.setVisible(true);
                                query.setResizable(false);
                                query.setLocationRelativeTo(null);
                                query.ID.setText(String.valueOf(set.getInt("ID_PRESTAMOS")));
                                query.id_libro.setText(String.valueOf(set.getInt("ID_LIBRO")));
                                query.id_socio.setText(String.valueOf(set.getInt("ID_SOCIO")));
                                query.fec_prestamo.setText(String.valueOf(set.getDate("FEC_PRESTAMO")));
                                query.fec_devolucion.setText(String.valueOf(set.getDate("FEC_DEVOLUCION")));
                                query.registrar.setEnabled(true);
                                query.modificar.setEnabled(true);
                                query.eliminar.setEnabled(true);
                                query.borrar.setEnabled(true);
                                query.ID.setEditable(false);
                                /*JOptionPane.showMessageDialog(null, "ID del Prestamo: "+String.valueOf(set.getInt("ID_PRESTAMOS"))+"\n"
                                            +"ID del Libro: "+String.valueOf(set.getInt("ID_LIBRO"))+"\n"
                                            +"ID del Socio: "+String.valueOf(set.getInt("ID_SOCIO"))+"\n"
                                            +"Fecha de Préstamo: "+String.valueOf(set.getDate("FEC_PRESTAMO"))+"\n"
                                            +"Fecha de Entrega: "+String.valueOf(set.getDate("FEC_DEVOLUCION")), "Mensaje", JOptionPane.INFORMATION_MESSAGE);*/
                            }
                        }
                    }     
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudieron mostrar los datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e.getMessage());
                }
            }
        });
        
    }
    
    public Icon icono(String camino, int o, int a){
        Icon imagen=new ImageIcon(new ImageIcon(getClass().getResource(camino))
        .getImage().getScaledInstance(o, a, java.awt.Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        Document documento=new Document();
        String selector=combo.getSelectedItem().toString();
        if(s.getSource()==combo){
            model.setRowCount(0);
            model.setColumnCount(0);
            String consulta="";
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                
                if(selector.equals("Libros")){
                    consulta="SELECT * FROM LIBROS ORDER BY ID_LIBRO";
                }else if(selector.equals("Autores")){
                    consulta="SELECT * FROM AUTORES ORDER BY ID_AUTOR";
                }else if(selector.equals("Socios")){
                    consulta="SELECT * FROM SOCIOS ORDER BY ID_SOCIO";
                }else if(selector.equals("Prestamos")){
                    consulta="SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS";
                }
                
                PreparedStatement psp=cnn.prepareStatement(consulta);
                ResultSet set=psp.executeQuery();
                
                if(selector.equals("Libros")){
                    model.addColumn("ID del Libro");
                    model.addColumn("Título");
                    model.addColumn("ID del Autor");
                    model.addColumn("Copias");

                    while(set.next()){
                        Object[] pila=new Object[4];
                        for (int i=0; i<4; i++){
                            pila[i]=set.getObject(i+1);
                        }
                        model.addRow(pila);
                    }
                }else if(selector.equals("Autores")){
                    model.addColumn("ID del Autor");
                    model.addColumn("Nombre");
                    model.addColumn("Nacionalidad");
                    
                    while(set.next()){
                        Object[] fila=new Object[3];
                        for(int i=0;i<3;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Socios")){
                    model.addColumn("ID del Socio");
                    model.addColumn("Nombre");
                    model.addColumn("Dirección");
                    model.addColumn("Teléfono");
                    
                    while(set.next()){
                        Object[] fila=new Object[4];
                        for(int i=0;i<4;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Prestamos")){
                    model.addColumn("ID del Préstamo");
                    model.addColumn("ID del Libro");
                    model.addColumn("ID del Socio");
                    model.addColumn("Fecha de Préstamo");
                    model.addColumn("Fecha de Devolución");
                    
                    while(set.next()){
                        Object[] fila=new Object[5];
                        for(int i=0;i<5;i++){
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
        }else if(s.getSource()==generar){
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
                            
                            //LIBROS
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
                            
                            //AUTORES
                            PdfPTable tabla2=new PdfPTable(3);
                            tabla2.addCell("ID del Autor");
                            tabla2.addCell("Nombre");
                            tabla2.addCell("Nacionalidad");
                            
                            Paragraph parrafo2=new Paragraph();
                            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo2.add("AUTORES REGISTRADOS\n\n");
                            
                            //SOCIOS
                            PdfPTable tabla3=new PdfPTable(4);
                            tabla3.addCell("ID del Socio");
                            tabla3.addCell("Nombre");
                            tabla3.addCell("Dirección");
                            tabla3.addCell("Teléfono");
                            
                            Paragraph parrafo3=new Paragraph();
                            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo3.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo3.add("SOCIOS REGISTRADOS\n\n");
                            
                            //PRESTAMOS
                            PdfPTable tabla4=new PdfPTable(5);
                            tabla4.addCell("ID del Préstamo");
                            tabla4.addCell("ID del Libro");
                            tabla4.addCell("ID del Socio");
                            tabla4.addCell("Fecha de Préstamo");
                            tabla4.addCell("Fecha de Devolución");
                            
                            Paragraph parrafo4=new Paragraph();
                            parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo4.add("PRESTAMOS REGISTRADOS\n\n");
                            
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
                                
                                PreparedStatement psp2=cnn.prepareStatement("SELECT * FROM AUTORES ORDER BY ID_AUTOR");
                                set=psp2.executeQuery();
                                
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
                                
                                PreparedStatement psp3=cnn.prepareStatement("SELECT * FROM SOCIOS ORDER BY ID_SOCIO");  
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
                                    Paragraph texto=new Paragraph();
                                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                                    texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                    texto.add("No hay registros todavía\n\n");
                                    documento.add(texto);
                                }
                                
                                PreparedStatement psp4=cnn.prepareStatement("SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS");
                                set=psp4.executeQuery();
                                
                                if(set.next()){
                                    do{ 
                                        tabla4.addCell(String.valueOf(set.getInt(1)));
                                        tabla4.addCell(String.valueOf(set.getInt(2)));
                                        tabla4.addCell(String.valueOf(set.getInt(3)));
                                        tabla4.addCell(set.getString(4));
                                        tabla4.addCell(set.getString(5));
                                    }while(set.next());
                                    documento.add(parrafo4);
                                    documento.add(tabla4);
                                }else{
                                    Paragraph texto=new Paragraph();
                                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                                    texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                    texto.add("No hay registros todavía\n\n");
                                    documento.add(texto);
                                }
                                
                                documento.close();
                                JOptionPane.showMessageDialog(null, "PDF generado exitosamente\nen: "+archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(DocumentException | SQLException e){
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
                    FileOutputStream strem=new FileOutputStream(ruta+"/desktop/Reporte.pdf");
                    PdfWriter.getInstance(documento, strem);
                    
                    try{
                        //LIBROS
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
                         
                        //AUTORES
                        PdfPTable tabla2=new PdfPTable(3);
                        tabla2.addCell("ID del Autor");
                        tabla2.addCell("Nombre");
                        tabla2.addCell("Nacionalidad");
                           
                        Paragraph parrafo2=new Paragraph();
                        parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo2.add("AUTORES REGISTRADOS\n\n");
                            
                        //SOCIOS
                        PdfPTable tabla3=new PdfPTable(4);
                        tabla3.addCell("ID del Socio");
                        tabla3.addCell("Nombre");
                        tabla3.addCell("Dirección");
                        tabla3.addCell("Teléfono");
                            
                        Paragraph parrafo3=new Paragraph();
                        parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo3.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo3.add("SOCIOS REGISTRADOS\n\n");
                          
                        //PRESTAMOS
                        PdfPTable tabla4=new PdfPTable(5);
                        tabla4.addCell("ID del Préstamo");
                        tabla4.addCell("ID del Libro");
                        tabla4.addCell("ID del Socio");
                        tabla4.addCell("Fecha de Préstamo");
                        tabla4.addCell("Fecha de Devolución");
                            
                        Paragraph parrafo4=new Paragraph();
                        parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo4.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo4.add("PRESTAMOS REGISTRADOS\n\n");
                          
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
                                
                            PreparedStatement psp2=cnn.prepareStatement("SELECT * FROM AUTORES ORDER BY ID_AUTOR");
                            set=psp2.executeQuery();
                              
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
                                
                            PreparedStatement psp3=cnn.prepareStatement("SELECT * FROM SOCIOS ORDER BY ID_SOCIO");  
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
                                Paragraph texto=new Paragraph();
                                texto.setAlignment(Paragraph.ALIGN_CENTER);
                                texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                texto.add("No hay registros todavía\n\n");
                                documento.add(texto);
                            }
                                
                            PreparedStatement psp4=cnn.prepareStatement("SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS");
                            set=psp4.executeQuery();
                                
                            if(set.next()){
                                do{ 
                                    tabla4.addCell(String.valueOf(set.getInt(1)));
                                    tabla4.addCell(String.valueOf(set.getInt(2)));
                                    tabla4.addCell(String.valueOf(set.getInt(3)));
                                    tabla4.addCell(set.getString(4));
                                    tabla4.addCell(set.getString(5));
                                }while(set.next());
                                documento.add(parrafo4);
                                documento.add(tabla4);
                            }else{
                                Paragraph texto=new Paragraph();
                                texto.setAlignment(Paragraph.ALIGN_CENTER);
                                texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                texto.add("No hay registros todavía\n\n");
                                documento.add(texto);
                            }
                                
                            documento.close();
                            JOptionPane.showMessageDialog(null, "PDF generado exitosamente\nen el escritorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }catch(DocumentException | SQLException e){
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
        }else if(s.getSource()==actualizar){
            model.setRowCount(0);
            model.setColumnCount(0);
            String consulta="";
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                
                if(selector.equals("Libros")){
                    consulta="SELECT * FROM LIBROS ORDER BY ID_LIBRO";
                }else if(selector.equals("Autores")){
                    consulta="SELECT * FROM AUTORES ORDER BY ID_AUTOR";
                }else if(selector.equals("Socios")){
                    consulta="SELECT * FROM SOCIOS ORDER BY ID_SOCIO";
                }else if(selector.equals("Prestamos")){
                    consulta="SELECT * FROM PRESTAMOS ORDER BY ID_PRESTAMOS";
                }
                
                PreparedStatement psp=cnn.prepareStatement(consulta);
                ResultSet set=psp.executeQuery();
                
                if(selector.equals("Libros")){
                    model.addColumn("ID del Libro");
                    model.addColumn("Título");
                    model.addColumn("ID del Autor");
                    model.addColumn("Copias");

                    while(set.next()){
                        Object[] pila=new Object[4];
                        for (int i=0; i<4; i++){
                            pila[i]=set.getObject(i+1);
                        }
                        model.addRow(pila);
                    }
                }else if(selector.equals("Autores")){
                    model.addColumn("ID del Autor");
                    model.addColumn("Nombre");
                    model.addColumn("Nacionalidad");
                    
                    while(set.next()){
                        Object[] fila=new Object[3];
                        for(int i=0;i<3;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                }else if(selector.equals("Socios")){
                    model.addColumn("ID del Socio");
                    model.addColumn("Nombre");
                    model.addColumn("Dirección");
                    model.addColumn("Teléfono");
                    
                    while(set.next()){
                        Object[] fila=new Object[4];
                        for(int i=0;i<4;i++){
                            fila[i]=set.getObject(i+1);
                        }
                        model.addRow(fila);
                    }
                    
                }else if(selector.equals("Prestamos")){
                    model.addColumn("ID del Préstamo");
                    model.addColumn("ID del Libro");
                    model.addColumn("ID del Socio");
                    model.addColumn("Fecha de Préstamo");
                    model.addColumn("Fecha de Devolución");
                    
                    while(set.next()){
                        Object[] fila=new Object[5];
                        for(int i=0;i<5;i++){
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
        }else if(s.getSource()==cerrar){
            Icon icono=null;
            String[] opcion={"Si", "No"};
            int delete=JOptionPane.showOptionDialog(null, "¿Estás seguro de cerrar la Base de Datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, HEIGHT, 
                icono, opcion, opcion[0]);
            if(delete==JOptionPane.YES_OPTION){
                System.exit(0); 
            }            
        }
    }
    
    public static void main(String[] args){
        Biblioteca libreria=new Biblioteca();
        libreria.setBounds(0, 0, 900, 320);
        libreria.setVisible(true);
        libreria.setResizable(false);
        libreria.setLocationRelativeTo(null);
    }
}
