package src;

import java.util.concurrent.Semaphore;

public class Filosofos implements Runnable{
    //Estou usando a interface Runnable ao inves de usar o extends

    private String nomeThread;
    private final Semaphore semaphore;
    private int comida = 1;

    public Filosofos(String i, Semaphore s) {
        //Foi feito um contrutor para salvar o numero da thread apenas para caso de estudo
        this.nomeThread = i;
        this.semaphore = s;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        comer();
    }

    private void comer() {
        try {
            semaphore.acquire(); // adquire uma permissão do semáforo 
            for (int i = comida; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("O filosofo " + nomeThread + " está comendo a parte " + i + " do prato" );
            }
            System.out.println(nomeThread + " Terminou de comer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // libera a permissão do semáforo
        }
    }
}