package proyectos;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Info_Equipo extends javax.swing.JFrame {

    public static int IDCliente_update = 0, IDEquipo = 0;
    public static String usuario = "", cliente = "";
    static String url = "jdbc:mysql://localhost/bd_ds";
    static String user = "root";
    static String password = "";

    public Info_Equipo() {
        initComponents();
        usuario = Login.user;
        IDCliente_update = Info_Clientes.user_update;
        cliente = Info_Clientes.nom;
        IDEquipo = Gestor_Clientes.ID;
        setBounds(0, 0, 670, 530);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Información del Equipo de " + cliente);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        nom.setText(cliente);
        setResizable(false);
        setLocationRelativeTo(null);

        delete_model.setVisible(false);
        delete_series.setVisible(false);
        comentar.setEnabled(false);
        comentarTecnico.setEnabled(false);
        fecha.setFont(new Font("Andale mono", 1, 12));

        ImageIcon fondo = new ImageIcon("src/imagenes/fondo.jpg");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(jLabel11.getWidth(),
        jLabel11.getHeight(), Image.SCALE_DEFAULT));
        jLabel11.setIcon(icono);
        this.repaint();
        
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            PreparedStatement psp = cnn.prepareStatement("SELECT * FROM EQUIPOS WHERE ID_EQUIPO=" + IDCliente_update);

            ResultSet set = psp.executeQuery();

            if (set.next()) {
                tipo.setSelectedItem(set.getString("TIPO_EQUIPO"));
                marca.setSelectedItem(set.getString("MARCA"));
                estado.setSelectedItem(set.getString("ESTATUS"));
                modelo.setText(set.getString("MODELO"));
                serie.setText(set.getString("NUM_SERIE"));
                ult_modificacion.setText(set.getString("ULTIMA_MODIFICACION"));

                String dia, mes, annio;
                dia = set.getString("DIA_INGRESO");
                mes = set.getString("MES_INGRESO");
                annio = set.getString("ANNIO_INGRESO");

                fecha.setText(dia + "/" + mes + "/" + annio);
                fecha.setText(annio + "年" + mes + "月" + dia + "日");

                observaciones.setText(set.getString("OBSERVACIONES"));
                comentarios.setText(set.getString("COMENTARIOS_TECNICOS"));
                jLabel9.setText("Comentarios y actualización del técnico: " + set.getString("REVISION_TECNICA_DE"));
            }

        } catch (SQLException ex) {
            System.err.println("Error al consulta informacion del equipo: " + ex);
        }

    }//

    public void habilitarBtn() {
        String yoasobi = modelo.getText().trim();
        String mwam = serie.getText().trim();

        if (yoasobi.isEmpty() | mwam.isEmpty()) {
            comentar.setEnabled(false);
            comentarTecnico.setEnabled(false);
        } else {
            comentar.setEnabled(true);
            comentarTecnico.setEnabled(true);
        }
    }

    public Icon icono(String camino, int a, int o) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(camino))
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

        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        fecha = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        marca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        delete_model = new javax.swing.JCheckBox();
        modelo = new javax.swing.JTextField();
        delete_series = new javax.swing.JCheckBox();
        serie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ult_modificacion = new javax.swing.JTextField();
        comentar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        comentarios = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comentarTecnico = new javax.swing.JButton();
        eliminarClientes = new javax.swing.JButton();
        eliminarEquipos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(153, 255, 255));
        titulo.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Información del Equipo");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 10, 360, -1));

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Nombre del Cliente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, -1, 20));

        jLabel7.setBackground(new java.awt.Color(153, 255, 255));
        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("Fecha de Ingreso:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabel10.setBackground(new java.awt.Color(153, 255, 255));
        jLabel10.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 255));
        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        estado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revisión", "Reparado", "Entregado" }));
        estado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 130, 25));

        fecha.setBackground(new java.awt.Color(204, 204, 204));
        fecha.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 0, 0));
        fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha.setActionCommand("<Not Set>");
        fecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fecha.setEnabled(false);
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 210, 25));

        nom.setBackground(new java.awt.Color(204, 204, 204));
        nom.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        nom.setForeground(new java.awt.Color(0, 0, 0));
        nom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nom.setEnabled(false);
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 25));

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Tipo de Equipo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        tipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Computadora de Escritorio", "Impresora", "Multifuncional", "Smartphone" }));
        tipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 25));

        marca.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Allenware", "Apple", "Asus", "Brother", "Dell", "HP", "Toshiba", "Hauwei", "Samsung", "Lenovo", "LG", "Vaio", "Xerox", "OPPO", "ZTE", "Motorola" }));
        marca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, 25));

        jLabel3.setBackground(new java.awt.Color(153, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Marca:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setBackground(new java.awt.Color(153, 255, 255));
        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Modelo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        delete_model.setBackground(new java.awt.Color(204, 204, 204));
        delete_model.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        delete_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_modelActionPerformed(evt);
            }
        });
        getContentPane().add(delete_model, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 290, 30, 30));

        modelo.setBackground(new java.awt.Color(204, 204, 204));
        modelo.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        modelo.setForeground(new java.awt.Color(0, 0, 0));
        modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modelo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                modeloKeyReleased(evt);
            }
        });
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 210, 30));

        delete_series.setBackground(new java.awt.Color(204, 204, 204));
        delete_series.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        delete_series.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_seriesActionPerformed(evt);
            }
        });
        getContentPane().add(delete_series, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 350, 30, 30));

        serie.setBackground(new java.awt.Color(204, 204, 204));
        serie.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        serie.setForeground(new java.awt.Color(0, 0, 0));
        serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        serie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        serie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                serieKeyTyped(evt);
            }
        });
        getContentPane().add(serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, 30));

        jLabel5.setBackground(new java.awt.Color(153, 255, 255));
        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("No. de Serie:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        jLabel6.setBackground(new java.awt.Color(153, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setText("Ultima modificación por:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 20));

        ult_modificacion.setBackground(new java.awt.Color(204, 204, 204));
        ult_modificacion.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        ult_modificacion.setForeground(new java.awt.Color(0, 0, 0));
        ult_modificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ult_modificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ult_modificacion.setEnabled(false);
        ult_modificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ult_modificacionKeyReleased(evt);
            }
        });
        getContentPane().add(ult_modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 210, 30));

        comentar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        comentar.setText("Comentar y actualizar");
        comentar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarActionPerformed(evt);
            }
        });
        getContentPane().add(comentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 210, -1));

        comentarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comentariosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(comentarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 380, 130));

        observaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                observacionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 380, 140));

        jLabel8.setBackground(new java.awt.Color(153, 255, 255));
        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 255));
        jLabel8.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel9.setBackground(new java.awt.Color(153, 255, 255));
        jLabel9.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 255));
        jLabel9.setText("Comentarios y actualización del técnico:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        comentarTecnico.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        comentarTecnico.setText("Comentar");
        comentarTecnico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comentarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarTecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(comentarTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 210, -1));

        eliminarClientes.setBackground(new java.awt.Color(255, 0, 51));
        eliminarClientes.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        eliminarClientes.setText("Eliminar Equipo");
        eliminarClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 180, 25));

        eliminarEquipos.setBackground(new java.awt.Color(255, 0, 51));
        eliminarEquipos.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        eliminarEquipos.setText("Eliminar Equipo");
        eliminarEquipos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 180, 25));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        comentar.setEnabled(true);
    }//GEN-LAST:event_estadoActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoActionPerformed

    private void modeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeloKeyReleased
        String ochako = modelo.getText();
        if (ochako.isEmpty()) {
            delete_model.setVisible(false);
        } else {
            delete_model.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_modeloKeyReleased

    private void delete_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_modelActionPerformed
        modelo.setText("");
        comentar.setEnabled(false);
        delete_model.setVisible(false);
    }//GEN-LAST:event_delete_modelActionPerformed

    private void delete_seriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_seriesActionPerformed
        serie.setText("");
        comentar.setEnabled(false);
        delete_series.setVisible(false);
    }//GEN-LAST:event_delete_seriesActionPerformed

    private void serieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serieKeyReleased
        String momo = serie.getText();
        if (momo.isEmpty()) {
            delete_series.setVisible(false);
        } else {
            delete_series.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_serieKeyReleased

    private void ult_modificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ult_modificacionKeyReleased

    }//GEN-LAST:event_ult_modificacionKeyReleased

    private void comentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarActionPerformed
        String[] op = {"Si", "No"};
        int hitori = JOptionPane.showOptionDialog(null, "¿Deseas actualizar los datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION,
                icono("/imagenes/warning.png", 30, 30), op, op[0]);
        if (hitori == JOptionPane.YES_OPTION) {
            Update();
            Info_Clientes.Actualizar();
        }

    }//GEN-LAST:event_comentarActionPerformed

    private void serieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serieKeyTyped
        int llave = evt.getKeyChar();

        if (!(llave >= 48 & llave <= 57)) {
            evt.consume();
        }

        if (serie.getText().trim().length() >= 13) {
            evt.consume();
        }
    }//GEN-LAST:event_serieKeyTyped

    private void comentarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarTecnicoActionPerformed
        String[] op = {"Si", "No"};
        int ryo = JOptionPane.showOptionDialog(null, "¿Deseas actualizar los datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION,
                icono("/imagenes/warning.png", 30, 30), op, op[0]);
        if (ryo == JOptionPane.YES_OPTION) {
            Calendar calendario = Calendar.getInstance();
            String device = tipo.getSelectedItem().toString();
            String brand = marca.getSelectedItem().toString();
            String model = modelo.getText().trim();
            String series = serie.getText().trim();
            String dia = String.valueOf(calendario.get(Calendar.DATE));
            String mes = String.valueOf(calendario.get(Calendar.MONTH));
            String annio = String.valueOf(calendario.get(Calendar.YEAR));
            String itsuki = comentarios.getText().trim();
            String status = estado.getSelectedItem().toString();
            String name = "";
            if (itsuki.isEmpty()) {
                observaciones.setText("Sin observaciones");
            }
            try {
                Connection cnn = DriverManager.getConnection(url, user, password);
                PreparedStatement psp = cnn.prepareStatement("UPDATE EQUIPOS SET TIPO_EQUIPO=?, MARCA=?, MODELO=?, "
                        + "NUM_SERIE=?, DIA_INGRESO=?, MES_INGRESO=?, ANNIO_INGRESO=?, ESTATUS=?,"
                        + " ULTIMA_MODIFICACION=?, COMENTARIOS_TECNICOS=?, REVISION_TECNICA_DE=? WHERE ID_EQUIPO=" + Gestor_Equipos.user_update);

                try {
                    PreparedStatement psp2 = cnn.prepareStatement("SELECT NOMBRE_USUARIO FROM USUARIOS WHERE USERNAME='" + usuario + "'");
                    ResultSet set = psp2.executeQuery();

                    if (set.next()) {
                        name = set.getString("NOMBRE_USUARIO");
                    }
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo localizar el nombre del usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    System.err.println("Error: " + s.getLocalizedMessage());
                }

                psp.setString(1, device);
                psp.setString(2, brand);
                psp.setString(3, model);
                psp.setString(4, series);
                psp.setString(5, dia);
                psp.setString(6, mes);
                psp.setString(7, annio);
                psp.setString(8, status);
                psp.setString(9, usuario);
                if (itsuki.isEmpty()) {
                    psp.setString(10, "Sin observaciones");
                } else {
                    psp.setString(10, itsuki);
                }
                psp.setString(11, name);

                psp.executeUpdate();
                Limpiar();
                JOptionPane.showMessageDialog(null, "¡Equipo actualizado exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                dispose();
            } catch (SQLException s) {
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo actualizar datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: " + s.getLocalizedMessage());
            }
            Gestor_Equipos.Actualizar();
        }
    }//GEN-LAST:event_comentarTecnicoActionPerformed

    private void observacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observacionesKeyReleased
        String shiratori = observaciones.getText().trim();
        if (shiratori.isEmpty()) {
            comentar.setEnabled(false);
        } else {
            comentar.setEnabled(true);
        }

    }//GEN-LAST:event_observacionesKeyReleased

    private void comentariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comentariosKeyReleased
        String shikimori = observaciones.getText().trim();
        if (shikimori.isEmpty()) {
            comentarTecnico.setEnabled(false);
        } else {
            comentarTecnico.setEnabled(true);
        }
    }//GEN-LAST:event_comentariosKeyReleased

    private void eliminarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClientesActionPerformed
        String[] op={"Si", "No"};
        int sayaka = JOptionPane.showOptionDialog(null, "¿Deseas eliminar este equipo?", "Advertencia", JOptionPane.INFORMATION_MESSAGE,
            JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
        if (sayaka == JOptionPane.YES_OPTION){
            try {
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("DELETE FROM EQUIPOS WHERE ID_EQUIPO="+IDCliente_update);

                psp.executeUpdate();
                cnn.close();

                delete_model.setVisible(false);
                delete_series.setVisible(false);
                observaciones.setText("");
                comentarios.setText("");
                modelo.setText("");
                modelo.setBackground(Color.orange);
                serie.setText("");
                serie.setBackground(Color.orange);
                fecha.setText("");
                fecha.setBackground(Color.orange);
                ult_modificacion.setText("");
                ult_modificacion.setBackground(Color.orange);
                
                JOptionPane.showMessageDialog(null, "¡Equipo eliminado exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (HeadlessException | SQLException s) {
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo eliminar el usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                System.err.println("Error: " + s.getLocalizedMessage());
            }
            Info_Clientes.Actualizar();
        }
    }//GEN-LAST:event_eliminarClientesActionPerformed

    private void eliminarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEquiposActionPerformed
        String[] op={"Si", "No"};
        int sayaka = JOptionPane.showOptionDialog(null, "¿Deseas eliminar este equipo?", "Advertencia", JOptionPane.INFORMATION_MESSAGE,
            JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
        if (sayaka == JOptionPane.YES_OPTION){
            try {
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("DELETE FROM EQUIPOS WHERE ID_EQUIPO="+IDCliente_update);

                psp.executeUpdate();
                cnn.close();

                delete_model.setVisible(false);
                delete_series.setVisible(false);
                observaciones.setText("");
                comentarios.setText("");
                modelo.setText("");
                modelo.setBackground(Color.orange);
                serie.setText("");
                serie.setBackground(Color.orange);
                fecha.setText("");
                fecha.setBackground(Color.orange);
                ult_modificacion.setText("");
                ult_modificacion.setBackground(Color.orange);
                
                JOptionPane.showMessageDialog(null, "¡Equipo eliminado exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (HeadlessException | SQLException s) {
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo eliminar el usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                System.err.println("Error: " + s.getLocalizedMessage());
            }
            Gestor_Equipos.Actualizar();
        }
    }//GEN-LAST:event_eliminarEquiposActionPerformed

    public void Update() {
        Calendar calendario = Calendar.getInstance();
        String device = tipo.getSelectedItem().toString();
        String brand = marca.getSelectedItem().toString();
        String model = modelo.getText().trim();
        String series = serie.getText().trim();
        String dia = String.valueOf(calendario.get(Calendar.DATE));
        String mes = String.valueOf(calendario.get(Calendar.MONTH));
        String annio = String.valueOf(calendario.get(Calendar.YEAR));
        String itsuki = observaciones.getText().trim();
        String status = estado.getSelectedItem().toString();
        String name = "";
        if (itsuki.isEmpty()) {
            observaciones.setText("Sin observaciones");
        }

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("UPDATE EQUIPOS SET TIPO_EQUIPO=?, MARCA=?, MODELO=?, "
                    + "NUM_SERIE=?, DIA_INGRESO=?, MES_INGRESO=?, ANNIO_INGRESO=?, OBSERVACIONES=?, ESTATUS=?,"
                    + " ULTIMA_MODIFICACION=? WHERE ID_EQUIPO=" +Info_Clientes.user_update);

            try {
                PreparedStatement psp2 = cnn.prepareStatement("SELECT NOMBRE_USUARIO FROM USUARIOS WHERE USERNAME='" + usuario + "'");
                ResultSet set = psp2.executeQuery();

                if (set.next()) {
                    name = set.getString("NOMBRE_USUARIO");
                }
            } catch (SQLException s) {
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo localizar el nombre del usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: " + s.getLocalizedMessage());
            }

            psp.setString(1, device);
            psp.setString(2, brand);
            psp.setString(3, model);
            psp.setString(4, series);
            psp.setString(5, dia);
            psp.setString(6, mes);
            psp.setString(7, annio);
            if (itsuki.isEmpty()) {
                psp.setString(8, "Sin observaciones");
            } else {
                psp.setString(8, itsuki);
            }
            psp.setString(9, status);
            psp.setString(10, usuario);

            psp.executeUpdate();
            Limpiar();
            JOptionPane.showMessageDialog(null, "¡Equipo actualizado exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            dispose();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo actualizar datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
        Info_Clientes.Actualizar();
    }

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
            java.util.logging.Logger.getLogger(Info_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Info_Equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton comentar;
    public static javax.swing.JButton comentarTecnico;
    public static javax.swing.JTextPane comentarios;
    private javax.swing.JCheckBox delete_model;
    private javax.swing.JCheckBox delete_series;
    public static javax.swing.JButton eliminarClientes;
    public static javax.swing.JButton eliminarEquipos;
    public static javax.swing.JComboBox<String> estado;
    public static javax.swing.JTextField fecha;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JComboBox<String> marca;
    public static javax.swing.JTextField modelo;
    public static javax.swing.JTextField nom;
    public static javax.swing.JTextPane observaciones;
    public static javax.swing.JTextField serie;
    public static javax.swing.JComboBox<String> tipo;
    public static javax.swing.JLabel titulo;
    public static javax.swing.JTextField ult_modificacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        delete_model.setVisible(false);
        delete_series.setVisible(false);
        observaciones.setText("");
        comentarios.setText("");
        modelo.setText("");
        modelo.setBackground(Color.green);
        serie.setText("");
        serie.setBackground(Color.green);
    }
}
