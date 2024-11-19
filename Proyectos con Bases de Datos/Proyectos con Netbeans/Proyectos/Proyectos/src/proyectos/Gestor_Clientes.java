package proyectos;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

/**
 *
 * @author sebas
 */
public class Gestor_Clientes extends javax.swing.JFrame {

    public static String usuario = "", cliente = "";
    public static int user_update = 0;
    public static DefaultTableModel modulo = new DefaultTableModel();
    static String url = "jdbc:mysql://localhost/bd_ds";
    static String user = "root";
    static String password = "";
    public static int ID = 0;

    public Gestor_Clientes() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        usuario = Login.user;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Clientes registrados - Sesión de " + usuario);
        setBounds(0, 0, 640, 370);
        setLocationRelativeTo(null);
        setResizable(false);

        modulo.setRowCount(0);
        modulo.setColumnCount(0);
        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT ID_CLIENTE, NOMBRE_CLIENTE, MAIL_CLIENTE, TEL_CLIENTE, ULTIMA_MODIFICACION FROM CLIENTES");

            ResultSet set = psp.executeQuery();

            tabla_usuarios = new JTable(modulo);
            Scroll.setViewportView(tabla_usuarios);

            modulo.addColumn("");
            modulo.addColumn("Nombre");
            modulo.addColumn("Correo");
            modulo.addColumn("Telefono");
            modulo.addColumn("Modificado por");

            while (set.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = set.getObject(i + 1);
                }
                modulo.addRow(fila);
            }
            cnn.close();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo llenar la tabla",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
    

        tabla_usuarios.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent s){
                int fila=tabla_usuarios.rowAtPoint(s.getPoint());
                int columna=0;
                
                if(fila>-1){
                    ID=(int)modulo.getValueAt(fila, columna);
                    Info_Clientes info=new Info_Clientes();
                    info.setVisible(true);
                }
            }
        });

    }
   
    public static void Actualizar(){
        modulo.setRowCount(0);
        modulo.setColumnCount(0);
        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            PreparedStatement psp = cnn.prepareStatement("SELECT ID_CLIENTE, NOMBRE_CLIENTE, MAIL_CLIENTE, TEL_CLIENTE, ULTIMA_MODIFICACION FROM CLIENTES");

            ResultSet set = psp.executeQuery();

            tabla_usuarios = new JTable(modulo);
            Scroll.setViewportView(tabla_usuarios);

            modulo.addColumn("");
            modulo.addColumn("Nombre");
            modulo.addColumn("Correo");
            modulo.addColumn("Telefono");
            modulo.addColumn("Modificado por");

            while (set.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = set.getObject(i + 1);
                }
                modulo.addRow(fila);
            }
            cnn.close();
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo llenar la tabla",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: " + s.getLocalizedMessage());
        }
    

        tabla_usuarios.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent s){
                int fila=tabla_usuarios.rowAtPoint(s.getPoint());
                int columna=0;
                
                if(fila>-1){
                    ID=(int)modulo.getValueAt(fila, columna);
                    Info_Clientes info=new Info_Clientes();
                    info.setVisible(true);
                }
                System.out.println("ID"+ID);
            }
        });
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scroll = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuariosMouseClicked(evt);
            }
        });
        Scroll.setViewportView(tabla_usuarios);

        getContentPane().add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 610, 240));

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTES REGISTRADOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 310, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuariosMouseClicked

    }//GEN-LAST:event_tabla_usuariosMouseClicked

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
            java.util.logging.Logger.getLogger(Gestor_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestor_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JScrollPane Scroll;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JTable tabla_usuarios;
    // End of variables declaration//GEN-END:variables
}
