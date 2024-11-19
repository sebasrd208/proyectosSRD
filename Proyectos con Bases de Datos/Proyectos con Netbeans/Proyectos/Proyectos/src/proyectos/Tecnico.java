package proyectos;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

/**
 *
 * @author sebas
 */
public class Tecnico extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost/bd_ds";
    String user = "root";
    String password = "";
    public static String username, nom = "";
    int sesion;

    public Tecnico() {
        initComponents();
        username = Login.user;
        sesion = Administrador.sesion;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        if (sesion == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT NOMBRE_USUARIO "
                    + "FROM USUARIOS WHERE USERNAME='" + username + "'");

            ResultSet set = psp.executeQuery();
            if (set.next()) {
                nom = set.getString("NOMBRE_USUARIO");
                jLabel4.setText("Bienvenido " + nom);
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo localizar el nombre", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
        setTitle("Técnico - Sesión de " + username);
        setBounds(0, 0, 540, 320);
        setResizable(false);
        setLocationRelativeTo(null);

        logout.setFont(new Font("Andale mono", 4, 12));
    }

    public Icon icono(String way, int a, int o) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(way))
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

        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apoyo-tecnico.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 100, 100));

        jButton1.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grafica.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, 100));

        jButton2.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grafica.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 100, 100));

        logout.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        logout.setText("Cerrar Sesión");
        logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 100, 25));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion Equipos");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, 150, 20));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grafica de Estados");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 195, 140, 20));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Grafica de Marcas");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 195, 140, 20));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Bienvenido ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jLabel5.setAutoscrolls(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Gestor_Equipos gestor = new Gestor_Equipos();
        gestor.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Grafica_Status miku = new Grafica_Status();
        miku.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Grafica_Marcas nino = new Grafica_Marcas();
        nino.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        String[] op = {"Si", "No"};
        long kaguya = JOptionPane.showOptionDialog(null, "¿Estás seguro de cerrar sesión?", "Advertencia", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 30, 30), op, op[0]);
        if (kaguya == JOptionPane.YES_OPTION) {
            dispose();
            Login megumin = new Login();
            megumin.setVisible(true);
            megumin.con.setText("Contraseña:");
            megumin.con.setFont(new Font("Sylfaen", Font.BOLD, 15));
            megumin.us.setText("Usuario:");
            megumin.us.setFont(new Font("Sylfaen", Font.BOLD, 15));
            megumin.jButton1.setText("Acceder");
            megumin.jButton1.setFont(new Font("Sylfaen", Font.BOLD, 18));
            megumin.setTitle("Acceso al Sistema");
            JOptionPane.showMessageDialog(null, "Cerraste Sesión");
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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
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
