/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.nivel_1;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
//Tuvo problemas para subir sus partes en git, Yo lo ayude a subirlo
public class Fantasma extends Thread {

    private JLabel fantasma;
    private boolean estaVivo;
    private int pos_x;
    private int pos_y;
    private int desplazamiento_max = 90;
    private int desplazamiento = 0;
    private int pausa = 5;
    public Fantasma(JLabel fantasma) {
        this.fantasma = fantasma;
        estaVivo = true;
    }

    public void run() {
        while (estaVivo) {
            pos_x = fantasma.getX();
            pos_y = fantasma.getY();
            desplazamiento = 0;
            try {
                sleep(en_rango(0, 30));
                desplazamiento_max = en_rango(20, 100);
                pausa = en_rango(5, 50);
                switch (en_rango(0, 6)) {
                    case 0:
                        while (desplazamiento < desplazamiento_max) {
                            if(pos_x < 742-43)pos_x++; else break;
                            desplazamiento++;
                            fantasma.setLocation(pos_x, pos_y);
                            sleep(pausa);
                        }
                        break;
                    case 1:
                        while (desplazamiento < desplazamiento_max) {
                            if(pos_x > 0) pos_x--; else break;
                            desplazamiento++;
                            fantasma.setLocation(pos_x, pos_y);
                            sleep(pausa);
                        }
                        break;
                    case 2:
                        while (desplazamiento < desplazamiento_max) {
                            if(pos_y < 534-70) pos_y++; else break;
                            desplazamiento++;
                            fantasma.setLocation(pos_x, pos_y);
                            sleep(pausa);
                        }
                        break;
                    case 3:
                        while (desplazamiento < desplazamiento_max) {
                            if(pos_y > 0) pos_y--; else break;
                            desplazamiento++;
                            fantasma.setLocation(pos_x, pos_y);
                            sleep(pausa);
                        }
                        break;
                    case 4: sleep(500); break;
                    case 5: sleep(1000); break;
                    case 6: sleep(1500); break;
                }
                
            } catch (InterruptedException ex) {

            }

        }
    }

    public static int en_rango(int minimo, int maximo) {
        return (int) (Math.random() * (maximo + 1 - minimo) + minimo);
    }
    
    public JLabel getFantasma(){
        return this.fantasma;
    }
    public void matarFantasma(){
        estaVivo = false;
    }
    
}
