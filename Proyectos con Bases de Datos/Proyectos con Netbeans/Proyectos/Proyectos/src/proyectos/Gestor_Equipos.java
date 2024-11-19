package proyectos;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

/**
 *
 * @author sebas
 */
public class Gestor_Equipos extends javax.swing.JFrame {

    //String usuario="";
    //public static String user_update = "";
    static DefaultTableModel modulo = new DefaultTableModel();
    static String url = "jdbc:mysql://localhost/bd_ds";
    public static String user = "root";
    public static String password = "";
    static String username = "";
    public static int user_update = 0;

    public Gestor_Equipos() {
        initComponents();
        username = Login.user;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Equipos registrados - Sesión de " + username);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 640, 365);
        setLocationRelativeTo(null);
        setResizable(false);

        modulo.setRowCount(0);
        modulo.setColumnCount(0);
        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS");

            ResultSet set = psp.executeQuery();

            equipos = new JTable(modulo);
            Scroll.setViewportView(equipos);

            modulo.addColumn("");
            modulo.addColumn("Tipo de equipo");
            modulo.addColumn("Marca");
            modulo.addColumn("Estado");

            while (set.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = set.getObject(i + 1);
                }
                modulo.addRow(fila);
            }

            cnn.close();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo llenar la tabla",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }

        equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent s) {
                int fila = equipos.rowAtPoint(s.getPoint());
                int columna = 0;
                if (fila > -1) {
                    user_update = (int) equipos.getValueAt(fila, columna);
                    Info_Equipo carnaval = new Info_Equipo();
                    carnaval.setVisible(true);
                    carnaval.setTitle("Información del Equipo - Sesión de "+username);
                    try {
                        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                        PreparedStatement psp = cnn.prepareStatement("SELECT * FROM EQUIPOS WHERE ID_EQUIPO=" + user_update);

                        ResultSet set = psp.executeQuery();

                        if (set.next()) {
                            carnaval.tipo.setSelectedItem(set.getString("TIPO_EQUIPO"));
                            carnaval.marca.setSelectedItem(set.getString("MARCA"));
                            carnaval.estado.setSelectedItem(set.getString("ESTATUS"));
                            carnaval.modelo.setText(set.getString("MODELO"));
                            carnaval.serie.setText(set.getString("NUM_SERIE"));
                            carnaval.ult_modificacion.setText(set.getString("ULTIMA_MODIFICACION"));

                            String dia, mes, annio;
                            dia = set.getString("DIA_INGRESO");
                            mes = set.getString("MES_INGRESO");
                            annio = set.getString("ANNIO_INGRESO");

                            carnaval.fecha.setText(dia + "/" + mes + "/" + annio);
                            carnaval.fecha.setText(annio + "年" + mes + "月" + dia + "日");

                            carnaval.observaciones.setText(set.getString("OBSERVACIONES"));
                            carnaval.comentarios.setText(set.getString("COMENTARIOS_TECNICOS"));
                            carnaval.jLabel9.setText("Comentarios y actualización del técnico: " + set.getString("REVISION_TECNICA_DE"));
                            Info_Equipo.comentar.setVisible(false);
                            Info_Equipo.observaciones.setEditable(false);
                            Info_Equipo.eliminarClientes.setVisible(false);
                            Info_Equipo.eliminarEquipos.setVisible(true);
                            
                        }

                    } catch (SQLException ex) {
                        System.err.println("Error al consulta informacion del equipo: " + ex);
                    }
                }
            }
        });

    }
    
    public static void Actualizar(){
        String status = estado.getSelectedItem().toString();
        String consulta = "";
        modulo.setRowCount(0);
        modulo.setColumnCount(0);
        try {
            Connection cnn=DriverManager.getConnection(url, user, password);
            if (status.equals("Todos")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS";
            } else if (status.equals("Nuevo ingreso")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("No reparado")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("En revisión")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("Reparado")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("Entregado")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            }
            PreparedStatement psp = cnn.prepareStatement(consulta);

            ResultSet set = psp.executeQuery();

            equipos = new JTable(modulo);
            Scroll.setViewportView(equipos);

            modulo.addColumn("");
            modulo.addColumn("Tipo de equipo");
            modulo.addColumn("Marca");
            modulo.addColumn("Estado");

            while (set.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = set.getObject(i + 1);
                }
                modulo.addRow(fila);
            }
            cnn.close();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo llenar la tabla",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
        equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent s) {
                int fila = equipos.rowAtPoint(s.getPoint());
                int columna = 0;
                if (fila > -1) {
                    user_update = (int) equipos.getValueAt(fila, columna);
                    Info_Equipo carnaval = new Info_Equipo();
                    carnaval.setVisible(true);                    
                    try {
                        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                        PreparedStatement psp = cnn.prepareStatement("SELECT * FROM EQUIPOS WHERE ID_EQUIPO=" + user_update);

                        ResultSet set = psp.executeQuery();

                        if (set.next()) {
                            carnaval.tipo.setSelectedItem(set.getString("TIPO_EQUIPO"));
                            carnaval.marca.setSelectedItem(set.getString("MARCA"));
                            carnaval.estado.setSelectedItem(set.getString("ESTATUS"));
                            carnaval.modelo.setText(set.getString("MODELO"));
                            carnaval.serie.setText(set.getString("NUM_SERIE"));
                            carnaval.ult_modificacion.setText(set.getString("ULTIMA_MODIFICACION"));

                            String dia, mes, annio;
                            dia = set.getString("DIA_INGRESO");
                            mes = set.getString("MES_INGRESO");
                            annio = set.getString("ANNIO_INGRESO");

                            carnaval.fecha.setText(dia + "/" + mes + "/" + annio);
                            carnaval.fecha.setText(annio + "年" + mes + "月" + dia + "日");

                            carnaval.observaciones.setText(set.getString("OBSERVACIONES"));
                            carnaval.comentarios.setText(set.getString("COMENTARIOS_TECNICOS"));
                            carnaval.jLabel9.setText("Comentarios y actualización del técnico: " + set.getString("REVISION_TECNICA_DE"));
                            Info_Equipo.comentar.setVisible(false);
                            Info_Equipo.observaciones.setEditable(false);
                            Info_Equipo.eliminarClientes.setVisible(false);
                            Info_Equipo.eliminarEquipos.setVisible(true);
                        }

                    } catch (SQLException ex) {
                        System.err.println("Error al consulta informacion del equipo: " + ex);
                    }
                }
            }
        });
    }
    
    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        equipos = new javax.swing.JTable();
        estado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EQUIPOS REGISTRADOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 290, 30));

        equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        Scroll.setViewportView(equipos);

        getContentPane().add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 600, 230));

        estado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revisión", "Reparado", "Entregado" }));
        estado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 130, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        String status = estado.getSelectedItem().toString();
        String consulta = "";
        modulo.setRowCount(0);
        modulo.setColumnCount(0);
        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            if (status.equals("Todos")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS";
            } else if (status.equals("Nuevo ingreso")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("No reparado")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("En revisión")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("Reparado")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            } else if (status.equals("Entregado")) {
                consulta = "SELECT ID_EQUIPO, TIPO_EQUIPO, MARCA, ESTATUS FROM EQUIPOS WHERE ESTATUS='" + status + "'";
            }
            PreparedStatement psp = cnn.prepareStatement(consulta);

            ResultSet set = psp.executeQuery();

            equipos = new JTable(modulo);
            Scroll.setViewportView(equipos);

            modulo.addColumn("");
            modulo.addColumn("Tipo de equipo");
            modulo.addColumn("Marca");
            modulo.addColumn("Estado");

            while (set.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = set.getObject(i + 1);
                }
                modulo.addRow(fila);
            }
            cnn.close();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo llenar la tabla",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
        equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent s) {
                int fila = equipos.rowAtPoint(s.getPoint());
                int columna = 0;
                if (fila > -1) {
                    user_update = (int) equipos.getValueAt(fila, columna);
                    Info_Equipo carnaval = new Info_Equipo();
                    carnaval.setVisible(true);                    
                    try {
                        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                        PreparedStatement psp = cnn.prepareStatement("SELECT * FROM EQUIPOS WHERE ID_EQUIPO=" + user_update);

                        ResultSet set = psp.executeQuery();

                        if (set.next()) {
                            carnaval.tipo.setSelectedItem(set.getString("TIPO_EQUIPO"));
                            carnaval.marca.setSelectedItem(set.getString("MARCA"));
                            carnaval.estado.setSelectedItem(set.getString("ESTATUS"));
                            carnaval.modelo.setText(set.getString("MODELO"));
                            carnaval.serie.setText(set.getString("NUM_SERIE"));
                            carnaval.ult_modificacion.setText(set.getString("ULTIMA_MODIFICACION"));

                            String dia, mes, annio;
                            dia = set.getString("DIA_INGRESO");
                            mes = set.getString("MES_INGRESO");
                            annio = set.getString("ANNIO_INGRESO");

                            carnaval.fecha.setText(dia + "/" + mes + "/" + annio);
                            carnaval.fecha.setText(annio + "年" + mes + "月" + dia + "日");

                            carnaval.observaciones.setText(set.getString("OBSERVACIONES"));
                            carnaval.comentarios.setText(set.getString("COMENTARIOS_TECNICOS"));
                            carnaval.jLabel9.setText("Comentarios y actualización del técnico: " + set.getString("REVISION_TECNICA_DE"));
                            Info_Equipo.comentar.setVisible(false);
                            Info_Equipo.observaciones.setEditable(false);
                            Info_Equipo.eliminarClientes.setVisible(false);
                            Info_Equipo.eliminarEquipos.setVisible(true);
                        }

                    } catch (SQLException ex) {
                        System.err.println("Error al consulta informacion del equipo: " + ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_estadoActionPerformed

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
            java.util.logging.Logger.getLogger(Gestor_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestor_Equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JScrollPane Scroll;
    public static javax.swing.JTable equipos;
    public static javax.swing.JComboBox<String> estado;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
