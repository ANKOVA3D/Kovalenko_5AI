package std;

class Contatore extends Thread {
    private int id;
    private int limite;
    private int valoreCorrente;
    private boolean completato;

    public Contatore(int id, int limite) {
        this.id = id;
        this.limite = limite;
        this.valoreCorrente = 0;
        this.completato = false;
    }

    public int getValoreCorrente() {
        return valoreCorrente;
    }

    public boolean isCompletato() {
        return completato;
    }

    @Override
    public void run() {
        try {
            while (valoreCorrente <= limite) {
                Thread.sleep(120); // Attendi 120 ms tra ogni incremento
                valoreCorrente++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        completato = true;
    }
}

