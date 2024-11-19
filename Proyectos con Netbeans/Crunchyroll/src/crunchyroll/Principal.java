package crunchyroll;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author sebas
 */
public class Principal extends JFrame implements ActionListener{

    public static JMenuBar bar;
    public static JMenu opciones, calculo, acerca, fondo;
    public static JMenuItem calcular, aka, kuro, murasaki, creador, salir, nuevo;
    public static JLabel logo, bienvenida, titulo, namae, paterno, materno,
            departamento,antiguedad, resultado, foster, label;
    public static JTextField nombre, paterno_trabajador, materno_trabajador;
    public static JComboBox depto, depto_ingles, depto_japones, antiguo, 
            antiguo_ingles, antiguo_japones, idiomas;
    public static JTextArea res;
    public static JScrollPane scroll;
    public static String yuza="";

    public Principal(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pantalla Principal");
        yuza=Bienvenida.user;
        ImageIcon img=new ImageIcon("src/imagenes/ico_crunchyroll.png");
        this.setIconImage(img.getImage());
        getContentPane().setBackground(new Color(255, 128, 0));
        BevelBorder jelavic=new BevelBorder(0);

        bar=new JMenuBar();
        bar.setBackground(new Color(255, 128, 0));
        setJMenuBar(bar);

        opciones=new JMenu("Opciones");
        opciones.setBackground(new Color(255, 128, 0));
        opciones.setFont(new Font("Andale Mono", Font.BOLD, 14));
        opciones.setForeground(Color.white);
        bar.add(opciones);

        calculo=new JMenu("Calcular");
        calculo.setBackground(new Color(255, 128, 0));
        calculo.setFont(new Font("Andale Mono", Font.BOLD, 14));
        calculo.setForeground(Color.white);
        bar.add(calculo);

        acerca=new JMenu("Acerca De");
        acerca.setBackground(new Color(255, 128, 0));
        acerca.setFont(new Font("Andale Mono", Font.BOLD, 14));
        acerca.setForeground(Color.white);
        bar.add(acerca);

        fondo=new JMenu("Colores de Fondo");
        fondo.setFont(new Font("Andale Mono", 1, 14));
        fondo.setForeground(new Color(255, 128, 0));
        opciones.add(fondo);

        calcular=new JMenuItem("Vacaciones");
        calcular.setFont(new Font("Andale Mono", Font.BOLD, 14));
        calcular.setForeground(new Color(255, 128, 0));
        calcular.addActionListener(this);
        calculo.add(calcular);

        aka=new JMenuItem("Rojo");
        aka.setFont(new Font("Andale Mono", Font.BOLD, 14));
        aka.setForeground(new Color(255, 128, 0));
        aka.addActionListener(this);
        fondo.add(aka);

        kuro=new JMenuItem("Negro");
        kuro.setFont(new Font("Andale Mono", Font.BOLD, 14));
        kuro.setForeground(new Color(255, 128, 0));
        kuro.addActionListener(this);
        fondo.add(kuro);

        murasaki=new JMenuItem("Morado");
        murasaki.setFont(new Font("Andale Mono", Font.BOLD, 14));
        murasaki.setForeground(new Color(255, 128, 0));
        murasaki.addActionListener(this);
        fondo.add(murasaki);

        nuevo=new JMenuItem("Nuevo");
        nuevo.setFont(new Font("Andale Mono", Font.BOLD, 14));
        nuevo.setForeground(new Color(255, 128, 0));
        nuevo.addActionListener(this);
        opciones.add(nuevo);

        creador=new JMenuItem("Datos del Desarrollador");
        creador.setFont(new Font("Andale Mono", 1, 14));
        creador.setForeground(new Color(255, 128, 0));
        creador.addActionListener(this);
        acerca.add(creador);

        salir=new JMenuItem("Salir");
        salir.setFont(new Font("Andale Mono", 1, 14));
        salir.setForeground(new Color(255, 128, 0));
        salir.addActionListener(this);
        opciones.add(salir);

        ImageIcon coca=new ImageIcon("src/imagenes/Crunchyroll_blanco.png");
        logo=new JLabel(coca);
        logo.setBounds(10, 20, 300, 52);
        add(logo);

        bienvenida=new JLabel("Bienvenido "+yuza);
        bienvenida.setBounds(320, 15, 300, 50);
        bienvenida.setFont(new Font("Andale Mono", 0, 30));
        bienvenida.setForeground(Color.white);
        add(bienvenida);

        titulo=new JLabel("Datos del Trabajador para el calculo de vacaciones");
        titulo.setBounds(45, 120, 900, 25);
        titulo.setFont(new Font("Andale Mono", 0, 24));
        titulo.setForeground(Color.white);
        add(titulo);

        namae=new JLabel("Nombre Completo:");
        namae.setBounds(25, 180, 180, 25);
        namae.setFont(new Font("Andale Mono", 1, 12));
        namae.setForeground(Color.white);
        add(namae);

        nombre=new JTextField();
        nombre.setBounds(25, 205, 150, 30);
        nombre.setFont(new Font("Andale Mono", 1, 12));
        nombre.setBackground(Color.lightGray);
        nombre.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        nombre.setForeground(Color.red);
        nombre.setBorder(jelavic);
        add(nombre);

        paterno=new JLabel("Apellido Paterno:");
        paterno.setBounds(25, 250, 180, 25);
        paterno.setFont(new Font("Andale Mono", 1, 12));
        paterno.setForeground(Color.white);
        add(paterno);

        paterno_trabajador=new JTextField();
        paterno_trabajador.setBounds(25, 275, 150, 30);
        paterno_trabajador.setFont(new Font("Andale Mono", 1, 12));
        paterno_trabajador.setBackground(Color.lightGray);
        paterno_trabajador.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        paterno_trabajador.setForeground(Color.red);
        paterno_trabajador.setBorder(jelavic);
        add(paterno_trabajador);

        materno=new JLabel("Apellido Materno:");
        materno.setBounds(25, 320, 180, 25);
        materno.setFont(new Font("Andale Mono", 1, 12));
        materno.setForeground(Color.white);
        add(materno);

        materno_trabajador=new JTextField();
        materno_trabajador.setBounds(25, 345, 150, 30);
        materno_trabajador.setFont(new Font("Andale Mono", 1, 12));
        materno_trabajador.setBackground(Color.lightGray);
        materno_trabajador.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        materno_trabajador.setForeground(Color.red);
        materno_trabajador.setBorder(jelavic);
        add(materno_trabajador);

        departamento=new JLabel("Selecciona el Departamento:");
        departamento.setBounds(220, 180, 200, 25);
        departamento.setFont(new Font("Andale Mono", 1, 12));
        departamento.setForeground(Color.white);
        add(departamento);

        depto=new JComboBox();
        depto.setBounds(220, 205, 200, 30);
        depto.setBackground(Color.lightGray);
        depto.setFont(new Font("Andale Mono", 1, 12));
        depto.setForeground(Color.white);
        depto.setBorder(jelavic);
        depto.addItem("Elegir");
        depto.addItem("Atencion Al Cliente");
        depto.addItem("Departamento de Logistica");
        depto.addItem("Departamento de Gerencia");
        add(depto);

        depto_ingles=new JComboBox();
        depto_ingles.setBounds(220, 205, 200, 30);
        depto_ingles.setBackground(Color.lightGray);
        depto_ingles.setFont(new Font("Andale Mono", 1, 12));
        depto_ingles.setForeground(Color.white);
        depto_ingles.setBorder(jelavic);
        depto_ingles.setVisible(false);
        depto_ingles.addItem("Choose");
        depto_ingles.addItem("Customer Support");
        depto_ingles.addItem("Logistics Department");
        depto_ingles.addItem("Management Department");
        add(depto_ingles);
        
        depto_japones=new JComboBox();
        depto_japones.setBounds(220, 205, 200, 30);
        depto_japones.setBackground(Color.lightGray);
        depto_japones.setFont(new Font("Andale Mono", 1, 12));
        depto_japones.setForeground(Color.white);
        depto_japones.setBorder(jelavic);
        depto_japones.setVisible(false);
        depto_japones.addItem("選択する");
        depto_japones.addItem("顧客サポート");
        depto_japones.addItem("物流部門");
        depto_japones.addItem("管理部門");
        add(depto_japones);
        
        antiguedad=new JLabel("Selecciona la Antigüedad:");
        antiguedad.setBounds(220, 250, 200, 25);
        antiguedad.setFont(new Font("Andale Mono", 1, 12));
        antiguedad.setForeground(Color.white);
        add(antiguedad);

        antiguo=new JComboBox();
        antiguo.setBounds(220, 275, 200, 30);
        antiguo.setBackground(Color.lightGray);
        antiguo.setFont(new Font("Andale Mono", 1, 12));
        antiguo.setForeground(Color.white);
        antiguo.setBorder(jelavic);
        antiguo.addItem("Elegir");
        antiguo.addItem("1 año de servicio");
        antiguo.addItem("2 a 6 años de servicio");
        antiguo.addItem("7 años o más de servicio");
        add(antiguo);

        antiguo_ingles=new JComboBox();
        antiguo_ingles.setBounds(220, 275, 200, 30);
        antiguo_ingles.setBackground(Color.lightGray);
        antiguo_ingles.setFont(new Font("Andale Mono", 1, 12));
        antiguo_ingles.setForeground(Color.white);
        antiguo_ingles.setBorder(jelavic);
        antiguo_ingles.setVisible(false);
        antiguo_ingles.addItem("Choose");
        antiguo_ingles.addItem("1 year of service");
        antiguo_ingles.addItem("2 to 6 years of service");
        antiguo_ingles.addItem("7 or more years of service");
        add(antiguo_ingles);
        
        antiguo_japones=new JComboBox();
        antiguo_japones.setBounds(220, 275, 200, 30);
        antiguo_japones.setBackground(Color.lightGray);
        antiguo_japones.setFont(new Font("Andale Mono", 1, 12));
        antiguo_japones.setForeground(Color.white);
        antiguo_japones.setBorder(jelavic);
        antiguo_japones.setVisible(false);
        antiguo_japones.addItem("選択する");
        antiguo_japones.addItem("勤続1年");
        antiguo_japones.addItem("勤続2年から6年");
        antiguo_japones.addItem("勤続7年以上");
        add(antiguo_japones);
        
        label=new JLabel("Idiomas:");
        label.setBounds(450, 180, 100, 25);
        label.setForeground(Color.white);
        label.setFont(new Font("Andale Mono", 1, 12));
        add(label);

        idiomas=new JComboBox();
        idiomas.setBounds(450, 205, 150, 30);
        idiomas.setBackground(Color.lightGray);
        idiomas.setFont(new Font("Andale Mono", 1, 12));
        idiomas.setForeground(Color.white);
        idiomas.setBorder(jelavic);
        idiomas.addItem("Español");
        idiomas.addItem("English");
        idiomas.addItem("日本語");
        idiomas.addActionListener(this);
        add(idiomas);

        resultado=new JLabel("Resultados del Calculo:");
        resultado.setBounds(220, 320, 180, 25);
        resultado.setFont(new Font("Andale Mono", 1, 12));
        resultado.setForeground(Color.white);
        add(resultado);

        res=new JTextArea("\n  Aqui aparece el resultado del calculo de las vacaciones");
        res.setEditable(false);
        res.setBackground(Color.lightGray);
        res.setBorder(jelavic);
        res.setFont(new Font("Andale Mono", 1, 12));
        res.setForeground(Color.red);
        scroll=new JScrollPane(res);
        scroll.setBounds(220, 345, 385, 90);
        add(scroll);

        foster=new JLabel("©2023 The Crunchyroll Company | Todos los derechos reservados");
        foster.setBounds(135, 445, 500, 30);
        foster.setFont(new Font("Andale Mono", 1, 12));
        foster.setForeground(Color.white);
        add(foster);
    }

