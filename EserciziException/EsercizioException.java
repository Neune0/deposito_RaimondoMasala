import java.util.Scanner;

public class EsercizioException {
    public static void main(String[] args) {
        // scanner per leggere la stringa di input utente
        Scanner scanner;
        final double prezzoPerCioccolatino = 1.00;

        boolean exit= false;
        do{
            scanner = new Scanner(System.in); // reeset dello scanner perche lo chiudo nel finally
            try {
                System.out.print("Inserisci la quantità di cioccolatini: ");
                String input = scanner.nextLine(); 
    
                // conversione occhio a NumberFormatException
                int quantita = Integer.parseInt(input);
                
                // qui non ci va se il parse fallisce
                if (quantita < 0) {
                    throw new IllegalArgumentException("quantita negativa");
                }
    
                double costoTotale = quantita * prezzoPerCioccolatino;
                System.out.println("Totale da pagare: " + costoTotale);
                // se arrivo qui allora ok posso uscire 
                exit = true;
                
            } catch (NumberFormatException e) {
                System.out.println("Errore: non hai inserito un numero");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            } finally {
                System.out.println("Ciao");
                scanner.close();
            }
        }while(!exit);
        
    }
    
}
