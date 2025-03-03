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
