package proyecto_ceteq;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
/**
 *
 * @author sebas
 */
public class SecuenciasSQL extends JFrame implements ActionListener, KeyListener{
    private JLabel ticket;
    private JTextField txt;
    private JButton btn, btn2, btn3, btn4;
    private JComboBox combo, combo2, combo3, combo4;
    
    public SecuenciasSQL(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Secuencias SQL");
        
        BevelBorder border=new BevelBorder(0);
        Font estilo=new Font("Sylfaen", 1, 12);
        
        ticket=new JLabel("Inicio de secuencia:");
        ticket.setBounds(10, 10, 180, 25);
        ticket.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        ticket.setFont(estilo);
        add(ticket);
        
        txt=new JTextField();
        txt.setBounds(10, 35, 150, 25);
        txt.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        txt.addKeyListener(this);
        txt.setFont(estilo);
        txt.setBorder(border);
        add(txt);
        
        btn=new JButton("Crear secuencia");
        btn.setBounds(10, 70, 150, 25);
        btn.setFont(estilo);
        btn.setBorder(border);
        btn.setEnabled(false);
        btn.addActionListener(this);
        btn.setFocusPainted(false);
        add(btn);
        
        btn2=new JButton("Crear Disparador");
        btn2.setBounds(10, 105, 150, 25);
        btn2.setFont(estilo);
        btn2.setBorder(border);
        btn2.setEnabled(false);
        btn2.addActionListener(this);
        btn2.setFocusPainted(false);
        add(btn2);
        
        combo=new JComboBox();
        combo.setBounds(10, 140, 200, 25);
        combo.setFont(estilo);
        combo.setBorder(border);
        combo.addItem("TUTORES_SEQ");
        combo.addItem("CARRERAS_ALUMNO_SEQ");
        combo.addItem("CARRERAS_SEQ");
        combo.addItem("ESTUDIANTES_SEQ");
        combo.addItem("TU_ALUMNOS_SEQ");
        add(combo);
        
        combo2=new JComboBox();
        combo2.setBounds(10, 175, 220, 25);
        combo2.setFont(estilo);
        combo2.setBorder(border);
        combo2.addItem("INSERTAR_TUTORES");
        combo2.addItem("INSERTAR_CARRERA_ALUMNO");
        combo2.addItem("INSERTAR_CARRERA");
        combo2.addItem("INSERTAR_ALUMNO");
        combo2.addItem("INSERTAR_TU_ALUMNO");
        add(combo2);
        
        combo3=new JComboBox();
        combo3.setBounds(10, 210, 120, 25);
        combo3.setFont(estilo);
        combo3.setBorder(border);
        combo3.addItem("ID_TUTOR");
        combo3.addItem("CA_ID");
        combo3.addItem("ID_CARRERA");
        combo3.addItem("ID_ALUMNO");
        combo3.addItem("ID_TABLA");
        add(combo3);
        
        combo4=new JComboBox();
        combo4.setBounds(140, 210, 120, 25);
        combo4.setFont(estilo);
        combo4.setBorder(border);
        combo4.addItem("TUTORES");
        combo4.addItem("CARRERA_ALUMNOS");
        combo4.addItem("CARRERAS");
        combo4.addItem("ESTUDIANTES");
        combo4.addItem("TUTORES_ALUMNOS");
        add(combo4);
        
        btn3=new JButton("Eliminar Secuencia");
        btn3.setBounds(160, 70, 150, 25);
        btn3.setFont(estilo);
        btn3.setBorder(border);
        btn3.setEnabled(false);
        btn3.setFocusPainted(false);
        btn3.addActionListener(this);
        add(btn3);
        
        btn4=new JButton("Eliminar Disparador");
        btn4.setBounds(160, 105, 150, 25);
        btn4.setFont(estilo);
        btn4.setBorder(border);
        btn4.setFocusPainted(false);
        btn4.addActionListener(this);
        add(btn4);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent s){
        String selector=combo.getSelectedItem().toString();
        String selector2=combo2.getSelectedItem().toString();
        String selector3=combo3.getSelectedItem().toString();
        String selector4=combo4.getSelectedItem().toString();
        String incremento=txt.getText().trim();
        //int num=Integer.parseInt(incremento);
        if(s.getSource()==btn){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                PreparedStatement psp=cnn.prepareStatement("CREATE SEQUENCE "+selector+"\n" +
                            "START WITH "+incremento+"\n"+
                            "INCREMENT BY 1\n"+
                            "MAXVALUE 999\n"+
                            "MINVALUE 1\n"+
                            "NOCYCLE");
                
                psp.executeUpdate();
                btn2.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Secuencia "+selector+" creada exitosamente",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "¡ERROR!, ¡No se pudo crear la secuencia!",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }else if(s.getSource()==btn2){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                //Connection cnn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                PreparedStatement psp=cnn.prepareStatement("CREATE OR REPLACE TRIGGER "+selector2+"\n"+
                        " BEFORE INSERT ON "+selector4+" FOR EACH ROW BEGIN\n" +
                        " SELECT "+selector+".NEXTVAL INTO:NEW."+selector3+" FROM DUAL;\n"+
                        "END;");
                //PreparedStatement psp2=cnn2.prepareStatement("");
                
                psp.executeUpdate();
                //psp2.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Disparador "+selector2+" creada exitosamente",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "¡ERROR!, ¡No se pudo crear el disparador!",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }else if(s.getSource()==btn3){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                PreparedStatement psp=cnn.prepareStatement("DROP SEQUENCE "+selector);
                
                psp.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Secuencia "+selector2+" eliminada exitosamente",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "¡ERROR!, ¡No se pudo eliminar la secuencia!",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }else if(s.getSource()==btn4){
            try{
                Connection cnn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Sebastian", "admin");
                PreparedStatement psp=cnn.prepareStatement("DROP TRIGGER "+selector2);
                
                psp.executeUpdate();
                btn4.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Disparador "+selector2+" eliminada exitosamente",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "¡ERROR!, ¡No se pudo eliminar el disparador!",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent s){
        if(s.getSource()==txt){
            if(txt.getText().trim().isEmpty()){
                btn.setEnabled(false);
            }else{
                btn.setEnabled(true);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent s){
        if(s.getSource()==txt){
            int key=s.getKeyChar();
            boolean numero=key>=48 & key<=57;
            if(!numero){
                s.consume();
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent s){
        
    }
    
    public static void main(String[] args){
        SecuenciasSQL sequence=new SecuenciasSQL();
        sequence.setBounds(0, 0, 350, 300);
        sequence.setVisible(true);
        sequence.setResizable(false);
        sequence.setLocationRelativeTo(null);
    }
}
