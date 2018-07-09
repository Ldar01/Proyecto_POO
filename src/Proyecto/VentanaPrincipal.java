/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author MARIELOS
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    public JPanel panel;
    public JButton btn_inicio, btn_instru,btn_user;
    public JLabel lbl_fondo, lbl_inicio;
    public ImageIcon img_fondo_principal,icn_inicio, icn_user, icn_indicaciones;
 
    public VentanaPrincipal() {
        //tamano de la ventana
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Ghostbusters"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
        Sonido();
        setResizable(false);
    }
    //Inicializamos los componentes
    private void iniciarComponentes() {
        crearPaneles();
        colocarBotones();
        agregarEtiquetas();
    }
    //Creamos el panel donde estaran las cosas
    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }
    //Agregamos las etiquetas
    private void agregarEtiquetas() {
        //ETIQUETA TIPO IMAGEN
        img_fondo_principal = new ImageIcon("src/Imagenes/Ghostbusters.jpg"); //agregando la imagen
        lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel    
    }
    //Colocamos los botones
    private void colocarBotones() {
        //BOTON DE INICIAR SECCION
        btn_inicio = new JButton();
        btn_inicio.setBounds(440, 450, 200, 80);
        icn_inicio = new ImageIcon("src/Imagenes/Play.PNG");
        btn_inicio.setIcon(new ImageIcon(icn_inicio.getImage().getScaledInstance(btn_inicio.getWidth(), btn_inicio.getHeight(), Image.SCALE_SMOOTH)));
        btn_inicio.setContentAreaFilled(false);
        btn_inicio.setEnabled(true);
        btn_inicio.setBorder(null);
        btn_inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_inicio.addActionListener(this); //eventos del boton
        panel.add(btn_inicio);

        //BOTON DE INSTRUCCIONES
        btn_instru = new JButton();
        btn_instru.setBounds(5, 5, 200, 100);
        icn_indicaciones = new ImageIcon("src/Imagenes/Indicaciones.png");
        btn_instru.setIcon(new ImageIcon(icn_indicaciones.getImage().getScaledInstance(btn_instru.getWidth(), btn_instru.getHeight(), Image.SCALE_SMOOTH)));
        btn_instru.setContentAreaFilled(false);
        btn_instru.setEnabled(true);
        btn_instru.setBorder(null);
        btn_instru.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_instru.addActionListener(this); //eventos del boton
        panel.add(btn_instru);
       
    }
    //Eventos del boton
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON INICIO SECCION
        if (evento.getSource() == btn_inicio) {
            VentanaLogin login = new VentanaLogin(); 
            login.setVisible(true);
            this.dispose();
        }
        //EVENTO DEL BOTON INSTRUCCIONES
        if (evento.getSource() == btn_instru) {
            VentanaInstrucciones instrucciones = new VentanaInstrucciones(); 
            instrucciones.setVisible(true);
            this.dispose();
        }

    }
    //Agregamos sonido
    public void Sonido(){
        AudioClip audio; //Importamos AudioClip que es una interfaz que nos permite poner sonidos
        audio = Applet.newAudioClip(getClass().getResource("Ghostbusters.wav"));//Obtenemos de donde es el archivo
        audio.loop();//Hacemos que se repita una y otra vez
    }
}
