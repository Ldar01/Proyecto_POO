/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.nivel_1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Ruiz
 */
public class Disparo extends Thread {

    JLabel disparo;
    JPanel panel;
    private int pos_x;
    private int pos_y;
    private final int direccion;
    private ArrayList<Fantasma> fantasmas;
    private int alcance;
    public Disparo(JLabel disparo, int direccion, JPanel panel, ArrayList<Fantasma> fantasmas, int alcance) {
        this.alcance = alcance;
        this.disparo = disparo;
        this.panel = panel;
        this.direccion = direccion;
        this.fantasmas = fantasmas;
    }

    @Override
    public void run() {
        
        int i = 0;

        pos_x = disparo.getX();
        pos_y = disparo.getY();
        while (i < alcance) {
            try {
                sleep(2);
                switch(direccion){
                    case 0: pos_x++; break;
                    case 1: pos_x--; break;
                    case 2: pos_y++; break;
                    case 3: pos_y--; break;
                }
                
                verificarMuerteFantasma();
                disparo.setLocation(pos_x, pos_y);
                i++;
            } catch (InterruptedException ex) {

            }

        }
        try {
            sleep(50);
            panel.remove(disparo);
            panel.repaint();
            mostrarCoor(disparo);
            System.out.println(fantasmas.size());
            System.out.println("---------------");
        } catch (InterruptedException ex) {
        }
        
    }
    public void mostrarCoor(JLabel objeto){
        System.out.print("("+objeto.getX()+", "+objeto.getY()+") , ");
        System.out.println("("+objeto.getX()/33+", "+objeto.getY()/33+")");
        
    }
    public void verificarMuerteFantasma(){
        Fantasma muerto = null;
        for (Fantasma fantasma : fantasmas) {
            if(verificarColision(disparo.getX(), disparo.getY(), fantasma.getFantasma().getX(), fantasma.getFantasma().getY())){
                fantasma.matarFantasma();
                panel.remove(fantasma.getFantasma());
                muerto = fantasma;
//                fantasmas.remove(fantasma);
                panel.repaint();
                System.out.println("MUERER!");
            }
        }
        fantasmas.remove(muerto);
    }
    
    public boolean verificarColision(int x1, int y1, int x2, int y2){
        int ancho1,ancho2,alto1,alto2;
        ancho1=ancho2=alto1=alto2=33;
        //primer punto a
        
//        return bx >= ax && bx<=ax+33   ;
        return ((x1)-(ancho2)<=(x2) && (x1)+(ancho1)>=(x2) && (y1)-(alto2)<=(y2) && (y1)+(alto1)>=(y2));
    }

}
