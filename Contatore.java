import java.util.Random;

public class Contatore implements Runnable {
    private final int max;

    public Contatore(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        Random random = new Random();
        int X = random.nextInt(max + 1); // Numero casuale tra 0 e N

        try {
            for (int i = 0; i <= X; i++) {
                // Conta fino a X senza stampare
                Thread.sleep(120); // Aspetta 120ms ogni incremento
            }
            System.out.println("Thread ha contato fino a: " + X);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
