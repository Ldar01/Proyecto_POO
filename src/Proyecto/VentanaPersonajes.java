/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

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

    public VentanaPersonajes() {
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Seleccion de Personajes"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
    }

    private void iniciarComponentes() {
        crearPaneles();
        colocarBotones();
        agregarEtiquetas();
    }

    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }

    private void agregarEtiquetas() {
        //ETIQUETA TIPO IMAGEN
        ImageIcon img_fondo_principal = new ImageIcon("src/Imagenes/Personajes.jpg"); //agregando la imagen
        JLabel lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel   
    }
    private void colocarBotones() {
        //BOTON DE PERSONAJE1
        btn_personaje1_peter = new JButton();
        btn_personaje1_peter.setBounds(200, 480, 240, 57);
        ImageIcon icn_peter = new ImageIcon("src/Imagenes/Peter.png");
        btn_personaje1_peter.setIcon(new ImageIcon(icn_peter.getImage().getScaledInstance(btn_personaje1_peter.getWidth(), btn_personaje1_peter.getHeight(), Image.SCALE_SMOOTH)));
        btn_personaje1_peter.setContentAreaFilled(false);
        btn_personaje1_peter.setEnabled(true);
        btn_personaje1_peter.addActionListener(this); //eventos del boton
        panel.add(btn_personaje1_peter);
        
        //BOTON DE PERSONAJE2
        btn_personaje2_mary = new JButton();
        btn_personaje2_mary.setBounds(580, 480, 240, 57);
        ImageIcon icn_mary = new ImageIcon("src/Imagenes/Mary.png");
        btn_personaje2_mary.setIcon(new ImageIcon(icn_mary.getImage().getScaledInstance(btn_personaje2_mary.getWidth(), btn_personaje2_mary.getHeight(), Image.SCALE_SMOOTH)));
        btn_personaje2_mary.setContentAreaFilled(false);
        btn_personaje2_mary.setEnabled(true);
        btn_personaje2_mary.addActionListener(this); //eventos del boton
        panel.add(btn_personaje2_mary);
        
    }
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL LOS BOTONES DE LOS PERSONAJES
        if (evento.getSource() == btn_personaje1_peter) {
           VentanaNivel1 ventana1 = new VentanaNivel1(); 
           ventana1.setVisible(true);
           this.dispose();   
        }
        if (evento.getSource() == btn_personaje2_mary) {
           VentanaNivel1 ventana1 = new VentanaNivel1(); 
           ventana1.setVisible(true);
           this.dispose();   
        }
    }
}
