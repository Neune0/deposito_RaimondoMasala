import java.util.ArrayList;
import java.util.Scanner;

public class GestionaleVille {
    public static void main(String[] args) {
        ArrayList<ArrayList<Object>> ville = new ArrayList<>();

        menu(ville);
    }

    // il menu principale del gestionale
    public static void menu(ArrayList<ArrayList<Object>> ville) {
        Scanner myIntScanner = new Scanner(System.in);
        int sceltaUtente = 0;
        do {
            System.out.println("-------- MENU ---------------");
            System.out.println("premi 0 per aggiunge una villa");
            System.out.println("premi 1 per visualizzare le ville");
            System.out.println("premi 2 per effetuare una ricerca tramite nome");
            System.out.println("premi 3 per uscire");

            switch (sceltaUtente) {
                case 0: // aggiungere una villa
                    ville.add(addVilla());
                    break;
                case 1: // visulizzare ville
                printVille(ville);

                    break;
                case 2: // ricerca per nome

                    break;
                case 3:
                    // uscita
                    System.out.println("hai scelto di uscire");
                    break;

                default:
                    System.out.println("opzione non valida");
                    break;
            }

        } while (sceltaUtente != 3);
        myIntScanner.close();

    }

    // per aggiungere una villa
    public static ArrayList<Object> addVilla() {
        ArrayList<Object> villa = new ArrayList<>();
        Scanner myIntScanner = new Scanner(System.in);
        Scanner myStringScanner = new Scanner(System.in);

        String nomeVilla = "";
        Integer quantitaStanze = 0;
        Integer hasPiscina = 0;

        do {
            System.out.println("Inserisci il nome della villa: ");
            nomeVilla = myStringScanner.nextLine().trim();
            if (nomeVilla.isEmpty()) {
                System.out.println("Inserisci un nome valido,riprova");
            } else {
                villa.add(nomeVilla);
            }
        } while (nomeVilla.isEmpty());

        do {
            System.out.println("Inserisci il numero delle stanze: ");
            quantitaStanze = myStringScanner.nextInt();
            if (quantitaStanze <= 0) {
                System.out.println("Inserisci una quantita valida,riprova");
            } else {
                villa.add(quantitaStanze);
            }
        } while (quantitaStanze <= 0);

        System.out.println("Dimmmi se la villa ha una piscina oppure no(S/N): ");
        hasPiscina = myStringScanner.nextLine().trim().toUpperCase().equals("S") ? 1 : 0;
        villa.add(hasPiscina);

        myIntScanner.close();
        myStringScanner.close();

        return villa;
    }

    public static void printVille(ArrayList<ArrayList<Object>> ville){
        for(ArrayList<Object> villa : ville){
            System.out.println("Nome villa: "+villa.get(0)+" num stanze: "+villa.get(1)+" piscina: "+villa.get(2));
        }
    }

    public static void ricercaPerNome(ArrayList<ArrayList<Object>> ville){
        String nomeVilla="";
        Scanner myStringScanner = new Scanner(System.in);

        do {
            System.out.println("Inserisci il nome della villa: ");
            nomeVilla = myStringScanner.nextLine().trim();
            if (nomeVilla.isEmpty()) {
                System.out.println("Inserisci un nome valido,riprova");
            }
        } while (nomeVilla.isEmpty());

        for(ArrayList<Object> villa : ville){
            if(villa.get(0).equals(nomeVilla)){
                System.out.println("Nome villa: "+villa.get(0)+" num stanze: "+villa.get(1)+" piscina: "+villa.get(2));
            }
        }

        myStringScanner.close();
    }
}
