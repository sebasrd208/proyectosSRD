package proyectos;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Info_Usuarios extends javax.swing.JFrame {

    public static String username = "", ID = "";
    public static int sesion;
    String url = "jdbc:mysql://localhost/bd_ds";
    String user = "root";
    String password = "";
    int megumin = 0;

    public Info_Usuarios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        username = Login.user;
        megumin = Gestor_Usuarios.user_update;
        ID = Gestor_Usuarios.dato;
        sesion = Gestor_Usuarios.sesion;
        setLocationRelativeTo(null);
        setBounds(0, 0, 640, 460);
        setResizable(false);
        setLocationRelativeTo(null);
        //System.out.println(Gestor_Usuarios.ID);
        if (sesion == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        borrar_correo.setVisible(false);
        borrar_nombre.setVisible(false);
        borrar_telefono.setVisible(false);
        borrar_usuario.setVisible(false);
        actualizar.setEnabled(false);

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT * FROM USUARIOS WHERE USERNAME='" + ID + "'");

            ResultSet set = psp.executeQuery();
            if (set.next()) {
                info.setText("Información del Usuario " + set.getString("NOMBRE_USUARIO"));
                setTitle("Información del Usuario " + set.getString("NOMBRE_USUARIO") + " - Sesión de " + username);
                nombre.setText(set.getString("NOMBRE_USUARIO"));
                correo.setText(set.getString("EMAIL"));
                telefono.setText(set.getString("TELEFONO"));
                permisos.setSelectedItem(set.getString("TIPO_NIVEL"));
                usuario.setText(set.getString("USERNAME"));
                estado.setSelectedItem(set.getString("ESTATUS"));
                registro.setText(set.getString("REGISTRADO_POR"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL CARGAR!!, contacte al administrador", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error al crear usuario: " + e.getLocalizedMessage());
        }
    }

    public Icon icono(String camino, int a, int o) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(camino))
                .getImage().getScaledInstance(a, o, Image.SCALE_DEFAULT));

        return imagen;
    }

    public void habilitarBtn() {
        String name = nombre.getText().trim();
        String email = correo.getText().trim();
        String phone = telefono.getText().trim();
        String shiguri = usuario.getText().trim();

        if (name.isEmpty() | email.isEmpty() | phone.isEmpty() | shiguri.isEmpty()) {
            actualizar.setEnabled(false);
        } else {
            actualizar.setEnabled(true);
        }
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        info = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        borrar_nombre = new javax.swing.JCheckBox();
        nombre = new javax.swing.JTextField();
        borrar_correo = new javax.swing.JCheckBox();
        correo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        borrar_telefono = new javax.swing.JCheckBox();
        telefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        permisos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        borrar_usuario = new javax.swing.JCheckBox();
        usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        registro = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        info.setForeground(new java.awt.Color(153, 255, 255));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Información del Usuario");
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        borrar_nombre.setBackground(new java.awt.Color(153, 153, 153));
        borrar_nombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 110, 30, 30));

        nombre.setBackground(new java.awt.Color(153, 153, 153));
        nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, 30));

        borrar_correo.setBackground(new java.awt.Color(153, 153, 153));
        borrar_correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_correoActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 170, 30, 30));

        correo.setBackground(new java.awt.Color(153, 153, 153));
        correo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoKeyReleased(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 180, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Correo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Teléfono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 20));

        borrar_telefono.setBackground(new java.awt.Color(153, 153, 153));
        borrar_telefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 230, 30, 30));

        telefono.setBackground(new java.awt.Color(153, 153, 153));
        telefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 180, 30));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Permisos de:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 20));

        permisos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        permisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        permisos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        permisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permisosActionPerformed(evt);
            }
        });
        getContentPane().add(permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 25));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, 20));

        borrar_usuario.setBackground(new java.awt.Color(153, 153, 153));
        borrar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 110, 30, 30));

        usuario.setBackground(new java.awt.Color(153, 153, 153));
        usuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 180, 30));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setText("Estado:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, 20));

        estado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        estado.setToolTipText("");
        estado.setAutoscrolls(true);
        estado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        estado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 25));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("Modificado por última vez:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, 20));

        registro.setBackground(new java.awt.Color(153, 153, 153));
        registro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        registro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        registro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registro.setEnabled(false);
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        getContentPane().add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 180, 30));

        actualizar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        actualizar.setText("Actualizar Usuario");
        actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 180, 25));

        jButton1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jButton1.setText("Restaurar Contraseña");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 180, 25));

        eliminar.setBackground(new java.awt.Color(255, 0, 51));
        eliminar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        eliminar.setText("Eliminar Usuario");
        eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 180, 25));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        String name = nombre.getText();
        if (name.isEmpty()) {
            borrar_nombre.setVisible(false);
        } else {
            borrar_nombre.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_nombreKeyReleased

    private void borrar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_nombreActionPerformed
        nombre.setText("");
        borrar_nombre.setVisible(false);
        actualizar.setEnabled(false);
    }//GEN-LAST:event_borrar_nombreActionPerformed

    private void borrar_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_correoActionPerformed
        correo.setText("");
        borrar_correo.setVisible(false);
        actualizar.setEnabled(false);
    }//GEN-LAST:event_borrar_correoActionPerformed

    private void correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyReleased
        String mail = correo.getText();
        if (mail.isEmpty()) {
            borrar_correo.setVisible(false);
        } else {
            borrar_correo.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_correoKeyReleased

    private void borrar_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_telefonoActionPerformed
        telefono.setText("");
        borrar_telefono.setVisible(false);
        actualizar.setEnabled(false);
    }//GEN-LAST:event_borrar_telefonoActionPerformed

    private void telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyReleased
        String phone = telefono.getText();
        if (phone.isEmpty()) {
            borrar_telefono.setVisible(false);
        } else {
            borrar_telefono.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_telefonoKeyReleased

    private void permisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permisosActionPerformed
        actualizar.setEnabled(true);
    }//GEN-LAST:event_permisosActionPerformed

    private void borrar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_usuarioActionPerformed
        usuario.setText("");
        borrar_usuario.setVisible(false);
        actualizar.setEnabled(false);
    }//GEN-LAST:event_borrar_usuarioActionPerformed

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        String username2 = usuario.getText();
        if (username2.isEmpty()) {
            borrar_usuario.setVisible(false);
        } else {
            borrar_usuario.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_usuarioKeyReleased

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        actualizar.setEnabled(true);
    }//GEN-LAST:event_estadoActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        String name = nombre.getText().trim();
        String mail = correo.getText().trim();
        String phone = telefono.getText().trim();
        String username2 = usuario.getText().trim();
        String permiso = permisos.getSelectedItem().toString();
        String estatus = estado.getSelectedItem().toString();
        try {
            Connection cnn1 = DriverManager.getConnection(url, user, password);
            PreparedStatement psp1 = cnn1.prepareStatement("SELECT USERNAME FROM USUARIOS WHERE USERNAME='" + username2 + "' AND NOT ID_USUARIO=" + megumin);

            ResultSet set = psp1.executeQuery();
            if (set.next()) {
                usuario.setBackground(Color.red);

                JOptionPane.showMessageDialog(null, "Este usuario ya existe, wey");

                System.out.println();
            } else {
                String[] op = {"Si", "No"};
                int hitori = JOptionPane.showOptionDialog(null, "¿Deseas actualizar los datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 30, 30), op, op[0]);
                if (hitori == JOptionPane.YES_OPTION) {
                    try {
                        Connection cnn2 = DriverManager.getConnection(url, user, password);
                        PreparedStatement psp = cnn2.prepareStatement("UPDATE USUARIOS SET NOMBRE_USUARIO=?, EMAIL=?, TELEFONO=?, USERNAME=?,"
                                + " TIPO_NIVEL=?, ESTATUS=?, REGISTRADO_POR=? WHERE ID_USUARIO=" + megumin);

                        psp.setString(1, name);
                        psp.setString(2, mail);
                        psp.setString(3, phone);
                        psp.setString(4, username2);
                        psp.setString(5, permiso);
                        psp.setString(6, estatus);
                        psp.setString(7, username);

                        psp.executeUpdate();
                        Clean();
                        cnn2.close();
                        JOptionPane.showMessageDialog(null, "¡Modificación exitosa!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (SQLException s) {
                        JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo actualizar los datos, ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println("Error: " + s.getLocalizedMessage());
                    }
                }
            }
            cnn1.close();
        } catch (HeadlessException | SQLException s) {
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, ¡No se puede mostrar información!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
        Gestor_Usuarios.Actualizar();
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cambiar_contra zero_two = new Cambiar_contra();
        zero_two.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        int llave = evt.getKeyChar();

        if (!(llave >= 48 & llave <= 57)) {
            evt.consume();
        }

        if(telefono.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String[] op={"Si", "No"};
        int sayaka = JOptionPane.showOptionDialog(null, "¿Deseas eliminar este usuario?", "Advertencia", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.YES_NO_OPTION, icono("/imagenes/eliminar.png", 30, 30), op, op[0]);
        if (sayaka == JOptionPane.YES_OPTION){
            try {
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("DELETE FROM USUARIOS WHERE ID_USUARIO=" + megumin);

                psp.executeUpdate();
                cnn.close();

                nombre.setText("");
                nombre.setBackground(Color.orange);
                correo.setText("");
                correo.setBackground(Color.orange);
                telefono.setText("");
                telefono.setBackground(Color.orange);
                usuario.setText("");
                usuario.setBackground(Color.orange);
                registro.setText("");
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                dispose();
            } catch (HeadlessException | SQLException s) {
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo eliminar el usuario", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                System.err.println("Error: " + s.getLocalizedMessage());
            }
            Gestor_Usuarios.Actualizar();
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
            java.util.logging.Logger.getLogger(Info_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Info_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton actualizar;
    public javax.swing.JCheckBox borrar_correo;
    public javax.swing.JCheckBox borrar_nombre;
    public javax.swing.JCheckBox borrar_telefono;
    public javax.swing.JCheckBox borrar_usuario;
    public javax.swing.JTextField correo;
    public static javax.swing.JButton eliminar;
    public javax.swing.JComboBox<String> estado;
    public static javax.swing.JLabel info;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField nombre;
    public javax.swing.JComboBox<String> permisos;
    public javax.swing.JTextField registro;
    public javax.swing.JTextField telefono;
    public javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

    public void Clean() {
        nombre.setText("");
        nombre.setBackground(Color.green);
        correo.setText("");
        correo.setBackground(Color.green);
        telefono.setText("");
        telefono.setBackground(Color.green);
        usuario.setText("");
        usuario.setBackground(Color.green);
    }
}
