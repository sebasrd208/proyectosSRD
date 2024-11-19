package proyectos;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author sebas
 */
public class Acerca_De extends javax.swing.JFrame {

    public static String user, nom;
    int sesion;
    public Acerca_De() {
        initComponents();
        user=Login.user;
        sesion=Administrador.sesion;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del desarrollador - Sesión de "+user);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es siempre
     * regenerado por el editor de formularios.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        pasatiempos = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        lugar = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        edad = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("DESARROLLADO POR SEBASTIAN RAMIRO DIAZ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 480, 20));

        pasatiempos.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        pasatiempos.setForeground(new java.awt.Color(153, 255, 255));
        pasatiempos.setText("Pasatiempos: Ejercicio, ver anime, escuchar corridos y banda");
        getContentPane().add(pasatiempos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 490, 20));

        estado.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        estado.setForeground(new java.awt.Color(153, 255, 255));
        estado.setText("Estado: Soltero y sin compromiso");
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, 20));

        lugar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lugar.setForeground(new java.awt.Color(153, 255, 255));
        lugar.setText("Lugar de Nacimiento: Hospital San Pedro, Zacapoaxtla, Puebla, México");
        getContentPane().add(lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 480, 20));

        fecha.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(153, 255, 255));
        fecha.setText("Fecha de Nacimiento: 24-Enero-1999");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 360, 20));

        edad.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        edad.setForeground(new java.awt.Color(153, 255, 255));
        edad.setText("Edad: 25 años");
        getContentPane().add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Acerca_De.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acerca_De.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acerca_De.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acerca_De.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acerca_De().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel edad;
    public static javax.swing.JLabel estado;
    public static javax.swing.JLabel fecha;
    private javax.swing.JLabel fondo;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel lugar;
    public static javax.swing.JLabel pasatiempos;
    // End of variables declaration//GEN-END:variables
}
