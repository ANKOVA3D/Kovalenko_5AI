package std;
import java.util.Random;

public class StatoThread {
    public static void main(String[] args) throws InterruptedException {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Input dei valori T ed N
        System.out.print("Inserisci il numero di thread (T): ");
        int T = scanner.nextInt();
        System.out.print("Inserisci il valore massimo (N): ");
        int N = scanner.nextInt();

        // Creazione di T thread
        Contatore[] contatori = new Contatore[T];
        Random random = new Random();

        for (int i = 0; i < T; i++) {
            int limiteCasuale = random.nextInt(N + 1); // Limite X casuale tra 0 e N
            contatori[i] = new Contatore(i, limiteCasuale);
            contatori[i].start();
        }

        // Monitoraggio di thread
        boolean tuttiCompletati = false;
        while (!tuttiCompletati) {
            tuttiCompletati = true; // Assumiamo che tutti sono completati

       
            for (Contatore contatore : contatori) {
                if (contatore.isAlive()) {
                    System.out.println("Thread " + contatore.getId() + " sta contando a: " + contatore.getValoreCorrente());
                    tuttiCompletati = false; // Almeno un thread non è completato
                } else if (contatore.isCompletato()) {
                    System.out.println("Thread " + contatore.getId() + " COMPLETATO");
                }
            }

            // Genera un tempo di attesa casuale tra 0 e 1 secondo (0-1000 ms)
            int attesaCasuale = random.nextInt(1001);
            Thread.sleep(attesaCasuale);
        }

        // Aspetta che tutti i thread finiscano
        for (Contatore contatore : contatori) {
            contatore.join();  // Il thread principale aspetta la terminazione di ogni thread figlio
        }

        // Tutti i thread sono completati
        System.out.println("TUTTI I THREAD COMPLETATI");
    }
}
