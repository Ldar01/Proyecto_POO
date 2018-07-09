/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Proyecto.nivel_1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Ruiz
 */
//Tuvo problemas para subir sus partes en git, Yo lo ayude a subirlo
public class JugadorHilo extends Thread{
    private JLabel jugador;
    private JFrame ventana;
    private boolean EstaVivo;
    private int Vida = 300;
    JPanel panel;
    private ArrayList<Fantasma> fantasmas;

    public JugadorHilo(JLabel jugador, ArrayList<Fantasma> ghosts, JPanel panel) {
        this.jugador = jugador;
        this.fantasmas = ghosts;
        this.panel = panel;
        EstaVivo = true;
    }
    
    @Override
     public void run(){
         //Mientras el jugador este vivo
         while(EstaVivo){
             try {
                 sleep(20);
             } catch (InterruptedException ex) {
                 //Logger.getLogger(JugadorHilo.class.getName()).log(Level.SEVERE, null, ex);
             }
             if(!verificarMuerteJugador()){
                 this.panel.remove(jugador);//Aqui es cuando el jugador muere y es quitado de la ventana
                 this.panel.updateUI();
                 this.setEstaVivo(false); 
             }
         }
     }
     //Funcion que verifica si el jugador fue tocado
    public boolean verificarMuerteJugador(){

        for (Fantasma fantasma : fantasmas) {
            if(verificarColision(this.jugador.getX(), this.jugador.getY(), fantasma.getFantasma().getX(), fantasma.getFantasma().getY())){
                System.out.println("Huy me tocaron");
                if(this.Vida != 0){
                    this.setVida(this.Vida-1);
                    return true;
                }
               
            }
        }
        if(this.Vida == 0){
            
//            this.panel.remove(jugador);
//            this.panel.updateUI();
            return false;
        }
       return true; 
    }
    //Funcion que verifica colision por medio de coordenadas
    public boolean verificarColision(int x1, int y1, int x2, int y2){
        int ancho1,ancho2,alto1,alto2;
        ancho1=ancho2=alto1=alto2=33;

        return ((x1)-(ancho2)<=(x2) && (x1)+(ancho1)>=(x2) && (y1)-(alto2)<=(y2) && (y1)+(alto1)>=(y2));
    }
    //Setters y Getters
    public boolean isVivo() {
        return EstaVivo;
    }

    public void setEstaVivo(boolean EstaVivo) {
        this.EstaVivo = EstaVivo;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }
     
}

