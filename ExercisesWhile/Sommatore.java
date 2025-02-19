import java.util.Scanner;
public class Sommatore{
    public static void main(String[] args) {
        // creo lo scanner
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Inserisci una serie di numeri interi positivi affinche io li sommi assieme\nQuando vuoi uscire inserisci un numero negativo");

        // inizializzazione variabili
        int numeroInserito=0;
        int sommatore=0;

        // ciclo per il sommatore
        do{
            // richiesta input e read input utente
            System.out.println("Inserisci un numero positivo oppure uno negativo per uscire: ");
            numeroInserito = myScanner.nextInt();

            // condizione di continuazione
            if(numeroInserito>=0){
                sommatore+=numeroInserito;
            }
            
        }while(numeroInserito>=0);

        // stampa del risultato
        System.out.println("hai deciso di uscire dal loop\nRisultato finale: "+sommatore);


        myScanner.close();
    }
}