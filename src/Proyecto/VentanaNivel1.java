/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MARIELOS
 */
public class VentanaNivel1 extends JFrame  {
    public JPanel panel;
    
    public VentanaNivel1() {
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Nivel 1"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
    }
    private void iniciarComponentes() {
      crearPaneles();
      agregarEtiquetas();
    }
     private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }
     private void agregarEtiquetas() { 
        ImageIcon img_reloj = new ImageIcon("src/Imagenes/Reloj.png"); //agregando la imagen
        JLabel lbl_tiempo = new JLabel(img_reloj);
        lbl_tiempo.setBounds(10, 2, 40, 40);
        lbl_tiempo.setIcon(new ImageIcon(img_reloj.getImage().getScaledInstance(lbl_tiempo.getWidth(), lbl_tiempo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_tiempo);
        
        ImageIcon img_copa = new ImageIcon("src/Imagenes/Rayo.png"); //agregando la imagen
        JLabel lbl_recolectar = new JLabel(img_copa);
        lbl_recolectar.setBounds(450, 2, 60, 50);
        lbl_recolectar.setIcon(new ImageIcon(img_copa.getImage().getScaledInstance(lbl_recolectar.getWidth(), lbl_recolectar.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_recolectar);
        
        ImageIcon img_corazon = new ImageIcon("src/Imagenes/Corazon.png"); //agregando la imagen
        JLabel lbl_vida = new JLabel(img_corazon);
        lbl_vida.setBounds(800, 2, 50, 50);
        lbl_vida.setIcon(new ImageIcon(img_corazon.getImage().getScaledInstance(lbl_vida.getWidth(), lbl_vida.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_vida);
        
        //ETIQUETA TIPO IMAGEN
        ImageIcon img_fondo_principal = new ImageIcon("src/Imagenes/Nivel1.png"); //agregando la imagen
        JLabel lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel   
    }
}
