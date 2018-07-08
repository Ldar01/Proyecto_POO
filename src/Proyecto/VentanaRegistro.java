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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author MARIELOS
 */
public class VentanaRegistro extends JFrame implements ActionListener{

    public JPanel panel;
    public JButton btn_registro;
    public JTextField txt_username;
    public JPasswordField txt_password;

    public VentanaRegistro() {
        this.setSize(1000, 650); //ancho y alto 
        this.setTitle("Registro"); //titulo de la ventana
        this.setLocationRelativeTo(null); //la ventana al centro
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //boton de cierre, termina la ejecucion del programa
    }

    private void iniciarComponentes() {
        crearPaneles();
        agregarCamposTexto();
        colocarBotones();
        agregarEtiquetas();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
        this.getContentPane().add(panel); //agregamos el panel a la ventana
        panel.setLayout(null);
    }
    public void agregarCamposTexto(){
        txt_username= new JTextField(20);
        txt_username.setBounds(200, 150, 200, 40);
        panel.add(txt_username);
        
        txt_password = new JPasswordField(20);
        txt_password.setBounds(200, 270, 200, 40);
        panel.add(txt_password);
    }
    private void agregarEtiquetas() {
        JLabel lbl_user = new JLabel("Username");
        lbl_user.setBounds(200, 30,1000,200);
        lbl_user.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_user.setForeground(Color.white);
        panel.add(lbl_user); //agregando la etiqueta al panel  
        
        JLabel lbl_password = new JLabel("Password");
        lbl_password.setBounds(200, 150,1000,200);
        lbl_password.setFont(new Font("Verdana", Font.BOLD, 20));
        lbl_password.setForeground(Color.white);
        panel.add(lbl_password); //agregando la etiqueta al panel 
        
        //ETIQUETA TIPO IMAGEN
        ImageIcon img_fondo_principal = new ImageIcon("src/Imagenes/Login.jpg"); //agregando la imagen
        JLabel lbl_fondo = new JLabel(img_fondo_principal); //agregando la etiqueta con la imgane
        lbl_fondo.setBounds(0, 0, 1000, 607);
        lbl_fondo.setIcon(new ImageIcon(img_fondo_principal.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lbl_fondo); //agregando la etiqueta al panel   
    }
    private void colocarBotones() {
        btn_registro = new JButton();
        btn_registro.setBounds(200, 350, 200, 80);
        ImageIcon icn_registro = new ImageIcon("src/Imagenes/Crear_Seccion.jpg");
        btn_registro.setIcon(new ImageIcon(icn_registro.getImage().getScaledInstance(btn_registro.getWidth(), btn_registro.getHeight(), Image.SCALE_SMOOTH)));
        btn_registro.setContentAreaFilled(false);
        btn_registro.addActionListener(this); //eventos del boton
        panel.add(btn_registro);
    }
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btn_registro) {
            registrarBase();
        }
    }
    private void registrarBase(){
        String usuario = txt_username.getText();
        String password = txt_password.getText();
        
        if(usuario.length() == 0 || password.length() == 0){
           JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        }else{
            System.out.println(usuario);
            System.out.println(password);
            int respuesta = JOptionPane.showConfirmDialog(this, "Se registro correctamente");
            if(JOptionPane.OK_OPTION == respuesta){
                VentanaPrincipal principal = new VentanaPrincipal(); 
                principal.setVisible(true);
                this.dispose();        
            }
        }
    }
}
