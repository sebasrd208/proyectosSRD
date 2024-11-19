package proyectos;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author sebas
 */
public class Registro_Usuarios extends javax.swing.JFrame {

    public static String us="";
    char rapthalia;
    int sesion;    
    public Registro_Usuarios(){
        initComponents();
        us=Login.user;
        sesion=Administrador.sesion;
        if(sesion==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }else{
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        setTitle("Registra un nuevo usuario - Sesión de "+us);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setResizable(false);
        setBounds(0, 0, 630, 385);
        setLocationRelativeTo(null);
        registrar.setEnabled(false);
        mostrar_contrasena.setVisible(false);
        mostrar_confirmacion.setVisible(false);
    }

    public void habilitarBtn(){
        String name=nombre.getText().trim();
        String email=correo.getText().trim();
        String telefono=phone.getText().trim();
        String usuario=user.getText().trim();
        String password=contrasena.getText().trim();
        String confirm=confirmar.getText().trim();
        
        if(name.isEmpty() | email.isEmpty()| telefono.isEmpty()| usuario.isEmpty()
            | password.isEmpty()| confirm.isEmpty()){
            registrar.setEnabled(false);
        }else{
            registrar.setEnabled(true);
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
        jLabel8 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lista = new javax.swing.JComboBox<>();
        user = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mostrar_contrasena = new javax.swing.JCheckBox();
        contrasena = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mostrar_confirmacion = new javax.swing.JCheckBox();
        confirmar = new javax.swing.JPasswordField();
        registrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 230, -1));

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 255));
        jLabel8.setText("Nombre:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        nombre.setBackground(new java.awt.Color(153, 255, 255));
        nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, 30));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Correo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        correo.setBackground(new java.awt.Color(153, 255, 255));
        correo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoKeyReleased(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 30));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        phone.setBackground(new java.awt.Color(153, 255, 255));
        phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneKeyTyped(evt);
            }
        });
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 220, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Permisos de:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        lista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admisnistrador", "Capturista", "Tecnico" }));
        lista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });
        getContentPane().add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, -1));

        user.setBackground(new java.awt.Color(153, 255, 255));
        user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userKeyReleased(evt);
            }
        });
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 220, 30));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, 20));

        mostrar_contrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        mostrar_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_contrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 30, 30));

        contrasena.setBackground(new java.awt.Color(153, 255, 255));
        contrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contrasena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contrasenaKeyReleased(evt);
            }
        });
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 220, 30));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, 20));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("Confirmar contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, 20));

        mostrar_confirmacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        mostrar_confirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_confirmacionActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar_confirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 30, 30));

        confirmar.setBackground(new java.awt.Color(153, 255, 255));
        confirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmarKeyReleased(evt);
            }
        });
        getContentPane().add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 220, 30));

        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addUser.png"))); // NOI18N
        registrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        getContentPane().add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 90, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_contrasenaActionPerformed
        if(mostrar_contrasena.isSelected()){
            ImageIcon imagen=new ImageIcon("src/imagenes/no mostrar.png");
            mostrar_contrasena.setIcon(imagen);
            rapthalia=contrasena.getEchoChar();
            contrasena.setEchoChar((char)0);
        }else{
            ImageIcon imagen=new ImageIcon("src/imagenes/mostrar.png");
            mostrar_contrasena.setIcon(imagen);
            contrasena.setEchoChar(rapthalia);

        }
    }//GEN-LAST:event_mostrar_contrasenaActionPerformed

    private void mostrar_confirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_confirmacionActionPerformed
        if(mostrar_confirmacion.isSelected()){
            ImageIcon imagen=new ImageIcon("src/imagenes/no mostrar.png");
            mostrar_confirmacion.setIcon(imagen);
            rapthalia=confirmar.getEchoChar();
            confirmar.setEchoChar((char)0);
        }else{
            ImageIcon imagen=new ImageIcon("src/imagenes/mostrar.png");
            mostrar_confirmacion.setIcon(imagen);
            confirmar.setEchoChar(rapthalia);
        }
    }//GEN-LAST:event_mostrar_confirmacionActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        String nom, mail, telefono, username, contra, confirm, permiso, selector;
        
        nom=nombre.getText().trim();
        mail=correo.getText().trim();
        telefono=phone.getText().trim();
        username=user.getText().trim();
        contra=contrasena.getText().trim();
        confirm=confirmar.getText().trim();
        permiso=lista.getSelectedItem().toString();
            
        if(!contra.equals(confirm)){
            confirmar.setBackground(Color.red);
            contrasena.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Las contraseñas no coninciden");
            confirmar.setText("");
            contrasena.setText("");
        }else{
            try{
                Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                PreparedStatement psp=cnn.prepareStatement(
                    "select username from usuarios where username='"+username+"'");

                ResultSet itona=psp.executeQuery();

                if(itona.next()){
                    user.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Este usuario ya existe, wey", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    cnn.close();
                }else{
                    cnn.close();
                    try{
                        Connection cnn2=DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
                        PreparedStatement ps=cnn2.prepareStatement("insert into usuarios values (?,?,?,?,?,?,?,?,?)");

                        ps.setInt(1, 0);
                        ps.setString(2, nom);
                        ps.setString(3, mail);
                        ps.setString(4, telefono);
                        ps.setString(5, username);
                        ps.setString(6, contra);
                        ps.setString(7, permiso);
                        ps.setString(8, "Activo");
                        ps.setString(9, us);
                        
                        ps.executeUpdate();
                        cnn2.close();

                        Limpiar();

                        nombre.setBackground(Color.green);
                        correo.setBackground(Color.green);
                        phone.setBackground(Color.green);
                        user.setBackground(Color.green);
                        contrasena.setBackground(Color.green);
                        confirmar.setBackground(Color.green);

                        JOptionPane.showMessageDialog(null, "¡Registro exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                        
                        
                        this.dispose();

                    }catch(SQLException e){
                        System.err.println("Error al registrar usuario "+e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, CONECTATE AL SERVIDOR");
                    }
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("Error al validar nombre de usuario: "+e);
                JOptionPane.showMessageDialog(null, "¡¡Error al comparar usuarios!!"); 
            }
        }   
    }//GEN-LAST:event_registrarActionPerformed

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        habilitarBtn();        
    }//GEN-LAST:event_nombreKeyReleased

    private void correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyReleased
        habilitarBtn();        
    }//GEN-LAST:event_correoKeyReleased

    private void phoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyReleased
        habilitarBtn();
    }//GEN-LAST:event_phoneKeyReleased

    private void userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyReleased
        habilitarBtn();
    }//GEN-LAST:event_userKeyReleased

    private void contrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contrasenaKeyReleased
        String alya=contrasena.getText().trim();
        if(alya.isEmpty()){
            mostrar_contrasena.setVisible(false);
        }else{
            mostrar_contrasena.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_contrasenaKeyReleased

    private void confirmarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarKeyReleased
        String yuki=confirmar.getText().trim();
        if(yuki.isEmpty()){
            mostrar_confirmacion.setVisible(false);
        }else{
            mostrar_confirmacion.setVisible(true);
        }
        habilitarBtn();
    }//GEN-LAST:event_confirmarKeyReleased

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyTyped
        int llave=evt.getKeyChar();
            
        if(!(llave>=48 & llave<=57)){
            evt.consume();
        }
            
        if(phone.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_phoneKeyTyped

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed

    }//GEN-LAST:event_listaActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmar;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JTextField correo;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> lista;
    private javax.swing.JCheckBox mostrar_confirmacion;
    private javax.swing.JCheckBox mostrar_contrasena;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField phone;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
    public void Limpiar(){
        nombre.setText("");
        correo.setText("");
        phone.setText("");
        user.setText("");
        contrasena.setText("");
        confirmar.setText("");
    }
}
