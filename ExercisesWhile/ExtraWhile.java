import java.util.Random;
import java.util.Scanner;

public class ExtraWhile {
    public static void main(String[] args) {
        // creazione scanner per interi e stringhe
        Scanner myIntScanner = new Scanner(System.in);
        Scanner myStringScanner = new Scanner(System.in);

        // creazione generatore random
        Random genRandom = new Random();

        boolean upperExit = false; // per uscita dal menu principale

        System.out.println("Benvenuto....");

        // variabili sommatore
        int numeroInserito = 0;
        int sommatore = 0;

        // variabili tabellina
        int iterator = 1;
        int numeroScelto = 0;

        // variabili per numero segreto
        boolean exit = false;
        int guess = 0;
        int randomNum = 0;
        String scelta = "S";

        do {
            System.out.println(
                    "premi 1 per sommatore\npremi 2 per tabellina\npremi 3 per numeroSegreto\n premi 4 per uscire");
            int sceltaMenu = myIntScanner.nextInt();

            switch (sceltaMenu) {
                case 1:
                    // sommatore
                    System.out.println(
                            "Inserisci una serie di numeri interi positivi affinche io li sommi assieme\nQuando vuoi uscire inserisci un numero negativo");

                    // ciclo per il sommatore
                    do {
                        // richiesta input e read input utente
                        System.out.println("Inserisci un numero positivo oppure uno negativo per uscire: ");
                        numeroInserito = myIntScanner.nextInt();

                        // condizione di continuazione del sommatore
                        if (numeroInserito >= 0) {
                            sommatore += numeroInserito;
                        }

                    } while (numeroInserito >= 0);

                    // stampa del risultato del sommatore
                    System.out.println("hai deciso di uscire dal loop\nRisultato finale: " + sommatore);

                    break;
                case 2:
                    // tabellina
                    // richiesta e inserimento dell'input utente
                    System.out.println("Inserisci il numero del quale vuoi visualizzare la tabellina(fino a 10): ");
                    numeroScelto = myIntScanner.nextInt();

                    iterator = 1; // iteratore per creazione tabellina
                    System.out.println("Tabellina del " + numeroScelto + "\n");

                    while (iterator < 10) {
                        System.out.println("| " + numeroScelto + " x " + iterator + " : " + iterator * numeroScelto);
                        iterator++;
                    }
                    break;
                case 3:
                    // numero segreto
                    System.out.println("Inizio del gioco.");

                    exit = false; // per uscire dal gioco
                    guess = 0; // la guess dell'utente
                    randomNum = 0; // il numero randomico da indovinare
                    scelta = "S"; // la scelta dell'utente per continuare o meno il gioco

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
                                    exit = true; // per uscire dal gioco del numero segreto
                                }
                            }

                        } while (guess != randomNum);

                    } while (!exit);
                    break;
                case 4:
                    // l'utente a scelto di uscire
                    upperExit = true; // per uscire del tutto dal gioco
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        } while (!upperExit);

        // chiusura degli scanner utilizzati e saluti
        System.out.println("ciao ciao...");
        myIntScanner.close();
        myStringScanner.close();

    }
}
