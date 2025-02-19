import java.util.Random;
import java.util.Scanner;

public class NumeroSegreto {
    public static void main(String[] args) {
        // creazione scanner per interi e stringhe
        Scanner myIntScanner = new Scanner(System.in);
        Scanner myStringScanner = new Scanner(System.in);

        // creazione generatore random
        Random genRandom = new Random();

        System.out.println("Inizio del gioco.");
        
        boolean exit = false; // per uscire dal gioco
        int guess = 0; // la guess dell'utente
        int randomNum = 0; // il numero randomico da indovinare
        String scelta = "S"; // la scelta dell'utente per continuare o meno il gioco

        // finche non si esce dal gioco
        do {
            System.out.println("Generazione numero segreto....");
            
            // generazione numero casuale tra 1 e 100
            randomNum = genRandom.nextInt(100) + 1;

            System.out.println("Numero Segreto creato");

            // finche l'utente non indovina
            do {
                // richiesta e lettura guess utente
                System.out.println("Prova ad indovinare: ");
                guess = myIntScanner.nextInt();

                // suggerimenti all'utente e controllo guess corretta
                if (guess > randomNum) {
                    System.out.println("Troppo alto, riprova");
                } else if (guess < randomNum) {
                    System.out.println("Troppo basso, riprova");
                } else {
                    // l'utente ha indovinato gli si chiede se vuole continuare
                    System.out.println("Bravo dai...\n vuoi giocare ancora?S/N");
                    // read scelta utente
                    scelta = myStringScanner.nextLine().trim().toUpperCase();
                    if (scelta.equals("N")) {
                        exit = true; // per uscire dal gioco
                    }
                }

            } while (guess != randomNum);

        } while (!exit);

        // saluti e chiusura degli scanner
        System.out.println("Ciao");
        myIntScanner.close();
        myStringScanner.close();
    }
}
