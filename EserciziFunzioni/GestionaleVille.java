import java.util.ArrayList;
import java.util.Scanner;

public class GestionaleVille {
    public static void main(String[] args) {
        // la struttura dati che contiene le ville
        ArrayList<ArrayList<Object>> ville = new ArrayList<>();

        // il menu del gestionale
        menu(ville);
    }

    // il menu principale del gestionale
    public static void menu(ArrayList<ArrayList<Object>> ville) {
        // scanner per scelta menu utente
        Scanner myIntScanner = new Scanner(System.in);
        int sceltaUtente = 0; // la scelta dell'utente
        do {
            System.out.println("-------- MENU ---------------");
            System.out.println("premi 0 per aggiunge una villa");
            System.out.println("premi 1 per visualizzare le ville");
            System.out.println("premi 2 per effetuare una ricerca tramite nome");
            System.out.println("premi 3 per uscire");

            switch (sceltaUtente) {
                case 0: // aggiungere una villa
                    ville.add(addVilla());
                    break;
                case 1: // visulizzare ville
                    printVille(ville);
                    break;
                case 2: // ricerca per nome
                    ricercaPerNome(ville);
                    break;
                case 3: // uscita
                    System.out.println("hai scelto di uscire");
                    break;
                default:
                    System.out.println("opzione non valida");
                    break;
            }

        } while (sceltaUtente != 3);
        myIntScanner.close();

    }

    // per aggiungere una villa
    public static ArrayList<Object> addVilla() {
        // struttura dati per singola villa
        ArrayList<Object> villa = new ArrayList<>();
        // scanner per input utente
        Scanner myIntScanner = new Scanner(System.in);
        Scanner myStringScanner = new Scanner(System.in);

        // variabili ausiliari per input utente
        String nomeVilla = "";
        Integer quantitaStanze = 0;
        Integer hasPiscina = 0;

        // richiesta nome
        do {
            System.out.println("Inserisci il nome della villa: ");
            nomeVilla = myStringScanner.nextLine().trim();
            if (nomeVilla.isEmpty()) {
                System.out.println("Inserisci un nome valido,riprova");
            } else {
                villa.add(nomeVilla);
            }
        } while (nomeVilla.isEmpty());

        // richiesta numero stanze
        do {
            System.out.println("Inserisci il numero delle stanze: ");
            quantitaStanze = myStringScanner.nextInt();
            if (quantitaStanze <= 0) {
                System.out.println("Inserisci una quantita valida,riprova");
            } else {
                villa.add(quantitaStanze);
            }
        } while (quantitaStanze <= 0);

        // richiesta presenza o meno piscina
        System.out.println("Dimmmi se la villa ha una piscina oppure no(S/N): ");
        hasPiscina = myStringScanner.nextLine().trim().toUpperCase().equals("S") ? 1 : 0;

        // aggiunge la villa alla lista di ville
        villa.add(hasPiscina);

        // chiusura scanners
        myIntScanner.close();
        myStringScanner.close();

        return villa;
    }

    // stampa tutte le ville presenti nel gestionale
    public static void printVille(ArrayList<ArrayList<Object>> ville) {
        // per ogni villa stampo tutti i suoi "attributi"
        for (ArrayList<Object> villa : ville) {
            System.out.println(
                    "Nome villa: " + (String) villa.get(0) + " num stanze: " + (Integer) villa.get(1) + " piscina: " + (Integer) villa.get(2));
        }
    }

    // ricerca ville per nome villa
    public static void ricercaPerNome(ArrayList<ArrayList<Object>> ville) {
        String nomeVilla = ""; // il nome villa da cercare
        // scanner per scelta utente
        Scanner myStringScanner = new Scanner(System.in);

        // richiesta nome villa
        do {
            System.out.println("Inserisci il nome della villa: ");
            nomeVilla = myStringScanner.nextLine().trim();
            if (nomeVilla.isEmpty()) {
                System.out.println("Inserisci un nome valido,riprova");
            }
        } while (nomeVilla.isEmpty());

        // per ogni villa se il nome corrisponde stampo tutti gli "attributi" della villa
        for (ArrayList<Object> villa : ville) {
            if (((String)(villa.get(0))).equals(nomeVilla)) {
                System.out.println(
                        "Nome villa: " + (String)villa.get(0) + " num stanze: " + (Integer)villa.get(1) + " piscina: " + (Integer)villa.get(2));
            }
        }

        // chiusura scanner
        myStringScanner.close();
    }
}
