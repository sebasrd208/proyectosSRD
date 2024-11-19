package proyectos;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Grafica_Status extends javax.swing.JFrame{

    String usuario="";
    int nuevo, no_reparado, revision, reparado, entregado;

    String[] estado_nom = new String[5];
    int[] estado_cantidad = new int[5];
    
    static String url = "jdbc:mysql://localhost/bd_ds";
    static String user = "root";
    static String password = "";
    public Grafica_Status(){
        initComponents();
        usuario=Login.user;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setTitle("Gráfica de Status - Sesión de "+usuario);
        setSize(550, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        try{
            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("SELECT ESTATUS, COUNT(ESTATUS) AS CANTIDAD FROM EQUIPOS GROUP BY ESTATUS");
            
            ResultSet set=psp.executeQuery();
            
            if(set.next()){
                int pos=0;
                do {
                    estado_nom[pos]=set.getString(1);
                    estado_cantidad[pos]=set.getInt(2);

                    if(estado_nom[pos].equalsIgnoreCase("Nuevo ingreso")){
                        nuevo=estado_cantidad[pos];
                    }else if(estado_nom[pos].equalsIgnoreCase("No reparado")){
                        no_reparado=estado_cantidad[pos];
                    }else if(estado_nom[pos].equalsIgnoreCase("En revisión")){
                        revision=estado_cantidad[pos];
                    }else if(estado_nom[pos].equalsIgnoreCase("Reparado")){
                        reparado=estado_cantidad[pos];
                    }else if(estado_nom[pos].equalsIgnoreCase("Entregado")){
                        entregado=estado_cantidad[pos];
                    }
                    pos++;
                }while(set.next());
            }
            cnn.close();
        }catch(SQLException s){
            System.err.println("Error al conectar con la Base de Datos: "+s.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, contacté al administrador", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        
        repaint();
    }

    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método es
     * siempre regenerado por el editor de formularios.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Grafica de Estado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

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
            java.util.logging.Logger.getLogger(Grafica_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafica_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafica_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafica_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafica_Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public int Repeticion(int nuevo, int no_reparado, int revision, int reparado, int entregado){
        if (nuevo>no_reparado & nuevo>revision & nuevo>reparado & nuevo>entregado){
            return nuevo;
        }else if(no_reparado>revision & no_reparado>reparado & no_reparado>entregado){
            return no_reparado;
        }else if(revision>reparado & revision>entregado){
            return revision;
        }else if(reparado>entregado){
            return reparado;
        }else{
            return entregado;
        }
    }
    @Override
    public void paint(Graphics s){
        super.paint(s);
        int repeticion=Repeticion(nuevo, no_reparado, revision, reparado, entregado);
        
        int nuevo_ingreso=nuevo*430/repeticion;
        int NoReparado=no_reparado*430/repeticion;
        int EnRevision=revision*430/repeticion;
        int Reparado=reparado*430/repeticion;
        int Entregado=entregado*430/repeticion;
        
        s.setColor(Color.yellow);
        s.fillRect(100, 100, nuevo_ingreso, 40);
        s.drawString("Nuevo ingreso", 15, 118);
        s.drawString("Cantidad: "+nuevo, 15, 133);
        
        s.setColor(Color.orange);
        s.fillRect(100, 160, NoReparado, 40);
        s.drawString("No Reparado", 15, 178);
        s.drawString("Cantidad: "+no_reparado, 15, 193);
            
        s.setColor(Color.black);
        s.fillRect(100, 220, EnRevision, 40);
        s.drawString("En revisión", 15, 238);
        s.drawString("Cantidad: "+revision, 15, 253);
        
        s.setColor(Color.white);
        s.fillRect(100, 280, Reparado, 40);
        s.drawString("Reparado", 15, 298);
        s.drawString("Cantidad: "+reparado, 15, 313);
        
        s.setColor(Color.blue);
        s.fillRect(100, 340, Entregado, 40);
        s.drawString("Entregado", 15, 358);
        s.drawString("Cantidad: "+Entregado, 15, 373);
   
    }
}
