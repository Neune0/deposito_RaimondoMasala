public class Auto {

    // region Properties
    public String modello;
    public String colore;
    public int velocita;
    // endregion

    // region Constructors
    public Auto(String modello, String colore) {
        this.modello = modello;
        this.colore = colore;
        this.velocita = 0;
    }
    // endregion

    public static void main(String[] args) {
        Auto auto1 = new Auto("Fiat 500", "Bianca");

        System.out.println("Modello: " + auto1.modello);
        System.out.println("Colore: " + auto1.colore);

        auto1.accelera(50);
        auto1.frena(20);
    }
    

    // region Methods
    public void accelera(int incremento) {
        velocita += incremento;
        System.out.println("L'auto " + modello +  "ha accellerato. Velocita attuale: " + velocita + " km/h");
    }

    public void frena(int decremento) {
        velocita -= decremento;
        if(velocita<0){
            velocita = 0;
        }
        System.out.println("L'auto " + modello +  "ha frenato. Velocita attuale: " + velocita + " km/h");
    }

    // endregion

}

class Prenotazione{
    String nomeCliente;
    int riga;
    int colonna;

    // costruttore
    public Prenotazione(String nomeCliente, int riga, int colonna){
        this.nomeCliente = nomeCliente;
        this.riga = riga;
        this.colonna = colonna;
    }

    public static void main(String[] args) {
        Prenotazione prenotazione1 = new Prenotazione("Mario Rossi", 5, 10);
        System.out.println("Prenotazione effettuata da: " + prenotazione1.nomeCliente);
        System.out.println("Riga: " + prenotazione1.riga);
        System.out.println("Colonna: " + prenotazione1.colonna);
    }
}