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
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class FinNivelHilo extends Thread {

    ArrayList<Fantasma> fantasmas;
    //JFrame frame;
    Laberinto lab;

    public FinNivelHilo(ArrayList<Fantasma> fantasmas, Laberinto lab) {
        this.fantasmas = fantasmas;
        this.lab = lab;
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

        JOptionPane.showMessageDialog(null, "Genial!, El nivel 2 te espera");
        Laberinto2 nivel_2 = new Laberinto2(20,lab.getPersonaje_png(),33,20);
        nivel_2.setVisible(true);
        lab.dispose();
    }
}
