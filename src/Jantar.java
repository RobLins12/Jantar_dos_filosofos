package src;
import java.util.concurrent.Semaphore;

public class Jantar{
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(2);
        
        Thread a = new Thread(new Filosofos("João", semaforo));
        Thread b = new Thread(new Filosofos("Flávio", semaforo));
        Thread c = new Thread(new Filosofos("Robson", semaforo));
        Thread d = new Thread(new Filosofos("Gabi", semaforo));
        Thread e = new Thread(new Filosofos("Giovanni", semaforo));

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}