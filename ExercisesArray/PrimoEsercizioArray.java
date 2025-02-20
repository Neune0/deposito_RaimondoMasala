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

        // finche tutto l'array non è pieno di numeri superiori a 100
        while(numeri[0]<=100 && numeri[1]<=100 && numeri[2]<=100){
            
            // faccio riempire l'array all'utente
            for(int i=0;i<numeri.length;i++){
                System.out.println("Inserisci un numero superiore a 100: ");
                numeri[i] = myIntScanner.nextInt();
            }

            // stampa dell' array riempito dall'utente
            for (int numero : numeri) {
                System.out.println("i dati che hai inserito: ");
                System.out.println(numero);
            }

            // se l'utente non ha riempito correttamente lo faccio notare
            if(numeri[0]<=100 && numeri[1]<=100 && numeri[2]<=100){
                System.out.println("Tutti i numeri devono essere superiori a 100, riprova");
            }
            
        }
        // chiusura scanner
        myIntScanner.close();

    }
    
}
