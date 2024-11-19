package proyectos;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author sebas
 */
public class Cambiar_contra extends javax.swing.JFrame {

    /**
     * Creates new form Cambiar_contra
     */
    String usuario="", user_update="";
    int sesion;
    char neta; 
    String url="jdbc:mysql://localhost/bd_ds";
    String user="root";
    String password="";
    public Cambiar_contra(){
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());        
        user_update=Gestor_Usuarios.dato;
        sesion=Info_Usuarios.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        setTitle("Cambiar contraseña de "+user_update);
        setBounds(0, 0, 530, 380);
        setResizable(false);
        setLocationRelativeTo(null);
        
        mostrar.setVisible(false);
        mostrar2.setVisible(false);
        mostrar3.setVisible(false);
        jButton1.setEnabled(false);
        
    }
    
    public Icon icono(String way, int a, int o){
        Icon imagen=new ImageIcon(new ImageIcon(getClass().getResource(way))
        .getImage().getScaledInstance(a, o, Image.SCALE_DEFAULT));
        
        return imagen;
    }
    
    public void habilitarBtn(){
        String natsuki=contra.getText().trim();
        String hayasaka=confirmar.getText().trim();
        String ubel=nuevo.getText().trim();
        
        if(natsuki.isEmpty() | hayasaka.isEmpty() | ubel.isEmpty()){
            jButton1.setEnabled(false);
        }else{
            jButton1.setEnabled(true);
        }
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es siempre
     * regenerado por el editor de formularios.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mostrar = new javax.swing.JCheckBox();
        contra = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        mostrar2 = new javax.swing.JCheckBox();
        confirmar = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        mostrar3 = new javax.swing.JCheckBox();
        nuevo = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cambiar Contraseña");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 280, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña Actual:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 260, 20));

        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, 25));

        contra.setBackground(new java.awt.Color(204, 204, 204));
        contra.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        contra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contraKeyReleased(evt);
            }
        });
        getContentPane().add(contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 260, 25));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nueva Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 260, 20));

        mostrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        mostrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar2ActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, 25));

        confirmar.setBackground(new java.awt.Color(204, 204, 204));
        confirmar.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        confirmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        confirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmarKeyReleased(evt);
            }
        });
        getContentPane().add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 260, 25));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Confirmar Contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 260, 20));

        mostrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        mostrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar3ActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, 25));

        nuevo.setBackground(new java.awt.Color(204, 204, 204));
        nuevo.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        nuevo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nuevoKeyReleased(evt);
            }
        });
        getContentPane().add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 260, 25));

        jButton1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jButton1.setText("Cambiar Contraseña");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 160, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        if(mostrar.isSelected()){
            ImageIcon imagen=new ImageIcon("src/imagenes/no mostrar.png");
            mostrar.setIcon(imagen);
            neta=contra.getEchoChar();
            contra.setEchoChar((char)0);
        }else{
            ImageIcon imagen=new ImageIcon("src/imagenes/mostrar.png");
            mostrar.setIcon(imagen);
            contra.setEchoChar(neta);
        }
    }//GEN-LAST:event_mostrarActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarActionPerformed

    private void mostrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar2ActionPerformed
        if(mostrar2.isSelected()){
            ImageIcon imagen=new ImageIcon("src/imagenes/no mostrar.png");
            mostrar2.setIcon(imagen);
            neta=confirmar.getEchoChar();
            confirmar.setEchoChar((char)0);
        }else{
            ImageIcon imagen=new ImageIcon("src/imagenes/mostrar.png");
            mostrar2.setIcon(imagen);
            confirmar.setEchoChar(neta);
        }
    }//GEN-LAST:event_mostrar2ActionPerformed

    private void mostrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar3ActionPerformed
        if(mostrar3.isSelected()){
            ImageIcon imagen=new ImageIcon("src/imagenes/no mostrar.png");
            mostrar3.setIcon(imagen);
            neta=nuevo.getEchoChar();
            nuevo.setEchoChar((char)0);
        }else{
            ImageIcon imagen=new ImageIcon("src/imagenes/mostrar.png");
            mostrar3.setIcon(imagen);
            nuevo.setEchoChar(neta);
        }
    }//GEN-LAST:event_mostrar3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String paz=contra.getText().trim();
        String contrasena=nuevo.getText().trim();
        String confirmacion=confirmar.getText().trim();
        if(contrasena.equals(confirmacion)){
            try{
                Connection cnn=DriverManager.getConnection(url, user, password);
                PreparedStatement psp=cnn.prepareStatement("SELECT PASSWORD FROM USUARIOS WHERE USERNAME='"+user_update+"'");
            
                ResultSet set=psp.executeQuery();
                if(set.next()){
                    if(paz.equals(set.getString("PASSWORD"))){
                        String[] op = {"Si", "No"};
                        int hitori = JOptionPane.showOptionDialog(null, "¿Deseas actualizar los datos?", "Advertencia", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, icono("/imagenes/warning.png", 30, 30), op, op[0]);
                        if (hitori == JOptionPane.YES_OPTION) {
                            try{
                                Connection cnn2=DriverManager.getConnection(url, user, password);
                                PreparedStatement psp2=cnn2.prepareStatement("UPDATE USUARIOS SET PASSWORD=? WHERE USERNAME='"+user_update+"'");
                        
                                psp2.setString(1, contrasena);
                            
                                psp2.executeUpdate();                            
                            
                                contra.setBackground(Color.green);
                                confirmar.setBackground(Color.green);
                                nuevo.setBackground(Color.green);
                                contra.setText("");
                                confirmar.setText("");
                                nuevo.setText("");
                                cnn2.close();
                            
                                JOptionPane.showMessageDialog(null, "¡Contraseña cambiada exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                            
                            
                                this.dispose();
                            }catch(SQLException s){
                                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo actualizar la contraseña", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                                                                        
                                System.err.println("Error: "+s.getLocalizedMessage());
                            }
                        }
                    }else{
                        contra.setBackground(Color.red);
                        JOptionPane.showMessageDialog(null, "¡La contraseña es incorrecta!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        contra.setText("");
                        jButton1.setEnabled(false);
                    }
                }
                cnn.close();
            }catch(HeadlessException | SQLException s){
                JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo localizar la contraseña", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: "+s.getLocalizedMessage());
            }
        }else{
            nuevo.setBackground(Color.red);
            confirmar.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "¡Las contraseñas no coinciden!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            nuevo.setText("");
            confirmar.setText("");
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void contraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraKeyReleased
        String password=contra.getText().trim();
        if(password.isEmpty()){
            mostrar.setVisible(false);
        }else{
            mostrar.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_contraKeyReleased

    private void confirmarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarKeyReleased
        String confirm=confirmar.getText().trim();
        if(confirm.isEmpty()){
            mostrar2.setVisible(false);
        }else{
            mostrar2.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_confirmarKeyReleased

    private void nuevoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoKeyReleased
        String nuevo_password=nuevo.getText().trim();
        if(nuevo_password.isEmpty()){
            mostrar3.setVisible(false);
        }else{
            mostrar3.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_nuevoKeyReleased

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
            java.util.logging.Logger.getLogger(Cambiar_contra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambiar_contra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambiar_contra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambiar_contra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cambiar_contra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmar;
    private javax.swing.JPasswordField contra;
    public static javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JCheckBox mostrar;
    private javax.swing.JCheckBox mostrar2;
    private javax.swing.JCheckBox mostrar3;
    private javax.swing.JPasswordField nuevo;
    // End of variables declaration//GEN-END:variables
}
