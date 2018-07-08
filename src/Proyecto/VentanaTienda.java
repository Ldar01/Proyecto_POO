/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MARIELOS
 */
public class VentanaTienda extends JFrame implements ActionListener{
    public JPanel panel;
    public JButton btn_buy_1, btn_buy_2,btn_buy_3,btn_buy_4,btn_buy_5,btn_buy_6;
    public JLabel lbl_fondo, lbl_velocidad_1, lbl_velocidad_2,lbl_velocidad_3, lbl_arma_1, lbl_arma_2, lbl_arma_3;
    public ImageIcon img_fondo_principal, img_velocidad_1,img_velocidad_2, img_velocidad_3, img_arma_1,img_arma_2, img_arma_3,icn_buy;
 
    public VentanaTienda() {
        //tamano de la ventana
        this.setSize(1000, 750); //ancho y alto 
        this.setTitle("Tienda Ghostbusters"); //titulo de la ventana
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
        //ETIQUETA TIPO TEXTO
        JLabel lbl_nombre = new JLabel("Tienda Ghostbusters");
        lbl_nombre.setBounds(310,0,1000,50);
        lbl_nombre.setFont(new Font("Verdana", Font.BOLD, 30));
        lbl_nombre.setForeground(Color.white);
        panel.add(lbl_nombre); //agregando la etiqueta al panel 
        
        //ETIQUETAS TIPO IMAGEN
        img_velocidad_1 = new ImageIcon("src/Imagenes/velocidad1.jpg");
        lbl_velocidad_1 = new JLabel(img_velocidad_1); //agregando la etiqueta con la imgane
        lbl_velocidad_1.setBounds(90, 80, 200, 200);
        lbl_velocidad_1.setIcon(new ImageIcon(img_velocidad_1.getImage().getScaledInstance(lbl_velocidad_1.getWidth(), lbl_velocidad_1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_velocidad_1); //agregando la etiqueta al panel  
        
        img_velocidad_2 = new ImageIcon("src/Imagenes/velocidad2.jpg");
        lbl_velocidad_2= new JLabel(img_velocidad_2); //agregando la etiqueta con la imgane
        lbl_velocidad_2.setBounds(400, 80, 200, 200);
        lbl_velocidad_2.setIcon(new ImageIcon(img_velocidad_2.getImage().getScaledInstance(lbl_velocidad_2.getWidth(), lbl_velocidad_2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_velocidad_2); //agregando la etiqueta al panel 
        
        img_velocidad_3 = new ImageIcon("src/Imagenes/velocidad3.jpg");
        lbl_velocidad_3 = new JLabel(img_velocidad_3); //agregando la etiqueta con la imgane
        lbl_velocidad_3.setBounds(700, 80, 200, 200);
        lbl_velocidad_3.setIcon(new ImageIcon(img_velocidad_3.getImage().getScaledInstance(lbl_velocidad_3.getWidth(), lbl_velocidad_3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_velocidad_3); //agregando la etiqueta al panel 
       
        img_arma_1 = new ImageIcon("src/Imagenes/arma1.jpg");
        lbl_arma_1 = new JLabel(img_arma_1); //agregando la etiqueta con la imgane
        lbl_arma_1.setBounds(90, 400, 200, 200);
        lbl_arma_1.setIcon(new ImageIcon(img_arma_1.getImage().getScaledInstance(lbl_arma_1.getWidth(), lbl_arma_1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_arma_1); //agregando la etiqueta al panel 
        
        img_arma_2 = new ImageIcon("src/Imagenes/arma2.jpg");
        lbl_arma_2 = new JLabel(img_arma_2); //agregando la etiqueta con la imgane
        lbl_arma_2.setBounds(400, 400, 200, 200);
        lbl_arma_2.setIcon(new ImageIcon(img_arma_2.getImage().getScaledInstance(lbl_arma_2.getWidth(), lbl_arma_2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_arma_2); //agregando la etiqueta al panel
        
        img_arma_3 = new ImageIcon("src/Imagenes/arma3.jpg");
        lbl_arma_3 = new JLabel(img_arma_3); //agregando la etiqueta con la imgane
        lbl_arma_3.setBounds(700, 400, 200, 200);
        lbl_arma_3.setIcon(new ImageIcon(img_arma_3.getImage().getScaledInstance(lbl_arma_3.getWidth(), lbl_arma_3.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_arma_3); //agregando la etiqueta al panel
        
        //ETIQUETA TIPO IMAGEN
        img_fondo_principal = new ImageIcon("src/Imagenes/Fondo.jpg"); //agregando la imagen
        lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 750);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel 
    }
    private void colocarBotones() {
        btn_buy_1 = new JButton();
        btn_buy_1.setBounds(120, 280, 150, 100);
        icn_buy = new ImageIcon("src/Imagenes/Buy.png");
        btn_buy_1.setIcon(new ImageIcon(icn_buy.getImage().getScaledInstance(btn_buy_1.getWidth(), btn_buy_1.getHeight(), Image.SCALE_SMOOTH)));
        btn_buy_1.setContentAreaFilled(false);
        btn_buy_1.setEnabled(true);
        btn_buy_1.addActionListener(this); //eventos del boton
        panel.add(btn_buy_1);
        
        btn_buy_2 = new JButton();
        btn_buy_2.setBounds(430, 280, 150, 100);
        icn_buy = new ImageIcon("src/Imagenes/Buy.png");
        btn_buy_2.setIcon(new ImageIcon(icn_buy.getImage().getScaledInstance(btn_buy_2.getWidth(), btn_buy_2.getHeight(), Image.SCALE_SMOOTH)));
        btn_buy_2.setContentAreaFilled(false);
        btn_buy_2.setEnabled(true);
        btn_buy_2.addActionListener(this); //eventos del boton
        panel.add(btn_buy_2);
        
        btn_buy_3 = new JButton();
        btn_buy_3.setBounds(730, 280, 150, 100);
        icn_buy = new ImageIcon("src/Imagenes/Buy.png");
        btn_buy_3.setIcon(new ImageIcon(icn_buy.getImage().getScaledInstance(btn_buy_3.getWidth(), btn_buy_3.getHeight(), Image.SCALE_SMOOTH)));
        btn_buy_3.setContentAreaFilled(false);
        btn_buy_3.setEnabled(true);
        btn_buy_3.addActionListener(this); //eventos del boton
        panel.add(btn_buy_3);
        
        btn_buy_4 = new JButton();
        btn_buy_4.setBounds(120, 600, 150, 100);
        icn_buy = new ImageIcon("src/Imagenes/Buy.png");
        btn_buy_4.setIcon(new ImageIcon(icn_buy.getImage().getScaledInstance(btn_buy_4.getWidth(), btn_buy_4.getHeight(), Image.SCALE_SMOOTH)));
        btn_buy_4.setContentAreaFilled(false);
        btn_buy_4.setEnabled(true);
        btn_buy_4.addActionListener(this); //eventos del boton
        panel.add(btn_buy_4);
        
        btn_buy_5 = new JButton();
        btn_buy_5.setBounds(430, 600, 150, 100);
        icn_buy = new ImageIcon("src/Imagenes/Buy.png");
        btn_buy_5.setIcon(new ImageIcon(icn_buy.getImage().getScaledInstance(btn_buy_5.getWidth(), btn_buy_5.getHeight(), Image.SCALE_SMOOTH)));
        btn_buy_5.setContentAreaFilled(false);
        btn_buy_5.setEnabled(true);
        btn_buy_5.addActionListener(this); //eventos del boton
        panel.add(btn_buy_5);
        
        btn_buy_6 = new JButton();
        btn_buy_6.setBounds(730, 600, 150, 100);
        icn_buy = new ImageIcon("src/Imagenes/Buy.png");
        btn_buy_6.setIcon(new ImageIcon(icn_buy.getImage().getScaledInstance(btn_buy_6.getWidth(), btn_buy_6.getHeight(), Image.SCALE_SMOOTH)));
        btn_buy_6.setContentAreaFilled(false);
        btn_buy_6.setEnabled(true);
        btn_buy_6.addActionListener(this); //eventos del boton
        panel.add(btn_buy_6);
    }
    public void actionPerformed(ActionEvent evento){
        //EVENTOS DE LOS BOTONES
        if (evento.getSource() == btn_buy_1) {
            System.out.println("Comprando velocidad x3");
        }
        if (evento.getSource() == btn_buy_2) {
            System.out.println("Comprando velocidad x11");
        }
        if (evento.getSource() == btn_buy_3) {
            System.out.println("Comprando velocidad x60");
        }
        if (evento.getSource() == btn_buy_4) {
            System.out.println("Comprando arma de protones");
        }
        if (evento.getSource() == btn_buy_5) {
            System.out.println("Comprando unidad contenedora");
        }
        if (evento.getSource() == btn_buy_6) {
            System.out.println("Comprando arma de ectoplasma");
        }
    }
}