    public void actionPerformed(ActionEvent s){
        if(s.getSource()==calcular){
            String selector=idiomas.getSelectedItem().toString();
            String p=paterno_trabajador.getText().trim();
            String m=materno_trabajador.getText().trim();
            String n=nombre.getText().trim();
            String d=depto.getSelectedItem().toString();
            String a=antiguo.getSelectedItem().toString();
            if(selector.equals("Español")){
                if(p.equals("") || m.equals("") || n.equals("")
                        || d.equals("Elegir") || a.equals("Elegir")){
                    JOptionPane.showMessageDialog(null, "Debes llenar los datos", "Mensaje", 
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    if(d.equals("Atencion Al Cliente")){
                        if(a.equals("1 año de servicio")){
                            res.setText("\n   El trabajador " + n + " " + m + " " + p
                                +"\n   quien labora en " + d + " con " + a
                                +"\n   recibe 7 dias de vacaciones");
                        }
                        if(a.equals("2 a 6 años de servicio")){
                            res.setText("\n   El trabajador " + n + " " + m + " " + p
                                +"\n   quien labora en " + d + " con " + a
                                +"\n   recibe 14 dias de vacaciones");
                        }
                        if(a.equals("7 años o más de servicio")){
                            res.setText("\n   El trabajador " + n + " " + m + " " + p
                                +"\n   quien labora en " + d + " con " + a
                                +"\n   recibe 20 dias de vacaciones");
                        }
                    }
                    if(d.equals("Departamento de Logistica")){
                        if(a.equals("1 año de servicio")){
                            res.setText("\n   El trabajador " + n + " " + m + " " + p
                                +"\n   quien labora en " + d + " con " + a
                                +"\n   recibe 7 dias de vacaciones");
                        }
                        if(a.equals("2 a 6 años de servicio")){
                            res.setText("\n   El trabajador " + n + " " + m + " " + p
                                +"\n   quien labora en "+d+" con "+a
                                +"\n   recibe 15 dias de vacaciones");
                        }
                        if(a.equals("7 años o más de servicio")){
                            res.setText("\n   El trabajador "+n+" "+m+" "+p
                                +"\n   quien labora en "+d+" con "+a
                                +"\n   recibe 22 dias de vacaciones");
                        }
                    }
                    if(d.equals("Departamento de Gerencia")){
                        if(a.equals("1 año de servicio")){
                            res.setText("\n   El trabajador "+n+" "+m+" "+p
                                +"\n    quien labora en "+d+" con "+a
                                +"\n    recibe 10 dias de vacaciones");
                        }
                        if(a.equals("2 a 6 años de servicio")){
                            res.setText("\n   El trabajador "+n+" "+m+" "+p
                                +"\n   quien labora en "+d+" con "+a
                                +"\n   recibe 20 dias de vacaciones");
                        }
                        if(a.equals("7 años o más de servicio")){
                            res.setText("\n   El trabajador "+n+" "+m+" "+p
                                +"\n   quien labora en "+d+" con "+a
                                +"\n   recibe 1 mes de vacaciones");
                        }
                    }
                }
            }else if(selector.equals("English")){
                if(p.equals("") || m.equals("") || n.equals("")
                        || depto_ingles.getSelectedItem().equals("Choose") 
                        || antiguo_ingles.getSelectedItem().equals("Choose")){
                    JOptionPane.showMessageDialog(null, "You must fill in the data!");
                }else{
                    if(depto_ingles.getSelectedItem().equals("Customer Support")){
                        if(antiguo_ingles.getSelectedItem().equals("1 year of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                +"\n    who works in Customer Support with "
                                +"\n    1 year of service receives 7 days of vacation");
                        }
                        if(antiguo_ingles.getSelectedItem().equals("2 to 6 years of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                +"\n   who works in Customer Support with "
                                + "\n   2 to 6 years of service receives 14 days of vacation");
                        }
                        if(antiguo_ingles.getSelectedItem().equals("7 or more years of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                + "\n   who works in Customer Support with"
                                + "\n   7 years of service receives 20 days of vacation");
                        }
                    }
                    if(depto_ingles.getSelectedItem().equals("Logistics Department")){
                        if(antiguo_ingles.getSelectedItem().equals("1 year of service")){
                            res.setText("\n   The worker "+n+" "+m+" "+p
                                + "\n   who works in Logistics Department with"
                                + "\n   1 year of service receives 7 days of vacation");
                        }
                        if(antiguo_ingles.getSelectedItem().equals("2 to 6 years of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                + "\n   who works in Logistics Department with"
                                + "\n   2 to 6 years of service receives 15 days of vacation");
                        }
                        if(antiguo_ingles.getSelectedItem().equals("7 or more years of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                + "\n   who works in Logistics Department with"
                                + "\n   7 years of service receives 22 days of vacation");
                        }
                    }
                    if(depto_ingles.getSelectedItem().equals("Management Department")){
                        if(antiguo_ingles.getSelectedItem().equals("1 year of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                + "\n   who works in Management Department with"
                                + "\n   1 year of service receives 10 days of vacation");
                        }
                        if(antiguo_ingles.getSelectedItem().equals("2 to 6 years of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                + "\n   who works in Management Department with"
                                + "\n   2 to 6 years of service receives 20 days of vacation");
                        }
                        if(antiguo_ingles.getSelectedItem().equals("7 or more years of service")){
                            res.setText("\n   The worker " + n + " " + m + " " + p
                                + "\n   who works in Management Department with"
                                + "\n   7 years of service receives 1 mounth of vacation");
                        }
                    }
                }
            }else if(selector.equals("日本語")){
                if(p.equals("") || m.equals("") || n.equals("")
                || depto_japones.getSelectedItem().equals("選択する")
                || antiguo_japones.getSelectedItem().equals("選択する")){
                    JOptionPane.showMessageDialog(null, "データを入力する必要があります!", 
                        "メッセージ", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    if(depto_japones.getSelectedItem().equals("顧客サポート")){
                        if(antiguo_japones.getSelectedItem().equals("勤続1年")){
                            res.setText("\n   カスタマー サービス部門で勤続 1 "
                                +"\n    年の従業員 "+p+" "+m+" "+n
                                +"\n    は、7 日間の休暇を取得します。");
                        }
                        if(antiguo_japones.getSelectedItem().equals("勤続2年から6年")){
                            res.setText("\n   顧客サービス部門で 2 年から 6 年勤務す"
                                +"\n    る労働者 "+p+" "+m+" "+n
                                +"\n   は、14 日間の休暇を取得します");
                        }
                        if(antiguo_japones.getSelectedItem().equals("勤続7年以上")){
                            res.setText("\n   顧客サービス部門で勤続 7 年の"
                                +"\n    従業員 "+p+" "+m+" "+n
                                +"\n   は、20 日間の休暇を取得します。");
                        }
                    }
                    if(depto_japones.getSelectedItem().equals("物流部門")){
                        if(antiguo_japones.getSelectedItem().equals("勤続1年")){
                            res.setText("\nロジスティクス部門で勤続 1 年の"
                                +"\n労働者 "+p+" "+m+" "+n
                                +"\nは、7 日間の休暇を受け取ります。");
                        }
                        if(antiguo_japones.getSelectedItem().equals("勤続2年から6年")){
                            res.setText("\nロジスティクス部門で勤続 2 年から "
                                +"\n6 年の労働者 "+p+" "+m+" "+n
                                +"\nは、15 日間の休暇を取得します。");
                        }
                        if(antiguo_japones.getSelectedItem().equals("勤続7年以上")){
                            res.setText("\nロジスティクス部門で勤続 7 年の"
                                +"\n労働者 "+p+" "+m+" "+n
                                +"\nは、22 日間の休暇を受け取ります。");
                        }
                    }
                    if(depto_japones.getSelectedItem().equals("管理部門")){
                        if(antiguo_japones.getSelectedItem().equals("勤続1年")){
                            res.setText("\n管理部門で勤続 1 年の"
                                +"\n従業員 "+p+" "+m+" "+n
                                +"\nは、10 日間の休暇を受け取ります。");
                        }
                        if(antiguo_japones.getSelectedItem().equals("勤続2年から6年")){
                            res.setText("\n管理部門で勤続 2 年から "
                                +"\n6 年の従業員 "+p+" "+m+" "+n
                                +"\nは、20 日間の休暇を取得します。");
                        }
                        if(antiguo_japones.getSelectedItem().equals("勤続7年以上")){
                            res.setText("\n管理部門で勤続 7 年の"
                                + "\n従業員 "+p+" "+m+" "+n
                                + "\nは 1 か月の休暇を取得します。");
                        }
                    }
                }
            }
        }else if(s.getSource()==aka){
            getContentPane().setBackground(Color.red);
        }else if(s.getSource()==kuro){
            getContentPane().setBackground(Color.black);
        }else if(s.getSource()==murasaki){
            getContentPane().setBackground(new Color(51, 0, 51));
        }else if(s.getSource()==creador){
            if(idiomas.getSelectedItem().equals("Español")){
                JOptionPane.showMessageDialog(null, "Nombre: Sebastian Ramiro Diaz"
                +"\nPasatiempos: Ver anime y escuchar corridos"
                +"\nEdad: 23 Años", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else if(idiomas.getSelectedItem().equals("English")){
                JOptionPane.showMessageDialog(null, "Name: Sebastian Ramiro Diaz"
                +"\nHobbies: Watching anime and listening to corridos"
                +"\nAge: 23 Years");
            }else if(idiomas.getSelectedItem().equals("日本語")){
                JOptionPane.showMessageDialog(null, "名前: Sebastian Ramiro Diaz"
                +"\n趣味: アニメ鑑賞、corridosを聞くこと\n年: 23 歳", "メッセージ", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(s.getSource()==salir){
            if(idiomas.getSelectedItem().equals("Español")){
                Bienvenida ventanabienvenida=new Bienvenida();
                ventanabienvenida.setBounds(0, 0, 350, 470);
                ventanabienvenida.setVisible(true);
                ventanabienvenida.setResizable(false);
                ventanabienvenida.setLocationRelativeTo(null);
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "¡Salida Exitosa!");
                ventanabienvenida.ticket.setText("Sistema de Control Vacacional");
                ventanabienvenida.ticket.setFont(new Font("Andale Mono", 3, 18));
                ventanabienvenida.ticket.setBounds(35, 150, 300, 40);
                ventanabienvenida.ticket3.setText("Ingrese su nombre:");
                ventanabienvenida.boton.setText("Ingresar");
                ventanabienvenida.setTitle("Bienvenido");
                ventanabienvenida.menu.setSelectedIndex(0);
            }else if(idiomas.getSelectedItem().equals("English")){
                Bienvenida ventanabienvenida=new Bienvenida();
                ventanabienvenida.setBounds(0, 0, 350, 470);
                ventanabienvenida.setVisible(true);
                ventanabienvenida.setResizable(false);
                ventanabienvenida.setLocationRelativeTo(null);
                this.setVisible(false);
                ventanabienvenida.ticket.setText("Vacation Control System");
                ventanabienvenida.ticket.setFont(new Font("Andale Mono", 3, 18));
                ventanabienvenida.ticket.setBounds(60, 150, 300, 40);
                ventanabienvenida.ticket3.setText("Enter your name:");
                ventanabienvenida.boton.setText("Enter");
                ventanabienvenida.setTitle("Welcome");
                ventanabienvenida.menu.setSelectedIndex(1);
                JOptionPane.showMessageDialog(null, "Exit Successful!");
            }else if(idiomas.getSelectedItem().equals("日本語")){
                Bienvenida ventanabienvenida=new Bienvenida();
                ventanabienvenida.setBounds(0, 0, 350, 470);
                ventanabienvenida.setVisible(true);
                ventanabienvenida.setResizable(false);
                ventanabienvenida.setLocationRelativeTo(null);
                this.setVisible(false);
                ventanabienvenida.ticket.setText("休暇管理システム");
                ventanabienvenida.ticket.setFont(new Font("Andale Mono", Font.BOLD, 18));
                ventanabienvenida.ticket.setBounds(100, 150, 300, 40);
                ventanabienvenida.ticket3.setText("お名前を入力してください:");
                ventanabienvenida.boton.setText("入る");
                ventanabienvenida.setTitle("おかえり");
                ventanabienvenida.menu.setSelectedIndex(2);
                JOptionPane.showMessageDialog(null, "終了しました!");
            }
        }else if(s.getSource()==nuevo){
            if(idiomas.getSelectedItem().equals("Español")){
                nombre.setText("");
                paterno_trabajador.setText("");
                materno_trabajador.setText("");
                res.setText("\n  Aqui aparece el resultado del calculo de las vacaciones");
                depto.setVisible(true);
                depto.setSelectedIndex(0);
                depto_ingles.setVisible(false);
                depto_ingles.setSelectedIndex(0);
                depto_japones.setVisible(false);
                depto_japones.setSelectedIndex(0);
                antiguo.setVisible(true);
                antiguo.setSelectedIndex(0);
                antiguo_ingles.setVisible(false);
                antiguo_ingles.setSelectedIndex(0);
                antiguo_japones.setVisible(false);
                antiguo_japones.setSelectedIndex(0);
            }else if(idiomas.getSelectedItem().equals("English")){
                nombre.setText("");
                paterno_trabajador.setText("");
                materno_trabajador.setText("");
                res.setText("\n  Here is the result of the vacation calculation");
                depto.setVisible(false);
                depto.setSelectedIndex(0);
                depto_ingles.setVisible(true);
                depto_ingles.setSelectedIndex(0);
                depto_japones.setVisible(false);
                depto_japones.setSelectedIndex(0);
                antiguo.setVisible(false);
                antiguo.setSelectedIndex(0);
                antiguo_ingles.setVisible(true);
                antiguo_ingles.setSelectedIndex(0);
                antiguo_japones.setVisible(false);
                antiguo_japones.setSelectedIndex(0);
            }else if(idiomas.getSelectedItem().equals("日本語")){
                nombre.setText("");
                paterno_trabajador.setText("");
                materno_trabajador.setText("");
                res.setText("\n  ここに結果が表示されます");
                depto.setVisible(false);
                depto.setSelectedIndex(0);
                depto_ingles.setVisible(false);
                depto_ingles.setSelectedIndex(0);
                depto_japones.setVisible(true);
                depto_japones.setSelectedIndex(0);
                antiguo.setVisible(false);
                antiguo.setSelectedIndex(0);
                antiguo_ingles.setVisible(false);
                antiguo_ingles.setSelectedIndex(0);
                antiguo_japones.setVisible(true);
                antiguo_japones.setSelectedIndex(0);
            }
        }else if(s.getSource()==idiomas){
            if(idiomas.getSelectedItem().equals("English")){
                opciones.setText("Options");
                calculo.setText("Calculate");
                acerca.setText("About");
                fondo.setText("Background colors");
                label.setText("Language");
                calcular.setText("Vacations");
                aka.setText("Red");
                kuro.setText("Black");
                murasaki.setText("Purple");
                nuevo.setText("New");
                creador.setText("Developer Details");
                salir.setText("Exit");
                bienvenida.setText("Welcome " + yuza);
                titulo.setText("Worker Data for Vacation Calculation");
                titulo.setBounds(150, 120, 900, 25);
                namae.setText("Full Name:");
                depto.setVisible(false);
                depto_ingles.setVisible(true);
                depto_japones.setVisible(false);
                antiguo.setVisible(false);
                antiguo_ingles.setVisible(true);
                antiguo_japones.setVisible(false);
                paterno.setText("Last Name:");
                materno.setText("Mother's Last Name:");
                departamento.setText("Select the Department:");
                antiguedad.setText("Select the Age:");
                resultado.setText("Calculation Results:");
                res.setText("\n  Here is the result of the vacation calculation");
                setTitle("Main Screen");
                foster.setText("©2023 The Crunchyroll Company | All rights reserved");
            }else if(idiomas.getSelectedItem().equals("Español")){
                opciones.setText("Opciones");
                calculo.setText("Calcular");
                acerca.setText("Acerca De");
                fondo.setText("Colores de Fondo");
                label.setText("Idioma");
                calcular.setText("Vacaciones");
                aka.setText("Rojo");
                kuro.setText("Negro");
                murasaki.setText("Morado");
                nuevo.setText("Nuevo");
                creador.setText("Datos del Desarrollador");
                salir.setText("Salir");
                bienvenida.setText("Bienvenido " + yuza);
                titulo.setText("Datos del Trabajador para el calculo de vacaciones");
                titulo.setBounds(45, 120, 900, 25);
                depto.setVisible(true);
                depto_ingles.setVisible(false);
                depto_japones.setVisible(false);
                antiguo.setVisible(true);
                antiguo_ingles.setVisible(false);
                antiguo_japones.setVisible(false);
                namae.setText("Nombre Completo:");
                paterno.setText("Apellido Paterno:");
                materno.setText("Apellido Materno:");
                departamento.setText("Selecciona el Departamento:");
                antiguedad.setText("Selecciona la Antigüedad:");
                resultado.setText("Resultados del Calculo:");
                res.setText("\n  Aqui aparece el resultado del calculo de las vacaciones");
                setTitle("Pantalla principal");
                foster.setText("©2023 The Crunchyroll Company | Todos los derechos reservados");
            }else if(idiomas.getSelectedItem().equals("日本語")){
                opciones.setText("オプション");
                calculo.setText("計算する");
                acerca.setText("詳細");
                fondo.setText("背景色");
                label.setText("熟語");
                calcular.setText("休日");
                aka.setText("赤");
                kuro.setText("黒");
                murasaki.setText("紫");
                nuevo.setText("新着");
                creador.setText("開発者の詳細");
                salir.setText("外出");
                bienvenida.setText("おかえり " + yuza);
                titulo.setText("休暇計算用の就業者データ");
                titulo.setBounds(170, 120, 900, 25);
                depto.setVisible(false);
                depto_ingles.setVisible(false);
                depto_japones.setVisible(true);
                antiguo.setVisible(false);
                antiguo_ingles.setVisible(false);
                antiguo_japones.setVisible(true);
                namae.setText("フルネーム:");
                paterno.setText("苗字:");
                materno.setText("母の姓:");
                departamento.setText("部門を選択:");
                antiguedad.setText("古代を選択:");
                resultado.setText("計算結果:");
                res.setText("\n  ここに結果が表示されます");
                setTitle("メインスクリーン");
                foster.setText("©2023 The Crunchyroll Company | 全著作権所有。");
            }
        }
    }

    public static void main(String[] args){
        Principal ventana = new Principal();
        ventana.setBounds(0, 0, 640, 540);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
    }
}
