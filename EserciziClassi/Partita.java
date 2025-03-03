import java.util.ArrayList;
import java.util.Scanner;

public class Partita {
    ArrayList<Squadra> squadre = new ArrayList<Squadra>();

    public static void main(String[] args) {
        Partita partita = new Partita();
        Squadra squadra1 = new Squadra(new ArrayList<Calciatore>());
        Squadra squadra2 = new Squadra(new ArrayList<Calciatore>());

        for(int i=0;i<12;i++){
            // chiedi calciatore
            squadra1.addCalciatore(chiediCalciatore());
        }

        for(int i=0;i<12;i++){
            // chiedi calciatore
            squadra2.addCalciatore(chiediCalciatore());
        }

        partita.printRisultatoPartita();
    }

    public void printRisultatoPartita(){
        // genero random il risultato
        int risultato1 = (int)(Math.random() * 10);
        int risultato2 = (int)(Math.random() * 10);
        System.out.println("Risultato partita: " + risultato1 + " - " + risultato2);
    }

    public static Calciatore chiediCalciatore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome del calciatore: ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il ruolo del calciatore: ");
        String ruolo = scanner.nextLine();
        scanner.close();
        return new Calciatore(nome, ruolo);
    }
    
}

class Squadra{
    ArrayList<Calciatore> squadra = new ArrayList<Calciatore>();

    public Squadra(ArrayList<Calciatore> squadra) {
        this.squadra = squadra;
    }

    public void addCalciatore(Calciatore calciatore){
        squadra.add(calciatore);
    }

    public void printSquadra(){
        for(Calciatore calciatore : squadra){
            calciatore.printCalciatore();
        }
    }

    
}

class Calciatore{
    String nome;
    String ruolo;

    public Calciatore(String nome, String ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
    }

    public void printCalciatore(){
        System.out.println("Nome: " + nome + " Ruolo: " + ruolo);
    }

}
