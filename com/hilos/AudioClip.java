package com.hilos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AudioClip implements Runnable{
    @Override
    public void run(){
        try{
             InputStream inputStream = new BufferedInputStream(new FileInputStream("Passionfruit.wav"));
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
             AudioFormat audioFormat = audioInputStream.getFormat();
             DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
             Clip clip = (Clip) AudioSystem.getLine(info);
             clip.open(audioInputStream);
             clip.start();

        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            AudioFileFormat.Type[] tipos = AudioSystem.getAudioFileTypes();
            System.out.println("Formatos soportados:");
            for (AudioFileFormat.Type tipo : tipos){
                System.out.print(tipo.getExtension() + ", ");
            }
            System.out.println("");
        }
    }
}