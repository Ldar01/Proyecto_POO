/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author MARIELOS
 */
public class VentanaLogin extends JFrame implements ActionListener{
    public JPanel panel;
    public JButton btn_play;
    public JTextField txt_username;
    
    public VentanaLogin() {
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Login"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
    }
    private void iniciarComponentes() {
        crearPaneles();
        colocarBotones();
        agregarCamposTexto();
        agregarEtiquetas();
    }
    public void agregarCamposTexto(){
        txt_username= new JTextField(20);
        txt_username.setBounds(200, 150, 200, 40);
        panel.add(txt_username);

    }
    
    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }
    private void colocarBotones() {
       //BOTON DE PLAY
        btn_play = new JButton();
        btn_play.setBounds(200, 350, 200, 80);
        ImageIcon icn_play = new ImageIcon("src/Imagenes/Play.png");
        btn_play.setIcon(new ImageIcon(icn_play.getImage().getScaledInstance(btn_play.getWidth(), btn_play.getHeight(), Image.SCALE_SMOOTH)));
        btn_play.setContentAreaFilled(false);
        btn_play.setEnabled(true);
        btn_play.setBorder(null);
        btn_play.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_play.addActionListener(this); //eventos del boton
        panel.add(btn_play);
    }

    private void agregarEtiquetas() {
        //ETIQUETA TIPO TEXTO
        JLabel lbl_user = new JLabel("Username");
        lbl_user.setBounds(200, 30,1000,200);
        lbl_user.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_user.setForeground(Color.white);
        panel.add(lbl_user); //agregando la etiqueta al panel  

        
        //ETIQUETA TIPO IMAGEN
        ImageIcon img_fondo_principal = new ImageIcon("src/Imagenes/Login.jpg"); //agregando la imagen
        JLabel lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel   
    }
    public void actionPerformed(ActionEvent evento) {
        //EVENTO DEL BOTON PLAY
        if (evento.getSource() == btn_play) {
            registrarBase();
            VentanaPersonajes personajes = new VentanaPersonajes(); 
            personajes.setVisible(true);
            this.dispose();
        }
    }
    private void registrarBase(){
        String usuario = txt_username.getText();
        
    }
}
