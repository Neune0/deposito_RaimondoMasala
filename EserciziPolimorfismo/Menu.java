package EserciziPolimorfismo;

import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        Chef chef1 = new Chef("dsafg");
        Chef chef2 = new Chef("asdfs");
        ArrayList<String> ingredienti1 = new ArrayList<>();
        ingredienti1.add("Pasta");
        ingredienti1.add("Pomodoro");
        ArrayList<String> ingredienti2 = new ArrayList<>();
        ingredienti2.add("Carne");
        ingredienti2.add("Patate");
        Piatto piatto1 = new Piatto(ingredienti1, 12.50, chef1);
        Piatto piatto2 = new Piatto(ingredienti2, 18.90, chef2);
        

        Ordinazione ordinazione = new Ordinazione();
        ordinazione.aggiungiPiatto(piatto1);
        ordinazione.aggiungiPiatto(piatto2);

        // Stampare il totale del conto
        System.out.println("Totale conto: " + ordinazione.calcolaConto() + "€");
    }
}

class Piatto{
    private ArrayList<String> ingredienti;
    private double prezzo;
    Chef chef;

    public Piatto(ArrayList<String> ingredienti, double prezzo, Chef chef){
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.chef = chef;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public Chef getChef(){
        return chef;
    }

    public ArrayList<String> getIngredienti(){
        return ingredienti;
    }

}

class Chef{
    private String nomeChef;
    public Chef(String nomeChef){
        this.nomeChef = nomeChef;
    }

    public String getNomeChef(){
        return nomeChef;
    }
    
}

class Ordinazione{
    private ArrayList<Piatto> piatti;

    public Ordinazione(ArrayList<Piatto> piatti){
        this.piatti = piatti;
    }
    public Ordinazione(){
        this.piatti = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto piatto){
        piatti.add(piatto);
    }

    public double calcolaConto(){
        double conto = 0;
        for(Piatto piatto : piatti){
            conto += piatto.getPrezzo();
        }
        return conto;
    }
}
