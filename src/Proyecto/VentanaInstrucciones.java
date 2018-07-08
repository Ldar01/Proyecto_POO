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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MARIELOS
 */
public class VentanaInstrucciones extends JFrame implements ActionListener{
    public JPanel panel;
    public JButton btn_regresar;

    public VentanaInstrucciones() {
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Instrucciones"); //titulo de la ventana
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
        ImageIcon img_fondo_principal = new ImageIcon("src/Imagenes/Ghostbusters2.jpg"); //agregando la imagen
        JLabel lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel   
    }
    private void colocarBotones() {
        //BOTON DE ATRAS
        btn_regresar = new JButton();
        btn_regresar.setBounds(5, 5, 110, 110);
        ImageIcon ico_atras = new ImageIcon("src/Imagenes/Atras.png");
        btn_regresar.setIcon(new ImageIcon(ico_atras.getImage().getScaledInstance(btn_regresar.getWidth(), btn_regresar.getHeight(), Image.SCALE_SMOOTH)));
        btn_regresar.setContentAreaFilled(false);
        btn_regresar.setEnabled(true);
        btn_regresar.addActionListener(this); //eventos del boton
        panel.add(btn_regresar);
    }
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON DE ATRAS
        if (evento.getSource() == btn_regresar) {
            VentanaPrincipal principal = new VentanaPrincipal(); 
            principal.setVisible(true);
            this.dispose();
        }
    }
}
