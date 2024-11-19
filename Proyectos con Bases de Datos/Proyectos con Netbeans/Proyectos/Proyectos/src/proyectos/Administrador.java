package proyectos;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author sebas
 */
public class Administrador extends javax.swing.JFrame {

    public static String yuza = "", nom = "";
    public static int sesion;

    String url = "jdbc:mysql://localhost/bd_ds";
    String user = "root";
    String password = "";

    public Administrador() {
        initComponents();
        yuza = Login.user;
        sesion = 1;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Administrador - sesion de " + yuza);
        setBounds(0, 0, 650, 430);
        setResizable(false);
        setLocationRelativeTo(null);

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT NOMBRE_USUARIO "
                    + "FROM USUARIOS WHERE USERNAME='" + yuza + "'");

            ResultSet set = psp.executeQuery();
            if (set.next()) {
                nom = set.getString("NOMBRE_USUARIO");
                nom_usuario.setText("Bienvenido " + nom);
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo localizar el nombre", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }

        logout.setFont(new Font("Andale Mono", 4, 13));

    }

    public Icon icono(String icon, int a, int o) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(icon))
                .getImage().getScaledInstance(a, o, Image.SCALE_DEFAULT));

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

        registro = new javax.swing.JButton();
        nom_usuario = new javax.swing.JLabel();
        gestor = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        usuarios = new javax.swing.JLabel();
        gestion = new javax.swing.JLabel();
        creatividad = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        capturista = new javax.swing.JLabel();
        tecnico = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addUser.png"))); // NOI18N
        registro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        getContentPane().add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, 100));

        nom_usuario.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        nom_usuario.setForeground(new java.awt.Color(153, 255, 255));
        nom_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nom_usuario.setText("Bienvenido");
        getContentPane().add(nom_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        gestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/informationuser.png"))); // NOI18N
        gestor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestorActionPerformed(evt);
            }
        });
        getContentPane().add(gestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 100, 100));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/creatividad.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 100, 100));

        usuarios.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        usuarios.setForeground(new java.awt.Color(153, 255, 255));
        usuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarios.setText("Registrar Usuarios");
        getContentPane().add(usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 165, 100, -1));

        gestion.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        gestion.setForeground(new java.awt.Color(153, 255, 255));
        gestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestion.setText("Gestión Usuarios");
        getContentPane().add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 165, 120, -1));

        creatividad.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        creatividad.setForeground(new java.awt.Color(153, 255, 255));
        creatividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creatividad.setText("Creatividad");
        getContentPane().add(creatividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 165, 100, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/capturista.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 100, 100));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tecnico.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 100, 100));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Propietario.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 100, 100));

        capturista.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        capturista.setForeground(new java.awt.Color(255, 255, 255));
        capturista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        capturista.setText("Panel del Capturista");
        getContentPane().add(capturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 130, -1));

        tecnico.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        tecnico.setForeground(new java.awt.Color(255, 255, 255));
        tecnico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tecnico.setText("Panel del Técnico");
        getContentPane().add(tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 325, 140, -1));

        from.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        from.setText("Acerca de");
        getContentPane().add(from, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 325, 100, -1));

        logout.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        logout.setText("Cerrar sesión");
        logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        Registro_Usuarios m = new Registro_Usuarios();
        m.setVisible(true);            
    }//GEN-LAST:event_registroActionPerformed

    private void gestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestorActionPerformed
        Gestor_Usuarios yord = new Gestor_Usuarios();
        yord.setVisible(true);
    }//GEN-LAST:event_gestorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "Este botón aún no esta programado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Capturista cmd = new Capturista();
        cmd.setVisible(true);
        Capturista.logout.setVisible(false);        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Tecnico tecn = new Tecnico();
        tecn.setVisible(true);
        tecn.logout.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Acerca_De sheele = new Acerca_De();
        sheele.setVisible(true);        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        String[] op = {"Si", "No"};
        int kaguya = JOptionPane.showOptionDialog(null, "¿Estás seguro de cerrar sesión?", "Mensaje", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 30, 30), op, op[0]);
        if (kaguya == JOptionPane.YES_OPTION) {
            dispose();
            Login megumin = new Login();
            megumin.setVisible(true);            
            JOptionPane.showMessageDialog(null, "Sesión finalizada exitosamente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel capturista;
    public static javax.swing.JLabel creatividad;
    public static javax.swing.JLabel from;
    public static javax.swing.JLabel gestion;
    private javax.swing.JButton gestor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JButton logout;
    public static javax.swing.JLabel nom_usuario;
    private javax.swing.JButton registro;
    public static javax.swing.JLabel tecnico;
    public static javax.swing.JLabel usuarios;
    // End of variables declaration//GEN-END:variables
}
