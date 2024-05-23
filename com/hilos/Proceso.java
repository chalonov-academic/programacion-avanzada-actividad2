package com.hilos;

public class Proceso implements Runnable {
    
    @Override public void run(){
        int y = 1, x = 0;
        try{
            while(y>0) {
                System.out.println("Numero "+x);
                x++;
                Thread.sleep(1200);
            }
        }catch(Exception ex){
            System.out.println(""+ex);
        }
    }
    
}
