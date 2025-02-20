
/* utilizzare arraylist per creare un sistema di prenotazioni e ricerca*/

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

        int sceltaMenuUtente = 0; // per scelta menu
        int colonnaTarget = 0; // per ricerca tramite colonna
        int filaTarget = 0; // per ricerca tramite fila
        String nomeTarget = ""; // per ricerca per nome

        // righe e colonne massime per la prenotazione
        int minRiga = 0, maxRiga = 2;
        int minCol = 0, maxCol = 8;

        // il totale dei posti
        int postiTotali = 24;

        // boolean per controllo posto occupato
        boolean occupato = false;

        // boolean per controllo posto libero
        boolean libero = true;

        // menu
        do {
            System.out.println("----------- MENU -----------");
            System.out.println(" 0 per prenotare un posto");
            System.out.println(" 1 per visualizzare i posti disponibili");
            System.out.println(" 2 per visualizzare i posti prenotati");
            System.out.println(" 3 per effettuare una ricerca per nome");
            System.out.println(" 4 per effettuare una ricerca per fila");
            System.out.println(" 5 per effettuare una ricerca per colonna");
            System.out.println(" 6 per stampare il report");
            System.out.println(" 7 per uscire");
            sceltaMenuUtente = myIntScanner.nextInt();

            switch (sceltaMenuUtente) {
                case 0:
                    if (nomi.size() < postiTotali) {

                        // aggiungere una prenotazione
                        System.out.println("Hai scelto di prenotare un posto.");

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
                            for (int riga : righe) {
                                if (riga == row) {
                                    for (int colonna : colonne) {
                                        if (colonna == col) {
                                            // posto gia occupato
                                            occupato = true;
                                        }
                                    }
                                }
                            }
                            if (occupato) {
                                System.out.println("Il posto da te selezionato è gia occupato, riprova");
                            } else {
                                // inserisco la prenotazione
                                righe.add(row);
                                colonne.add(col);
                            }
                        } while (occupato);

                    } else {
                        System.out.println("Tutti i posti sono prenotati mi dispiace");
                    }

                    break;
                case 1:
                    System.out.println("Hai scelto di visualizzare la lista dei posti liberi");
                    // visualizzare tutti i posti non prenotati
                    // srotolo numero file e numero colonne
                    libero = true;
                    for (int i = 0; i < maxRiga; i++) {
                        for (int j = 0; j < maxCol; j++) {
                            // i e j sono i miei target riga e target colonna
                            // controllo che il posto non sia gia occupato
                            libero = true; // riassegno a true
                            for (int riga : righe) {
                                if (riga == i) {
                                    for (int colonna : colonne) {
                                        if (colonna == j) {
                                            // posto gia occupato
                                            libero = false;
                                        }
                                    }
                                }
                            }
                            // il posto è libero lo posso stampare
                            if (libero) {
                                System.out.println("fila " + i + " colonna " + j + " è libero");
                            }
                        }
                    }

                    break;
                case 2:
                    // visualizzare tutti i posti prenotati
                    System.out.println("Hai scelto di visualizzare la lista dei posti prenotati: ");
                    for (int i = 0; i < nomi.size(); i++) {
                        System.out.println(
                                "Posto fila: " + righe.get(i) + " colonna: " + colonne.get(i) + " prenotato a nome di: "
                                        + nomi.get(i));
                    }

                    break;
                case 3:
                    // cercare prenotazioni per nome
                    nomeTarget = "";
                    do {
                        System.out.println("Hai scelto la ricerca per nome.\nInserisci il nome: ");
                        nomeTarget = myStringScanner.nextLine();
                        if (nomeTarget.length() <= 0) {
                            System.out.println("Nome inserito non valido,riprova");
                        }

                    } while (nomeTarget.length() <= 0);

                    for (int i = 0; i < nomi.size(); i++) {
                        if (nomeTarget.equals(nomi.get(i))) {
                            // trovato corrispondenza stampo
                            System.out.println(
                                    "Trovato corrispondenza per nome: " + nomeTarget + " in fila: " + righe.get(i)
                                            + " e colonna:" + colonne.get(i));
                        }
                    }

                    break;
                case 4:
                    // cercare prenotazioni per fila

                    filaTarget = 0; // reset della fila target
                    do {
                        System.out.println("Hai scelto la ricerca per fila.\nInserisci la colonna min 0 max 2: ");
                        filaTarget = myIntScanner.nextInt();
                        if (filaTarget < minRiga || filaTarget > maxRiga) {
                            System.out.println("Fila non valida, riprova");
                        }

                    } while (filaTarget < minRiga || filaTarget > maxRiga);

                    for (int i = 0; i < righe.size(); i++) {
                        if (filaTarget == righe.get(i)) {
                            // trovato corrispondenza stampo
                            System.out.println(
                                    "Trovato corrispondenza per fila: " + filaTarget + " in colonna: " + colonne.get(i)
                                            + " a nome di:" + nomi.get(i));
                        }
                    }
                    break;
                case 5:
                    // cercare prenotazioni per colonna
                    colonnaTarget = 0; // reset della colonna target
                    do {
                        System.out.println("Hai scelto la ricerca per colonna.\nInserisci la colonna min 0 max 8: ");
                        colonnaTarget = myIntScanner.nextInt();
                        if (colonnaTarget < minCol || colonnaTarget > maxCol) {
                            System.out.println("Colonna non valida, riprova");
                        }

                    } while (colonnaTarget < minCol || colonnaTarget > maxCol);

                    // cercare prenotazioni per colonne, scorro arraylist colonne
                    for (int i = 0; i < colonne.size(); i++) {
                        // se è presente stampo i dati relativi ai 3 arraylist per lo stesso indice
                        if (colonnaTarget == colonne.get(i)) {
                            // trovato corrispondenza stampo
                            System.out.println(
                                    "Trovato corrispondenza per colonna: " + colonnaTarget + " in fila: " + righe.get(i)
                                            + " a nome di:" + nomi.get(i));
                        }
                    }

                    break;
                case 6:
                    // report
                    // stampare posti totali/posti occupati
                    System.out.println("I posti occupati sono: " + nomi.size());
                    System.out.println("I posti liberi sono: " + (postiTotali - nomi.size()));
                    break;
                case 7:
                    // uscita
                    System.out.println("Hai scelto di uscire.");
                    break;
                default:
                    System.out.println("opzione menu non valida, riprova");
                    break;
            }

        } while (sceltaMenuUtente != 7);

    }
}
