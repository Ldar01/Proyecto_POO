/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Proyecto.nivel_1;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Ruiz
 */

//Tuvo problemas para subir sus partes en git, Yo lo ayude a subirlo
public final class Laberinto extends JFrame {

    private JPanel panel;
    private final String raiz = "src/Proyecto/nivel_1/imagenes/";
    private final int lado = 33;
    private int ancho = 10;
    private int alto = 8;
    int personaje_x = 4*lado;
    int personaje_y = 3*lado;
    private int velocidad = 3; //tiene que ser multiplo de 33  (1 3 11 33)
    
    private JLabel corazon1, corazon2, corazon3, corazon4, corazon5, corazon6;
    private int vidas = 3;
    private JLabel personaje;
    private String personaje_png;
    private JugadorHilo prueba;
   
    JLabel disparo;//Disparo
    private int direccion  = 0;
    
    ArrayList<Fantasma> fantasmas;//Fantasma
    private int cantFantasmas;
    int alcance;
    //Constructor de laberinto que tiene como parametros la cantidad de fantasmas del nivel, el personaje seleccionado
    //La velocidad en la que iran los fantasmas y el alcance de ellos
    public Laberinto(int cantFantasmas, String personaje_png, int velocidad, int alcance) {
        this.alcance = alcance;
        this.velocidad = velocidad;
        this.cantFantasmas = cantFantasmas;
        this.personaje_png = personaje_png;
        this.setTitle("Nivel 1"); //titulo de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearPaneles();
        cargarPersonaje();
        eventoMoverPersonaje();
        cargarEscenario();
        cargarCorazones();
        this.setSize(ancho * lado + 16, alto * lado+lado+6);
        System.out.println((ancho * lado + 16) +"  "+ (alto * lado+lado+6));
        this.setLocationRelativeTo(null);
        cargarFondo();
        cargarFantasmas();
        verificarFin();
        prueba = new JugadorHilo(personaje, fantasmas, panel);// <------------ Aqui puse el hilo
        prueba.start(); // <------------ Inicia :v
        setResizable(false);
    }
    //Funcion que verifica con el hilo si ya fueron asesinados todos los fantasmas
    public void verificarFin(){
        FinNivelHilo fin = new FinNivelHilo(fantasmas, this);
        fin.start();
    }
    //Funcion que alista los fanasmas
    private void cargarFantasmas(){
        fantasmas = new ArrayList();
        
        for (int i = 0; i < cantFantasmas; i++) {
            agregarFantasma(en_rango(100, 600), en_rango(100, 400));

        }
    }
    //Funcion que sirve para agregar a los fantasmas
    private void agregarFantasma(int x, int y){
        Fantasma fantasma_hilo;//El hilo del movimiento de los fantasmas
        JLabel fantasma_label = null;
        switch(en_rango(2, 2)){
            case 0: fantasma_label = cargarImagen(raiz+"arana.png", x, y); break;
            case 1: fantasma_label = cargarImagen(raiz+"calabera.png", x, y); break;
            case 2: fantasma_label = cargarImagen(raiz+"ghost.png", x, y); break;
            case 3: fantasma_label = cargarImagen(raiz+"gato.png", x, y); break;
        }
        panel.add(fantasma_label,0);
        fantasma_hilo = new Fantasma(fantasma_label);
        fantasma_hilo.start();
        
        fantasmas.add(fantasma_hilo);
    }
    
    //Funcion que coloca los corazones
    private void cargarCorazones(){
        corazon1 = cargarImagen(raiz+"heart_full.png",17*lado, 1*lado);
        panel.add(corazon1);
        corazon2 = cargarImagen(raiz+"heart_full.png",18*lado, 1*lado);
        panel.add(corazon2);
        corazon3 = cargarImagen(raiz+"heart_full.png",19*lado, 1*lado);
        panel.add(corazon3);
        
        corazon4 = cargarImagen(raiz+"heart_empty.png",17*lado, 1*lado);
        
        corazon5 = cargarImagen(raiz+"heart_empty.png",18*lado, 1*lado);
        
        corazon6 = cargarImagen(raiz+"heart_empty.png",19*lado, 1*lado);
        
    }
    //Funcion que quita los corazones llenos por corazones vacios
    private void quitarVida(){
        switch(vidas){
            case 3:
                panel.remove(corazon3);
                panel.add(corazon4);
                panel.updateUI();
                break;
            case 2:
                panel.remove(corazon2);
                panel.add(corazon5);
                panel.updateUI();
                break;
            case 1:
                panel.remove(corazon1);
                panel.add(corazon6);
                panel.updateUI();
                break;
        }
        vidas--;
    }
    
