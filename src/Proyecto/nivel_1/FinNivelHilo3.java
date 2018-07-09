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
public class FinNivelHilo3 extends Thread{
    ArrayList<Fantasma> fantasmas;
    JFrame frame;
    Laberinto2 lab2;
    
    public FinNivelHilo3(ArrayList<Fantasma> fantasmas, JFrame frame) {
        this.fantasmas = fantasmas;
        this.frame = frame;
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

        JOptionPane.showMessageDialog(null, "Felicidades! Eliminastes a todos! :D");
        frame.dispose();
    }
}
