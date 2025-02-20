import java.util.Scanner;

public class SevenDays {
    public static void main(String[] args) {
        // array che conterra' i giorni scelti dall'utente
        int[] days = { 0, 0, 0, 0, 0, 0, 0 };
        // creazione oggetto Scanner
        Scanner myIntScanner = new Scanner(System.in);

        // prompt utente iniziale
        System.out.println("Inserisci 7 giorni della settimana da te scelti");

        // scorro array per inserimento dei 7 giorni scelti
        for (int i = 0; i < days.length; i++) {
            // richiedo input e memorizzo in array
            System.out.println("Inserisci un giorno della settimana 0 per lunedi ... 6 per domenica");
            // gestisce anche congruenze (%7)
            days[i] = myIntScanner.nextInt() % 7;

            // comunica all'utente quale giorno ha scelto
            switch (days[i]) {
                case 0:
                    System.out.println("Hai scelto Lunedi");
                    break;
                case 1:
                    System.out.println("Hai scelto Martedi");
                    break;
                case 2:
                    System.out.println("Hai scelto Mercoledi");
                    break;
                case 3:
                    System.out.println("Hai scelto Giovedi");
                    break;
                case 4:
                    System.out.println("Hai scelto Venerdi");
                    break;
                case 5:
                    System.out.println("Hai scelto Sabato");
                    break;
                case 6:
                    System.out.println("Hai scelto Domenica");
                    break;

                default:
                System.out.println("error");
                    break;
            }
        }

            // stampo i giorni selezionati dall'utente
            System.out.println("Hai selezionato i sequenti giorni: ");
            for (int day : days) {
                switch (day) {
                    case 0:
                        System.out.println("Lunedi");
                        break;
                    case 1:
                        System.out.println("Martedi");
                        break;
                    case 2:
                        System.out.println("Mercoledi");
                        break;
                    case 3:
                        System.out.println("Giovedi");
                        break;
                    case 4:
                        System.out.println("Venerdi");
                        break;
                    case 5:
                        System.out.println("Sabato");
                        break;
                    case 6:
                        System.out.println("Domenica");
                        break;

                    default:
                    System.out.println("error");
                        break;
                }
            }

        // chiusura oggetto scanner
        myIntScanner.close();
    }
}
