import com.hilos.*;

public class Main {

    public static void main(String[] args) {
        Imagen imagen = new Imagen();
        HiloServer hiloServer = new HiloServer();
        AudioClip audio = new AudioClip();

        Thread t1 = new Thread(imagen);
        Thread t2 = new Thread(hiloServer);
        Thread t3 = new Thread(audio);

        t1.start();
        t2.start();
        t3.start();
    }
}
