package proyectos;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Registro_Clientes extends javax.swing.JFrame {

    public static String usuario="";
    String url="jdbc:mysql://localhost/bd_ds";
    String user="root";
    String password="";
    public Registro_Clientes() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        usuario=Login.user;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Registra un nuevo cliente - Sesión de "+usuario);
        setBounds(0, 0, 530, 380);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        registrar.setEnabled(false);
        borrar_nom.setVisible(false);
        borrar_correo.setVisible(false);
        borrar_telefono.setVisible(false);
        borrar_direccion.setVisible(false);
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es siempre
     * regenerado por el editor de formularios.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrar_nom = new javax.swing.JCheckBox();
        registrar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        borrar_correo = new javax.swing.JCheckBox();
        correo = new javax.swing.JTextField();
        borrar_telefono = new javax.swing.JCheckBox();
        telefono = new javax.swing.JTextField();
        borrar_direccion = new javax.swing.JCheckBox();
        dir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borrar_nom.setBackground(new java.awt.Color(204, 204, 204));
        borrar_nom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_nomActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 70, 30, 30));

        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        registrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        getContentPane().add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 100, 100));

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 170, 30));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        borrar_correo.setBackground(new java.awt.Color(204, 204, 204));
        borrar_correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_correoActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 130, 30, 30));

        correo.setBackground(new java.awt.Color(204, 204, 204));
        correo.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        correo.setForeground(new java.awt.Color(0, 0, 0));
        correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoKeyReleased(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 30));

        borrar_telefono.setBackground(new java.awt.Color(204, 204, 204));
        borrar_telefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 190, 30, 30));

        telefono.setBackground(new java.awt.Color(204, 204, 204));
        telefono.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(0, 0, 0));
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
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 30));

        borrar_direccion.setBackground(new java.awt.Color(204, 204, 204));
        borrar_direccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 250, 30, 30));

        dir.setBackground(new java.awt.Color(204, 204, 204));
        dir.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        dir.setForeground(new java.awt.Color(0, 0, 0));
        dir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dirKeyReleased(evt);
            }
        });
        getContentPane().add(dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 170, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Correo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Teléfono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registrar Cliente");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 120, 25));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void habilitarBtn(){
        String nata=nombre.getText().trim();
        String gabito=correo.getText().trim();
        String peso=telefono.getText().trim();
        String frontera=dir.getText().trim();
        
        if(nata.isEmpty() | gabito.isEmpty() 
            | peso.isEmpty() | frontera.isEmpty()){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
        }
    }
    
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        String name=nombre.getText().trim();
        String email=correo.getText().trim();
        String phone=telefono.getText().trim();
        String direction=dir.getText().trim();
        try{
            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("INSERT INTO CLIENTES VALUES (?,?,?,?,?,?)");
            
            psp.setInt(1, 0);
            psp.setString(2, name);
            psp.setString(3, email);
            psp.setString(4, phone);
            psp.setString(5, direction);
            psp.setString(6, usuario);
            
            psp.executeUpdate();
            cnn.close();
            
            Limpiar();
                        
            JOptionPane.showMessageDialog(null, "¡Registro exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);            
            
            dispose();
        }catch(HeadlessException | SQLException s){
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo registrar el cliente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
            System.err.println("Error: "+s.getLocalizedMessage());
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        String asuna=nombre.getText();
        if(asuna.isEmpty()){
            borrar_nom.setVisible(false);
        }else{
            borrar_nom.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_nombreKeyReleased

    private void borrar_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_nomActionPerformed
        nombre.setText("");
        borrar_nom.setVisible(false);
        registrar.setEnabled(false);
    }//GEN-LAST:event_borrar_nomActionPerformed

    private void correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyReleased
        String suguha=correo.getText();
        if(suguha.isEmpty()){
            borrar_correo.setVisible(false);
        }else{
            borrar_correo.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_correoKeyReleased

    private void borrar_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_correoActionPerformed
        correo.setText("");
        borrar_correo.setVisible(false);
        registrar.setEnabled(false);
    }//GEN-LAST:event_borrar_correoActionPerformed

    private void telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyReleased
        String alice=telefono.getText();
        if(alice.isEmpty()){
            borrar_telefono.setVisible(false);
        }else{
            borrar_telefono.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_telefonoKeyReleased

    private void borrar_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_telefonoActionPerformed
        telefono.setText("");
        borrar_telefono.setVisible(false);
        registrar.setEnabled(false);
    }//GEN-LAST:event_borrar_telefonoActionPerformed

    private void dirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dirKeyReleased
        String lizbeth=dir.getText();
        if(lizbeth.isEmpty()){
            borrar_direccion.setVisible(false);
        }else{
            borrar_direccion.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_dirKeyReleased

    private void borrar_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_direccionActionPerformed
        dir.setText("");
        borrar_direccion.setVisible(false);
        registrar.setEnabled(false);
    }//GEN-LAST:event_borrar_direccionActionPerformed

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        int llave=evt.getKeyChar();
            
        if(!(llave>=48 & llave<=57)){
            evt.consume();
        }
            
        if(telefono.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

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
            java.util.logging.Logger.getLogger(Registro_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borrar_correo;
    private javax.swing.JCheckBox borrar_direccion;
    private javax.swing.JCheckBox borrar_nom;
    private javax.swing.JCheckBox borrar_telefono;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField dir;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
    public void Limpiar(){
        borrar_nom.setVisible(false);
        borrar_correo.setVisible(false);
        borrar_telefono.setVisible(false);
        borrar_direccion.setVisible(false);
        nombre.setBackground(Color.GREEN);
        nombre.setText("");
        correo.setBackground(Color.GREEN);
        correo.setText("");
        telefono.setBackground(Color.GREEN);
        telefono.setText("");
        dir.setBackground(Color.GREEN);
        dir.setText("");
    }

}
