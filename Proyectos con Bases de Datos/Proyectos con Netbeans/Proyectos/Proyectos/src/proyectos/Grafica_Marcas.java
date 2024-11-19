package proyectos;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author sebas
 */
public class Grafica_Marcas extends javax.swing.JFrame {

    String username="";
    
    int nuevo, no_reparado, revision, reparado, entregado;

    String[] estado_nom = new String[5];
    int[] estado_cantidad = new int[5];
    
    int acer, allenware, apple, asus, brother, dell, hp, toshiba, 
        hauwei, samsung, lenovo, lg, xerox, vaios, oppo, zte, motorola;
    int[] marcas_cantidad=new int[17];
    String[] marcas_nombre=new String[17];
    static String url = "jdbc:mysql://localhost/bd_ds";
    static String user = "root";
    static String password = "";
    public Grafica_Marcas(){
        initComponents();
        username=Login.user;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gráfica de Status - Sesión de "+username);
        setSize(550, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        
        try{
            Connection cnn=DriverManager.getConnection(url, user, password);
            PreparedStatement psp=cnn.prepareStatement("SELECT MARCA, COUNT(MARCA) AS MARCAS_REGISTRADA FROM EQUIPOS GROUP BY MARCA");
            
            ResultSet set=psp.executeQuery();
            
            if(set.next()){
                int pos=0;
                do{
                    marcas_nombre[pos]=set.getString(1);
                    marcas_cantidad[pos]=set.getInt(2);
                    if(marcas_nombre[pos].equalsIgnoreCase("Acer")){
                        acer=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Allenware")){
                        allenware=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Apple")){
                        apple=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Asus")){
                        asus=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Brother")){
                        brother=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Dell")){
                        dell=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("HP")){
                        hp=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Toshiba")){
                        toshiba=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Hauwei")){
                        hauwei=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Samsung")){
                        samsung=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Lenovo")){
                        lenovo=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("LG")){
                        lg=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Xerox")){
                        xerox=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Vaio")){
                        vaios=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("OPPO")){
                        oppo=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("ZTE")){
                        zte=marcas_cantidad[pos];
                    }else if(marcas_nombre[pos].equalsIgnoreCase("Motorola")){
                        motorola=marcas_cantidad[pos];
                    }
                    pos++;
                }while(set.next());
                
                PreparedStatement psp2=cnn.prepareStatement("SELECT ESTATUS, COUNT(ESTATUS) AS CANTIDAD FROM EQUIPOS GROUP BY ESTATUS");
                ResultSet megumin=psp2.executeQuery();
                if(megumin.next()){
                    int pos2=0;
                    do{
                        estado_nom[pos2]=megumin.getString(1);
                        estado_cantidad[pos2]=megumin.getInt(2);

                        if(estado_nom[pos2].equalsIgnoreCase("Nuevo ingreso")){
                            nuevo=estado_cantidad[pos2];
                        }else if(estado_nom[pos2].equalsIgnoreCase("No reparado")){
                            no_reparado=estado_cantidad[pos2];
                        }else if(estado_nom[pos2].equalsIgnoreCase("En revisión")){
                            revision=estado_cantidad[pos2];
                        }else if(estado_nom[pos2].equalsIgnoreCase("Reparado")){
                            reparado=estado_cantidad[pos2];
                        }else if(estado_nom[pos2].equalsIgnoreCase("Entregado")){
                            entregado=estado_cantidad[pos2];
                        }
                    pos2++;
                    }while(megumin.next());
                }
            }
            cnn.close();
        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "¡ERROR!, No se pudo hacer la consulta requerida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Error: "+s.getLocalizedMessage());
        }
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
        jLabel1.setText("Grafica de Marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

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
            java.util.logging.Logger.getLogger(Grafica_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafica_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafica_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafica_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new Grafica_Marcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics s){
        super.paint(s);
        
        int total=nuevo+no_reparado+reparado+revision+entregado;
        
        //Grafica de pastel
        int akari=nuevo*360/total;
        int mikari=no_reparado*360/total;
        int masha=reparado*360/total;
        int nino=revision*360/total;
        int satou=entregado*360/total;
        
        s.setColor(Color.red);
        s.fillArc(15, 80, 200, 200, 0, akari);
        s.fillRect(25, 290, 20, 20);
        s.drawString("Nuevo: "+nuevo+" productos", 55, 305);
        
        s.setColor(Color.orange);
        s.fillArc(15, 80, 200, 200, akari, mikari);
        s.fillRect(25, 320, 20, 20);
        s.drawString("No reparado: "+no_reparado+" productos", 55, 335);
        
        s.setColor(Color.yellow);
        s.fillArc(15, 80, 200, 200, akari+mikari, masha);
        s.fillRect(25, 350, 20, 20);
        s.drawString("Reparado: "+reparado+" productos", 55, 365);
        
        s.setColor(Color.lightGray);
        s.fillArc(15, 80, 200, 200, akari+mikari+masha, nino);
        s.fillRect(25, 380, 20, 20);
        s.drawString("En revision: "+revision+" productos", 55, 395);
        
        s.setColor(Color.blue);
        s.fillArc(15, 80, 200, 200, akari+mikari+masha+nino, satou);
        s.fillRect(25, 410, 20, 20);
        s.drawString("Entregado: "+entregado+" productos", 55, 425);
        
        //Marcas
        s.setColor(Color.pink);
        s.fillRect(230, 100, 20, 20);
        s.drawString("Acer: "+acer+" productos", 255, 115);
        
        s.setColor(Color.black);
        s.fillRect(230, 130, 20, 20);
        s.drawString("Allenware: "+allenware+" productos", 255, 145);
        
        s.setColor(Color.green);
        s.fillRect(230, 160, 20, 20);
        s.drawString("Apple: "+apple+" productos", 255, 175);
        
        s.setColor(Color.magenta);
        s.fillRect(230, 190, 20, 20);
        s.drawString("Asus: "+asus+" productos", 255, 205);
        
        s.setColor(Color.white);
        s.fillRect(230, 220, 20, 20);
        s.drawString("Brother: "+brother+" productos", 255, 235);
        
        s.setColor(new Color(135, 206, 225));
        s.fillRect(230, 250, 20, 20);
        s.drawString("Dell: "+dell+" productos", 255, 265);
        
        s.setColor(new Color(90, 40, 100));
        s.fillRect(230, 280, 20, 20);
        s.drawString("HP: "+hp+" productos", 255, 295);
        
        s.setColor(new Color(90, 110, 100));
        s.fillRect(230, 310, 20, 20);
        s.drawString("Toshiba: "+toshiba+" productos", 255, 325);
        
        s.setColor(new Color(0, 255, 255));
        s.fillRect(230, 340, 20, 20);
        s.drawString("Hauwei: "+hauwei+" productos", 255, 355);
        
        s.setColor(new Color(120, 190, 0));
        s.fillRect(230, 370, 20, 20);
        s.drawString("Samsung: "+samsung+" productos", 255, 385);
        
        s.setColor(new Color(120, 190, 100));
        s.fillRect(230, 400, 20, 20);
        s.drawString("Lenovo: "+lenovo+" productos", 255, 415);
        
        s.setColor(new Color(135, 206, 225));
        s.fillRect(395, 100, 20, 20);
        s.drawString("LG: "+lg+" productos", 420, 115);
        
        s.setColor(new Color(120, 50, 100));
        s.fillRect(395, 130, 20, 20);
        s.drawString("Xerox: "+xerox+" productos", 420, 145);
        
        s.setColor(new Color(10, 225, 200));
        s.fillRect(395, 160, 20, 20);
        s.drawString("Vaios: "+vaios+" productos", 420, 175);
        
        s.setColor(new Color(120, 120, 120));
        s.fillRect(395, 190, 20, 20);
        s.drawString("OPPO: "+oppo+" productos", 420, 205);
        
        s.setColor(new Color(50, 220, 180));
        s.fillRect(395, 220, 20, 20);
        s.drawString("ZTE: "+zte+" productos", 420, 235);
        
        s.setColor(new Color(135, 206, 225));
        s.fillRect(395, 250, 20, 20);
        s.drawString("Motorola: "+motorola+" productos", 420, 265);
    }
}
