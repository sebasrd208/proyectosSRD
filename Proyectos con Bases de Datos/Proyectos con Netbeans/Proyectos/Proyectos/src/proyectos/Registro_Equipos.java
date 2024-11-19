package proyectos;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author sebas
 */
public class Registro_Equipos extends javax.swing.JFrame{

    String url="jdbc:mysql://localhost/bd_ds";
    String user="root";
    String password="";
    int IDcliente=0;
    String usuario="", cliente="";
    public Registro_Equipos(){
        initComponents();
        usuario=Login.user;
        cliente=Gestor_Clientes.cliente;
        IDcliente=Gestor_Clientes.user_update;            
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registra un nuevo equipo para "+cliente+" - Sesión de "+usuario);
        setResizable(false);
        setBounds(0, 0, 640, 445);
        setLocationRelativeTo(null);
        
        nom.setText(cliente);
        nom.setEditable(false);
        
        borrar_cliente.setVisible(false);
        borrar_modelo.setVisible(false);
        borrar_serie.setVisible(false);
        registro.setEnabled(false);
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es siempre
     * regenerado por el editor de formularios.
     */
    
    
    public void habilitarBtn(){
        String model=modelo.getText().trim();
        String series=serie.getText().trim();        
        
        if(model.isEmpty() | series.isEmpty()){
            registro.setEnabled(false);
        }else{
            registro.setEnabled(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextPane();
        borrar_cliente = new javax.swing.JCheckBox();
        nom = new javax.swing.JTextField();
        tipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        marca = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        borrar_modelo = new javax.swing.JCheckBox();
        modelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        borrar_serie = new javax.swing.JCheckBox();
        serie = new javax.swing.JTextField();
        registro = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Equipos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 300, -1));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Nombre del Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        observaciones.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        observaciones.setForeground(new java.awt.Color(0, 0, 0));
        observaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                observacionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 360, 240));

        borrar_cliente.setBackground(new java.awt.Color(204, 204, 204));
        borrar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_cliente.setRequestFocusEnabled(false);
        borrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 30, 30));

        nom.setBackground(new java.awt.Color(204, 204, 204));
        nom.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        nom.setForeground(new java.awt.Color(0, 0, 0));
        nom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomKeyReleased(evt);
            }
        });
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        tipo.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Computadora de Escritorio", "Impresora", "Multifuncional", "Smartphone" }));
        tipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 210, 25));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Tipo de Equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Marca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        marca.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Allenware", "Apple", "Asus", "Brother", "Dell", "HP", "Toshiba", "Hauwei", "Samsung", "Lenovo", "LG", "Vaio", "Xerox", "OPPO", "ZTE", "Motorola" }));
        marca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 210, 25));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Modelo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        borrar_modelo.setBackground(new java.awt.Color(204, 204, 204));
        borrar_modelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_modeloActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 30, 30));

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
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 210, 30));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setText("No. de Serie:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        borrar_serie.setBackground(new java.awt.Color(204, 204, 204));
        borrar_serie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        borrar_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_serieActionPerformed(evt);
            }
        });
        getContentPane().add(borrar_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 30, 30));

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
        getContentPane().add(serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 210, 30));

        registro.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        registro.setText("Registrar Equipo");
        registro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        getContentPane().add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 250, 25));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyReleased
        
    }//GEN-LAST:event_nomKeyReleased

    private void borrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_clienteActionPerformed
        nom.setText("");
        registro.setEnabled(false);
        borrar_cliente.setVisible(false);
    }//GEN-LAST:event_borrar_clienteActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoActionPerformed

    private void modeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeloKeyReleased
        String miku=modelo.getText();
        if(!miku.isEmpty()){
            borrar_modelo.setVisible(true);
        }else{
            borrar_modelo.setVisible(false);
        }
        habilitarBtn();
    }//GEN-LAST:event_modeloKeyReleased

    private void borrar_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_modeloActionPerformed
        modelo.setText("");
        registro.setEnabled(false);
        borrar_modelo.setVisible(false);
    }//GEN-LAST:event_borrar_modeloActionPerformed

    private void serieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serieKeyReleased
        String itsuki=serie.getText();
        if(!itsuki.isEmpty()){
            borrar_serie.setVisible(true);
        }else{
            borrar_serie.setVisible(false);
        }
        habilitarBtn();
    }//GEN-LAST:event_serieKeyReleased

    private void borrar_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_serieActionPerformed
        serie.setText("");
        registro.setEnabled(false);
        borrar_serie.setVisible(false);
    }//GEN-LAST:event_borrar_serieActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        Calendar calendario=Calendar.getInstance();
        String equipo=tipo.getSelectedItem().toString();       
        String mwam=marca.getSelectedItem().toString();
        String model=modelo.getText().trim();
        String number=serie.getText().trim();
        String dia=String.valueOf(calendario.get(Calendar.DATE));
        String mes=String.valueOf(calendario.get(Calendar.MONTH));
        String annio=String.valueOf(calendario.get(Calendar.YEAR));
        String itsuki=observaciones.getText().trim();
        if(itsuki.isEmpty()){
            observaciones.setText("Sin observaciones.");
        }
        
        try{
            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("INSERT INTO EQUIPOS VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            psp.setInt(1, 0);
            psp.setInt(2, IDcliente);
            psp.setString(3, equipo);
            psp.setString(4, mwam);
            psp.setString(5, model);
            psp.setString(6, number);
            psp.setString(7, dia);
            psp.setString(8, mes);
            psp.setString(9, annio);
            if(itsuki.isEmpty()){
                psp.setString(10, "Sin observaciones.");
            }else{
                psp.setString(10, itsuki);
            }
            psp.setString(11, "Nuevo ingreso");
            psp.setString(12, usuario);
            psp.setString(13, "");
            psp.setString(14, "");
            
            psp.executeUpdate();
            cnn.close();
            
            Limpiar();
            System.out.println("ID: "+Info_Clientes.equipo);
        
            JOptionPane.showMessageDialog(null, "¡Registro exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
            Info_Clientes.Actualizar();
            dispose();
        }catch(HeadlessException | SQLException s){            
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo registrar el equipo!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: "+s.getLocalizedMessage());
        }
    }//GEN-LAST:event_registroActionPerformed
    
    private void observacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observacionesKeyReleased
        
    }//GEN-LAST:event_observacionesKeyReleased

    private void serieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serieKeyTyped
        int llave=evt.getKeyChar();
        
        if(!(llave>=48 & llave<=57)){
            evt.consume();
        }
        
        if(serie.getText().trim().length()>=13){
            evt.consume();
        }
    }//GEN-LAST:event_serieKeyTyped

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
            java.util.logging.Logger.getLogger(Registro_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borrar_cliente;
    private javax.swing.JCheckBox borrar_modelo;
    private javax.swing.JCheckBox borrar_serie;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextField nom;
    private javax.swing.JTextPane observaciones;
    public static javax.swing.JButton registro;
    private javax.swing.JTextField serie;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
    public void Limpiar(){
        borrar_cliente.setVisible(false);
        borrar_modelo.setVisible(false);
        borrar_serie.setVisible(false);
        observaciones.setText("");
        modelo.setText("");
        modelo.setBackground(Color.green);
        serie.setText("");
        serie.setBackground(Color.green);
    }
}
