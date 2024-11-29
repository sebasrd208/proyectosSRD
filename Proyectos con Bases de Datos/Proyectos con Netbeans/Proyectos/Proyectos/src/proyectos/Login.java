package proyectos;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Login extends javax.swing.JFrame{

    public static String user = "";
    String pass = "";
    char pequeño;
    int tiempo = 0;

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Acceso al sistema");
        setSize(400, 580);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon wallpaper=new ImageIcon("src/imagenes/fondo.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(fondo.getWidth(),
        fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        this.repaint();
        
        ImageIcon bd=new ImageIcon("src/imagenes/DS.png");
        Icon icono2=new ImageIcon(bd.getImage().getScaledInstance(logo.getWidth(),
        logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(icono2);
        this.repaint();
                
        jButton1.setEnabled(false);
        borrar.setVisible(false);
        mostrar.setVisible(false);

        usuario.setFont(new Font("Andale mono", 4, 15));
        contrasena.setFont(new Font("Andale mono", 4, 15));
    }

    public void habilitarBtn() {
        String thoru = usuario.getText().trim();
        String kanna = contrasena.getText().trim();
        if (thoru.isEmpty() | kanna.isEmpty()) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
//        //sebasrd_208, SDK24991
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrar = new javax.swing.JCheckBox();
        logo = new javax.swing.JLabel();
        us = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        con = new javax.swing.JLabel();
        mostrar = new javax.swing.JCheckBox();
        contrasena = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borrar.setBackground(new java.awt.Color(153, 255, 255));
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        getContentPane().add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 353, 30, -1));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 240, 240));

        us.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        us.setForeground(new java.awt.Color(0, 0, 0));
        us.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        us.setText("Usuario:");
        getContentPane().add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 90, 25));

        usuario.setBackground(new java.awt.Color(153, 255, 255));
        usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario.setActionCommand("<Not Set>");
        usuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 230, 30));

        con.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        con.setForeground(new java.awt.Color(0, 0, 0));
        con.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        con.setText("Contraseña:");
        getContentPane().add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 120, 25));

        mostrar.setContentAreaFilled(false);
        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });
        mostrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mostrarKeyReleased(evt);
            }
        });
        getContentPane().add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 30, 30));

        contrasena.setBackground(new java.awt.Color(153, 255, 255));
        contrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contrasena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contrasenaKeyReleased(evt);
            }
        });
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 230, 30));

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton1.setText("Acceder");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 100, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed

    }//GEN-LAST:event_usuarioActionPerformed

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        String anya = usuario.getText().trim();
        if (anya.isEmpty()) {
            borrar.setVisible(false);
        } else {
            borrar.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_usuarioKeyReleased

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        usuario.setText("");
        contrasena.setText("");
        mostrar.setVisible(false);
        borrar.setVisible(false);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_borrarActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        if (mostrar.isSelected()) {
            ImageIcon imagen = new ImageIcon("src/imagenes/no mostrar.png");
            pequeño = contrasena.getEchoChar();
            mostrar.setIcon(imagen);
            contrasena.setEchoChar((char) 0);
        } else {
            ImageIcon imagen2 = new ImageIcon("src/imagenes/mostrar.png");
            mostrar.setIcon(imagen2);
            contrasena.setEchoChar(pequeño);
        }
    }//GEN-LAST:event_mostrarActionPerformed

    private void mostrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mostrarKeyReleased

    }//GEN-LAST:event_mostrarKeyReleased

    private void contrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contrasenaKeyReleased
        String akane = contrasena.getText().trim();
        if (akane.isEmpty()) {
            mostrar.setVisible(false);
        } else {
            mostrar.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_contrasenaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        user = usuario.getText().trim();
        pass = contrasena.getText().trim();
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            PreparedStatement psp = cnn.prepareStatement("select tipo_nivel, estatus, username, password from usuarios where username='"
                    + user + "' and password='" + pass + "'");

            ResultSet set = psp.executeQuery();
            if (set.next()) {
                String tipo = set.getString("tipo_nivel");
                String estado = set.getString("estatus");
                if (user.equalsIgnoreCase(set.getString("username")) & pass.equals(set.getString("password"))) {
                    if (tipo.equalsIgnoreCase("Administrador") & estado.equalsIgnoreCase("Activo")) {
                        Administrador ad = new Administrador();
                        ad.setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Iniciaste sesión exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tipo.equalsIgnoreCase("Tecnico") & estado.equalsIgnoreCase("Activo")) {
                        Tecnico tecnico = new Tecnico();
                        tecnico.setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Iniciaste sesión exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tipo.equalsIgnoreCase("Capturista") & estado.equalsIgnoreCase("Activo")) {
                        Capturista capturista = new Capturista();
                        capturista.setVisible(true);
                        dispose();//nagisa_909, NGS28991
                        JOptionPane.showMessageDialog(null, "Iniciaste sesión exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (tiempo == 5){
                    JOptionPane.showMessageDialog(null, "Superaste la cantidad de intentos, inténtalo más tarde");
                    usuario.setText("");
                    contrasena.setText("");
                    mostrar.setVisible(false);
                    borrar.setVisible(false);
                    jButton1.setEnabled(false);
                    System.exit(0);
                } else {
                    if (tiempo == 4) {
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos"
                                + "\nTe quedan 1 intento");
                        usuario.setText("");
                        contrasena.setText("");
                        mostrar.setVisible(false);
                        borrar.setVisible(false);
                        jButton1.setEnabled(false);
                        tiempo += 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos"
                                + "\nTe quedan " + (5 - tiempo) + " intentos");
                        usuario.setText("");
                        contrasena.setText("");
                        mostrar.setVisible(false);
                        borrar.setVisible(false);
                        jButton1.setEnabled(false);
                        tiempo += 1;
                        //tiempo=tiempo+1;
                    }
                }
            } else if (tiempo == 5) {

                JOptionPane.showMessageDialog(null, "Superaste la cantidad de intentos, inténtalo más tarde");
                usuario.setText("");
                contrasena.setText("");
                mostrar.setVisible(false);
                borrar.setVisible(false);
                jButton1.setEnabled(false);
                System.exit(0);

            } else {

                if (tiempo == 4) {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos"
                            + "\nTe quedan 1 intento");
                    usuario.setText("");
                    contrasena.setText("");
                    mostrar.setVisible(false);
                    borrar.setVisible(false);
                    jButton1.setEnabled(false);
                    tiempo += 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos"
                            + "\nTe quedan " + (5 - tiempo) + " intentos");
                    usuario.setText("");
                    contrasena.setText("");
                    mostrar.setVisible(false);
                    borrar.setVisible(false);
                    jButton1.setEnabled(false);
                    tiempo += 1;
                    //tiempo=tiempo+1;
                }

            }
        } catch (SQLException s) {
            System.err.println("Error al iniciar sesion: " + s);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borrar;
    public static javax.swing.JLabel con;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JLabel fondo;
    public static javax.swing.JButton jButton1;
    private javax.swing.JLabel logo;
    private javax.swing.JCheckBox mostrar;
    public static javax.swing.JLabel us;
    public static javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
