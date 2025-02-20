/* utilizzare arraylist per creare un sistema di prenotazioni*/

import java.util.ArrayList;
import java.util.Scanner;

public class PrenotazioneRicerca {
    public static void main(String[] args) {
        Scanner myStringScanner = new Scanner(System.in);
        Scanner myIntScanner = new Scanner(System.in);
        ArrayList<Integer> righe = new ArrayList<>();
        ArrayList<Integer> colonne = new ArrayList<>();
        ArrayList<String> nomi = new ArrayList<>();
        boolean exit = false;

        int row = 0;
        int col = 0;
        String name = "";

        // righe e colonne massime per la prenotazione
        int minRiga = 0, maxRiga = 2;
        int minCol = 0, maxCol = 8;

        // boolean per controllo posto occupato
        boolean occupato = false;

        while (!exit) {

            // aggiungere una prenotazione
            // inserimento nome
            do {
                System.out.println("Inserisci il tuo nome: ");
                name = myStringScanner.nextLine();
                if (name.length() <= 0) {
                    System.out.println("nome inserito non valido, riprova");
                } else {
                    nomi.add(name);
                }
            } while (name.length() <= 0);

            // assegnazione posto
            do {
                // riga
                do {
                    System.out.println("Inserisci la riga del posto da prenotare min 0 max 8: ");
                    row = myIntScanner.nextInt();
                    if (row < minRiga || row > maxRiga) {
                        System.out.println("riga inserita non valida min 0 max 8, riprova");
                    } else {
                        // non posso ancora inserire poiche non so se il posto sara occupato
                    }
                } while (row < minRiga || row > maxRiga);

                // colonna
                do {
                    System.out.println("Inserisci la colonna del posto da prenotare min 0 max 8: ");
                    col = myIntScanner.nextInt();
                    if (col < minCol || col > maxCol) {
                        System.out.println("colonna inserita non valida min 0 max 8, riprova");
                    } else {
                        // non posso ancora inserire poiche non so se il posto sara occupato
                    }
                } while (col < minCol || col > maxCol);
                
                // controllo che il posto non sia gia occupato
                for(int riga : righe){
                    if(riga == row){
                        for(int colonna : colonne){
                            if(colonna == col){
                                // posto gia occupato
                                occupato = true;
                            }
                        }
                    }
                }
                if (occupato) {
                    System.out.println("Il posto da te selezionato è gia occupato, riprova");
                }
            } while (occupato);


        }


        // cercare prenotazioni per file
        int filaTarget= 0;

        for(int i=0;i<maxRiga;i++){
            if(filaTarget==righe.get(i)){

            }
        }
    }
}
