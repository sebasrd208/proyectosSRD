package proyectos;

import com.itextpdf.text.pdf.*;
import com.itextpdf.text.*;
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
public class Info_Clientes extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost/bd_ds";
    String user = "root";
    String password = "";
    public static String usuario = "", nom="";    
    public static int user_update = 0;
    int ID = 0;
    public static DefaultTableModel tabla = new DefaultTableModel();
    static int IDcliente_update = 0, equipo = 0;

    public Info_Clientes() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        usuario = Login.user;
        IDcliente_update = Gestor_Clientes.user_update;
        equipo = Gestor_Clientes.ID;        
        
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setResizable(false);
        setBounds(0, 0, 640, 450);
        setLocationRelativeTo(null);
        borrar_nom.setVisible(false);
        borrar_correo.setVisible(false);
        borrar_telefono.setVisible(false);
        borrar_direccion.setVisible(false);
        actualizar.setEnabled(false);
                
        tabla.setRowCount(0);
        tabla.setColumnCount(0);
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            PreparedStatement pst = cnn.prepareStatement(
                    "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ID_CLIENTE="+equipo);

            ResultSet capulin = pst.executeQuery();

            tabla_equipos = new JTable(tabla);
            jScrollPane1.setViewportView(tabla_equipos);

            tabla.addColumn("ID del Equipo");
            tabla.addColumn("Tipo de Equipo");
            tabla.addColumn("Marca");
            tabla.addColumn("Estado");

            while (capulin.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = capulin.getObject(i + 1);
                }
                tabla.addRow(fila);
            }
            cnn.close();
        } catch (SQLException s) {
            System.err.println("Error al llenar la tabla: " + s);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacté al administrador");
        }
        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE ID_CLIENTE="+equipo);

            ResultSet set = psp.executeQuery();
            if (set.next()){
                nom=set.getString("NOMBRE_CLIENTE");
                setTitle("Información del cliente "+nom+" - Sesión de " + usuario);
                titulo.setText("Información del Cliente "+nom); 
                nombre.setText(nom);
                correo.setText(set.getString("MAIL_CLIENTE"));
                telefono.setText(set.getString("TEL_CLIENTE"));
                direccion.setText(set.getString("DIR_CLIENTE"));
                modificacion.setText(set.getString("ULTIMA_MODIFICACION"));
            }
            cnn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL CARGAR!!, contacte al administrador", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error al crear usuario: " + e.getLocalizedMessage());
        }
        
        tabla_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent s) {
                int fila = tabla_equipos.rowAtPoint(s.getPoint());
                int columna = 0;
                if (fila > -1) {
                    user_update = (int) tabla.getValueAt(fila, columna);
                    Info_Equipo carnaval = new Info_Equipo();
                    carnaval.setVisible(true);
                    Info_Equipo.comentarTecnico.setVisible(false);
                    Info_Equipo.comentarios.setEditable(false);
                    Info_Equipo.eliminarClientes.setVisible(true);
                    Info_Equipo.eliminarEquipos.setVisible(false);
                }
            }
        });
    }

    public Icon icono(String camino, int a, int o) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(camino))
        .getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));

        return imagen;
    }

    public static void Actualizar() {
        tabla.setRowCount(0);
        tabla.setColumnCount(0);
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            PreparedStatement pst = cnn.prepareStatement(
                    "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ID_CLIENTE="+equipo);

            ResultSet capulin = pst.executeQuery();

            tabla_equipos = new JTable(tabla);
            jScrollPane1.setViewportView(tabla_equipos);

            tabla.addColumn("ID del Equipo");
            tabla.addColumn("Tipo de Equipo");
            tabla.addColumn("Marca");
            tabla.addColumn("Estado");

            while (capulin.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = capulin.getObject(i + 1);
                }
                tabla.addRow(fila);
            }
            cnn.close();
        } catch (SQLException s) {
            System.err.println("Error al llenar la tabla: " + s);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacté al administrador");
        }
        tabla_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent s) {
                int fila = tabla_equipos.rowAtPoint(s.getPoint());
                int columna = 0;
                if (fila > -1) {
                    user_update = (int) tabla.getValueAt(fila, columna);
                    Info_Equipo carnaval = new Info_Equipo();
                    carnaval.setVisible(true);
                    Info_Equipo.comentarTecnico.setVisible(false);
                    Info_Equipo.comentarios.setEditable(false);
                    Info_Equipo.eliminarClientes.setVisible(true);
                    Info_Equipo.eliminarEquipos.setVisible(false);
                }
            }
        });
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    public void Update() {
        String hayasaka = nombre.getText().trim();
        String kaguya = correo.getText().trim();
        String chika = telefono.getText().trim();
        String miko = direccion.getText().trim();

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("UPDATE CLIENTES SET NOMBRE_CLIENTE=?, "
                    + "MAIL_CLIENTE=?, TEL_CLIENTE=?, DIR_CLIENTE=?, ULTIMA_MODIFICACION=? WHERE ID_CLIENTE=" + IDcliente_update);

            psp.setString(1, hayasaka);
            psp.setString(2, kaguya);
            psp.setString(3, chika);
            psp.setString(4, miko);
            psp.setString(5, usuario);

            psp.executeUpdate();
            cnn.close();

            Limpiar();

            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo actualizar el cliente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        borrar_nom = new javax.swing.JCheckBox();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        borrar_correo = new javax.swing.JCheckBox();
        correo = new javax.swing.JTextField();
        borrar_telefono = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        borrar_direccion = new javax.swing.JCheckBox();
        direccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modificacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_equipos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 255, 255));
        titulo.setText("Información del Cliente");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        borrar_nom.setBackground(new java.awt.Color(204, 204, 204));
        borrar_nom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_nomActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 90, 30, 30));

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Correo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        borrar_correo.setBackground(new java.awt.Color(204, 204, 204));
        borrar_correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_correoActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 150, 30, 30));

        correo.setBackground(new java.awt.Color(204, 204, 204));
        correo.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoKeyReleased(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 30));

        borrar_telefono.setBackground(new java.awt.Color(204, 204, 204));
        borrar_telefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 210, 30, 30));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Teléfono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        telefono.setBackground(new java.awt.Color(204, 204, 204));
        telefono.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoKeyReleased(evt);
            }
        });
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 210, 30));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        borrar_direccion.setBackground(new java.awt.Color(204, 204, 204));
        borrar_direccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 270, 30, 30));

        direccion.setBackground(new java.awt.Color(204, 204, 204));
        direccion.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        direccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });
        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionKeyReleased(evt);
            }
        });
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 210, 30));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Ultima modificación:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        modificacion.setBackground(new java.awt.Color(204, 204, 204));
        modificacion.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        modificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modificacion.setEnabled(false);
        getContentPane().add(modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 210, 30));

        tabla_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 370, 190));

        jButton3.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jButton3.setText("Registrar Equipo");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 250, 25));

        actualizar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        actualizar.setText("Actualizar Cliente");
        actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 250, 25));

        jButton2.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/impresora.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 100, 100));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 55, 55));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void habilitarBtn() {
        String namae = nombre.getText().trim();
        String mail = correo.getText().trim();
        String denwa = telefono.getText().trim();
        String jusho = direccion.getText().trim();

        if (namae.isEmpty() | mail.isEmpty() | denwa.isEmpty() | jusho.isEmpty()) {
            actualizar.setEnabled(false);
        } else {
            actualizar.setEnabled(true);
        }
    }

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        String nagisa = nombre.getText();
        if (nagisa.isEmpty()) {
            borrar_nom.setVisible(false);
        } else {
            borrar_nom.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_nombreKeyReleased

    private void borrar_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_nomActionPerformed
        nombre.setText("");
        actualizar.setEnabled(false);
        borrar_nom.setVisible(false);
    }//GEN-LAST:event_borrar_nomActionPerformed

    private void correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyReleased
        String kaede = correo.getText();
        if (kaede.isEmpty()) {
            borrar_correo.setVisible(false);
        } else {
            borrar_correo.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_correoKeyReleased

    private void borrar_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_correoActionPerformed
        correo.setText("");
        actualizar.setEnabled(false);
        borrar_correo.setVisible(false);
    }//GEN-LAST:event_borrar_correoActionPerformed

    private void borrar_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_telefonoActionPerformed
        telefono.setText("");
        actualizar.setEnabled(false);
        borrar_telefono.setVisible(false);
    }//GEN-LAST:event_borrar_telefonoActionPerformed

    private void telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyReleased
        String karma = telefono.getText();
        if (karma.isEmpty()) {
            borrar_telefono.setVisible(false);
        } else {
            borrar_telefono.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_telefonoKeyReleased

    private void borrar_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_direccionActionPerformed
        direccion.setText("");
        actualizar.setEnabled(false);
        borrar_direccion.setVisible(false);
    }//GEN-LAST:event_borrar_direccionActionPerformed

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionActionPerformed

    private void direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyReleased
        String manami = direccion.getText();
        if (manami.isEmpty()) {
            borrar_direccion.setVisible(false);
        } else {
            borrar_direccion.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_direccionKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registro_Equipos rbg = new Registro_Equipos();
        rbg.setVisible(true);        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        String[] op = {"Si", "No"};
        int hitori = JOptionPane.showOptionDialog(null, "¿Deseas actualizar los datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION,
                icono("/imagenes/warning.png", 30, 30), op, op[0]);
        if (hitori == JOptionPane.YES_OPTION) {
            Update();
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Document documento = new Document();
        try {
            String[] opciones={"Definir Ruta", "Ruta Predeterminada", "Cancelar"};
            String op=(String)JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", JOptionPane.INFORMATION_MESSAGE,
                    icono("/imagenes/guardar.png", 30, 30), opciones, opciones[0]);
            if (op.equals("Definir Ruta")) {
                JFileChooser seleccion = new JFileChooser();
                int kaijuu = seleccion.showSaveDialog(null);
                if (kaijuu == seleccion.APPROVE_OPTION) {
                    try {
                        String archivo = seleccion.getSelectedFile() + ".pdf";
                        PdfWriter.getInstance(documento, new FileOutputStream(archivo));

                        com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/BannerPDF_Español.png");
                        header.scaleToFit(650, 1000);
                        header.setAlignment(Chunk.ALIGN_CENTER);

                        Paragraph parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo.add("Información del cliente. \n \n");

                        Paragraph parrafo2 = new Paragraph();
                        parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                        parrafo2.add("Equipos registrados. \n \n");

                        documento.open();
                        documento.add(header);

                        //Informacion del cliente
                        PdfPTable tablaCliente = new PdfPTable(5);
                        tablaCliente.addCell("ID");
                        tablaCliente.addCell("Nombre");
                        tablaCliente.addCell("email");
                        tablaCliente.addCell("Télefono");
                        tablaCliente.addCell("Dirección");

                        //Equipos registrados
                        PdfPTable tablaEquipos = new PdfPTable(4);
                        tablaEquipos.addCell("ID");
                        tablaEquipos.addCell("Equipo");
                        tablaEquipos.addCell("Marca");
                        tablaEquipos.addCell("Estado");

                        try {
                            Connection cnn = DriverManager.getConnection(url, user, password);
                            PreparedStatement psp = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE ID_CLIENTE="+equipo);

                            ResultSet set = psp.executeQuery();

                            if (set.next()) {
                                do {
                                    tablaCliente.addCell(set.getString(1));
                                    tablaCliente.addCell(set.getString(2));
                                    tablaCliente.addCell(set.getString(3));
                                    tablaCliente.addCell(set.getString(4));
                                    tablaCliente.addCell(set.getString(5));
                                } while (set.next());
                                documento.add(parrafo);
                                documento.add(tablaCliente);
                            } else {
                                Paragraph texto = new Paragraph();
                                texto.setAlignment(Paragraph.ALIGN_CENTER);
                                texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                texto.add("No hay registros todavía\n\n");
                                documento.add(parrafo);
                                documento.add(texto);
                            }
                        } catch (DocumentException | SQLException s) {
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: " + s.getLocalizedMessage());
                        }

                        try {
                            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                            PreparedStatement psp = cnn.prepareStatement(
                                    "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ID_CLIENTE="+equipo);

                            ResultSet set = psp.executeQuery();

                            if (set.next()) {
                                do {
                                    tablaEquipos.addCell(set.getString(1));
                                    tablaEquipos.addCell(set.getString(2));
                                    tablaEquipos.addCell(set.getString(3));
                                    tablaEquipos.addCell(set.getString(4));
                                } while (set.next());
                                documento.add(parrafo2);
                                documento.add(tablaEquipos);
                            } else {
                                Paragraph texto = new Paragraph();
                                texto.setAlignment(Paragraph.ALIGN_CENTER);
                                texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                texto.add("No hay registros todavía\n\n");
                                documento.add(parrafo2);
                                documento.add(texto);
                            }
                            cnn.close();
                        } catch (DocumentException | SQLException s) {
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: " + s.getLocalizedMessage());
                        }
                        documento.close();
                        JOptionPane.showMessageDialog(null, "¡Tú reporte se ha creado con éxito!\n"
                                + "Ruta del archivo: " + archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } catch (DocumentException | HeadlessException | IOException s) {
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: " + s.getLocalizedMessage());
                    }
                }
            } else if (op.equals("Ruta Predeterminada")) {
                try {
                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/"+nom+".pdf"));

                    com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/BannerPDF_Español.png");
                    header.scaleToFit(650, 1000);
                    header.setAlignment(Chunk.ALIGN_CENTER);

                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                    parrafo.add("Información del cliente. \n \n");

                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                    parrafo2.add("Equipos registrados. \n \n");

                    documento.open();
                    documento.add(header);

                    //Informacion del cliente
                    PdfPTable tablaCliente = new PdfPTable(5);
                    tablaCliente.addCell("ID");
                    tablaCliente.addCell("Nombre");
                    tablaCliente.addCell("email");
                    tablaCliente.addCell("Télefono");
                    tablaCliente.addCell("Dirección");

                    //Equipos registrados
                    PdfPTable tablaEquipos = new PdfPTable(4);
                    tablaEquipos.addCell("ID");
                    tablaEquipos.addCell("Equipo");
                    tablaEquipos.addCell("Marca");
                    tablaEquipos.addCell("Estado");

                    try {
                        Connection cnn = DriverManager.getConnection(url, user, password);
                        PreparedStatement psp = cnn.prepareStatement("SELECT * FROM CLIENTES WHERE ID_CLIENTE="+equipo);

                        ResultSet set=psp.executeQuery();

                        if(set.next()){
                            do{
                                tablaCliente.addCell(set.getString(1));
                                tablaCliente.addCell(set.getString(2));
                                tablaCliente.addCell(set.getString(3));
                                tablaCliente.addCell(set.getString(4));
                                tablaCliente.addCell(set.getString(5));
                            }while(set.next());
                            documento.add(parrafo);
                            documento.add(tablaCliente);
                        }else{
                            Paragraph texto=new Paragraph();
                            texto.setAlignment(Paragraph.ALIGN_CENTER);
                            texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            texto.add("No hay registros todavía\n\n");
                            documento.add(parrafo);
                            documento.add(texto);
                        }
                    }catch(DocumentException | SQLException s){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: " + s.getLocalizedMessage());
                    }

                    try{
                        Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                        PreparedStatement psp = cnn.prepareStatement(
                                "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ID_CLIENTE="+equipo);

                        ResultSet set=psp.executeQuery();

                        if(set.next()){
                            do{
                                tablaEquipos.addCell(set.getString(1));
                                tablaEquipos.addCell(set.getString(2));
                                tablaEquipos.addCell(set.getString(3));
                                tablaEquipos.addCell(set.getString(4));
                            }while(set.next());
                            documento.add(parrafo2);
                            documento.add(tablaEquipos);
                        }else{
                            Paragraph texto = new Paragraph();
                            texto.setAlignment(Paragraph.ALIGN_CENTER);
                            texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            texto.add("No hay registros todavía\n\n");
                            documento.add(parrafo2);
                            documento.add(texto);
                        }
                        cnn.close();
                    }catch(DocumentException | SQLException s){
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: " + s.getLocalizedMessage());
                    }

                    documento.close();
                    JOptionPane.showMessageDialog(null, "¡Tú reporte se ha creado con éxito!\n"
                            +"El documento se encuentra en el\nescritorio de esta computadora");
                }catch(DocumentException | HeadlessException | IOException s){
                    JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: " + s.getLocalizedMessage());
                }
            }else if(op.equals("Cancelar")){
                JOptionPane.showMessageDialog(null, "Operación Cancelada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch(Exception s){

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String []op={"Si", "No"};
        int frontera=JOptionPane.showOptionDialog(null, "¿Deseas eliminar este cliente?", "Mensaje", JOptionPane.INFORMATION_MESSAGE,
            JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
        if(frontera==JOptionPane.YES_OPTION){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("DELETE FROM CLIENTES WHERE ID_CLIENTE="+equipo);
                PreparedStatement psp2=cnn.prepareStatement("DELETE FROM EQUIPOS WHERE ID_CLIENTE="+equipo);
                
                psp.executeUpdate();
                psp2.executeUpdate();
                
                Limpiar();
                Actualizar();
                
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException s){
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo eliminar el cliente");
                System.err.println("Error: "+s.getLocalizedMessage());
            }
            Gestor_Clientes.Actualizar();
        }
    }//GEN-LAST:event_eliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Info_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Info_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton actualizar;
    private javax.swing.JCheckBox borrar_correo;
    private javax.swing.JCheckBox borrar_direccion;
    private javax.swing.JCheckBox borrar_nom;
    private javax.swing.JCheckBox borrar_telefono;
    public static javax.swing.JTextField correo;
    public static javax.swing.JTextField direccion;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField modificacion;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JTable tabla_equipos;
    public static javax.swing.JTextField telefono;
    public static javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
    public void Limpiar() {
        nombre.setBackground(Color.green);
        nombre.setText("");
        correo.setBackground(Color.green);
        correo.setText("");
        telefono.setBackground(Color.green);
        telefono.setText("");
        direccion.setBackground(Color.green);
        direccion.setText("");
    }
}
