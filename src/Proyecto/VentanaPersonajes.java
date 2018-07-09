/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import Proyecto.nivel_1.Laberinto;
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
public class VentanaPersonajes extends JFrame implements ActionListener{
    public JPanel panel;
    public JButton btn_personaje1_peter,btn_personaje2_mary;
    private String nombre_Personaje;
    //Donde se inicializa
    public VentanaPersonajes() {
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Seleccion de Personajes"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
    }
    //Iniciamos los componentes
    private void iniciarComponentes() {
        crearPaneles();
        colocarBotones();
        agregarEtiquetas();
    }
    //Se crea el panel
    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }
    //Se agregan las etiquetas
    private void agregarEtiquetas() {
        //ETIQUETA TIPO IMAGEN
        ImageIcon img_fondo_principal = new ImageIcon("src/Imagenes/Personajes.jpg"); //agregando la imagen
        JLabel lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel   
    }
    //Colocamos botones
    private void colocarBotones() {
        //BOTON DE PERSONAJE1
        btn_personaje1_peter = new JButton();
        btn_personaje1_peter.setBounds(200, 480, 240, 57);
        ImageIcon icn_peter = new ImageIcon("src/Imagenes/Peter.png");
        btn_personaje1_peter.setIcon(new ImageIcon(icn_peter.getImage().getScaledInstance(btn_personaje1_peter.getWidth(), btn_personaje1_peter.getHeight(), Image.SCALE_SMOOTH)));
        btn_personaje1_peter.setContentAreaFilled(false);
        btn_personaje1_peter.setEnabled(true);
        btn_personaje1_peter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_personaje1_peter.addActionListener(this); //eventos del boton
        btn_personaje1_peter.setBorder(null);
        panel.add(btn_personaje1_peter);
        
        //BOTON DE PERSONAJE2
        btn_personaje2_mary = new JButton();
        btn_personaje2_mary.setBounds(580, 480, 240, 57);
        ImageIcon icn_mary = new ImageIcon("src/Imagenes/Mary.png");
        btn_personaje2_mary.setIcon(new ImageIcon(icn_mary.getImage().getScaledInstance(btn_personaje2_mary.getWidth(), btn_personaje2_mary.getHeight(), Image.SCALE_SMOOTH)));
        btn_personaje2_mary.setContentAreaFilled(false);
        btn_personaje2_mary.setEnabled(true);
        btn_personaje2_mary.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_personaje2_mary.addActionListener(this); //eventos del boton
        btn_personaje2_mary.setBorder(null);
        panel.add(btn_personaje2_mary);
        
    }
    //Eventos del boton
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL LOS BOTONES DE LOS PERSONAJES
        if (evento.getSource() == btn_personaje1_peter) {
            this.nombre_Personaje = "MCNormal.png";
           (new Laberinto(10, "MCNormal.png", 33, 20)).setVisible(true);
           this.dispose();   
        }
        if (evento.getSource() == btn_personaje2_mary) {
           Laberinto nivel1 = new Laberinto(10, "FCNormal.png", 33, 20);
           this.nombre_Personaje = "FCNormal.png";
           nivel1.setVisible(true);         
           this.dispose();   
        }
    }

    public String getNombre_Personaje() {
        return nombre_Personaje;
    }
}
