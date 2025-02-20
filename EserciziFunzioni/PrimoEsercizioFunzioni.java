/* esercizio 1 su funzioni, gestione spedizioni penne */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PrimoEsercizioFunzioni {
    public static void main(String[] args) {
        // la struttura dati che contiene le spedizioni inizializzata randomica
        ArrayList<ArrayList<Integer>> spedizioni = generaSpedizioni();

        // il menu del gestionale
        menu(spedizioni);
        return;
    }

    // per aggiungere un lotto da prompt
    public static ArrayList<Integer> addLotto() {
        ArrayList<Integer> quantitaColori = new ArrayList<>();
        Scanner myIntScanner = new Scanner(System.in);

        System.out.println("Inserisci il numero di penne per il colore rosso: ");
        quantitaColori.add(myIntScanner.nextInt());

        System.out.println("Inserisci il numero di penne per il colore blu: ");
        quantitaColori.add(myIntScanner.nextInt());

        System.out.println("Inserisci il numero di penne per il colore verde: ");
        quantitaColori.add(myIntScanner.nextInt());

        System.out.println("Inserisci il numero di penne per il colore nero: ");
        quantitaColori.add(myIntScanner.nextInt());

        myIntScanner.close();
        return quantitaColori;

    }

    // stampa tutte le spedizioni
    public static void printSpedizioni(ArrayList<ArrayList<Integer>> spedizioni) {
        int i = 0;
        for (ArrayList<Integer> spedizione : spedizioni) {
            System.out.println("spedizione " + i + ": " + spedizione.get(0) + " rosse " + spedizione.get(1) + " blu "
                    + spedizione.get(2) + " verdi " + spedizione.get(3) + " verdi");
            i++;
        }
    }

    // stampa la quantita totale per ogni tipo di penna(colore)
    public static void printTotPerColore(ArrayList<ArrayList<Integer>> spedizioni) {
        int rosse = 0, blu = 0, verdi = 0, nere = 0;
        for (ArrayList<Integer> spedizione : spedizioni) {
            rosse += spedizione.get(0);
            blu += spedizione.get(1);
            verdi += spedizione.get(2);
            nere += spedizione.get(3);
        }

        System.out.println("rosse totali: " + rosse);
        System.out.println("blu totali: " + blu);
        System.out.println("verdi totali: " + verdi);
        System.out.println("nere totali: " + nere);
    }

    // fa una ricerca e stampa tutte le spedizioni che contengono almeno una penna del colore selezionato
    public static void ricercaPerColore(String colore, ArrayList<ArrayList<Integer>> spedizioni) {
        int index = 0;
        switch (colore) {
            case "rosse":
                index = 0;
                break;
            case "blu":
                index = 1;
                break;
            case "verdi":
                index = 2;
                break;
            case "nere":
                index = 3;
                break;
            default:
                System.out.println("errore");
                break;
        }

        int i = 0;
        for (ArrayList<Integer> spedizione : spedizioni) {
            if (spedizione.get(index) > 0) {
                // print della spedizione
                System.out
                        .println("spedizione " + i + ": " + spedizione.get(0) + " rosse " + spedizione.get(1) + " blu "
                                + spedizione.get(2) + " verdi " + spedizione.get(3) + " verdi");

                i++;
            }
        }
    }

    // genera una spedizione random
    public static ArrayList<Integer> generaSpedizione() {
        Random generatoreInteri = new Random();
        ArrayList<Integer> spedizione = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            spedizione.add(generatoreInteri.nextInt(100));
        }
        return spedizione;
    }

    // genera da 0 a 10 spedizioni randomicamente
    public static ArrayList<ArrayList<Integer>> generaSpedizioni() {
        ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
        Random generatoreInteri = new Random();
        int numeroDiSpedizioni = generatoreInteri.nextInt(10) + 1;
        for (int i = 0; i < numeroDiSpedizioni; i++) {
            spedizioni.add(generaSpedizione());
        }
        return spedizioni;
    }

    // il menu principale del gestionale
    public static void menu(ArrayList<ArrayList<Integer>> spedizioni) {
        Scanner myIntScanner = new Scanner(System.in);
        int sceltaUtente = 0;
        do {
            System.out.println("-------- MENU ---------------");
            System.out.println("premi 0 per aggiunge una spedizione");
            System.out.println("premi 1 per visualizzare le spedizioni");
            System.out.println("premi 2 per sapere il totale delle penne per colore");
            System.out.println("premi 3 per effetuare una ricerca per colore");
            System.out.println("premi 4 per uscire");

            switch (sceltaUtente) {
                case 0: // aggiungere una spedizione
                    spedizioni.add(addLotto());

                    break;
                case 1:
                    printSpedizioni(spedizioni);

                    break;
                case 2:
                    printTotPerColore(spedizioni);

                    break;
                case 3:
                    // menu ricerca per colore
                    menuColore(spedizioni);
                    break;
                case 4:
                    System.out.println("hai scelto di uscire");

                    break;

                default:
                    System.out.println("opzione non valida");
                    break;
            }

        } while (sceltaUtente != 4);
        myIntScanner.close();

    }

    // il menu per la ricerca tramite colore
    public static void menuColore(ArrayList<ArrayList<Integer>> spedizioni) {
        Scanner myIntScanner = new Scanner(System.in);
        int sceltaUtente = 0;
        do {
            System.out.println("-------- MENU ---------------");
            System.out.println("premi 0 per rosso");
            System.out.println("premi 1 per blu");
            System.out.println("premi 2 per verde");
            System.out.println("premi 3 per nero");
            System.out.println("premi 4 per uscire");

            switch (sceltaUtente) {
                case 0:
                    ricercaPerColore("rosse", spedizioni);

                    break;
                case 1:
                    ricercaPerColore("blu", spedizioni);

                    break;
                case 2:
                    ricercaPerColore("verdi", spedizioni);

                    break;
                case 3:
                    ricercaPerColore("nere", spedizioni);

                    break;
                case 4:

                    break;

                default:
                    System.out.println("opzione non valida");
                    break;
            }

        } while (sceltaUtente != 4);

        myIntScanner.close();

    }
}