    //Eventos para mover el personaje
    private void eventoMoverPersonaje(){
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                switch(ke.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                            direccion = 1;
                            personaje_x-=velocidad;
                        break;
                    case KeyEvent.VK_RIGHT:
                            direccion = 0;
                            personaje_x+=velocidad;
                        break;
                    case KeyEvent.VK_UP:
                            direccion = 3;
                            personaje_y-=velocidad;
                        break;
                    case KeyEvent.VK_DOWN:
                            direccion = 2;
                            personaje_y+=velocidad;
                        break;
                    case KeyEvent.VK_A:
                        disparo = cargarImagen(raiz+"disparo.png", personaje_x, personaje_y);
                        panel.add(disparo,0);                     
                        Disparo p = new Disparo(disparo, direccion, panel, fantasmas, 100);
                        p.start();
                        
                        break;
                    
                }	
                personaje.setLocation(personaje_x, personaje_y);
//                mostrarCoor();
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
    }
    //Muestra las coordenadas del jugador
    void mostrarCoor(){
        System.out.println(personaje_x+" - "+personaje_y);
    }
    //Carga la imagen del personaje
    private void cargarPersonaje(){
        personaje = cargarImagen(raiz+personaje_png, personaje_x, personaje_y);
        panel.add(personaje);
    }
    //Creamos los paneles
    private void crearPaneles() {
        panel = new JPanel(); //creacion de un panel
//        add(panel);
        panel.setLayout(null);
        this.getContentPane().add(panel); //agregamos el panel a la ventana

        
    }
    //Funcion que por medio de una matriz se llena el fondo
    public void cargarEscenario(){
        char[][] matrizElementos = cargarMatriz();
        for (int i = 0; i < matrizElementos.length; i++) {
            for (int j = 0; j < matrizElementos[0].length; j++) {
                //Dependiendo de lo que se encuentre escrito en la matriz se iran poniendo las siguientes imagenes
                switch(matrizElementos[i][j]){
                    case 's': panel.add(cargarImagen(raiz + "suelo_piedra.png", j * lado, i * lado)); break;
                    case 'b': panel.add(cargarImagen(raiz + "buho.png", j * lado, i * lado)); break;
                    case 'r': panel.add(cargarImagen(raiz + "rip.png", j * lado, i * lado)); break;
                    case 'p': panel.add(cargarImagen(raiz + "piedrars.png", j * lado, i * lado)); break;
                    case 'a': panel.add(cargarImagen(raiz + "arbol.png", j * lado, i * lado)); break;
                }
            }
        }
    }
    public void cargarFondo() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                panel.add(cargarImagen(raiz + "suelo.png", j * lado, i * lado));
            }
        }
    }
    //Carga la imagen
    public JLabel cargarImagen(String ruta, int x, int y) {
        ImageIcon img = new ImageIcon(ruta); //agregando la imagen
        JLabel lbl = new JLabel(img); //agregando la etiqueta con la imgane
        lbl.setBounds(x, y, lado, lado);
        lbl.setIcon(new ImageIcon(img.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH)));
        return lbl;
    }
    //Matriz para el juego
    public char[][] cargarMatriz() {
        String data = ""
                + "                      \n"
                + "         r            \n"
                + "   b    sssssssssssss \n"
                + " ssss   s saspp    rs \n"
                + " spp   rs sss sssss s \n"
                + " ssssssssp  sss   s   \n"
                + " s     asp r  arssspp \n"
                + " sssss  sssss sss sss \n"
                + "  r  spps   sas     s \n"
                + " sss ssssss ssspsssbs \n"
                + " s sa     s    ps s s \n"
                + " s ssssssss sssrs s s \n"
                + " sr    b  ppsas s   s \n"
                + " ssssssssssss sss sss \n"
                + "                      ";
                
        String[] filas = data.split("\n");
        alto = filas.length;      
        ancho = filas[0].length();
        char[][] matriz = new char[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matriz[i][j] = filas[i].charAt(j);
            }
        }
        return matriz;
    }
    
    //Setters y Getters

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getPersonaje_x() {
        return personaje_x;
    }

    public void setPersonaje_x(int personaje_x) {
        this.personaje_x = personaje_x;
    }

    public int getPersonaje_y() {
        return personaje_y;
    }

    public void setPersonaje_y(int personaje_y) {
        this.personaje_y = personaje_y;
    }

    public JLabel getCorazon1() {
        return corazon1;
    }

    public void setCorazon1(JLabel corazon1) {
        this.corazon1 = corazon1;
    }

    public JLabel getCorazon2() {
        return corazon2;
    }

    public void setCorazon2(JLabel corazon2) {
        this.corazon2 = corazon2;
    }

    public JLabel getCorazon3() {
        return corazon3;
    }

    public void setCorazon3(JLabel corazon3) {
        this.corazon3 = corazon3;
    }

    public JLabel getCorazon4() {
        return corazon4;
    }

    public void setCorazon4(JLabel corazon4) {
        this.corazon4 = corazon4;
    }

    public JLabel getCorazon5() {
        return corazon5;
    }

    public void setCorazon5(JLabel corazon5) {
        this.corazon5 = corazon5;
    }

    public JLabel getCorazon6() {
        return corazon6;
    }

    public void setCorazon6(JLabel corazon6) {
        this.corazon6 = corazon6;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public JLabel getPersonaje() {
        return personaje;
    }

    public void setPersonaje(JLabel personaje) {
        this.personaje = personaje;
    }

    public JLabel getDisparo() {
        return disparo;
    }

    public void setDisparo(JLabel disparo) {
        this.disparo = disparo;
    }
    public static int en_rango(int minimo, int maximo) {
        return (int) (Math.random() * (maximo + 1 - minimo) + minimo);
    }

    public String getPersonaje_png() {
        return personaje_png;
    }

    public void setPersonaje_png(String personaje_png) {
        this.personaje_png = personaje_png;
    }
}
