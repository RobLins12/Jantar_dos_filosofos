package src;

public class Threads implements Runnable{
    //Estou usando a interface Runnable ao inves de usar o extends

    private String nomeThread;
    private boolean isLock;
    private int comida = 1;

    public Threads(String i) {
        //Foi feito um contrutor para salvar o numero da thread apenas para caso de estudo
        this.nomeThread = i;
    }

    @Override
    public void run() {
        while (isLock) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        comer();
    }

    private void comer() {
        for (int i = comida; i <= 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("O filosofo " + nomeThread + " está comendo a parte " + i + " do prato" );
        }
    }

    public void lock(){
        this.isLock = true;
    }

    public void unlock(){
        this.isLock = false;
    }
}