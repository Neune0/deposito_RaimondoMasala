/* esercizio 1 su funzioni, gestione spedizioni penne */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PrimoEsercizioFunzioni {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
        ArrayList<Integer> quantitaColori = new ArrayList<>();

    }

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

    public static void printSpedizioni(ArrayList<ArrayList<Integer>> spedizioni) {
        int i = 0;
        for (ArrayList<Integer> spedizione : spedizioni) {
            System.out.println("spedizione " + i + ": " + spedizione.get(0) + " rosse " + spedizione.get(1) + " blu "
                    + spedizione.get(2) + " verdi " + spedizione.get(3) + " verdi");
                    i++;
        }
    }

    public static void printTotPerColore(ArrayList<ArrayList<Integer>> spedizioni) {
        int rosse = 0, blu = 0, verdi = 0, nere = 0;
        for (ArrayList<Integer> spedizione : spedizioni) {
            rosse += spedizione.get(0);
            blu += spedizione.get(1);
            verdi += spedizione.get(2);
            nere += spedizione.get(3);
        }

        System.out.println("rosse totali: " + rosse);
        System.out.println("blu totali: " + rosse);
        System.out.println("verdi totali: " + rosse);
        System.out.println("nere totali: " + rosse);
    }

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
                System.out.println("spedizione " + i + ": " + spedizione.get(0) + " rosse " + spedizione.get(1) + " blu "
                    + spedizione.get(2) + " verdi " + spedizione.get(3) + " verdi");
                
                i++;
            }
        }
    }

    // genera una spedizione random
    public static ArrayList<Integer> generaSpedizione(){
        Random generatoreInteri = new Random();
        ArrayList<Integer> spedizione = new ArrayList<>();

        for(int i=0;i<4;i++){
            spedizione.add(generatoreInteri.nextInt(100));
        }
        return spedizione;
    }

    public static ArrayList<ArrayList<Integer>> generaSpedizioni(){
        ArrayList<ArrayList<Integer>> spedizioni = new ArrayList<>();
        Random generatoreInteri = new Random();
        int numeroDiSpedizioni = generatoreInteri.nextInt(10)+1;
        for(int i=0;i<numeroDiSpedizioni;i++){
            spedizioni.add(generaSpedizione());
        }
        return spedizioni;
    }
}
