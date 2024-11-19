package crunchyroll;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author sebas
 */
public class Licencia extends JFrame implements ActionListener{

    public static JComboBox menu;
    public static JLabel ticket, logo, personaje;
    public static JCheckBox palomita;
    public static JButton aceptar, no_aceptar;
    public static JTextArea info;
    public static JScrollPane scroll;
    public static String user="";

    public Licencia(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencias de Uso");
        user=Bienvenida.user;
        ImageIcon img=new ImageIcon("src/imagenes/ico_crunchyroll.png");
        this.setIconImage(img.getImage());
        BevelBorder border=new BevelBorder(0);

        menu=new JComboBox();
        menu.setBounds(10, 10, 100, 25);
        menu.setFont(new Font("Andale Mono", Font.BOLD, 10));
        menu.addItem("Español");
        menu.addItem("English");
        menu.addItem("日本語");
        menu.setOpaque(true);
        menu.setBorder(border);
        menu.addActionListener(this);
        add(menu);

        ticket=new JLabel("TÉRMINOS Y CONDICIONES");
        ticket.setBounds(200, 30, 250, 25);
        ticket.setFont(new Font("Andale Mono", 1, 15));
        add(ticket);

        info=new JTextArea();
        info.setFont(new Font("Andale Mono", 4, 10));
        info.setText("        TÉRMINOS Y CONDICIONES\n"
                +"\n         A PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE CRUNCHYROLL COMPANY."
                +"\n         B. PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISENO DE LAS INTERFACES GRAFICAS,"
                +"\n         C. EL DESARROLLADOR SEBASTIAN NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE."
                +"\n\n        LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE"
                +"\n        EL DESARROLLADOR Y AUTOR SEBASTIAN NO SE RESPONSABILIZA DEL USO QUE USTED"
                +"\n        HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)"
                +"\n        SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
                +"\n\n        PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR"
                +"\n        VISITE NUESTRAS SUCURSALES");
        info.setEditable(false);
        info.setBorder(border);
        scroll=new JScrollPane(info);
        scroll.setBounds(10, 60, 570, 200);
        add(scroll);

        palomita=new JCheckBox("Yo "+user+" Acepto");
        palomita.setBounds(10, 270, 200, 25);        
        palomita.setFont(new Font("Andale Mono", 1, 12));
        palomita.setFocusPainted(false);
        palomita.setBorder(border);
        palomita.addActionListener(this);
        add(palomita);

        aceptar=new JButton("Continuar");
        aceptar.setBounds(10, 300, 100, 25);
        aceptar.setBorder(border);
        aceptar.setFocusPainted(false);
        aceptar.setEnabled(false);
        aceptar.setFont(new Font("Andale Mono", 1, 12));
        aceptar.addActionListener(this);
        add(aceptar);

        no_aceptar=new JButton("No acepto");
        no_aceptar.setBounds(120, 300, 100, 25);
        no_aceptar.setBorder(border);
        no_aceptar.setFocusPainted(false);
        no_aceptar.setFont(new Font("Andale Mono", 1, 12));
        no_aceptar.addActionListener(this);
        add(no_aceptar);
        
        ImageIcon imagen=new ImageIcon("src/imagenes/Crunchyroll (1).png");
        logo=new JLabel(imagen);
        logo.setBounds(330, 280, 148, 29);
        add(logo);
        
        ImageIcon anime=new ImageIcon("src/imagenes/img.png");
        personaje=new JLabel(anime);
        personaje.setBounds(450, 250, 118, 100);
        add(personaje);
    }

