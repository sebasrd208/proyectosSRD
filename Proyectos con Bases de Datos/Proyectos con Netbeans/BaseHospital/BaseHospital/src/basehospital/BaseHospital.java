package basehospital;
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
  **/
 public class BaseHospital extends JFrame implements ActionListener{
    
    private JLabel fondo;
    public static JTable tabla;
    private JScrollPane scroll;
    private JButton  generar, cerrar, nuevo;
    public static DefaultTableModel model=new DefaultTableModel();
    public static int sesion=1;
    
    public static String url="jdbc:mysql://localhost/hospital";
    public static String usuario="root";
    public static String password="";
    
    public BaseHospital(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bases de Datos - Biblioteca");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/database.png")).getImage());

        BevelBorder border=new BevelBorder(0);
        java.awt.Font estilo=new java.awt.Font("Sylfaen", 1, 12);

        nuevo=new JButton("Nuevo expediente");
        nuevo.setBounds(10, 10, 130, 25);
        nuevo.setFont(estilo);
        nuevo.setBorder(border);
        nuevo.setFocusPainted(false);
        nuevo.addActionListener(this);
        add(nuevo);
        
        tabla=new JTable(model);
        //tabla.addMouseListener(this);
        scroll=new JScrollPane(tabla);
        scroll.setBounds(10, 40, 850, 150);
        scroll.setFont(estilo);
        scroll.setViewportView(tabla);
        add(scroll);

        try{
            Connection cnn=DriverManager.getConnection(url, usuario, password);
            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM VACACIONES");

            ResultSet set=psp.executeQuery();

            model.addColumn("No. de Expediente");
            model.addColumn("Nombre");
            model.addColumn("Función");
            model.addColumn("VP1");
            model.addColumn("VP2");
            model.addColumn("VBR/VMR/VAR");
            model.addColumn("PE");
            model.addColumn("LM");

            while(set.next()){
                Object[] pila=new Object[8];
                for (int i=0; i<8; i++){
                    pila[i]=set.getObject(i+1);
                }
                model.addRow(pila);
            }
            cnn.close();

        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            s.printStackTrace();
        }
        
        ImageIcon imagen=new ImageIcon("src/imagenes/importar.png");
        generar=new JButton(imagen);
        generar.setBounds(10, 200, 70, 70);
        generar.setBorder(border);
        generar.setFont(estilo);
        generar.setFocusPainted(false);
        generar.addActionListener(this);
        add(generar);

        cerrar=new JButton("Cerrar sesión");
        cerrar.setBounds(760, 200, 100, 25);
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
                int fila=tabla.rowAtPoint(s.getPoint());
                int columna=0;
                try{
                    Connection cnn=DriverManager.getConnection(url, usuario, password);
                    PreparedStatement psp=cnn.prepareStatement("SELECT * FROM VACACIONES WHERE EXPEDIENTE="+tabla.getValueAt(fila, columna));
                    
                    ResultSet set=psp.executeQuery();
                    
                    if(fila>-1){
                        if(set.next()){
                            Hospital byoujin=new Hospital();
                            byoujin.setVisible(true);
                            byoujin.expediente.setText(set.getString("EXPEDIENTE"));
                            byoujin.nombre.setText(set.getString("NOMBRE"));
                            byoujin.funcion.setText(set.getString("FUNCION"));
                            byoujin.vp1.setText(String.valueOf(set.getInt("VP1")));
                            byoujin.vp2.setText(String.valueOf(set.getInt("VP2")));
                            byoujin.vbr.setText(String.valueOf(set.getInt("VBR")));
                            byoujin.pe.setText(String.valueOf(set.getInt("PE")));
                            byoujin.lm.setText(String.valueOf(set.getInt("LM")));
                            byoujin.buscar.setEnabled(true);
                            byoujin.buscar.setVisible(false);
                            byoujin.registrar.setEnabled(true);
                            byoujin.registrar.setVisible(false);
                            byoujin.eliminar.setEnabled(true);
                            byoujin.modificar.setEnabled(true);
                            byoujin.modificar.setBounds(220, 170, 100, 25);
                            byoujin.limpiar.setVisible(false);
                            byoujin.expediente.setEditable(false);
                            byoujin.nombre.setEditable(false);
                            byoujin.funcion.setEditable(false);
                        }
                    }                    
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudieron mostrar los datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: "+e.getMessage());
                }
            }
        });
    }
    
    public Icon icono(String camino, int a, int o){
        Icon imagen=new ImageIcon(new ImageIcon(getClass().getResource(camino))
                .getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==generar){
            try{
                String []op={"Definir ruta", "Ruta predeterminada", "Cancelar"};
                String selector=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", 
                    HEIGHT, icono("/imagenes/guardar.png", 30, 30), op, op[0]);
                Document documento=new Document();
                if(selector.equals("Definir ruta")){
                    JFileChooser seleccion=new JFileChooser();
                    int opcion=seleccion.showSaveDialog(this);
                
                    if(opcion==seleccion.APPROVE_OPTION){
                        try{
                            String archivo=seleccion.getSelectedFile()+".pdf";
                            FileOutputStream file=new FileOutputStream(archivo);
                            PdfWriter.getInstance(documento, file);
                        
                            PdfPTable tabla=new PdfPTable(8);
                            tabla.addCell("Expediente");
                            tabla.addCell("Nombre");
                            tabla.addCell("Función");
                            tabla.addCell("VP1");
                            tabla.addCell("VP2");
                            tabla.addCell("VBR/VMR/VAR");
                            tabla.addCell("PE");
                            tabla.addCell("LM");
                        
                            com.itextpdf.text.Image logo=com.itextpdf.text.Image.getInstance("src/imagenes/salud.png");
                            logo.scaleToFit(120, 250);
                            logo.setAlignment(Chunk.ALIGN_LEFT);
                        
                            Paragraph parrafo=new Paragraph();
                            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                            parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            parrafo.add("LISTA DE EXPEDIENTES\n\n");
                        
                            documento.open();
                            documento.add(logo);
                        
                            try{
                                Connection cnn=DriverManager.getConnection(url, usuario, password);
                                PreparedStatement psp=cnn.prepareStatement("SELECT * FROM VACACIONES");
                                
                                ResultSet set=psp.executeQuery();
                            
                                if(set.next()){
                                    do{
                                        tabla.addCell(String.valueOf(set.getInt(1)));
                                        tabla.addCell(set.getString(2));
                                        tabla.addCell(set.getString(3));
                                        tabla.addCell(String.valueOf(set.getInt(4)));
                                        tabla.addCell(String.valueOf(set.getInt(5)));
                                        tabla.addCell(String.valueOf(set.getInt(6)));
                                        tabla.addCell(String.valueOf(set.getInt(7)));
                                        tabla.addCell(String.valueOf(set.getInt(8)));
                                    }while(set.next());
                                    documento.add(parrafo);
                                    documento.add(tabla);
                                }else{
                                    Paragraph texto=new Paragraph();
                                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                                    texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                    texto.add("No hay expedientes todavía\n\n");
                                    documento.add(texto);
                                }
                            
                                documento.close();
                                JOptionPane.showMessageDialog(null, "Reporte generado exitosamente\nen: "+archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            }catch(DocumentException | SQLException s){
                                JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                System.err.println("Error: "+s.getMessage());
                            }
                        }catch(DocumentException | IOException s){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar el reporte!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+s.getMessage());
                        }
                    }
                }else if(selector.equals("Ruta predeterminada")){
                    try{
                        String ruta=System.getProperty("user.home");
                        FileOutputStream file=new FileOutputStream(ruta+"/desktop/Reporte de expedientes.pdf");
                        PdfWriter.getInstance(documento, file);
                    
                        PdfPTable tabla=new PdfPTable(8);
                        tabla.addCell("Expediente");
                        tabla.addCell("Nombre");
                        tabla.addCell("Función");
                        tabla.addCell("VP1");
                        tabla.addCell("VP2");
                        tabla.addCell("VBR/VMR/VAR");
                        tabla.addCell("PE");
                        tabla.addCell("LM");
                        
                        com.itextpdf.text.Image logo=com.itextpdf.text.Image.getInstance("src/imagenes/salud.png");
                        logo.scaleToFit(120, 250);
                        logo.setAlignment(Chunk.ALIGN_LEFT);
                        
                        Paragraph parrafo=new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("LISTA DE EXPEDIENTES\n\n");
                        
                        documento.open();
                        documento.add(logo);
                        
                        try{
                            Connection cnn=DriverManager.getConnection(url, usuario, password);
                            PreparedStatement psp=cnn.prepareStatement("SELECT * FROM VACACIONES");
                            
                            ResultSet set=psp.executeQuery();
                            
                            if(set.next()){
                                do{
                                    tabla.addCell(String.valueOf(set.getInt(1)));
                                    tabla.addCell(set.getString(2));
                                    tabla.addCell(set.getString(3));
                                    tabla.addCell(String.valueOf(set.getInt(4)));
                                    tabla.addCell(String.valueOf(set.getInt(5)));
                                    tabla.addCell(String.valueOf(set.getInt(6)));
                                    tabla.addCell(String.valueOf(set.getInt(7)));
                                    tabla.addCell(String.valueOf(set.getInt(8)));
                                }while(set.next());
                                documento.add(parrafo);
                                documento.add(tabla);
                            }else{
                                Paragraph texto=new Paragraph();
                                texto.setAlignment(Paragraph.ALIGN_CENTER);
                                texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                texto.add("No hay expedientes todavía\n\n");
                                documento.add(texto);
                            }
                            
                            documento.close();
                            JOptionPane.showMessageDialog(null, "Reporte generado exitosamente en\n"
                                +"el escriotorio de esta computadora", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }catch(DocumentException | SQLException s){
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: "+s.getMessage());
                        }
                    }catch(DocumentException | HeadlessException | IOException s){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar el reporte!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: "+s.getMessage());
                    }
                }else if(selector.equals("Cancelar")){
                    JOptionPane.showMessageDialog(null, "Operación cancelada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception s){
            
            }
        }else if(e.getSource()==cerrar){
            Icon icono=null;
            String []op={"Si", "No"};
            int close=JOptionPane.showOptionDialog(null, "¿Deseas cerra sesión?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, HEIGHT, icono, op, op[0]);
            if(close==JOptionPane.YES_OPTION){
                Login zero=new Login();
                zero.setBounds(0, 0, 319, 500);
                zero.setVisible(true);
                zero.setResizable(false);
                zero.setLocationRelativeTo(null);
                dispose();
                JOptionPane.showMessageDialog(null, "Sesión finalizada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource()==nuevo){
            Hospital byoujin=new Hospital();
            byoujin.setVisible(true);
            byoujin.setResizable(false);
            byoujin.setLocationRelativeTo(null);
            byoujin.modificar.setVisible(false);
            byoujin.buscar.setVisible(false);
            byoujin.eliminar.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        BaseHospital read=new BaseHospital();
        read.setBounds(0, 0, 900, 320);
        read.setVisible(true);
        read.setResizable(false);
        read.setLocationRelativeTo(null);
    }
}
