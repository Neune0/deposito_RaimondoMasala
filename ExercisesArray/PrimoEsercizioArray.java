/* Creiamo una array con 3 posizioni, 
    dopodiché facciamo stampare al sistema solo i valori superiori a 100 
    continuammo a far inserire all'utente finché questa condizione non stampa 3 volte */

import java.util.Scanner;

public class PrimoEsercizioArray {
    public static void main(String[] args) {
        // inizializzazione array
        int[] numeri = {0,0,0};
        // creazione scanner
        Scanner myIntScanner= new Scanner(System.in);

        int contatore=0;

        // finche l'utente non riempie l'array con numeri superiori a 100
        while(contatore<3){
            
            // faccio riempire l'array all'utente
            for(int i=0;i<numeri.length;i++){
                System.out.println("Inserisci un numero superiore a 100: ");
                numeri[i] = myIntScanner.nextInt();
                if(numeri[i]>=100){
                    contatore++;
                }
            }

            // stampa dell' array riempito dall'utente
            for (int numero : numeri) {
                System.out.println("i dati che hai inserito: ");
                System.out.println(numero);
            }

            // se l'utente non ha riempito correttamente lo faccio notare
            if(contatore<3){
                System.out.println("Tutti i numeri devono essere superiori a 100, riprova");
                contatore=0;
            }
            
        }
        // chiusura scanner
        myIntScanner.close();

    }
    
}
