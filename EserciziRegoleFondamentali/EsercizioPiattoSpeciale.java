import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioPiattoSpeciale {
    public static void main(String[] args) {
        Ingrediente paninoNormale = new Ingrediente("Panino normale", 1.0);
        Ingrediente paninoSesamo = new Ingrediente("panino al sesamo", 1.5);
        Ingrediente prosciutto = new Ingrediente("prosciutto", 2.0);
        Ingrediente formaggio = new Ingrediente("formaggio", 1.5);
        Ingrediente insalata = new Ingrediente("insalata", 1.0);
        Ingrediente pomodoro = new Ingrediente("pomodoro", 1.0);

        Menu menu = new Menu(new ArrayList<Ingrediente>(),new ArrayList<Integer>());
        menu.addIngrediente(paninoNormale);
        menu.addIngrediente(paninoSesamo);
        menu.addIngrediente(prosciutto);
        menu.addIngrediente(formaggio);
        menu.addIngrediente(insalata);
        menu.addIngrediente(pomodoro);
        menu.addQuantita(10);
        menu.addQuantita(10);
        menu.addQuantita(10);
        menu.addQuantita(10);
        menu.addQuantita(10);
        menu.addQuantita(10);

        String scelta = "";
        Scanner scanner = new Scanner(System.in);
        PiattoSpeciale piattoSpeciale = new PiattoSpeciale(new ArrayList<Ingrediente>());
        ArrayList<PiattoSpeciale> ordine = new ArrayList<PiattoSpeciale>();

        // loop scelta piatti
        do {
            System.out.println("componi la tua ordinazione: ");
            // loop per scelta ingredienti di un piatto
            do {
                menu.print();
                System.out.println(
                        "Inserisci il nome dell'ingrediente che vuoi aggiungere al piatto speciale, basta per uscire");
                scelta = scanner.nextLine();
                // controllo che la roba inserita esista veramente
                if (menu.contains(scelta)) {
                    for (Ingrediente i : menu.getIngredienti()) {
                        if (i.getNome().equals(scelta)) {
                            piattoSpeciale.addIngrediente(i);
                        }
                    }
                } else {
                    System.out.println("Ingrediente non trovato");
                }

            } while (!scelta.equals("basta"));
            ordine.add(piattoSpeciale);

            System.out.println("Il prezzo del piatto speciale è: " + piattoSpeciale.getPrezzo());
            piattoSpeciale = new PiattoSpeciale(new ArrayList<Ingrediente>());
            System.out.println(
                    "Vuoi inserire un altro piatto speciale? scrivi fatto per uscire premi un tasto per continuare");
            scelta = scanner.nextLine();

        } while (!scelta.equals("fatto"));

        // stampo il totale da pagare e i piatti ordinati
        double totale = 0.0;
        for (PiattoSpeciale p : ordine) {
            totale += p.getPrezzo();

        }
        System.out.println("Il totale da pagare è: " + totale);
        System.out.println("Hai ordinato: ");
        for (PiattoSpeciale p : ordine) {
            System.out.println("Piatto speciale con prezzo: " + p.getPrezzo());
        }
        scanner.close();
        return;
    }

}

class PiattoSpeciale {
    private final double fisso = 1.0; // prezzo fisso per ogni piatto speciale
    private double prezzo = fisso;

    private ArrayList<Ingrediente> ingredienti = new ArrayList<Ingrediente>();

    public PiattoSpeciale(ArrayList<Ingrediente> ingrediente) {
        this.prezzo = fisso;
        for (Ingrediente i : ingrediente) {
            this.prezzo += i.getPrezzo();
        }
    }

    public void addIngrediente(Ingrediente ingrediente) {
        ingredienti.add(ingrediente);
        this.prezzo += ingrediente.getPrezzo();
    }

    public Double getPrezzo() {
        return this.prezzo;
    }

}

class Menu {
    private ArrayList<Ingrediente> ingredienti = new ArrayList<Ingrediente>();
    private ArrayList<Integer> quantita = new ArrayList<Integer>();

    public Menu(ArrayList<Ingrediente> ingredienti,ArrayList<Integer> quantita) {
        this.ingredienti = ingredienti;
        this.quantita = quantita;
    }

    public ArrayList<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public ArrayList<Integer> getQuantita() {
        return quantita;
    }

    public void print() {
        for (Ingrediente i : ingredienti) {
            System.out.println(i.getNome() + " " + i.getPrezzo());
        }
    }

    public void addIngrediente(Ingrediente ingrediente) {
        ingredienti.add(ingrediente);
    }

    public void addQuantita(Integer quantita) {
        this.quantita.add(quantita);
    }

    public boolean contains(String nomeIngrediente) {
        for(int i=0;i<ingredienti.size();i++){
            if(ingredienti.get(i).getNome().equals(nomeIngrediente) && quantita.get(i)>0){
                quantita.set(i, quantita.get(i)-1); // diminuisco quantita di quel ingrediente
                return true;
            }
        }
        
        return false;
    }

}

class Ingrediente {
    private String nome;
    private double prezzo;

    public Ingrediente(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
