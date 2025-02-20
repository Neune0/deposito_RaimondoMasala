import java.util.Scanner;

public class Credenziali {
    public static void main(String[] args) {
        // creazione degli scanner
        Scanner myStringScanner = new Scanner(System.in);
        Scanner myIntScanner = new Scanner(System.in);
        // dati utente + ausiliari per conferma
        String nome = "", password = "", confermaNome = "", confermaPassword = "";
        int eta = 0, confermaEta = 0;
        int tentativi = 3; // massimo numero di tentativi per il login

        // inserimento nome
        while (nome.length() != 0) {
            System.out.println("Inserisci il tuo nome: ");
            nome = myStringScanner.nextLine();
            if (nome.length() <= 0) {
                System.out.println("Non hai inserito il tuo nome.\nRiprova");
            }
        }

        // inserimento password
        while (password.length() != 0) {
            System.out.println("Inserisci la tua password: ");
            password = myStringScanner.nextLine();
            if (password.length() <= 0) {
                System.out.println("Non hai inserito la tua password.\nRiprova");
            }
        }

        // inserimento eta
        while (eta <= 0) {
            System.out.println("Inserisci la tua eta: ");
            password = myStringScanner.nextLine();
            if (password.length() <= 0) {
                System.out.println("Non hai inserito un eta corretta.\nRiprova");
            }
        }

        // condizione login effettuato si/no
        boolean login = false;

        // login max 3 tentativi
        for (int i = 0; i < tentativi; i++) {
            System.out.println("Reiserisci il tuo nome: ");
            confermaNome = myStringScanner.nextLine();
            System.out.println("Reiserisci la tua password: ");
            confermaPassword = myStringScanner.nextLine();
            System.out.println("Reiserisci la tua eta: ");
            confermaEta = myIntScanner.nextInt();
            if (confermaEta == eta && confermaNome.equals(nome) && confermaPassword.equals(password)) {
                login = true;
                System.out.println("Login effettuato con successo");
                break;
            } else {
                // qui si potrebbe specificare cosa si è sbagliato
                System.out.println("Tentativo di login fallito");
                login = false;
            }
        }

        // controllo su login fallito
        if (!login) {
            System.out.println("mi dispiace non ti sei loggato");
        }

        // condizione per uscita dal menu
        boolean exit = false;

        int sceltaModifica = 0; // usata per la scelta dell'utente nel menu modifica

        // menu per modifica
        do {
            System.out.println(
                    "Vuoi modificare i tuoi dati?\npremi 1 per nome\npremi 2 per password\npremi 3 per eta\npremi 4 per no");
            sceltaModifica = myIntScanner.nextInt();

            // switch sulla scelta fatta dall'utente
            switch (sceltaModifica) {
                case 1:
                    do {
                        System.out.println("Inserisci il tuo nuovo nome: ");
                        nome = myStringScanner.nextLine();
                        if (nome.length() == 0) {
                            System.out.println("perfavore inserisci un nome valido");
                        }
                    } while (nome.length() != 0);

                    break;
                case 2:
                    do {
                        System.out.println("Inserisci la tua nuova password: ");
                        password = myStringScanner.nextLine();
                        if (password.length() == 0) {
                            System.out.println("perfavore inserisci una password valida");
                        }
                    } while (password.length() != 0);

                    break;
                case 3:
                    do {
                        System.out.println("Inserisci la tua nuova eta: ");
                        eta = myIntScanner.nextInt();
                        if (eta <= 0) {
                            System.out.println("perfavore inserisci una eta valida");
                        }
                    } while (eta <= 0);

                    break;
                case 4:
                    // l'utente ha scelto di uscire dal menu modifiche
                    System.out.println("Hai scelto di uscire");
                    exit = true;

                    break;

                default:
                    System.out.println("Non hai selezionato una opzione valida");
                    break;
            }

            System.out.println(
                    "I tuoi dati in questo momento\nNome: " + nome + "\nPassword: " + password + "\neta: " + eta);

        } while (!exit);

        // chiusura degli scanner
        myIntScanner.close();
        myStringScanner.close();

    }
}
