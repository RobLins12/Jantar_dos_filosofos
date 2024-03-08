package src;

public class Code {
    public static void main(String[] args) {

        String [] nomes = {"Robson", "Gabi", "Flávio", "João", "Giovanni"};
        int numeroFilosofos = 5;
        Threads filosofo = new Threads("");
        Thread thread;

        for (int i = 0; i < numeroFilosofos; i++) {
            //Aqui foi declarado o filosofo que será utilizado como parâmetro 
            filosofo = new Threads(nomes[i]);
            thread = new Thread(filosofo);
            filosofo.lock();
            thread.start();
            filosofo.unlock();
        }

        // A Main espera os filosofos comerem para avisar que todos comeram
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }       

        System.out.println("Todos comeram");
    }
}