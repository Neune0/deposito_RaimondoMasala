import java.util.Scanner;

public class UntilNegative {
    public static void main(String[] args) {
        // creazione scanner interi
        Scanner myIntScanner = new Scanner(System.in);

        // spiegazione di cio che fa il programma
        System.out.println("Inserisci un numero intero positivo ti diro se è pari o dispari\nInserisci un numero negativo per uscire");

        int inputUtente = 0; // l'input dell' utente

        // finche non inserisce un numero negativo
        while(inputUtente>=0){
            // richiesta e lettura input
            System.out.println("Inserisci un numero: ");
            inputUtente = myIntScanner.nextInt();

            // solo se l'input è maggiore o uguale a zero
            if(inputUtente>=0){
                // discrimino numeri pari e dispari
                if(inputUtente%2==0){
                    System.out.println("Questo numero è pari");
                }
                else{
                    System.out.println("Questo numero è dispari");
                }
            }
            
        }

    }
}
