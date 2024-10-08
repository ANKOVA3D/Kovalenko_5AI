public class Consumatore implements Runnable {
    private final Buffer buffer;
    private int pari = 0;
    private int dispari = 0;

    public Consumatore(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = buffer.take();
                System.out.println("Consumatore ha consumato: " + numero);

                if (numero % 2 == 0) {
                    pari++;
                } else {
                    dispari++;
                }

                System.out.println("Pari: " + pari + ", Dispari: " + dispari);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
