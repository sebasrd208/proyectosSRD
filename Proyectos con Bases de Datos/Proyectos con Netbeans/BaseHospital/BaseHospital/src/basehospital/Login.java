package basehospital;

 import javax.swing.border.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.sql.*;
 import java.awt.*;
 import java.io.*;
 import javax.swing.event.*;
 import javax.swing.table.*;

 /**
 *
 * @author sebas
 */

public class Login extends JFrame implements ActionListener {

    private JLabel fondo, etiqueta1, etiqueta2, etiqueta3, etiqueta4, aviso, incorrecto;
    private JCheckBox palomita, mostrar, borrar;
    private JButton boton, regresar;
    private JTextField cuadro;
    private JPasswordField contra;
    public static String user = "";
    String pass = "";
    char alice;
    int tiempo;

    public Login() {
        setLayout(null);
        setTitle("Login");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/database.png")).getImage());//Para cambiar el icono de Java por otra que tú quieras
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BevelBorder nagisa = new BevelBorder(0);

        ImageIcon pp = new ImageIcon("src/imagenes/mostrar.png");
        mostrar = new JCheckBox(pp);
        mostrar.setBounds(210, 295, 35, 25);
        mostrar.setContentAreaFilled(false);
        mostrar.setBorder(nagisa);
        mostrar.setBackground(Color.lightGray);
        mostrar.addActionListener(this);
        add(mostrar);

        ImageIcon p = new ImageIcon("src/imagenes/borrar.png");
        borrar = new JCheckBox(p);
        borrar.setBounds(210, 240, 35, 25);
        borrar.setContentAreaFilled(false);
        //mostrar.setBorder(nagisa);
        borrar.setVisible(false);
        borrar.setBackground(Color.lightGray);
        borrar.addActionListener(this);
        add(borrar);

        etiqueta2 = new JLabel("Usuario:");
        etiqueta2.setBounds(110, 210, 200, 30);
        etiqueta2.setFont(new Font("Andale Mono", 1, 15));
        etiqueta2.setForeground(Color.BLACK);
        add(etiqueta2);

        etiqueta3 = new JLabel("Contraseña:");
        etiqueta3.setBounds(100, 265, 200, 30);
        etiqueta3.setFont(new Font("Andale Mono", 1, 15));
        etiqueta3.setForeground(Color.BLACK);
        add(etiqueta3);

        etiqueta4=new JLabel("Creado por Sebastian Ramiro Díaz®");
        etiqueta4.setBounds(70, 430, 200, 30);
        etiqueta4.setFont(new Font("Andale Mono", 1, 9));
        etiqueta4.setForeground(Color.black);
        add(etiqueta4);

        cuadro = new JTextField();
        cuadro.setBounds(50, 240, 200, 25);
        cuadro.setBackground(Color.lightGray);
        cuadro.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        cuadro.setFont(new Font("Andale Mono", 1, 14));
        cuadro.setBorder(nagisa);
        cuadro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent s) {
                if (cuadro.getText().trim().equals("")) {
                    borrar.setVisible(false);
                } else {
                    borrar.setVisible(true);
                }
                habilitar();
            }
        });
        cuadro.setForeground(Color.BLACK);
        add(cuadro);

        contra = new JPasswordField();
        contra.setBounds(50, 295, 200, 25);
        contra.setBackground(Color.lightGray);
        contra.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        contra.setBorder(nagisa);
        contra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent s) {
                habilitar();
            }
        });
        contra.setFont(new Font("Andale Mono", 1, 14));
        contra.setForeground(Color.BLACK);
        add(contra);

        boton = new JButton("Acceder");
        boton.setBounds(100, 335, 100, 25);
        boton.setFont(new Font("Andele Mono", 1, 14));
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        boton.setEnabled(false);
        boton.setBorder(nagisa);
        boton.addActionListener(this);
        add(boton);

        aviso = new JLabel();
        aviso.setBounds(50, 320, 250, 25);
        aviso.setFont(new Font("Sylfaen", 1, 12));
        aviso.setVisible(false);
        add(aviso);

        //ImageIcon imagen = new ImageIcon("src/imagenes/fondo3.jpg");
        fondo = new JLabel();
        fondo.setBounds(0, 0, 309, 550);
        add(fondo);

        ImageIcon imagen = new ImageIcon("src/imagenes/login.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),
                fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        this.repaint();
    }

    public void habilitar(){
        if (cuadro.getText().trim().isEmpty() | contra.getText().trim().isEmpty()) {
            boton.setEnabled(false);
        } else {
            boton.setEnabled(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent s) {
        if (s.getSource() == boton) {
            user = cuadro.getText().trim();
            pass = contra.getText().trim();
            int validar = 0;
            String usuario = "", password = "";
            if (usuario.equals("") && password.equals("")) {
                cuadro.setBackground(Color.red);
                contra.setBackground(Color.red);
                validar++;
            }
            try{
                Connection cnn = Conexion.conectar();
                PreparedStatement psp = cnn.prepareStatement("SELECT * FROM usuarios "
                        +"WHERE usuario='"+user+"' AND contrasena='"+pass+"'");

                ResultSet set=psp.executeQuery();

                if (set.next()){
                    if(user.equalsIgnoreCase(set.getString("usuario")) & pass.equals(set.getString("contrasena"))) {
                        Base_Hospital base=new Base_Hospital();
                        base.setVisible(true);
                        DefaultTableModel model=new DefaultTableModel();
                        model.setRowCount(0);
                        model.setColumnCount(0);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Sesión iniciada exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    cuadro.setText("");
                    contra.setText("");
                    cuadro.setBackground(Color.lightGray);
                    contra.setBackground(Color.lightGray);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al acceder", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                System.err.println("Error: " + e);
            }
        } else if (s.getSource() == borrar) {
            cuadro.setText("");
            contra.setText("");
            borrar.setVisible(false);
            boton.setEnabled(false);
        } else if (s.getSource() == regresar) {
            cuadro.setVisible(true);
            contra.setVisible(true);
            boton.setVisible(true);
            palomita.setVisible(true);
            mostrar.setVisible(true);
            regresar.setVisible(false);
            incorrecto.setVisible(false);
            etiqueta2.setVisible(true);
            etiqueta3.setVisible(true);
        } else if (s.getSource() == mostrar) {
            if (mostrar.isSelected()) {
                ImageIcon img = new ImageIcon("src/imagenes/no mostrar.png");
                mostrar.setIcon(img);
                alice = contra.getEchoChar();
                contra.setEchoChar((char) 0);
            } else {
                ImageIcon img = new ImageIcon("src/imagenes/mostrar.png");
                mostrar.setIcon(img);
                contra.setEchoChar(alice);
            }
        }
    }

    /*public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getSource() == cuadro) {
            String ichika = cuadro.getText();
            if (!ichika.isEmpty()) {
                borrar.setVisible(true);
            } else {
                borrar.setVisible(false);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }*/
    public static void main(String[] args){
        Login zero = new Login();
        zero.setBounds(0, 0, 309, 550);
        zero.setVisible(true);
        zero.setResizable(false);
        zero.setLocationRelativeTo(null);
    }
}
