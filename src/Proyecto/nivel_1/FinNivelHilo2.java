/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Proyecto.nivel_1;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class FinNivelHilo2 extends Thread {
    ArrayList<Fantasma> fantasmas;
    //JFrame frame;
    Laberinto2 lab2;
    
    public FinNivelHilo2(ArrayList<Fantasma> fantasmas, Laberinto2 lab2_) {
        this.fantasmas = fantasmas;
        this.lab2 = lab2_;
        System.out.println(fantasmas.size());
    }

    @Override
    public void run() {
        try {
            while (fantasmas.size() > 0) {
                sleep(10);
            }
        } catch (InterruptedException ex) {

        }

        JOptionPane.showMessageDialog(null, "Lo lograste! Ahora el ultimo nivel te espera");
        Laberinto3 lab3 = new Laberinto3(40, lab2.getPersonaje_png(), 33, 20);
        lab3.setVisible(true);
        lab2.dispose();
    }
}
