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
    private int pos_x;//Posicion en X
    private int pos_y;//Posicion en Y
    private final int direccion;
    private ArrayList<Fantasma> fantasmas;//ArrayList de los enemigos
    private int alcance;//Longitud de la direccion de la bala
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
        while (i < alcance) {//Dependiendo del alcance
            try {
                sleep(2);
                switch(direccion){
                    case 0: pos_x++; break;// Tecla derecha la posicion del disparo estara en direccion hacia la derecha
                    case 1: pos_x--; break;//Tecla izquierda ""
                    case 2: pos_y++; break;//Tecla hacia abajo
                    case 3: pos_y--; break;//Tecla hacia arriba
                }
                
                verificarMuerteFantasma();//Verifica si ha tocado algun fantasma
                disparo.setLocation(pos_x, pos_y);//Actualiza la posicion de este
                i++;
            } catch (InterruptedException ex) {

            }

        }
        try {
            sleep(50);
            panel.remove(disparo);//Cuando llegue a su alcance se quitara ek disparo
            panel.repaint();//Se actualizara ls pantalla
            mostrarCoor(disparo);//Muestra las coordenadas
            System.out.println(fantasmas.size());
            System.out.println("---------------");
        } catch (InterruptedException ex) {
        }
        
    }
    
    //Funcion que muestra las coordenadas de un objeto
    public void mostrarCoor(JLabel objeto){
        System.out.print("("+objeto.getX()+", "+objeto.getY()+") , ");
        System.out.println("("+objeto.getX()/33+", "+objeto.getY()/33+")");
        
    }
    //Funcion que verifica si el disparo toco algun fantas,a
    public void verificarMuerteFantasma(){
        Fantasma muerto = null;
        for (Fantasma fantasma : fantasmas) {
            if(verificarColision(disparo.getX(), disparo.getY(), fantasma.getFantasma().getX(), fantasma.getFantasma().getY())){
                fantasma.matarFantasma();//Funcion de fantasma
                panel.remove(fantasma.getFantasma());//Es quitado
                muerto = fantasma;//Obtengo los datos del fantasma que fue asesinado
//                fantasmas.remove(fantasma);
                panel.repaint();//Actualiza
                System.out.println("MUERER!");
            }
        }
        fantasmas.remove(muerto);//Lo quito de la lista
    }
    //Funcion que verifica la colision entre objetos por medio de sus coordenadas
    public boolean verificarColision(int x1, int y1, int x2, int y2){
        int ancho1,ancho2,alto1,alto2;
        ancho1=ancho2=alto1=alto2=33;//Tamanio de 33 pixeles
        //primer punto a
        
//        return bx >= ax && bx<=ax+33   ;
        return ((x1)-(ancho2)<=(x2) && (x1)+(ancho1)>=(x2) && (y1)-(alto2)<=(y2) && (y1)+(alto1)>=(y2));
    }

}
