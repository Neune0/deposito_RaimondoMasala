import java.util.Scanner;

public class TabellinaWhile {
    public static void main(String[] args) {
        // crezione scanner
        Scanner myScanner = new Scanner(System.in);

        // richiesta e inserimento dell'input utente
        System.out.println("Inserisci il numero del quale vuoi visualizzare la tabellina(fino a 10): ");
        int numeroScelto = myScanner.nextInt();

        int iterator = 1; // iteratore per creazione tabellina
        System.out.println("Tabellina del "+numeroScelto+"\n");

        while(iterator<10){
            System.out.println("| "+numeroScelto+" x "+iterator+" : "+iterator*numeroScelto);
            iterator++;
        }

        // chiusura scanner
        myScanner.close();
    }
}
