package proyectos;

import com.itextpdf.text.pdf.*;
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
public class Capturista extends javax.swing.JFrame {

    public static String usuario = "", nom = "";
    int sesion;
    String url = "jdbc:mysql://localhost/bd_ds";
    String user = "root";
    String password = "";

    public Capturista() {
        initComponents();
        usuario = Login.user;
        sesion = Administrador.sesion;
        setTitle("Capturista - Sesion de " + usuario);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setBounds(0, 0, 550, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        if (sesion == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT NOMBRE_USUARIO FROM USUARIOS WHERE USERNAME='" + usuario + "'");

            ResultSet set = psp.executeQuery();

            if (set.next()) {
                nom = set.getString("NOMBRE_USUARIO");
                jLabel4.setText("Bienvenido " + nom);
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo localizar el nombre del usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }

    }

    public Icon icono(String way, int a, int o) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(way))
                .getImage().getScaledInstance(a, o, java.awt.Image.SCALE_DEFAULT));

        return imagen;
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Bienvenido");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jButton3.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addUser.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 100, 100));

        jButton1.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/informationuser.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, 100));

        jButton2.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/impresora.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 100, 100));

        logout.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        logout.setText("Cerrar sesión");
        logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 100, 25));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Imprimir Clientes");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 195, 120, 20));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion Clientes");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 195, 140, 20));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Clientes");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 195, 140, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registro_Clientes rgb = new Registro_Clientes();
        rgb.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Gestor_Clientes gt = new Gestor_Clientes();
        gt.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Document documento = new Document();
        try {
            String[] opciones = {"Definir Ruta", "Ruta Predeterminada", "Cancelar"};
            String op = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Opciones", JOptionPane.INFORMATION_MESSAGE,
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

                        documento.open();
                        documento.add(header);
                        documento.add(parrafo);

                        PdfPTable tablaCliente = new PdfPTable(5);
                        tablaCliente.addCell("ID");
                        tablaCliente.addCell("Nombre");
                        tablaCliente.addCell("email");
                        tablaCliente.addCell("Télefono");
                        tablaCliente.addCell("Dirección");

                        try {
                            Connection cnn = DriverManager.getConnection(url, user, password);
                            PreparedStatement psp = cnn.prepareStatement("SELECT * FROM CLIENTES");

                            ResultSet set = psp.executeQuery();

                            if (set.next()) {
                                do {
                                    tablaCliente.addCell(set.getString(1));
                                    tablaCliente.addCell(set.getString(2));
                                    tablaCliente.addCell(set.getString(3));
                                    tablaCliente.addCell(set.getString(4));
                                    tablaCliente.addCell(set.getString(5));
                                } while (set.next());
                                documento.add(tablaCliente);
                            } else {
                                Paragraph texto = new Paragraph();
                                texto.setAlignment(Paragraph.ALIGN_CENTER);
                                texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                                texto.add("No hay registros todavía\n\n");
                                documento.add(texto);
                            }

                            documento.close();
                            JOptionPane.showMessageDialog(null, "¡Tú reporte se ha creado con éxito!\n"
                                    + "Ruta del archivo: " + archivo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        } catch (DocumentException | SQLException s) {
                            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            System.err.println("Error: " + s.getLocalizedMessage());
                        }
                    } catch (DocumentException | HeadlessException | IOException s) {
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: " + s.getLocalizedMessage());
                    }
                }
            } else if (op.equals("Ruta Predeterminada")) {
                try {
                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Lista de Clientes.pdf"));

                    com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/BannerPDF_Español.png");
                    header.scaleToFit(650, 1000);
                    header.setAlignment(Chunk.ALIGN_CENTER);

                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                    parrafo.add("Información del cliente. \n \n");

                    documento.open();
                    documento.add(header);
                    documento.add(parrafo);

                    PdfPTable tablaCliente = new PdfPTable(5);
                    tablaCliente.addCell("ID");
                    tablaCliente.addCell("Nombre");
                    tablaCliente.addCell("email");
                    tablaCliente.addCell("Télefono");
                    tablaCliente.addCell("Dirección");

                    try {
                        Connection cnn = DriverManager.getConnection(url, user, password);
                        PreparedStatement psp = cnn.prepareStatement("SELECT * FROM CLIENTES");

                        ResultSet set = psp.executeQuery();

                        if (set.next()) {
                            do {
                                tablaCliente.addCell(set.getString(1));
                                tablaCliente.addCell(set.getString(2));
                                tablaCliente.addCell(set.getString(3));
                                tablaCliente.addCell(set.getString(4));
                                tablaCliente.addCell(set.getString(5));
                            } while (set.next());
                            documento.add(tablaCliente);
                        } else {
                            Paragraph texto = new Paragraph();
                            texto.setAlignment(Paragraph.ALIGN_CENTER);
                            texto.setFont(FontFactory.getFont("Sylfaen", 12, 1, BaseColor.RED));
                            texto.add("No hay registros todavía\n\n");
                            documento.add(texto);
                        }

                        documento.close();
                        JOptionPane.showMessageDialog(null, "¡Tú reporte se ha creado con éxito!\n"
                                + "El documento se encuentra en el\nescritorio de esta computadora");
                    } catch (DocumentException | SQLException s) {
                        JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡Datos no encontrados!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: " + s.getLocalizedMessage());
                    }
                } catch (DocumentException | HeadlessException | IOException s) {
                    JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se pudo generar PDF!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: " + s.getLocalizedMessage());
                }
            } else if (op.equals("Cancelar")) {
                JOptionPane.showMessageDialog(null, "Operación Cancelada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception s) {

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
            String op[] = {"Si", "No"};
            int himeragi = JOptionPane.showOptionDialog(null, "¿Estás seguro de cerrar sesión?", "Advertencia", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, icono("/imagenes/warning.png", 30, 30), op, op[0]);
            if (himeragi == JOptionPane.YES_OPTION) {
                Login abismo = new Login();
                abismo.setVisible(true);
                dispose();
                abismo.con.setText("Contraseña:");
                abismo.con.setFont(new java.awt.Font("Sylfaen", 1, 15));
                abismo.us.setText("Usuario:");
                abismo.us.setFont(new java.awt.Font("Sylfaen", 1, 15));
                abismo.jButton1.setText("Acceder");
                abismo.jButton1.setFont(new java.awt.Font("Sylfaen", 1, 18));
                abismo.setTitle("Acceso al Sistema");

                JOptionPane.showMessageDialog(null, "Cerraste sesión");
            }
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
