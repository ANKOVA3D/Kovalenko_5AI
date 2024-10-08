import java.util.Random;

public class Produttore implements Runnable {
    private final Buffer buffer;
    private final Random random = new Random();

    public Produttore(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numeroCasuale = random.nextInt(1024); // Numero casuale tra 0 e 1023
                buffer.put(numeroCasuale);
                System.out.println("Produttore ha generato: " + numeroCasuale);
                int ritardo = 100 + random.nextInt(901); // Intervallo casuale tra 100 e 1000 ms
                Thread.sleep(ritardo);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
