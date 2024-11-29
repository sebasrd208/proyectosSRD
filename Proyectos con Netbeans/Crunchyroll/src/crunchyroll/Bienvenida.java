package crunchyroll;
 import javax.swing.border.*;
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;

 /**
 *
 * @author sebas
 */

 public class Bienvenida extends JFrame implements ActionListener, KeyListener{
    public static JComboBox menu;
    public static JLabel fondo, fondo_2, ticket, ticket2, ticket3, limite;
    public static JTextField usuario;
    public static JButton boton;
    public static String user="";

    public Bienvenida(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        ImageIcon img=new ImageIcon("src/imagenes/ico_crunchyroll.png");
        this.setIconImage(img.getImage());
        getContentPane().setBackground(new Color(255, 128, 0));
        BevelBorder kayano=new BevelBorder(0);

        menu=new JComboBox();
        menu.setBounds(10, 10, 100, 25);
        menu.setFont(new Font("Andale Mono", Font.BOLD, 10));
        menu.addItem("Español");
        menu.addItem("English");
        menu.addItem("日本語");
        menu.setBorder(kayano);
        menu.addActionListener(this);
        add(menu);

        ticket=new JLabel("Sistema de Control Vacacional");
        ticket.setBounds(35, 180, 270, 40);
        ticket.setFont(new Font("Andale Mono", 3, 18));
        ticket.setForeground(Color.white);
        add(ticket);

        ticket2=new JLabel("©2023 Crunchyroll Company");
        ticket2.setBounds(60, 400, 300, 25);
        ticket2.setFont(new Font("Andale Mono", 2, 15));
        ticket2.setForeground(Color.white);
        add(ticket2);

        ticket3=new JLabel("Ingrese su nombre:");
        ticket3.setBounds(40, 235, 300, 25);
        ticket3.setFont(new Font("Andale Mono", 1, 13));
        ticket3.setForeground(Color.white);
        add(ticket3);

        boton=new JButton("Ingresar");
        boton.setBounds(110, 295, 100, 25);
        boton.setFont(new Font("Andale Mono", 1, 12));
        boton.setBorder(kayano);
        boton.setEnabled(false);
        boton.setFocusPainted(false);
        boton.addActionListener(this);
        add(boton);

        usuario=new JTextField();
        usuario.setBounds(40, 260, 240, 25);
        usuario.setFont(new Font("Andale Mono", 1, 12));
        usuario.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        usuario.addKeyListener(this);
        usuario.setBorder(kayano);
        add(usuario);
        
        limite=new JLabel("No se permiten más de 10 carácteres");
        limite.setBounds(40, 375, 250, 25);
        limite.setFont(new Font("Andale Mono", 1, 13));
        limite.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        limite.setVisible(false);
        limite.setForeground(Color.white);
        add(limite);

        ImageIcon imagen=new ImageIcon("src/imagenes/logo.png");
        fondo=new JLabel(imagen);
        fondo.setBounds(55, 40, 250, 141);
        add(fondo);
        
    }

    @Override
    public void actionPerformed(ActionEvent s){
        if(s.getSource()==boton){
            user=usuario.getText().trim();
            if(menu.getSelectedItem().equals("Español")){
       
                 Licencia miLicencia=new Licencia();
                 miLicencia.setBounds(0, 0, 600, 392);
                 miLicencia.setVisible(true);
                 miLicencia.setResizable(false);
                 miLicencia.setLocationRelativeTo(null);
                this.setVisible(false);
                ticket.setText("TERMINOS Y CONDICIONES");
                miLicencia.ticket.setBounds(200, 30, 250, 25);
                miLicencia.info.setText("        TERMINOS Y CONDICIONES\n"
                            +"\n         A. PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE CRUNCHYROLL COMPANY."
                            +"\n         B. PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISENO DE LAS INTERFACES GRAFICAS,"
                            +"\n         C. EL DESARROLLADOR SEBASTIAN NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE."
                            +"\n\n        LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE"
                            +"\n        EL DESARROLLADOR Y AUTOR SEBASTIAN NO SE RESPONSABILIZA DEL USO QUE USTED"
                            +"\n        HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)"
                            +"\n        SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
                            +"\n\n        PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR"
                            +"\n        VISITE NUESTRAS SUCURSALES");
                    miLicencia.palomita.setText("Yo "+miLicencia.user+" Acepto");
                    miLicencia.aceptar.setText("Continuar");
                    miLicencia.no_aceptar.setText("No acepto");
                    miLicencia.setTitle("Licencias de Uso");
                    miLicencia.menu.setSelectedIndex(0);
                
            }else if(menu.getSelectedItem().equals("English")){
              
Licencia miLicencia=new Licencia();
                    miLicencia.setBounds(0, 0, 600, 392);
                    miLicencia.setVisible(true);
                    miLicencia.setResizable(false);
                    miLicencia.setLocationRelativeTo(null);
                    this.setVisible(false);
                    miLicencia.ticket.setText("Terms and Conditions");
                    miLicencia.ticket.setBounds(200, 30, 250, 25);
                    miLicencia.info.setText("        TERMS AND CONDITIONS\n"
                            +"\n         A. NO SALE OR DISTRIBUTION IS PROHIBITED WITHOUT AUTHORIZATION FROM THE CRUNCHYROLL COMPANY."
                            +"\n         B. ALTERATION OF THE SOURCE CODE OR DESIGN OF THE GRAPHIC INTERFACES IS PROHIBITED"
                            +"\n         C. THE DEVELOPER SEBASTIAN TAKES NO RESPONSIBILITY FOR THE MISUSE OF THIS SOFTWARE."
                            +"\n\n        THE LEGAL AGREEMENTS SET FORTH BELOW GOVERN YOUR USE OF THIS SOFTWARE"
                            +"\n        THE DEVELOPER AND AUTHOR SEBASTIAN TAKES NO RESPONSIBILITY FOR THE USE THAT YOU"
                            +"\n        DO WITH THIS SOFTWARE AND ITS SERVICES. TO ACCEPT THESE TERMS CLICK ON (I ACCEPT)"
                            +"\n        IF YOU DO NOT AGREE TO THESE TERMS, CLICK (I DO NOT ACCEPT) AND DO NOT USE THIS SOFTWARE."
                            +"\n\n        FOR MORE INFORMATION ABOUT OUR SERVICE PRODUCTS, PLEASE"
                            +"\n        VISIT OUR BRANCHES.");
                    miLicencia.palomita.setText("I "+miLicencia.user+" agree");
                    miLicencia.aceptar.setText("Continue");
                    miLicencia.no_aceptar.setText("Not accept");
                    miLicencia.setTitle("Use Licenses");
                    miLicencia.menu.setSelectedIndex(1);
            }else if(menu.getSelectedItem().equals("日本語")){
      
Licencia miLicencia=new Licencia();
                    miLicencia.setBounds(0, 0, 600, 392);
                    miLicencia.setVisible(true);
                    miLicencia.setResizable(false);
                    miLicencia.setLocationRelativeTo(null);
                    this.setVisible(false);
                    ticket.setText("規約と条件");
                    miLicencia.ticket.setBounds(250, 30, 250, 25);
                    miLicencia.info.setText("        規約と条件\n"
                            +"\n         A. CRUNCHYROLL COMPANY の許可なしに、販売または配布を行うことは禁じられています。."
                            +"\n         B. ソース コードまたはグラフィック インターフェースのデザインの変更は禁止されています。,"
                            +"\n         C. 開発者のセバスチャンは、このソフトウェアの誤用について一切の責任を負いません。"
                            +"\n\n        以下に定める法的契約は、このソフトウェアの使用に適用されます。"
                            +"\n        開発者であり著者であるセバスチャンは、あなたが使用することについて一切の責任を負いません。"
                            +"\n        このソフトウェアとそのサービスを使用してください。これらの条件に同意するには、[同意します] をクリックします。"
                            +"\n        これらの条件に同意しない場合は、[同意しません] をクリックして、このソフトウェアを使用しないでください。"
                            +"\n\n        当社の製品またはサービスの詳細については、"
                            +"\n        当社の支店にアクセスしてください。");
                    miLicencia.palomita.setText("私 は "+user+" 受け入れます");
                    miLicencia.aceptar.setText("続く");
                    miLicencia.no_aceptar.setText("同意しません");
                    miLicencia.setTitle("ライセンス");
                    miLicencia.menu.setSelectedIndex(2);
            }
        }else if(s.getSource()==menu){
            if(menu.getSelectedItem().equals("English")){
                ticket.setText("Vacation Control System");
                ticket.setFont(new Font("Andale Mono", 3, 18));
                ticket.setBounds(60, 180, 300, 40);
                ticket3.setText("Enter your name:");
                boton.setText("Enter");
                setTitle("Welcome");
                limite.setText("No more than 10 characters allowed");
            }else if(menu.getSelectedItem().equals("Español")){
                ticket.setText("Sistema de Control Vacacional");
                ticket.setFont(new Font("Andale Mono", 3, 18));
                ticket.setBounds(35, 180, 300, 40);
                ticket3.setText("Ingrese su nombre:");
                boton.setText("Ingresar");
                setTitle("Bienvenido");
                limite.setText("No se permiten más de 10 carácteres");
            }else if(menu.getSelectedItem().equals("日本語")){
                ticket.setText("     休暇管理系");
                ticket.setFont(new Font("Andale Mono", Font.BOLD, 18));
                ticket.setBounds(100, 180, 300, 40);
                ticket3.setText("お名前を入力してください:");
                boton.setText("入る");
                setTitle("おかえり");
                limite.setText("10文字にこれ以上は許されません");
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
        if(e.getSource()==usuario){
            String elaina=usuario.getText();
            if(elaina.equals("")){
                boton.setEnabled(false);
            }else{
                boton.setEnabled(true);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent s){
        if(s.getSource()==usuario){
            String saya=usuario.getText();
            if(saya.length()>=10){
                s.consume();
                limite.setVisible(true);
            }else{
                limite.setVisible(false);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent s){
        
    }

    public static void main(String[] args){
        
        Bienvenida ventanabienvenida=new Bienvenida();
        ventanabienvenida.setBounds(0, 0, 350, 470);
        ventanabienvenida.setVisible(true);
        ventanabienvenida.setResizable(false);
        ventanabienvenida.setLocationRelativeTo(null);
    
    }
 }