    public void actionPerformed(ActionEvent s){
        if(s.getSource()==aceptar){
            Principal ventana=new Principal();
            ventana.setBounds(0, 0, 640, 540);
            ventana.setVisible(true);
            ventana.setResizable(false);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
            if(menu.getSelectedItem().equals("Español")){
                ventana.opciones.setText("Opciones");
                ventana.calculo.setText("Calcular");
                ventana.acerca.setText("Acerca De");
                ventana.fondo.setText("Colores de Fondo");
                ventana.label.setText("Idioma");
                ventana.calcular.setText("Vacaciones");
                ventana.aka.setText("Rojo");
                ventana.kuro.setText("Negro");
                ventana.murasaki.setText("Morado");
                ventana.nuevo.setText("Nuevo");
                ventana.creador.setText("Datos del Desarrollador");
                ventana.salir.setText("Salir");
                ventana.bienvenida.setText("Bienvenido "+ventana.yuza);
                ventana.titulo.setText("Datos del Trabajador para el calculo de vacaciones");
                ventana.titulo.setBounds(45, 120, 900, 25);
                ventana.namae.setText("Nombre Completo:");
                ventana.paterno.setText("Apellido Paterno:");
                ventana.materno.setText("Apellido Materno:");
                ventana.departamento.setText("Selecciona el Departamento:");
                ventana.antiguedad.setText("Selecciona la Antigüedad:");
                ventana.resultado.setText("Resultados del Calculo:");
                ventana.res.setText("\n  Aqui aparece el resultado del calculo de las vacaciones");
                ventana.setTitle("Pantalla principal");
                ventana.foster.setText("©2023 The Crunchyroll Company | Todos los derechos reservados");
                ventana.idiomas.setSelectedIndex(0);
            }else if(menu.getSelectedItem().equals("English")){
                ventana.opciones.setText("Options");
                ventana.calculo.setText("Calculate");
                ventana.acerca.setText("About");
                ventana.fondo.setText("Background colors");
                ventana.label.setText("Language");
                ventana.calcular.setText("Vacations");
                ventana.aka.setText("Red");
                ventana.kuro.setText("Black");
                ventana.murasaki.setText("Purple");
                ventana.nuevo.setText("New");
                ventana.creador.setText("Developer Details");
                ventana.salir.setText("Exit");
                ventana.bienvenida.setText("Welcome "+ventana.yuza);
                ventana.titulo.setText("Worker Data for Vacation Calculation");
                ventana.titulo.setBounds(150, 120, 900, 25);
                ventana.namae.setText("Full Name:");
                ventana.paterno.setText("Last Name:");
                ventana.materno.setText("Mother's Last Name:");
                ventana.departamento.setText("Select the Department:");
                ventana.antiguedad.setText("Select the Age:");
                ventana.resultado.setText("Calculation Results:");
                ventana.res.setText("\n  Here is the result of the vacation calculation");
                ventana.setTitle("Main Screen");
                ventana.foster.setText("©2023 The Crunchyroll Company | All rights reserved");
                ventana.idiomas.setSelectedIndex(1);
            }else if(menu.getSelectedItem().equals("日本語")){
                ventana.opciones.setText("オプション");
                ventana.calculo.setText("計算する");
                ventana.acerca.setText("詳細");
                ventana.fondo.setText("背景色");
                ventana.label.setText("熟語");
                ventana.calcular.setText("休日");
                ventana.aka.setText("赤");
                ventana.kuro.setText("黒");
                ventana.murasaki.setText("紫");
                ventana.nuevo.setText("新着");
                ventana.creador.setText("開発者の詳細");
                ventana.salir.setText("外出");
                ventana.bienvenida.setText("おかえり "+ventana.yuza);
                ventana.titulo.setText("休暇計算用の就業者データ");
                ventana.titulo.setBounds(170, 120, 900, 25);
                ventana.namae.setText("フルネーム:");
                ventana.paterno.setText("苗字:");
                ventana.materno.setText("母の姓:");
                ventana.departamento.setText("部門を選択:");
                ventana.antiguedad.setText("古代を選択:");
                ventana.resultado.setText("計算結果:");
                ventana.res.setText("\n  ここに結果が表示されます");
                ventana.setTitle("メインスクリーン");
                ventana.foster.setText("©2023 The Crunchyroll Company | 全著作権所有。");
                ventana.idiomas.setSelectedIndex(2);
            }
        }else if(s.getSource()==no_aceptar){
            if(menu.getSelectedItem().equals("Español")){
                Bienvenida ventanabienvenida=new Bienvenida();
                ventanabienvenida.setBounds(0, 0, 350, 470);
                ventanabienvenida.setVisible(true);
                ventanabienvenida.setResizable(false);
                ventanabienvenida.setLocationRelativeTo(null);
                this.setVisible(false);
                ventanabienvenida.ticket.setText("Sistema de Control Vacacional");
                ventanabienvenida.ticket.setFont(new Font("Andale Mono", 3, 18));
                ventanabienvenida.ticket.setBounds(35, 180, 300, 40);
                ventanabienvenida.ticket3.setText("Ingrese su nombre:");
                ventanabienvenida.boton.setText("Ingresar");
                ventanabienvenida.setTitle("Bienvenido");
                ventanabienvenida.limite.setText("No se permiten más de 10 carácteres");
                ventanabienvenida.menu.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Entonces con todo respeto"
                    +"\nVayase mucho a la verga", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }else if(menu.getSelectedItem().equals("English")){
                Bienvenida ventanabienvenida=new Bienvenida();
                ventanabienvenida.setBounds(0, 0, 350, 470);
                ventanabienvenida.setVisible(true);
                ventanabienvenida.setResizable(false);
                ventanabienvenida.setLocationRelativeTo(null);
                this.setVisible(false);
                ventanabienvenida.ticket.setText("Vacation Control System");
                ventanabienvenida.ticket.setFont(new Font("Andale Mono", 3, 18));
                ventanabienvenida.ticket.setBounds(60, 180, 300, 40);
                ventanabienvenida.ticket3.setText("Enter your name:");
                ventanabienvenida.boton.setText("Enter");
                ventanabienvenida.setTitle("Welcome");
                ventanabienvenida.menu.setSelectedIndex(1);
                ventanabienvenida.limite.setText("No more than 10 characters allowed");
                JOptionPane.showMessageDialog(null, "So with all respect"
                    +"\nFuck you");
            }else if(menu.getSelectedItem().equals("日本語")){
                Bienvenida ventanabienvenida=new Bienvenida();
                ventanabienvenida.setBounds(0, 0, 350, 470);
                ventanabienvenida.setVisible(true);
                ventanabienvenida.setResizable(false);
                ventanabienvenida.setLocationRelativeTo(null);
                this.setVisible(false);
                ventanabienvenida.ticket.setText("     休暇管理系");
                ventanabienvenida.ticket.setFont(new Font("Andale Mono", Font.BOLD, 18));
                ventanabienvenida.ticket.setBounds(100, 180, 300, 40);
                ventanabienvenida.ticket3.setText("お名前を入力してください:");
                ventanabienvenida.boton.setText("入る");
                ventanabienvenida.setTitle("おかえり");
                ventanabienvenida.menu.setSelectedIndex(2);
                ventanabienvenida.limite.setText("10文字にこれ以上は許されません");
                JOptionPane.showMessageDialog(null, "だから敬意を込めて"
                    +"\nくたばれ", "メッセージ", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(s.getSource()==palomita){
            if(palomita.isSelected()){
                aceptar.setEnabled(true);
                no_aceptar.setEnabled(false);
            }else{
                aceptar.setEnabled(false);
                no_aceptar.setEnabled(true);
            }
        }else if(s.getSource()==menu){
            if(menu.getSelectedItem().equals("English")){
                ticket.setText("Terms and Conditions");
                ticket.setBounds(200, 30, 250, 25);
                info.setText("        TERMS AND CONDITIONS\n"
                        +"\n         A. NO SALE OR DISTRIBUTION IS PROHIBITED WITHOUT AUTHORIZATION FROM THE CRUNCHYROLL COMPANY."
                        +"\n         B. ALTERATION OF THE SOURCE CODE OR DESIGN OF THE GRAPHIC INTERFACES IS PROHIBITED"
                        +"\n         C. THE DEVELOPER SEBASTIAN TAKES NO RESPONSIBILITY FOR THE MISUSE OF THIS SOFTWARE."
                        +"\n\n        THE LEGAL AGREEMENTS SET FORTH BELOW GOVERN YOUR USE OF THIS SOFTWARE"
                        +"\n        THE DEVELOPER AND AUTHOR SEBASTIAN TAKES NO RESPONSIBILITY FOR THE USE THAT YOU"
                        +"\n        DO WITH THIS SOFTWARE AND ITS SERVICES. TO ACCEPT THESE TERMS CLICK ON (I ACCEPT)"
                        +"\n        IF YOU DO NOT AGREE TO THESE TERMS, CLICK (I DO NOT ACCEPT) AND DO NOT USE THIS SOFTWARE."
                        +"\n\n        FOR MORE INFORMATION ABOUT OUR SERVICE PRODUCTS, PLEASE"
                        +"\n        VISIT OUR BRANCHES.");
                palomita.setText("I "+user+" agree");
                aceptar.setText("Continue");
                no_aceptar.setText("Not accept");
                setTitle("Use Licenses");
            }else if(menu.getSelectedItem().equals("Español")){
                ticket.setText("TERMINOS Y CONDICIONES");
                ticket.setBounds(200, 30, 250, 25);
                info.setText("        TERMINOS Y CONDICIONES\n"
                        + "\n         A. PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE CRUNCHYROLL COMPANY."
                        + "\n         B. PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISENO DE LAS INTERFACES GRAFICAS,"
                        + "\n         C. EL DESARROLLADOR SEBASTIAN NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE."
                        + "\n\n        LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE"
                        + "\n        EL DESARROLLADOR Y AUTOR SEBASTIAN NO SE RESPONSABILIZA DEL USO QUE USTED"
                        + "\n        HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)"
                        + "\n        SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
                        + "\n\n        PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR"
                        + "\n        VISITE NUESTRAS SUCURSALES");
                palomita.setText("Yo "+user+" Acepto");
                aceptar.setText("Continuar");
                no_aceptar.setText("No acepto");
                setTitle("Licencias de Uso");
            }else if(menu.getSelectedItem().equals("日本語")){
                ticket.setText("規約と条件");
                ticket.setBounds(250, 30, 250, 25);
                info.setText("        規約と条件\n"
                        + "\n         A. CRUNCHYROLL COMPANY の許可なしに、販売または配布を行うことは禁じられています。."
                        + "\n         B. ソース コードまたはグラフィック インターフェースのデザインの変更は禁止されています。,"
                        + "\n         C. 開発者のセバスチャンは、このソフトウェアの誤用について一切の責任を負いません。"
                        + "\n\n        以下に定める法的契約は、このソフトウェアの使用に適用されます。"
                        + "\n        開発者であり著者であるセバスチャンは、あなたが使用することについて一切の責任を負いません。"
                        + "\n        このソフトウェアとそのサービスを使用してください。これらの条件に同意するには、[同意します] をクリックします。"
                        + "\n        これらの条件に同意しない場合は、[同意しません] をクリックして、このソフトウェアを使用しないでください。"
                        + "\n\n        当社の製品またはサービスの詳細については、"
                        + "\n        当社の支店にアクセスしてください。");
                palomita.setText("私 は "+user+" 受け入れます");
                aceptar.setText("続く");
                no_aceptar.setText("同意しません");
                setTitle("ライセンス");
            }
        }
    }

    public static void main(String[] args){
        Licencia miLicencia=new Licencia();
        miLicencia.setBounds(0, 0, 600, 392);
        miLicencia.setVisible(true);
        miLicencia.setResizable(false);
        miLicencia.setLocationRelativeTo(null);

    }
}
