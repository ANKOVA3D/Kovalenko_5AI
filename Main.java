import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente i valori T e N
        System.out.print("Inserisci il numero di thread T: ");
        int T = scanner.nextInt();
        System.out.print("Inserisci il valore N: ");
        int N = scanner.nextInt();

        // Crea il buffer condiviso
        Buffer buffer = new Buffer(10); // La dimensione del buffer è arbitraria (10 in questo caso)

        // Crea e avvia il Produttore e il Consumatore
        Produttore produttore = new Produttore(buffer);
        Consumatore consumatore = new Consumatore(buffer);

        Thread produttoreThread = new Thread(produttore);
        Thread consumatoreThread = new Thread(consumatore);

        produttoreThread.start();
        consumatoreThread.start();

        // Crea i thread contatori e li avvia direttamente
        for (int i = 0; i < T; i++) {
            Thread contatoreThread = new Thread(new Contatore(N));
            contatoreThread.start();
        }
    }
}
