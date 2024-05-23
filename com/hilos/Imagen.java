package com.hilos;

import java.awt.*;
import javax.swing.JFrame;

public class Imagen extends JFrame implements Runnable{
    
    private int alto = 75, ancho = 75;
    private int [] posX = {150,150,150};
    private int [] posY = {50,125,200};
    private int [][] dir = {{6,4},{7,5},{3,6}};
    
    public Imagen(){
        super("Hilos");
        setSize(350,350);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(200,50,120));
        g.fillOval(posX[0], posY[0], alto, ancho);
        g.setColor(new Color(120,50,200));
        g.fillOval(posX[1], posY[1], alto, ancho);
        g.setColor(new Color(50,120,200));
        g.fillOval(posX[2], posY[2], alto, ancho);
    }
    
    public void mov(){
        for (int i = 0; i < 3; i++) {
            if(posX[i]<0){
                dir[i][0] = Math.abs(dir[i][0]);
            } else if(posX[i]>350-alto){
                dir[i][0] = -Math.abs(dir[i][0]);
            }
            posX[i]+=dir[i][0];
            
            if(posY[i]<20){
                dir[i][1] = Math.abs(dir[i][1]);
            } else if(posY[i]>350-ancho){
                dir[i][1] = -Math.abs(dir[i][1]);
            }
            posY[i]+=dir[i][1];
            
        }

    }
    
    @Override public void run(){
        try{
            Imagen nuevo = new Imagen();
            int a = 1;
            while(a>0){
                nuevo.mov();
                Thread.sleep(500);
                nuevo.repaint();
            }

        }catch(Exception ex){
            System.out.println(""+ex);
        }
    }

}
